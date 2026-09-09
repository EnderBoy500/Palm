package io.github.enderboy500.palm.data.provider;

import io.github.enderboy500.palm.content.PalmBlocks;
import io.github.enderboy500.palm.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;


public class PalmBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public PalmBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        valueLookupBuilder(ModTags.PALM)
                .add(PalmBlocks.PALM_LOG, PalmBlocks.STRIPPED_PALM_LOG, PalmBlocks.PALM_WOOD, PalmBlocks.STRIPPED_PALM_WOOD, PalmBlocks.PALM_PLANKS,
                        PalmBlocks.PALM_STAIRS, PalmBlocks.PALM_SLABS, PalmBlocks.PALM_FENCE, PalmBlocks.PALM_FENCE_GATE, PalmBlocks.PALM_BUTTON,
                        PalmBlocks.PALM_PRESSURE_PLATE, PalmBlocks.PALM_DOOR, PalmBlocks.PALM_TRAPDOOR, PalmBlocks.PALM_SHELF, PalmBlocks.PALM_WALL_SIGN,
                        PalmBlocks.PALM_HANGING_SIGN, PalmBlocks.PALM_WALL_HANGING_SIGN)
        ;

        valueLookupBuilder(BlockTags.MINEABLE_WITH_AXE)
                .addTag(ModTags.PALM)
                .add(PalmBlocks.COCONUT_BRICK_STAIRS)
                .add(PalmBlocks.STRIPPED_COCONUT_BRICK_STAIRS)
                .add(PalmBlocks.COCONUT_BRICK_SLAB)
                .add(PalmBlocks.STRIPPED_COCONUT_BRICK_SLAB)
        ;

        valueLookupBuilder(ModTags.PALM_LOGS).add(PalmBlocks.PALM_LOG, PalmBlocks.STRIPPED_PALM_LOG);
        valueLookupBuilder(ModTags.COCONUT_PLACEABLES).addTag(ModTags.PALM_LOGS).add(PalmBlocks.STRIPPED_PALM_WOOD, PalmBlocks.PALM_WOOD);

        valueLookupBuilder(BlockTags.STAIRS).add(PalmBlocks.COCONUT_BRICK_STAIRS).add(PalmBlocks.STRIPPED_COCONUT_BRICK_STAIRS);
        valueLookupBuilder(BlockTags.SLABS).add(PalmBlocks.COCONUT_BRICK_SLAB).add(PalmBlocks.STRIPPED_COCONUT_BRICK_SLAB);
        valueLookupBuilder(BlockTags.SAPLINGS).add(PalmBlocks.PALM_SAPLING);
        valueLookupBuilder(BlockTags.LEAVES).add(PalmBlocks.PALM_LEAVES);
        valueLookupBuilder(BlockTags.FENCE_GATES).add(PalmBlocks.PALM_FENCE_GATE);
        valueLookupBuilder(BlockTags.LOGS).add(PalmBlocks.PALM_LOG, PalmBlocks.STRIPPED_PALM_LOG);
        valueLookupBuilder(BlockTags.PLANKS).add(PalmBlocks.PALM_PLANKS);
        valueLookupBuilder(BlockTags.WOODEN_STAIRS).add(PalmBlocks.PALM_STAIRS);
        valueLookupBuilder(BlockTags.WOODEN_SLABS).add(PalmBlocks.PALM_SLABS);
        valueLookupBuilder(BlockTags.WOODEN_FENCES).add(PalmBlocks.PALM_FENCE);
        valueLookupBuilder(BlockTags.WOODEN_DOORS).add(PalmBlocks.PALM_DOOR);
        valueLookupBuilder(BlockTags.WOODEN_TRAPDOORS).add(PalmBlocks.PALM_TRAPDOOR);
        valueLookupBuilder(BlockTags.WOODEN_BUTTONS).add(PalmBlocks.PALM_BUTTON);
        valueLookupBuilder(BlockTags.WOODEN_PRESSURE_PLATES).add(PalmBlocks.PALM_PRESSURE_PLATE);
        valueLookupBuilder(BlockTags.WOODEN_SHELVES).add(PalmBlocks.PALM_SHELF);
    }
}
