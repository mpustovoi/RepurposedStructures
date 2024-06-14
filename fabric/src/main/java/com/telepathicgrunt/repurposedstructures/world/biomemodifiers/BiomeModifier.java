package com.telepathicgrunt.repurposedstructures.world.biomemodifiers;

import com.telepathicgrunt.repurposedstructures.RepurposedStructures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;

import java.util.Arrays;

public class BiomeModifier {
    public static void addFeatures() {
        addToBiome("dungeons/badlands", GenerationStep.Decoration.UNDERGROUND_STRUCTURES);
        addToBiome("dungeons/dark_forest", GenerationStep.Decoration.UNDERGROUND_STRUCTURES);
        addToBiome("dungeons/deep", GenerationStep.Decoration.UNDERGROUND_STRUCTURES);
        addToBiome("dungeons/desert", GenerationStep.Decoration.UNDERGROUND_STRUCTURES);
        addToBiome("dungeons/end", GenerationStep.Decoration.UNDERGROUND_STRUCTURES);
        addToBiome("dungeons/icy", GenerationStep.Decoration.UNDERGROUND_STRUCTURES);
        addToBiome("dungeons/jungle", GenerationStep.Decoration.UNDERGROUND_STRUCTURES);
        addToBiome("dungeons/mushroom", GenerationStep.Decoration.UNDERGROUND_STRUCTURES);
        addToBiome("dungeons/nether", GenerationStep.Decoration.UNDERGROUND_STRUCTURES);
        addToBiome("dungeons/snow", GenerationStep.Decoration.UNDERGROUND_STRUCTURES);
        addToBiome("dungeons/swamp", GenerationStep.Decoration.UNDERGROUND_STRUCTURES);
        addToBiome("wells/badlands", GenerationStep.Decoration.SURFACE_STRUCTURES);
        addToBiome("wells/forest", GenerationStep.Decoration.SURFACE_STRUCTURES);
        addToBiome("wells/mossy_stone", GenerationStep.Decoration.SURFACE_STRUCTURES);
        addToBiome("wells/mushroom", GenerationStep.Decoration.SURFACE_STRUCTURES);
        addToBiome("wells/nether", GenerationStep.Decoration.SURFACE_STRUCTURES);
        addToBiome("wells/snow", GenerationStep.Decoration.SURFACE_STRUCTURES);
        addToBiome("wells/cherry", GenerationStep.Decoration.SURFACE_STRUCTURES);

        removeFromBiome(ResourceLocation.fromNamespaceAndPath("minecraft", "monster_room_deep"), "has_structure/dungeons/deep", GenerationStep.Decoration.UNDERGROUND_STRUCTURES);

        // Have to do this abomination to get neutral ocean dungeons only in biomes that the other ocean dungeon types won't touch.
        // All due to BiomeModification API being per feature instead of an event like Forge's Biome Modification event.
        TagKey<Biome> oceanTag = TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "has_structure/dungeons/ocean"));
        BiomeModifications.create(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "dungeons/ocean_neutral"))
                .add(ModificationPhase.ADDITIONS,
                (context) -> context.hasTag(oceanTag)
                                && (!nameMatch(context.getBiomeKey().location().getPath(), "cold", "chilly", "frozen", "snow", "ice", "warm", "hot", "tropic", "lukewarm") || // Thanks to vanilla oceans all being same temperature...
                                (!nameExactMatch(context.getBiomeKey().location().getNamespace(), "minecraft") && context.getBiome().getBaseTemperature() >= 0.5f && context.getBiome().getBaseTemperature() < 0.9f)),
                context -> context.getGenerationSettings().addFeature(GenerationStep.Decoration.UNDERGROUND_STRUCTURES, ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "dungeons/ocean_neutral"))));

        BiomeModifications.create(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "dungeons/ocean_cold"))
                .add(ModificationPhase.ADDITIONS,
                        (context) -> context.hasTag(oceanTag)
                                && (nameMatch(context.getBiomeKey().location().getPath(), "cold", "chilly") || // Thanks to vanilla oceans all being same temperature...
                                (!nameExactMatch(context.getBiomeKey().location().getNamespace(), "minecraft") && context.getBiome().getBaseTemperature() >= 0.0f && context.getBiome().getBaseTemperature() < 0.5f)),
                        context -> context.getGenerationSettings().addFeature(GenerationStep.Decoration.UNDERGROUND_STRUCTURES, ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "dungeons/ocean_cold"))));

        BiomeModifications.create(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "dungeons/ocean_frozen"))
                .add(ModificationPhase.ADDITIONS,
                        (context) -> context.hasTag(oceanTag)
                                && (nameMatch(context.getBiomeKey().location().getPath(), "frozen", "snow", "ice") || // Thanks to vanilla oceans all being same temperature...
                                (!nameExactMatch(context.getBiomeKey().location().getNamespace(), "minecraft") && context.getBiome().getBaseTemperature() < 0.0f)),
                        context -> context.getGenerationSettings().addFeature(GenerationStep.Decoration.UNDERGROUND_STRUCTURES, ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "dungeons/ocean_frozen"))));

        BiomeModifications.create(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "dungeons/ocean_lukewarm"))
                .add(ModificationPhase.ADDITIONS,
                        (context) -> context.hasTag(oceanTag)
                                && (nameMatch(context.getBiomeKey().location().getPath(), "lukewarm") || // Thanks to vanilla oceans all being same temperature...
                                (!nameExactMatch(context.getBiomeKey().location().getNamespace(), "minecraft") && context.getBiome().getBaseTemperature() >= 0.9f && context.getBiome().getBaseTemperature() < 1.5f)),
                        context -> context.getGenerationSettings().addFeature(GenerationStep.Decoration.UNDERGROUND_STRUCTURES, ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "dungeons/ocean_lukewarm"))));

        BiomeModifications.create(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "dungeons/ocean_warm"))
                .add(ModificationPhase.ADDITIONS,
                        (context) -> context.hasTag(oceanTag)
                                && (nameMatch(context.getBiomeKey().location().getPath(), "warm", "hot", "tropic") || // Thanks to vanilla oceans all being same temperature...
                                (!nameExactMatch(context.getBiomeKey().location().getNamespace(), "minecraft") && context.getBiome().getBaseTemperature() >= 1.5f)),
                        context -> context.getGenerationSettings().addFeature(GenerationStep.Decoration.UNDERGROUND_STRUCTURES, ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "dungeons/ocean_warm"))));
    }

    private static void addToBiome(String featureName, GenerationStep.Decoration step) {
        BiomeModifications.create(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, featureName))
                .add(ModificationPhase.ADDITIONS,
                        (context) -> context.hasTag(TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "has_structure/" + featureName))),
                        (context) -> context.getGenerationSettings().addFeature(step, ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, featureName))));
    }

    private static void removeFromBiome(ResourceLocation feature, String biomeTagName, GenerationStep.Decoration step) {
        BiomeModifications.create(ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, "remove_" + feature.getPath()))
                .add(ModificationPhase.REMOVALS,
                        (context) -> context.hasTag(TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(RepurposedStructures.MODID, biomeTagName))),
                        (context) -> context.getGenerationSettings().removeFeature(step, ResourceKey.create(Registries.PLACED_FEATURE, feature)));
    }

    private static boolean nameMatch(String biomeName, String... targetMatch) {
        return Arrays.stream(targetMatch).anyMatch(biomeName::contains);
    }

    private static boolean nameExactMatch(String biomeName, String... targetMatch) {
        return Arrays.asList(targetMatch).contains(biomeName);
    }
}
