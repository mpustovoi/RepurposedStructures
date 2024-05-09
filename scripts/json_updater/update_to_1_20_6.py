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
              "function": "minecraft:set_nbt",
              "tag": "{Potion:\"minecraft:strong_harming\"}"

              "function": "minecraft:set_potion",
              "id": "minecraft:strong_harming"
""" and None

# Loot Table Updating
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
                        and objectToModify["function"] == "minecraft:set_nbt" \
                        and "Potion" in objectToModify["tag"]:
                        
                        objectToModify["function"] = "minecraft:set_potion"
                        if match := re.search("\\\"(\w+:\w+)\\\"", objectToModify["tag"], re.IGNORECASE):
                            objectToModify["id"] = match.group(1)
                        del objectToModify["tag"]

                traverseAndModify(lootTable, [setPotionComponent])

            with open(filepath, 'w') as file:
                json.dump(lootTable, file, indent = 2)
            continue
        else:
            continue


print('\n\nFINISHED!')
