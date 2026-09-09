package io.github.enderboy500.palm.content;

import io.github.enderboy500.palm.world.PalmPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;

public interface PalmWorldGenModifications {
    static void load() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.DESERT),
                GenerationStep.Decoration.VEGETAL_DECORATION, PalmPlacedFeatures.PALM_TREE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.BEACH),
                GenerationStep.Decoration.VEGETAL_DECORATION, PalmPlacedFeatures.BEACH_PALM_TREE_PLACED_KEY);
    }
}
