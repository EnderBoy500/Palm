package io.github.enderboy500.palm.block;

import com.mojang.math.OctahedralGroup;
import com.mojang.serialization.MapCodec;
import io.github.enderboy500.palm.content.PalmBlocks;
import io.github.enderboy500.palm.content.PalmDamageTypes;
import io.github.enderboy500.palm.content.PalmItems;
import io.github.enderboy500.palm.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class CoconutBlock extends FallingBlock implements BonemealableBlock {
    public static final MapCodec<CoconutBlock> CODEC = simpleCodec(CoconutBlock::new);
    public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_2;;


    public CoconutBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH).setValue(AGE, 0));
    }

    @Override
    protected VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        if (blockState.getValue(AGE) == 0) return CoconutShapes.getShapeAge0FromDirection(blockState);
        else if (blockState.getValue(AGE) == 1) return CoconutShapes.getShapeAge1FromDirection(blockState);
        else if (blockState.getValue(AGE) == 2) return CoconutShapes.getShapeAge2FromDirection(blockState);
        else return Shapes.block();
    }

    @Override
    protected MapCodec<? extends FallingBlock> codec() {
        return CODEC;
    }

    @Override
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
    }

    @Override
    public void setPlacedBy(Level level, BlockPos blockPos, BlockState blockState, @Nullable LivingEntity livingEntity, ItemStack itemStack) {
        super.setPlacedBy(level, blockPos, blockState, livingEntity, itemStack);
        if (itemStack.is(PalmItems.COCONUT)) level.setBlockAndUpdate(blockPos, blockState.setValue(AGE, 2));
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        BlockState blockState = this.defaultBlockState();
        LevelReader levelReader = blockPlaceContext.getLevel();
        BlockPos blockPos = blockPlaceContext.getClickedPos();

        for(Direction direction : blockPlaceContext.getNearestLookingDirections()) {
            if (direction.getAxis().isHorizontal()) {
                blockState = (BlockState)blockState.setValue(FACING, direction.getOpposite());
                if (blockState.canSurvive(levelReader, blockPos)) {
                    return blockState;
                }
            }
        }

        return null;
    }


    protected boolean isRandomlyTicking(BlockState blockState) {
        return blockState.getValue(AGE) < 2;
    }

    protected void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        if (serverLevel.random.nextInt(5) == 0) {
            int i = blockState.getValue(AGE);
            if (i < 2) {
                serverLevel.setBlock(blockPos, blockState.setValue(AGE, i + 1), 2);
            }
        }
    }


    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {
        return blockState.getValue(AGE) < 2;
    }

    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        return true;
    }

    public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        serverLevel.setBlock(blockPos, blockState.setValue(AGE, (Integer)blockState.getValue(AGE) + 1), 2);
    }

    protected boolean isPathfindable(BlockState blockState, PathComputationType pathComputationType) {
        return false;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, AGE);
    }

    @Override
    protected void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        if (isFree(serverLevel.getBlockState(blockPos.offset(blockState.getValue(FACING).getOpposite().getUnitVec3i()))) && blockPos.getY() >= serverLevel.getMinY()) {
            FallingBlockEntity fallingBlockEntity = FallingBlockEntity.fall(serverLevel, blockPos, blockState);
            this.falling(fallingBlockEntity);
        }
        return;
    }

    protected boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        BlockState blockState2 = levelReader.getBlockState(blockPos.relative((Direction)blockState.getValue(FACING).getOpposite()));
        return blockState2.is(ModTags.COCONUT_PLACEABLES);
    }

    @Override
    protected void onProjectileHit(Level level, BlockState blockState, BlockHitResult blockHitResult, Projectile projectile) {
        if (!isFree(level.getBlockState(blockHitResult.getBlockPos().offset(blockState.getValue(FACING).getOpposite().getUnitVec3i())))) {
            FallingBlockEntity fallingBlockEntity = FallingBlockEntity.fall(level, blockHitResult.getBlockPos(), blockState);
            this.falling(fallingBlockEntity);
        }
        super.onProjectileHit(level, blockState, blockHitResult, projectile);
    }

    public static boolean isFree(BlockState blockState) {
        return !blockState.is(ModTags.COCONUT_PLACEABLES);
    }

    @Override
    public int getDustColor(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return 0;
    }

    @Override
    public DamageSource getFallDamageSource(Entity entity) {
        return entity.damageSources().source(PalmDamageTypes.COCONUT, entity);
    }

    @Override
    protected void falling(FallingBlockEntity fallingBlockEntity) {
        fallingBlockEntity.setHurtsEntities((1 + (fallingBlockEntity.getBlockState().getValue(AGE)/2)) * 0.75f, 40);
    }


    @Override
    public void onBrokenAfterFall(Level level, BlockPos blockPos, FallingBlockEntity fallingBlockEntity) {
        if (level instanceof ServerLevel serverLevel && fallingBlockEntity.getBlockState().getValue(AGE) == 2) serverLevel.addFreshEntity(fallingBlockEntity.spawnAtLocation(serverLevel, PalmItems.HALF_COCONUT.getDefaultInstance()));
    }
}
