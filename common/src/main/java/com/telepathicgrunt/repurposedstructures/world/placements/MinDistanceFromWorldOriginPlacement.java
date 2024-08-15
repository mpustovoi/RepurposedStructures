package com.telepathicgrunt.repurposedstructures.world.placements;

import com.mojang.serialization.MapCodec;
import com.telepathicgrunt.repurposedstructures.modinit.RSPlacements;
import net.minecraft.core.BlockPos;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.minecraft.world.level.levelgen.placement.RepeatingPlacement;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MinDistanceFromWorldOriginPlacement extends PlacementModifier {
    public static final MapCodec<MinDistanceFromWorldOriginPlacement> CODEC = ExtraCodecs.NON_NEGATIVE_INT.fieldOf("min_distance_from_world_origin").xmap(MinDistanceFromWorldOriginPlacement::new, countPlacement -> countPlacement.minDistanceFromWorldOrigin);
    private final int minDistanceFromWorldOrigin;

    private MinDistanceFromWorldOriginPlacement(int intProvider) {
        this.minDistanceFromWorldOrigin = intProvider;
    }

    @Override
    public Stream<BlockPos> getPositions(PlacementContext placementContext, RandomSource randomSource, BlockPos blockPos) {
        return blockPos.distManhattan(BlockPos.ZERO) > minDistanceFromWorldOrigin ? Stream.of(blockPos) : Stream.empty();
    }

    @Override
    public PlacementModifierType<?> type() {
        return RSPlacements.MIN_DISTANCE_FROM_WORLD_ORIGIN_PLACEMENT.get();
    }
}
