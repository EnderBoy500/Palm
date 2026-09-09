package io.github.enderboy500.palm;

import io.github.ciph3rj.cipherlib.Cipher;
import io.github.enderboy500.palm.content.*;
import io.github.enderboy500.palm.util.ModTags;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.SharedConstants;
import net.minecraft.resources.Identifier;

import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Palm implements ModInitializer {
	public static final String MOD_ID = "palm";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Palm");

		Cipher.addModId(MOD_ID);

		PalmBlocks.load();

		PalmEntities.load();
		PalmDamageTypes.load();

		PalmItems.load();
		PalmCreativeModeTabModifiers.load();

		PalmWorldGenModifications.load();

		ModTags.load();

		DispenserBlock.registerProjectileBehavior(PalmItems.COCONUT);

		BlockEntityType.SHELF.addSupportedBlock(PalmBlocks.PALM_SHELF);
		BlockEntityType.SIGN.addSupportedBlock(PalmBlocks.PALM_SIGN);
		BlockEntityType.SIGN.addSupportedBlock(PalmBlocks.PALM_WALL_SIGN);
		BlockEntityType.HANGING_SIGN.addSupportedBlock(PalmBlocks.PALM_HANGING_SIGN);
		BlockEntityType.HANGING_SIGN.addSupportedBlock(PalmBlocks.PALM_WALL_HANGING_SIGN);

		StrippableBlockRegistry.register(PalmBlocks.PALM_LOG, PalmBlocks.STRIPPED_PALM_LOG);
		StrippableBlockRegistry.register(PalmBlocks.PALM_WOOD, PalmBlocks.STRIPPED_PALM_WOOD);
		StrippableBlockRegistry.register(PalmBlocks.COCONUT_BLOCK, PalmBlocks.STRIPPED_COCONUT_BLOCK);
		StrippableBlockRegistry.register(PalmBlocks.COCONUT_BRICKS, PalmBlocks.STRIPPED_COCONUT_BRICKS);

		FlammableBlockRegistry.getDefaultInstance().add(PalmBlocks.PALM_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(PalmBlocks.STRIPPED_PALM_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(PalmBlocks.PALM_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(PalmBlocks.STRIPPED_PALM_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(PalmBlocks.PALM_PLANKS, 20, 5);
		FlammableBlockRegistry.getDefaultInstance().add(PalmBlocks.PALM_STAIRS, 20, 5);
		FlammableBlockRegistry.getDefaultInstance().add(PalmBlocks.PALM_SLABS, 20, 5);
		FlammableBlockRegistry.getDefaultInstance().add(PalmBlocks.PALM_FENCE, 20, 5);
		FlammableBlockRegistry.getDefaultInstance().add(PalmBlocks.PALM_FENCE_GATE, 20, 5);
		FlammableBlockRegistry.getDefaultInstance().add(PalmBlocks.PALM_SHELF, 20, 5);
		FlammableBlockRegistry.getDefaultInstance().add(PalmBlocks.PALM_LEAVES, 20, 5);

		FuelRegistryEvents.BUILD.register(((builder, context) -> {
			builder.add(PalmBlocks.PALM_LOG, 300);
			builder.add(PalmBlocks.STRIPPED_PALM_LOG, 300);
			builder.add(PalmBlocks.PALM_WOOD, 300);
			builder.add(PalmBlocks.STRIPPED_PALM_WOOD, 300);
			builder.add(PalmBlocks.PALM_PLANKS, 300);
			builder.add(PalmBlocks.PALM_STAIRS, 300);
			builder.add(PalmBlocks.PALM_SLABS, 300);
			builder.add(PalmBlocks.PALM_PRESSURE_PLATE, 300);
			builder.add(PalmBlocks.PALM_BUTTON, 300);
			builder.add(PalmBlocks.PALM_FENCE, 300);
			builder.add(PalmBlocks.PALM_FENCE_GATE, 300);
			builder.add(PalmItems.PALM_BOAT, 1200);
			builder.add(PalmItems.PALM_CHEST_BOAT, 1200);
		}));
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
