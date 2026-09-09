package io.github.enderboy500.palm.data.provider;

import io.github.enderboy500.palm.content.PalmBlocks;
import io.github.enderboy500.palm.content.PalmItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class PalmBlockLootTableProvider extends FabricBlockLootTableProvider {
    public PalmBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        dropSelf(PalmBlocks.PALM_LOG);
        dropSelf(PalmBlocks.STRIPPED_PALM_LOG);
        dropSelf(PalmBlocks.PALM_WOOD);
        dropSelf(PalmBlocks.STRIPPED_PALM_WOOD);
        dropSelf(PalmBlocks.PALM_PLANKS);
        dropSelf(PalmBlocks.PALM_STAIRS);
        dropSelf(PalmBlocks.PALM_FENCE);
        dropSelf(PalmBlocks.PALM_FENCE_GATE);
        dropSelf(PalmBlocks.PALM_TRAPDOOR);
        dropSelf(PalmBlocks.PALM_BUTTON);
        dropSelf(PalmBlocks.PALM_PRESSURE_PLATE);
        dropSelf(PalmBlocks.PALM_SHELF);
        dropOther(PalmBlocks.PALM_SIGN, PalmItems.PALM_SIGN);
        dropOther(PalmBlocks.PALM_WALL_SIGN, PalmItems.PALM_SIGN);
        dropOther(PalmBlocks.PALM_HANGING_SIGN, PalmItems.PALM_HANGING_SIGN);
        dropOther(PalmBlocks.PALM_WALL_HANGING_SIGN, PalmItems.PALM_HANGING_SIGN);
        dropSelf(PalmBlocks.PALM_SAPLING);
        dropPottedContents(PalmBlocks.POTTED_PALM_SAPLING);
        add(PalmBlocks.PALM_LEAVES, (block -> createLeavesDrops(block, PalmBlocks.PALM_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES)));

        dropSelf(PalmBlocks.COCONUT_BLOCK);
        dropSelf(PalmBlocks.STRIPPED_COCONUT_BLOCK);
        dropSelf(PalmBlocks.COCONUT_BRICKS);
        dropSelf(PalmBlocks.COCONUT_BRICK_STAIRS);
        dropSelf(PalmBlocks.STRIPPED_COCONUT_BRICKS);
        dropSelf(PalmBlocks.STRIPPED_COCONUT_BRICK_STAIRS);
    }
}
