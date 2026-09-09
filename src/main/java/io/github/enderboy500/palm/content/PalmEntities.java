package io.github.enderboy500.palm.content;

import io.github.enderboy500.palm.Palm;
import io.github.enderboy500.palm.projectile.ThrownCoconut;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.boat.Boat;
import net.minecraft.world.entity.vehicle.boat.ChestBoat;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public interface PalmEntities {
    EntityType<Boat> PALM_BOAT = register("palm_boat", EntityType.Builder.of(boatFactory(() -> PalmItems.PALM_BOAT), MobCategory.MISC).noLootTable().sized(1.375F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10));
    EntityType<ChestBoat> PALM_CHEST_BOAT = register("palm_chest_boat", EntityType.Builder.of(chestBoatFactory(() -> PalmItems.PALM_CHEST_BOAT), MobCategory.MISC).noLootTable().sized(1.375F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10));

    EntityType<ThrownCoconut> COCONUT = register("coconut", EntityType.Builder.of(ThrownCoconut::new, MobCategory.MISC).noLootTable().sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10));

    private static <T extends Entity> EntityType<T> register(ResourceKey<EntityType<?>> resourceKey, EntityType.Builder<T> builder) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, resourceKey, builder.build(resourceKey));
    }

    private static <T extends Entity> EntityType<T> register(String string, EntityType.Builder<T> builder) {
        return register(ResourceKey.create(Registries.ENTITY_TYPE, Palm.id(string)), builder);
    }

    private static EntityType.EntityFactory<Boat> boatFactory(Supplier<Item> supplier) {
        return (entityType, level) -> new Boat(entityType, level, supplier);
    }

    private static EntityType.EntityFactory<ChestBoat> chestBoatFactory(Supplier<Item> supplier) {
        return (entityType, level) -> new ChestBoat(entityType, level, supplier);
    }

    static void load() {}
}
