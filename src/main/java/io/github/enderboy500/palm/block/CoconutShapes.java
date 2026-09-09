package io.github.enderboy500.palm.block;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Map;

public interface CoconutShapes {
    static VoxelShape makeAge0Shape() {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.375, 0.375, 0.75, 0.625, 0.625, 1), BooleanOp.OR);
        return shape;
    }

    static VoxelShape makeAge0ShapeSouth() {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.375, 0.375, 0, 0.625, 0.625, 0.25), BooleanOp.OR);
        return shape;
    }

    static VoxelShape makeAge0ShapeEast() {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.75, 0.375, 0.375, 1, 0.625, 0.625), BooleanOp.OR);
        return shape;
    }

    static VoxelShape makeAge0ShapeWest() {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0, 0.375, 0.375, 0.25, 0.625, 0.625), BooleanOp.OR);
        return shape;
    }

    static VoxelShape makeAge1Shape(){
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.3125, 0.3125, 0.625, 0.6875, 0.6875, 1), BooleanOp.OR);
        return shape;
    }
    static VoxelShape makeAge1ShapeSouth(){
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.3125, 0.3125, 0, 0.6875, 0.6875, 0.375), BooleanOp.OR);
        return shape;
    }
    static VoxelShape makeAge1ShapeEast(){
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.625, 0.3125, 0.3125, 1, 0.6875, 0.6875), BooleanOp.OR);
        return shape;
    }
    static VoxelShape makeAge1ShapeWest(){
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0, 0.3125, 0.3125, 0.375, 0.6875, 0.6875), BooleanOp.OR);
        return shape;
    }

    static VoxelShape makeAge2Shape(){
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.25, 0.25, 0.5, 0.75, 0.75, 1), BooleanOp.OR);
        return shape;
    }

    static VoxelShape makeAge2ShapeSouth(){
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.25, 0.25, 0, 0.75, 0.75, 0.5), BooleanOp.OR);
        return shape;
    }

    static VoxelShape makeAge2ShapeEast(){
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.5, 0.25, 0.25, 1, 0.75, 0.75), BooleanOp.OR);
        return shape;
    }
    static VoxelShape makeAge2ShapeWest(){
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0, 0.25, 0.25, 0.5, 0.75, 0.75), BooleanOp.OR);
        return shape;
    }

    static VoxelShape getShapeAge0FromDirection(BlockState state) {
        if (state.getValue(CoconutBlock.FACING) != null) return getListOfAge0Shapes.get(state.getValue(CoconutBlock.FACING));
        return CoconutShapes.makeAge0Shape();
    }
    static VoxelShape getShapeAge1FromDirection(BlockState state) {
        if (state.getValue(CoconutBlock.FACING) != null) return getListOfAge1Shapes.get(state.getValue(CoconutBlock.FACING));
        return CoconutShapes.makeAge1Shape();
    }
    static VoxelShape getShapeAge2FromDirection(BlockState state) {
        if (state.getValue(CoconutBlock.FACING) != null) return getListOfAge2Shapes.get(state.getValue(CoconutBlock.FACING));
        return CoconutShapes.makeAge2Shape();
    }

    Map<Direction, VoxelShape> getListOfAge0Shapes = Map.of(Direction.NORTH, CoconutShapes.makeAge0Shape(), Direction.SOUTH, CoconutShapes.makeAge0ShapeSouth(),
            Direction.WEST, makeAge0ShapeEast(), Direction.EAST, makeAge0ShapeWest());
    Map<Direction, VoxelShape> getListOfAge1Shapes = Map.of(Direction.NORTH, CoconutShapes.makeAge1Shape(), Direction.SOUTH, CoconutShapes.makeAge1ShapeSouth(),
            Direction.WEST, makeAge1ShapeEast(), Direction.EAST, makeAge1ShapeWest());
    Map<Direction, VoxelShape> getListOfAge2Shapes = Map.of(Direction.NORTH, CoconutShapes.makeAge2Shape(), Direction.SOUTH, CoconutShapes.makeAge2ShapeSouth(),
            Direction.WEST, makeAge2ShapeEast(), Direction.EAST, makeAge2ShapeWest());

}
