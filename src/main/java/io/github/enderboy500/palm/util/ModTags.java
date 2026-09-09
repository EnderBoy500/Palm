package io.github.enderboy500.palm.util;

import io.github.ciph3rj.cipherlib.helper.RegistryHelper;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public interface ModTags {
    TagKey<Block> PALM = RegistryHelper.registerBlockTags("palm");
    TagKey<Block> PALM_LOGS = RegistryHelper.registerBlockTags("palm_logs");
    TagKey<Block> COCONUT_PLACEABLES = RegistryHelper.registerBlockTags("coconut_placeables");

    TagKey<Item> PALM_PLANK_INGREDIENT = RegistryHelper.registerItemTags("palm_plank_ingredient");

    static void load() {}
}
