package io.github.enderboy500.palm.content;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;

public class PalmCreativeModeTabModifiers {
    private static void modifyBuildingBlocksTab() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(entries -> {
            entries.addAfter(Items.PALE_OAK_BUTTON, PalmBlocks.PALM_LOG, PalmBlocks.PALM_WOOD, PalmBlocks.STRIPPED_PALM_LOG, PalmBlocks.STRIPPED_PALM_WOOD
                    , PalmBlocks.PALM_PLANKS, PalmBlocks.PALM_STAIRS, PalmBlocks.PALM_SLABS, PalmBlocks.PALM_FENCE, PalmBlocks.PALM_FENCE_GATE,
                    PalmBlocks.PALM_DOOR, PalmBlocks.PALM_TRAPDOOR, PalmBlocks.PALM_PRESSURE_PLATE, PalmBlocks.PALM_BUTTON);
            entries.addAfter(Items.BAMBOO_BUTTON, PalmBlocks.COCONUT_BLOCK, PalmBlocks.COCONUT_BRICKS, PalmBlocks.COCONUT_BRICK_STAIRS, PalmBlocks.COCONUT_BRICK_SLAB
                    , PalmBlocks.STRIPPED_COCONUT_BLOCK, PalmBlocks.STRIPPED_COCONUT_BRICKS, PalmBlocks.STRIPPED_COCONUT_BRICK_STAIRS, PalmBlocks.STRIPPED_COCONUT_BRICK_SLAB);
        });
    }

    private static void modifyNaturalBlocksTab() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.NATURAL_BLOCKS).register(entries -> {
            entries.addAfter(Items.PALE_OAK_LOG, PalmBlocks.PALM_LOG);
            entries.addAfter(Items.PALE_OAK_SAPLING, PalmBlocks.PALM_SAPLING);
            entries.addAfter(Items.PALE_OAK_LEAVES, PalmBlocks.PALM_LEAVES);
            entries.addAfter(Items.MELON, PalmBlocks.COCONUT_BLOCK);
        });
    }

    private static void modifyFunctionalBlocksTab() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(entries -> {
            entries.addAfter(Items.PALE_OAK_SHELF, PalmBlocks.PALM_SHELF);

            entries.addAfter(Items.PALE_OAK_HANGING_SIGN, PalmItems.PALM_SIGN, PalmItems.PALM_HANGING_SIGN);
        });
    }

    private static void modifyToolsTab() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(entries -> {
            entries.addAfter(Items.PALE_OAK_CHEST_BOAT, PalmItems.PALM_BOAT, PalmItems.PALM_CHEST_BOAT);
        });
    }

    private static void modifyCombatTab() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(entries -> {
            entries.addAfter(Items.SNOWBALL, PalmItems.COCONUT);
        });
    }

    private static void modifyFoodTab() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(entries -> {
            entries.addAfter(Items.MELON_SLICE, PalmItems.HALF_COCONUT);
            entries.addAfter(Items.HONEY_BOTTLE, PalmItems.COCONUT_WATER);
        });
    }

    public static void load() {
        modifyBuildingBlocksTab();
        modifyNaturalBlocksTab();
        modifyFunctionalBlocksTab();
        modifyToolsTab();
        modifyFoodTab();
        modifyCombatTab();
    }
}
