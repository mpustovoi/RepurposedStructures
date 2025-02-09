package com.telepathicgrunt.repurposedstructures.mixins.features;

import com.telepathicgrunt.repurposedstructures.RepurposedStructures;
import com.telepathicgrunt.repurposedstructures.mixins.world.WorldGenRegionAccessor;
import com.telepathicgrunt.repurposedstructures.modinit.RSTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.SectionPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.chunk.ChunkStatus;
import net.minecraft.world.level.levelgen.feature.BasaltColumnsFeature;
import net.minecraft.world.level.levelgen.structure.Structure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(BasaltColumnsFeature.class)
public class NoBasaltColumnsInStructuresMixin {

    @Inject(
            method = "canPlaceAt(Lnet/minecraft/world/level/LevelAccessor;ILnet/minecraft/core/BlockPos$MutableBlockPos;)Z",
            at = @At(value = "HEAD"),
            cancellable = true
    )
    private static void repurposedstructures_noBasaltColumnsInStructures(LevelAccessor levelAccessor, int seaLevel, BlockPos.MutableBlockPos mutableBlockPos, CallbackInfoReturnable<Boolean> cir) {
        if(!(levelAccessor instanceof WorldGenRegion)) {
            return;
        }

        SectionPos sectionPos = SectionPos.of(mutableBlockPos);
        if (!levelAccessor.getChunk(sectionPos.x(), sectionPos.z()).getStatus().isOrAfter(ChunkStatus.STRUCTURE_REFERENCES)) {
            return;
        }

        Registry<Structure> configuredStructureFeatureRegistry = levelAccessor.registryAccess().registryOrThrow(Registries.STRUCTURE);
        StructureManager structureManager = ((WorldGenRegionAccessor)levelAccessor).getStructureManager();
        for (Holder<Structure> configuredStructureFeature : configuredStructureFeatureRegistry.getOrCreateTag(RSTags.NO_BASALT)) {
            if (structureManager.getStructureAt(mutableBlockPos, configuredStructureFeature.value()).isValid()) {
                cir.setReturnValue(false);
                return;
            }
        }
    }
}
