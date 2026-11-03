package io.github.enderboy500.palm.content;

import io.github.enderboy500.palm.Palm;
import io.github.enderboy500.palm.projectile.CoconutItem;
import io.github.enderboy500.palm.util.CoconutConsumeEffect;
import net.enderboy500.enderlib.registry.template.EItemRegistry;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Consumable;

public interface PalmItems {
    EItemRegistry registry = new EItemRegistry(Palm.MOD_ID);

    Item PALM_SIGN = registry.registerItem("palm_sign", properties -> new SignItem(PalmBlocks.PALM_SIGN, PalmBlocks.PALM_WALL_SIGN, properties),
            new Item.Properties().stacksTo(16));
    Item PALM_HANGING_SIGN = registry.registerItem("palm_hanging_sign", properties -> new HangingSignItem(PalmBlocks.PALM_HANGING_SIGN,
            PalmBlocks.PALM_WALL_HANGING_SIGN, properties), new Item.Properties().stacksTo(16));
    Item PALM_BOAT = registry.registerItem("palm_boat", properties -> new BoatItem(PalmEntities.PALM_BOAT, properties), new Item.Properties().stacksTo(1));
    Item PALM_CHEST_BOAT = registry.registerItem("palm_chest_boat", properties -> new BoatItem(PalmEntities.PALM_CHEST_BOAT, properties), new Item.Properties().stacksTo(1));

    Item COCONUT = registry.registerItem("coconut", CoconutItem::new, new Item.Properties());
    Item HALF_COCONUT = registry.registerItem("half_coconut", properties -> new BlockItem(PalmBlocks.COCONUT, properties),
            new Item.Properties().food(new FoodProperties(3, 1.4f, false), Consumable.builder().consumeSeconds(2.2f).onConsume(new CoconutConsumeEffect(true)).build()));
    Item COCONUT_WATER = registry.registerItem("coconut_water", new Item.Properties().stacksTo(16).craftRemainder(Items.GLASS_BOTTLE).usingConvertsTo(Items.GLASS_BOTTLE).food(new FoodProperties(0, 0f, true), Consumable.builder().hasConsumeParticles(false).animation(ItemUseAnimation.DRINK).sound(SoundEvents.GENERIC_DRINK).onConsume(new CoconutConsumeEffect(false)).build()), false);

    static void load() {}
}
