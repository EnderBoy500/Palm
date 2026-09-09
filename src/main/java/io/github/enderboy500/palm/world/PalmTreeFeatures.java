package io.github.enderboy500.palm.world;

import io.github.enderboy500.palm.Palm;
import io.github.enderboy500.palm.content.PalmBlocks;
import io.github.enderboy500.palm.world.tree.PalmFoliagePlacer;
import io.github.enderboy500.palm.world.tree.PalmTrunkPlacer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.Optional;

public class PalmTreeFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> PALM = registerKey("palm");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BEACH_PALM = registerKey("coconut_palm");

    public static final FoliagePlacerType<PalmFoliagePlacer> PALM_FOLIAGE_PLACER =
            Registry.register(BuiltInRegistries.FOLIAGE_PLACER_TYPE, Palm.id("palm_foliage_placer"),
                    new FoliagePlacerType<>(PalmFoliagePlacer.CODEC));

    public static final TrunkPlacerType<PalmTrunkPlacer> PALM_TRUNK_PLACER = Registry.register(BuiltInRegistries.TRUNK_PLACER_TYPE,
            Palm.id("palm_trunk_placer"), new TrunkPlacerType<>(PalmTrunkPlacer.CODEC));

    public static final TreeGrower PALM_GROWER = new TreeGrower("palm", 0.4f, Optional.empty(), Optional.empty(), Optional.of(PALM), Optional.of(BEACH_PALM), Optional.empty(), Optional.empty());
    public PalmTreeFeatures() {
    }

    public static void load() {}

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> bootstrapContext) {
        register(bootstrapContext, PALM, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(PalmBlocks.PALM_LOG), new PalmTrunkPlacer(6,2,2), BlockStateProvider.simple(PalmBlocks.PALM_LEAVES), new PalmFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), false), new TwoLayersFeatureSize(1, 0, 2)).dirt(BlockStateProvider.simple(Blocks.SAND)).build());
        register(bootstrapContext, BEACH_PALM, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(PalmBlocks.PALM_LOG), new PalmTrunkPlacer(6,2,2), BlockStateProvider.simple(PalmBlocks.PALM_LEAVES), new PalmFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), true), new TwoLayersFeatureSize(1, 0, 2)).dirt(BlockStateProvider.simple(Blocks.SAND)).build());
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Palm.id(name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
