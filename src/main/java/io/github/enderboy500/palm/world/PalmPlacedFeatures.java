package io.github.enderboy500.palm.world;

import io.github.enderboy500.palm.Palm;
import io.github.enderboy500.palm.content.PalmBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class PalmPlacedFeatures {
    public static final ResourceKey<PlacedFeature> PALM_TREE_PLACED_KEY = registerKey("palm_tree");
    public static final ResourceKey<PlacedFeature> BEACH_PALM_TREE_PLACED_KEY = registerKey("coconut_palm_tree");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, PALM_TREE_PLACED_KEY, configuredFeatures.getOrThrow(PalmTreeFeatures.PALM),
                    new PlacementModifier[]{PlacementUtils.countExtra(1, 0.00000001f, 0), RarityFilter.onAverageOnceEvery(25), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome(), BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(PalmBlocks.PALM_SAPLING.defaultBlockState(), BlockPos.ZERO))});
        register(context, BEACH_PALM_TREE_PLACED_KEY, configuredFeatures.getOrThrow(PalmTreeFeatures.BEACH_PALM),
                new PlacementModifier[]{PlacementUtils.countExtra(1, 0.00000001f, 0), RarityFilter.onAverageOnceEvery(5), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome(), BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(PalmBlocks.PALM_SAPLING.defaultBlockState(), BlockPos.ZERO))});
//        new PlacementModifier[]{RarityFilter.onAverageOnceEvery(25), InSquarePlacement.spread(),PlacementUtils.HEIGHTMAP_TOP_SOLID, PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()}
    }


    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Palm.id(name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                                                                          Holder<ConfiguredFeature<?, ?>> configuration, PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
