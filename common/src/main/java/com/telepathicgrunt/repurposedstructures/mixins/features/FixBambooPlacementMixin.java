package com.telepathicgrunt.repurposedstructures.mixins.features;

import com.llamalad7.mixinextras.sugar.Local;
import com.telepathicgrunt.repurposedstructures.mixins.world.WorldGenRegionAccessor;
import com.telepathicgrunt.repurposedstructures.modinit.RSTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.BambooFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.Structure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;


@Mixin(value = BambooFeature.class, priority = 1010)
public class FixBambooPlacementMixin {

    @Inject(
            method = "place(Lnet/minecraft/world/level/levelgen/feature/FeaturePlaceContext;)Z",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/WorldGenLevel;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z", ordinal = 2),
            require = 0
    )
    private void repurposedstructures_fixBambooNonAirCheck(FeaturePlaceContext<ProbabilityFeatureConfiguration> featurePlaceContext,
                                                           CallbackInfoReturnable<Boolean> cir,
                                                           @Local(ordinal = 0) WorldGenLevel worldGenLevel,
                                                           @Local(ordinal = 0) BlockPos.MutableBlockPos mutableBlockPos)
    {
        if (!worldGenLevel.isEmptyBlock(mutableBlockPos)) {
            mutableBlockPos.move(Direction.DOWN);
        }
    }
}
