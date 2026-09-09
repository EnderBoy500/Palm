package io.github.enderboy500.palm.content;

import io.github.ciph3rj.cipherlib.helper.RegistryHelper;
import io.github.enderboy500.palm.block.CoconutBlock;
import io.github.enderboy500.palm.block.CoconutFullBlock;
import io.github.enderboy500.palm.block.PalmSaplingBlock;
import io.github.enderboy500.palm.world.PalmTreeFeatures;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;

import static net.minecraft.world.level.block.Blocks.*;

public interface PalmBlocks {
    Block PALM_LOG = RegistryHelper.registerBlockWithItem("palm_log", RotatedPillarBlock::new, logProperties(MapColor.WOOD, MapColor.TERRACOTTA_YELLOW, SoundType.WOOD));
    Block PALM_WOOD = RegistryHelper.registerBlockWithItem("palm_wood", RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(OAK_WOOD));
    Block STRIPPED_PALM_LOG = RegistryHelper.registerBlockWithItem("stripped_palm_log", RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(OAK_WOOD).mapColor(MapColor.TERRACOTTA_YELLOW));
    Block STRIPPED_PALM_WOOD = RegistryHelper.registerBlockWithItem("stripped_palm_wood", RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(OAK_WOOD).mapColor(MapColor.TERRACOTTA_YELLOW));
    Block PALM_PLANKS = RegistryHelper.registerBlockAsACopyOfBlockWithItem("palm_planks", STRIPPED_PALM_WOOD);
    Block PALM_STAIRS = RegistryHelper.registerBlockWithItem("palm_stairs", settings -> new StairBlock(PALM_PLANKS.defaultBlockState(), settings), BlockBehaviour.Properties.ofFullCopy(PALM_PLANKS));
    Block PALM_SLABS = RegistryHelper.registerBlockWithItem("palm_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(PALM_PLANKS));
    Block PALM_FENCE = RegistryHelper.registerBlockWithItem("palm_fence", FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(PALM_PLANKS));
    Block PALM_FENCE_GATE = RegistryHelper.registerBlockWithItem("palm_fence_gate", settings -> new FenceGateBlock(WoodType.OAK, settings), BlockBehaviour.Properties.ofFullCopy(PALM_PLANKS));
    Block PALM_DOOR = RegistryHelper.registerBlockWithItem("palm_door", settings -> new DoorBlock(BlockSetType.OAK, settings), BlockBehaviour.Properties.ofFullCopy(PALM_PLANKS).noOcclusion());
    Block PALM_TRAPDOOR = RegistryHelper.registerBlockWithItem("palm_trapdoor", settings -> new TrapDoorBlock(BlockSetType.OAK, settings), BlockBehaviour.Properties.ofFullCopy(PALM_PLANKS).noOcclusion());
    Block PALM_BUTTON = RegistryHelper.registerBlockWithItem("palm_button", settings -> new ButtonBlock(BlockSetType.OAK, 30, settings), BlockBehaviour.Properties.ofFullCopy(PALM_PLANKS));
    Block PALM_PRESSURE_PLATE = RegistryHelper.registerBlockWithItem("palm_pressure_plate", settings -> new PressurePlateBlock(BlockSetType.OAK, settings), BlockBehaviour.Properties.ofFullCopy(PALM_PLANKS));
    Block PALM_SHELF = RegistryHelper.registerBlockWithItem("palm_shelf", ShelfBlock::new, BlockBehaviour.Properties.ofFullCopy(PALM_PLANKS));
    Block PALM_SIGN = RegistryHelper.registerBlock("palm_sign", settings -> new StandingSignBlock(WoodType.register(new WoodType("palm", BlockSetType.OAK)), settings), BlockBehaviour.Properties.ofFullCopy(PALM_PLANKS).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F).ignitedByLava());
    Block PALM_WALL_SIGN = RegistryHelper.registerBlock("palm_wall_sign", settings -> new WallSignBlock(WoodType.register(new WoodType("palm", BlockSetType.OAK)), settings), BlockBehaviour.Properties.ofFullCopy(PALM_PLANKS).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F).ignitedByLava());
    Block PALM_HANGING_SIGN = RegistryHelper.registerBlock("palm_hanging_sign", settings -> new CeilingHangingSignBlock(WoodType.register(new WoodType("palm", BlockSetType.OAK)), settings), BlockBehaviour.Properties.ofFullCopy(PALM_PLANKS).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F).ignitedByLava());
    Block PALM_WALL_HANGING_SIGN = RegistryHelper.registerBlock("palm_wall_hanging_sign", settings -> new WallHangingSignBlock(WoodType.register(new WoodType("palm", BlockSetType.OAK)), settings), BlockBehaviour.Properties.ofFullCopy(PALM_PLANKS).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F).ignitedByLava());
    Block PALM_LEAVES = RegistryHelper.registerBlockWithItem("palm_leaves", settings -> new TintedParticleLeavesBlock(-7158200, settings), BlockBehaviour.Properties.ofFullCopy(OAK_LEAVES));
    Block PALM_SAPLING = RegistryHelper.registerBlockWithItem("palm_sapling", settings -> new PalmSaplingBlock(PalmTreeFeatures.PALM_GROWER, settings), BlockBehaviour.Properties.ofFullCopy(OAK_SAPLING));
    Block POTTED_PALM_SAPLING = RegistryHelper.registerBlock("potted_palm_sapling", settings -> new FlowerPotBlock(PALM_SAPLING, settings), flowerPotProperties());

    Block COCONUT = RegistryHelper.registerBlock("coconut", CoconutBlock::new, BlockBehaviour.Properties.ofFullCopy(COCOA));
    Block COCONUT_BLOCK = RegistryHelper.registerBlockWithItem("coconut_block", CoconutFullBlock::new, BlockBehaviour.Properties.ofFullCopy(COCOA));
    Block COCONUT_BRICKS = RegistryHelper.registerBlockWithItem("coconut_bricks", Block::new, BlockBehaviour.Properties.ofFullCopy(COCOA));
    Block COCONUT_BRICK_STAIRS = RegistryHelper.registerBlockWithItem("coconut_brick_stairs", properties -> new StairBlock(COCONUT_BRICKS.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(COCONUT_BRICKS));
    Block COCONUT_BRICK_SLAB = RegistryHelper.registerBlockWithItem("coconut_brick_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(COCONUT_BRICKS));
    Block STRIPPED_COCONUT_BLOCK = RegistryHelper.registerBlockWithItem("stripped_coconut_block", CoconutFullBlock::new, BlockBehaviour.Properties.ofFullCopy(COCONUT_BRICKS));
    Block STRIPPED_COCONUT_BRICKS = RegistryHelper.registerBlockWithItem("stripped_coconut_bricks", Block::new, BlockBehaviour.Properties.ofFullCopy(COCONUT_BRICKS));
    Block STRIPPED_COCONUT_BRICK_STAIRS = RegistryHelper.registerBlockWithItem("stripped_coconut_brick_stairs", properties -> new StairBlock(STRIPPED_COCONUT_BRICKS.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(COCONUT_BRICKS));
    Block STRIPPED_COCONUT_BRICK_SLAB = RegistryHelper.registerBlockWithItem("stripped_coconut_brick_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(STRIPPED_COCONUT_BRICKS));

    static void load() {}
}
