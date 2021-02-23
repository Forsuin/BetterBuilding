package com.forsuin.betterbuilding;

import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldView;
import net.minecraft.world.chunk.light.ChunkLightProvider;
import java.util.Random;

public class BetterBuildingBlockDirt extends BetterBuildingStairs {


    BetterBuildingBlockDirt(Block block) {
        super(block);
    }

    private static boolean canSurvive(BlockState state, WorldView worldView, BlockPos pos) {
        BlockPos blockPos = pos.up();
        BlockState blockState = worldView.getBlockState(blockPos);
        if (blockState.isOf(Blocks.SNOW) && (Integer)blockState.get(SnowBlock.LAYERS) == 1) {
            return true;
        } else if (blockState.getFluidState().getLevel() == 8) {
            return false;
        } else {
            int i = ChunkLightProvider.getRealisticOpacity(worldView, state, pos, blockState, blockPos, Direction.UP, blockState.getOpacity(worldView, blockPos));
            return i < worldView.getMaxLightLevel();
        }
    }

    private static boolean canSpread(BlockState state, WorldView worldView, BlockPos pos) {
        BlockPos blockPos = pos.up();
        return canSurvive(state, worldView, pos) && !worldView.getFluidState(blockPos).isIn(FluidTags.WATER);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!canSurvive(state, world, pos)) {
            world.setBlockState(pos, BetterBuildingBlocks.DIRT_STAIRS.getDefaultState()
                    .with(FACING, state.get(FACING))
                    .with(HALF, state.get(HALF))
                    .with(SHAPE, state.get(SHAPE))
                    .with(WATERLOGGED, state.get(WATERLOGGED))
            );
        } else {
            if (world.getLightLevel(pos.up()) >= 9) {
                BlockState blockState = this.getDefaultState();

                for(int i = 0; i < 4; ++i) {
                    BlockPos blockPos = pos.add(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
                    if (world.getBlockState(blockPos).isOf(Blocks.DIRT) && canSpread(blockState, world, blockPos) /* || world.getBlockState(blockPos).isOf(BetterBuildingBlocks.DIRT_STAIRS) && canSpread(blockState, world, blockPos)*/) {
                        world.setBlockState(blockPos, (BlockState)blockState.with(SnowyBlock.SNOWY, world.getBlockState(blockPos.up()).isOf(Blocks.SNOW)));
                    }
                }
            }

        }
    }
}
