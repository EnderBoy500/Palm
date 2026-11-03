package io.github.enderboy500.palm.content;

import io.github.enderboy500.palm.Palm;
import io.github.enderboy500.palm.block.CoconutBlock;
import io.github.enderboy500.palm.block.CoconutFullBlock;
import io.github.enderboy500.palm.block.PalmSaplingBlock;
import io.github.enderboy500.palm.world.PalmTreeFeatures;
import net.enderboy500.enderlib.registry.template.EBlockRegistry;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;

import static net.minecraft.world.level.block.Blocks.*;

public interface PalmBlocks {
    EBlockRegistry registry = new EBlockRegistry(Palm.MOD_ID);
    
    Block PALM_LOG = registry.registerBlockWithItem("palm_log", RotatedPillarBlock::new, logProperties(MapColor.WOOD, MapColor.TERRACOTTA_YELLOW, SoundType.WOOD), true);
    Block PALM_WOOD = registry.registerBlockWithItem("palm_wood", RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(OAK_WOOD), true);
    Block STRIPPED_PALM_LOG = registry.registerBlockWithItem("stripped_palm_log", RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(OAK_WOOD).mapColor(MapColor.TERRACOTTA_YELLOW), true);
    Block STRIPPED_PALM_WOOD = registry.registerBlockWithItem("stripped_palm_wood", RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(OAK_WOOD).mapColor(MapColor.TERRACOTTA_YELLOW), true);
    Block PALM_PLANKS = registry.registerBlockAsACopyOfBlockWithItem("palm_planks", STRIPPED_PALM_WOOD, true);
    Block PALM_STAIRS = registry.registerBlockWithItem("palm_stairs", settings -> new StairBlock(PALM_PLANKS.defaultBlockState(), settings), BlockBehaviour.Properties.ofFullCopy(PALM_PLANKS), true);
    Block PALM_SLABS = registry.registerBlockWithItem("palm_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(PALM_PLANKS), true);
    Block PALM_FENCE = registry.registerBlockWithItem("palm_fence", FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(PALM_PLANKS), true);
    Block PALM_FENCE_GATE = registry.registerBlockWithItem("palm_fence_gate", settings -> new FenceGateBlock(WoodType.OAK, settings), BlockBehaviour.Properties.ofFullCopy(PALM_PLANKS), true);
    Block PALM_DOOR = registry.registerBlockWithItem("palm_door", settings -> new DoorBlock(BlockSetType.OAK, settings), BlockBehaviour.Properties.ofFullCopy(PALM_PLANKS).noOcclusion(), true);
    Block PALM_TRAPDOOR = registry.registerBlockWithItem("palm_trapdoor", settings -> new TrapDoorBlock(BlockSetType.OAK, settings), BlockBehaviour.Properties.ofFullCopy(PALM_PLANKS).noOcclusion(), true);
    Block PALM_BUTTON = registry.registerBlockWithItem("palm_button", settings -> new ButtonBlock(BlockSetType.OAK, 30, settings), BlockBehaviour.Properties.ofFullCopy(PALM_PLANKS), true);
    Block PALM_PRESSURE_PLATE = registry.registerBlockWithItem("palm_pressure_plate", settings -> new PressurePlateBlock(BlockSetType.OAK, settings), BlockBehaviour.Properties.ofFullCopy(PALM_PLANKS), true);
    Block PALM_SHELF = registry.registerBlockWithItem("palm_shelf", ShelfBlock::new, BlockBehaviour.Properties.ofFullCopy(PALM_PLANKS), true);
    Block PALM_SIGN = registry.registerBlock("palm_sign", settings -> new StandingSignBlock(WoodType.register(new WoodType("palm", BlockSetType.OAK)), settings), BlockBehaviour.Properties.ofFullCopy(PALM_PLANKS).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F).ignitedByLava(), true);
    Block PALM_WALL_SIGN = registry.registerBlock("palm_wall_sign", settings -> new WallSignBlock(WoodType.register(new WoodType("palm", BlockSetType.OAK)), settings), BlockBehaviour.Properties.ofFullCopy(PALM_PLANKS).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F).ignitedByLava(), true);
    Block PALM_HANGING_SIGN = registry.registerBlock("palm_hanging_sign", settings -> new CeilingHangingSignBlock(WoodType.register(new WoodType("palm", BlockSetType.OAK)), settings), BlockBehaviour.Properties.ofFullCopy(PALM_PLANKS).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F).ignitedByLava(), true);
    Block PALM_WALL_HANGING_SIGN = registry.registerBlock("palm_wall_hanging_sign", settings -> new WallHangingSignBlock(WoodType.register(new WoodType("palm", BlockSetType.OAK)), settings), BlockBehaviour.Properties.ofFullCopy(PALM_PLANKS).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F).ignitedByLava(), true);
    Block PALM_LEAVES = registry.registerBlockWithItem("palm_leaves", settings -> new TintedParticleLeavesBlock(-7158200, settings), BlockBehaviour.Properties.ofFullCopy(OAK_LEAVES), true);
    Block PALM_SAPLING = registry.registerBlockWithItem("palm_sapling", settings -> new PalmSaplingBlock(PalmTreeFeatures.PALM_GROWER, settings), BlockBehaviour.Properties.ofFullCopy(OAK_SAPLING), true);
    Block POTTED_PALM_SAPLING = registry.registerBlock("potted_palm_sapling", settings -> new FlowerPotBlock(PALM_SAPLING, settings), flowerPotProperties(), true);

    Block COCONUT = registry.registerBlock("coconut", CoconutBlock::new, BlockBehaviour.Properties.ofFullCopy(COCOA), true);
    Block COCONUT_BLOCK = registry.registerBlockWithItem("coconut_block", CoconutFullBlock::new, BlockBehaviour.Properties.ofFullCopy(COCOA), true);
    Block COCONUT_BRICKS = registry.registerBlockWithItem("coconut_bricks", Block::new, BlockBehaviour.Properties.ofFullCopy(COCOA), true);
    Block COCONUT_BRICK_STAIRS = registry.registerBlockWithItem("coconut_brick_stairs", properties -> new StairBlock(COCONUT_BRICKS.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(COCONUT_BRICKS), true);
    Block COCONUT_BRICK_SLAB = registry.registerBlockWithItem("coconut_brick_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(COCONUT_BRICKS), true);
    Block STRIPPED_COCONUT_BLOCK = registry.registerBlockWithItem("stripped_coconut_block", CoconutFullBlock::new, BlockBehaviour.Properties.ofFullCopy(COCONUT_BRICKS), true);
    Block STRIPPED_COCONUT_BRICKS = registry.registerBlockWithItem("stripped_coconut_bricks", Block::new, BlockBehaviour.Properties.ofFullCopy(COCONUT_BRICKS), true);
    Block STRIPPED_COCONUT_BRICK_STAIRS = registry.registerBlockWithItem("stripped_coconut_brick_stairs", properties -> new StairBlock(STRIPPED_COCONUT_BRICKS.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(COCONUT_BRICKS), true);
    Block STRIPPED_COCONUT_BRICK_SLAB = registry.registerBlockWithItem("stripped_coconut_brick_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(STRIPPED_COCONUT_BRICKS), true);

    static void load() {}
}
