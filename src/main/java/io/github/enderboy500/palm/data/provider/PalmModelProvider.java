package io.github.enderboy500.palm.data.provider;

import io.github.enderboy500.palm.content.PalmBlocks;
import io.github.enderboy500.palm.content.PalmItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TexturedModel;

public class PalmModelProvider extends FabricModelProvider {
    public PalmModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.woodProvider(PalmBlocks.PALM_LOG).logWithHorizontal(PalmBlocks.PALM_LOG).wood(PalmBlocks.PALM_WOOD);
        blockStateModelGenerator.woodProvider(PalmBlocks.STRIPPED_PALM_LOG).logWithHorizontal(PalmBlocks.STRIPPED_PALM_LOG).wood(PalmBlocks.STRIPPED_PALM_WOOD);
        blockStateModelGenerator.family(PalmBlocks.PALM_PLANKS).stairs(PalmBlocks.PALM_STAIRS).slab(PalmBlocks.PALM_SLABS).fence(PalmBlocks.PALM_FENCE)
                .fenceGate(PalmBlocks.PALM_FENCE_GATE).pressurePlate(PalmBlocks.PALM_PRESSURE_PLATE).button(PalmBlocks.PALM_BUTTON);
        blockStateModelGenerator.createHangingSign(PalmBlocks.STRIPPED_PALM_LOG, PalmBlocks.PALM_HANGING_SIGN, PalmBlocks.PALM_WALL_HANGING_SIGN);
        blockStateModelGenerator.createTrapdoor(PalmBlocks.PALM_TRAPDOOR);
        blockStateModelGenerator.createDoor(PalmBlocks.PALM_DOOR);
        blockStateModelGenerator.createShelf(PalmBlocks.PALM_SHELF, PalmBlocks.STRIPPED_PALM_LOG);
        blockStateModelGenerator.createTintedLeaves(PalmBlocks.PALM_LEAVES, TexturedModel.LEAVES, -7158200);
        blockStateModelGenerator.createPlantWithDefaultItem(PalmBlocks.PALM_SAPLING, PalmBlocks.POTTED_PALM_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(PalmItems.PALM_BOAT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(PalmItems.PALM_CHEST_BOAT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(PalmItems.PALM_SIGN, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(PalmItems.HALF_COCONUT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(PalmItems.COCONUT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(PalmItems.COCONUT_WATER, ModelTemplates.FLAT_ITEM);
    }
}
