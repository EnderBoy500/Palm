package io.github.enderboy500.palm.content;

import io.github.enderboy500.palm.Palm;
import net.enderboy500.enderlib.registry.template.EUnvariedRegistry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public interface PalmOtherRegistries {
    EUnvariedRegistry registry = new EUnvariedRegistry(Palm.MOD_ID);

    ResourceKey<DamageType> COCONUT = registry.registerDamageType("coconut");

    TagKey<Block> PALM = registry.registerBlockTags("palm");
    TagKey<Block> PALM_LOGS = registry.registerBlockTags("palm_logs");
    TagKey<Block> COCONUT_PLACEABLES = registry.registerBlockTags("coconut_placeables");

    TagKey<Item> PALM_PLANK_INGREDIENT = registry.registerItemTags("palm_plank_ingredient");

    static void load() {}
}
