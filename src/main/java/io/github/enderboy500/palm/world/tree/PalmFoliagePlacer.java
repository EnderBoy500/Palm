package io.github.enderboy500.palm.world.tree;

import com.mojang.datafixers.Products;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.enderboy500.palm.block.CoconutBlock;
import io.github.enderboy500.palm.block.CoconutShapes;
import io.github.enderboy500.palm.content.PalmBlocks;
import io.github.enderboy500.palm.world.PalmTreeFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.material.Fluids;

public class PalmFoliagePlacer extends FoliagePlacer {
    protected final boolean hasCoconut;

    public static MapCodec<PalmFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(instance ->
            palmFoliagePlacerParts(instance)
                    .apply(instance, PalmFoliagePlacer::new));

    protected static <P extends PalmFoliagePlacer> Products.P3<RecordCodecBuilder.Mu<P>, IntProvider, IntProvider, Boolean> palmFoliagePlacerParts(RecordCodecBuilder.Instance<P> instance) {
        return instance.group(IntProvider.codec(0, 16).fieldOf("radius").forGetter((foliagePlacer) -> foliagePlacer.radius), IntProvider.codec(0, 16).fieldOf("offset").forGetter((foliagePlacer) -> foliagePlacer.offset), Codec.BOOL.fieldOf("hasCoconut").forGetter((palm) -> palm.hasCoconut));
    }

    public PalmFoliagePlacer(IntProvider intProvider, IntProvider intProvider2, boolean hasCoconut) {
        super(intProvider, intProvider2);
        this.hasCoconut = hasCoconut;
    }

    public boolean getHasCoconut() {
        return this.hasCoconut;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return PalmTreeFeatures.PALM_FOLIAGE_PLACER;
    }

    @Override
    protected void createFoliage(LevelSimulatedReader levelSimulatedReader, FoliageSetter foliageSetter, RandomSource randomSource, TreeConfiguration treeConfiguration, int i, FoliageAttachment foliageAttachment, int j, int k, int l) {
        BlockPos center = foliageAttachment.pos();

        for (int h = -1; h <= 1; h++) {
            for (int g = -1; g <= 1; g++) {
                if (h == 0 || g == 0) tryPlaceLeaf(levelSimulatedReader, foliageSetter, randomSource, treeConfiguration, center.offset(h,0,g));
                tryPlaceLeaf(levelSimulatedReader, foliageSetter, randomSource, treeConfiguration, center.offset(h,-1,g));
            }
        }
        for (int h = -2; h <= 2; h++) {
            for (int g = -2; g <= 2; g++) {
                if (Math.abs(h) != 1 && Math.abs(g) != 1){
                    if (h == 0 || g == 0) tryPlaceLeaf(levelSimulatedReader, foliageSetter, randomSource, treeConfiguration, center.offset(h,-1,g));
                    else tryPermanentPlaceLeaf(levelSimulatedReader, foliageSetter, randomSource, treeConfiguration, center.offset(h,-2,g));
                }
            }
        }
        tryPermanentPlaceLeaf(levelSimulatedReader, foliageSetter, randomSource, treeConfiguration, center.offset(0,-2,3));
        tryPermanentPlaceLeaf(levelSimulatedReader, foliageSetter, randomSource, treeConfiguration, center.offset(0,-2,-3));
        tryPermanentPlaceLeaf(levelSimulatedReader, foliageSetter, randomSource, treeConfiguration, center.offset(3,-2,0));
        tryPermanentPlaceLeaf(levelSimulatedReader, foliageSetter, randomSource, treeConfiguration, center.offset(-3,-2,0));

        for (Direction direction : HorizontalDirectionalBlock.FACING.getPossibleValues()) {
            if (randomSource.nextBoolean() && foliageSetter.isSet(foliageAttachment.pos().offset(direction.getUnitVec3i())) && this.hasCoconut) {
                foliageSetter.set(foliageAttachment.pos().offset(direction.getUnitVec3i().below(2)), PalmBlocks.COCONUT.defaultBlockState().setValue(CoconutBlock.FACING, direction).setValue(CoconutBlock.AGE, randomSource.nextInt(0, 3)));
            }
        }
    }

    protected static boolean tryPermanentPlaceLeaf(LevelSimulatedReader levelSimulatedReader, FoliageSetter foliageSetter, RandomSource randomSource, TreeConfiguration treeConfiguration, BlockPos blockPos) {
        boolean bl = levelSimulatedReader.isStateAtPosition(blockPos, (blockStatex) -> (Boolean)blockStatex.getValueOrElse(BlockStateProperties.PERSISTENT, false));
        if (!bl && TreeFeature.validTreePos(levelSimulatedReader, blockPos)) {
            BlockState blockState = treeConfiguration.foliageProvider.getState(randomSource, blockPos);
            if (blockState.hasProperty(BlockStateProperties.WATERLOGGED)) {
                blockState = (BlockState)blockState.setValue(BlockStateProperties.WATERLOGGED, levelSimulatedReader.isFluidAtPosition(blockPos, (fluidState) -> fluidState.isSourceOfType(Fluids.WATER))).setValue(LeavesBlock.PERSISTENT, true);
            }

            foliageSetter.set(blockPos, blockState);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int foliageHeight(RandomSource randomSource, int i, TreeConfiguration treeConfiguration) {
        return 1;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource randomSource, int i, int j, int k, int l, boolean bl) {
        return false;
    }
}
