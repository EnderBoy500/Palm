package io.github.enderboy500.palm.world.tree;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.enderboy500.palm.world.PalmTreeFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;

public class PalmTrunkPlacer extends TrunkPlacer {
    public static final MapCodec<PalmTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec((instance) -> trunkPlacerParts(instance).apply(instance, PalmTrunkPlacer::new));

    public PalmTrunkPlacer(int i, int j, int k) {
        super(i, j, k);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return PalmTreeFeatures.PALM_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader levelSimulatedReader, BiConsumer<BlockPos, BlockState> biConsumer, RandomSource randomSource, int i, BlockPos blockPos, TreeConfiguration treeConfiguration) {

        Direction bendDirection = Direction.Plane.HORIZONTAL.getRandomDirection(randomSource);
        int bedStartAt = Math.max(1, i - 2 -randomSource.nextInt(3));
        int maxBend = 2 + randomSource.nextInt(2);
        BlockPos.MutableBlockPos current = blockPos.mutable();
        boolean isBent = false;
        int bendStep = 0;

        for (int y = 0; y < i; y++) {
            if (y >= bedStartAt && bendStep < maxBend && randomSource.nextFloat() < 0.6f && !isBent) {
                current.move(bendDirection);
                isBent = true;
                bendStep++;
            }
            if (isFree(levelSimulatedReader, current)) {
                placeLog(levelSimulatedReader, biConsumer, randomSource, current, treeConfiguration);
                current.move(Direction.UP);
            }
        }


        return List.of(new FoliagePlacer.FoliageAttachment(current.immutable(), 0 ,false));
    }
}
