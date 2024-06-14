package com.telepathicgrunt.repurposedstructures.misc.lootmanager;

import com.telepathicgrunt.repurposedstructures.RepurposedStructures;
import com.telepathicgrunt.repurposedstructures.utils.GeneralUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;

import java.util.HashMap;
import java.util.Map;

public class EndRemasteredDedicatedLoot {
    private EndRemasteredDedicatedLoot() {}

    public static boolean isEndRemasteredOn = false;
    public static final Map<ResourceLocation, ResourceLocation> END_REMASTERED_DEDICATED_TABLE_IMPORTS = createEndRemasteredMap();
    private static Map<ResourceLocation, ResourceLocation> createEndRemasteredMap() {
        Map<ResourceLocation, ResourceLocation> tableMap = new HashMap<>();
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/mineshafts/birch"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/abandoned_mineshaft"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/mineshafts/ocean"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/abandoned_mineshaft"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/mineshafts/savanna"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/abandoned_mineshaft"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/mineshafts/stone"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/abandoned_mineshaft"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/mineshafts/swamp"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/abandoned_mineshaft"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/mineshafts/dark_forest"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/abandoned_mineshaft"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/mineshafts/taiga"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/abandoned_mineshaft"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/igloos/stone"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/abandoned_mineshaft"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/igloos/mushroom"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/abandoned_mineshaft"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/igloos/grassy"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/abandoned_mineshaft"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/igloos/mangrove"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/abandoned_mineshaft"));

        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/dungeons/badlands"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/simple_dungeon"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/dungeons/dark_forest"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/simple_dungeon"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/dungeons/deep"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/simple_dungeon"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/dungeons/desert"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/simple_dungeon"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/dungeons/jungle"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/simple_dungeon"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/dungeons/icy"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/simple_dungeon"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/dungeons/mushroom"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/simple_dungeon"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/dungeons/ocean"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/simple_dungeon"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/dungeons/snow"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/simple_dungeon"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/dungeons/swamp"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/simple_dungeon"));

        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/fortresses/jungle_shrine"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/jungle_temple"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/mineshafts/jungle"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/jungle_temple"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/pyramids/jungle"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/jungle_temple"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/pyramids/flower_forest"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/jungle_temple"));

        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/mineshafts/desert"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/desert_pyramid"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/pyramids/mushroom"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/desert_pyramid"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/pyramids/giant_tree_taiga"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/desert_pyramid"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/pyramids/dark_forest"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/desert_pyramid"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "trapped_chests/pyramids/badlands"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/desert_pyramid"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "trapped_chests/pyramids/ocean"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/desert_pyramid"));

        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/mineshafts/icy"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/igloo_chest"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/pyramids/snowy"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/igloo_chest"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/pyramids/icy"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/igloo_chest"));

        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/outposts/badlands"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/pillager_outpost"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/outposts/birch"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/pillager_outpost"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/outposts/desert"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/pillager_outpost"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/outposts/giant_tree_taiga"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/pillager_outpost"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/outposts/icy"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/pillager_outpost"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/outposts/jungle"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/pillager_outpost"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/outposts/mangrove"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/pillager_outpost"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/outposts/oak"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/pillager_outpost"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/outposts/ocean"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/pillager_outpost"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/outposts/savanna"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/pillager_outpost"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/outposts/snowy"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/pillager_outpost"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/outposts/taiga"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/pillager_outpost"));

        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/outposts/basalt"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/nether_bridge"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/outposts/crimson"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/nether_bridge"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/outposts/nether_brick"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/nether_bridge"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/outposts/soul"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/nether_bridge"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/outposts/warped"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/nether_bridge"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/dungeons/nether"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/nether_bridge"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/mineshafts/basalt"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/nether_bridge"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/mineshafts/crimson"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/nether_bridge"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/mineshafts/nether"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/nether_bridge"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/mineshafts/soul"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/nether_bridge"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/mineshafts/warped"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/nether_bridge"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/temples/basalt"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/nether_bridge"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/temples/crimson"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/nether_bridge"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/temples/soul"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/nether_bridge"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/temples/wasteland"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/nether_bridge"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/temples/warped"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/nether_bridge"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "trapped_chests/temples/warped"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/nether_bridge"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "trapped_chests/pyramids/nether"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/nether_bridge"));

        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/shipwrecks/crimson/treasure"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/buried_treasure"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/shipwrecks/nether_bricks/treasure"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/buried_treasure"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/shipwrecks/warped/treasure"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/buried_treasure"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/bastions/underground/treasure"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/buried_treasure"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/bastions/underground/bridge"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/buried_treasure"));
        tableMap.put(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "chests/bastions/underground/skeleton_horse_stable"), ResourceLocation.fromNamespaceAndPath("endrem", "minecraft/chests/buried_treasure"));

        return tableMap;
    }

    public static void checkLoottables(MinecraftServer minecraftServer) {
        if(isEndRemasteredOn) {
            boolean invalidLootTableFound = false;
            for (Map.Entry<ResourceLocation, ResourceLocation> entry : END_REMASTERED_DEDICATED_TABLE_IMPORTS.entrySet()) {
                if (GeneralUtils.isInvalidLootTableFound(minecraftServer, entry)) {
                    invalidLootTableFound = true;
                }
            }
            if (invalidLootTableFound) {
                RepurposedStructures.LOGGER.error("Unknown import/target loot tables found for Repurposed Structures. See above logs and report to TelepathicGrunt please.");
            }
        }
    }
}
