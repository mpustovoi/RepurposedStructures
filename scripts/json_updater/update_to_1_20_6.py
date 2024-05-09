from os.path import exists
import os
import json
import re

data_folder = os.path.join('..', '..', 'common', 'src', 'main', 'resources', 'data', 'repurposed_structures')

loot_tables_folder = os.path.join('loot_tables')

def createFile(input_path, output_path, regex_list):
    file_content = ''
    with open(input_path, 'r') as file:
        file_content = file.read()
        for i in range(len(regex_list)):
           file_content = file_content.replace(f'${i + 1}', regex_list[i])

    path = output_path
    if not exists(path):
        os.makedirs(os.path.dirname(path), exist_ok=True)
        with open(path, 'w') as jsonFile1:
            jsonFile1.write(file_content)

def traverseAndModify(dictionary, modifiers):  
    for key, value in dictionary.items():
        if isinstance(value, dict):
            traverseAndModify(value, modifiers)
            for modifier in modifiers:
                modifier(value)
        elif isinstance(value, list):
            for listEntry in value:
                if isinstance(listEntry, dict):
                    traverseAndModify(listEntry, modifiers)
                    for modifier in modifiers:
                        modifier(listEntry)

#--------------------------------------------------------------------------------------------

"""
        {
          "name": "minecraft:magenta_banner",
          "functions": [
            {
              "function": "set_nbt",
              "tag": "{BlockEntityTag:{Patterns:[{Pattern:bri,Color:15},{Pattern:ss,Color:2},{Pattern:gru,Color:15},{Pattern:gru,Color:2},{Pattern:mr,Color:15},{Pattern:br,Color:2},{Pattern:br,Color:15},{Pattern:bl,Color:2},{Pattern:bl,Color:15},{Pattern:bts,Color:2},{Pattern:gru,Color:10},{Pattern:bts,Color:15}]}}"
            }
          ]
        },

        
        {
          "name": "minecraft:magenta_banner",
          "functions": [
            {
              "function": "minecraft:set_banner_pattern",
              "patterns": [
                {
                  "pattern": "minecraft:base",
                  "color": "lime"
                }
              ]
            }
          ]
        },
""" and None

# Loot Table Updating
bannerPatternConversion = {
    "b": "minecraft:base",
    "bl": "minecraft:square_bottom_left",
    "br": "minecraft:square_bottom_right",
    "tl": "minecraft:square_top_left",
    "tr": "minecraft:square_top_right",
    "bs": "minecraft:stripe_bottom",
    "ts": "minecraft:stripe_top",
    "ls": "minecraft:stripe_left",
    "rs": "minecraft:stripe_right",
    "cs": "minecraft:stripe_center",
    "ms": "minecraft:stripe_middle",
    "drs": "minecraft:stripe_downright",
    "dls": "minecraft:stripe_downleft",
    "ss": "minecraft:small_stripes",
    "cr": "minecraft:cross",
    "sc": "minecraft:straight_cross",
    "bt": "minecraft:triangle_bottom",
    "tt": "minecraft:triangle_top",
    "bts": "minecraft:triangles_bottom",
    "tts": "minecraft:triangles_top",
    "ld": "minecraft:diagonal_left",
    "rd": "minecraft:diagonal_up_right",
    "lud": "minecraft:diagonal_up_left",
    "rud": "minecraft:diagonal_right",
    "mc": "minecraft:circle",
    "mr": "minecraft:rhombus",
    "vh": "minecraft:half_vertical",
    "hh": "minecraft:half_horizontal",
    "vhr": "minecraft:half_vertical_right",
    "hhb": "minecraft:half_horizontal_bottom",
    "bo": "minecraft:border",
    "cbo": "minecraft:curly_border",
    "gra": "minecraft:gradient",
    "gru": "minecraft:gradient_up",
    "bri": "minecraft:bricks",
    "glb": "minecraft:globe",
    "cre": "minecraft:creeper",
    "sku": "minecraft:skull",
    "flo": "minecraft:flower",
    "moj": "minecraft:mojang",
    "pig": "minecraft:piglin"
}
bannerColorConversion = {
    "0": "white",
    "1": "orange",
    "2": "magenta",
    "3": "light_blue",
    "4": "yellow",
    "5": "lime",
    "6": "pink",
    "7": "gray",
    "8": "light_gray",
    "9": "cyan",
    "10": "purple",
    "11": "blue",
    "12": "brown",
    "13": "green",
    "14": "red",
    "15": "black"
}
path = os.path.join(data_folder, loot_tables_folder)
for (subdir, dirs, files) in os.walk(path, topdown=True):
    for file in files:
        directory = subdir + os.sep
        filepath = directory + file

        if filepath.endswith(".json"):
            lootTable = {}
            with open(filepath, 'r') as file:
                lootTable = json.loads(file.read())

                def setPotionComponent(objectToModify):
                    if "function" in objectToModify \
                        and "tag" in objectToModify \
                        and (objectToModify["function"] == "minecraft:set_nbt" or objectToModify["function"] == "set_nbt") \
                        and "Potion" in objectToModify["tag"]:
                        
                        objectToModify["function"] = "minecraft:set_potion"
                        if match := re.search("\\\"(\w+:\w+)\\\"", objectToModify["tag"], re.IGNORECASE):
                            objectToModify["id"] = match.group(1)
                        del objectToModify["tag"]

                def setBannerComponent(objectToModify):
                    if "function" in objectToModify \
                        and "tag" in objectToModify \
                        and (objectToModify["function"] == "minecraft:set_nbt" or objectToModify["function"] == "set_nbt") \
                        and "BlockEntityTag:{Patterns:" in objectToModify["tag"]:
                        
                        objectToModify["function"] = "minecraft:set_banner_pattern"

                        bannerData = []
                        if matches := re.findall("Pattern:(\w+),Color:(\d+)", objectToModify["tag"], re.IGNORECASE):
                            for match in matches:
                                pattern = {}
                                pattern["pattern"] = bannerPatternConversion[match[0]]
                                pattern["color"] = bannerColorConversion[match[1]]
                                bannerData.append(pattern)

                        objectToModify["patterns"] = bannerData
                        del objectToModify["tag"]

                traverseAndModify(lootTable, [setPotionComponent, setBannerComponent])

            with open(filepath, 'w') as file:
                json.dump(lootTable, file, indent = 2)
            continue
        else:
            continue


print('\n\nFINISHED!')
