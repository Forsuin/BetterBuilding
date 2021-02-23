package com.forsuin.betterbuilding;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.StairsBlock;

public class BetterBuildingStairs extends StairsBlock {
    BetterBuildingStairs(Block block) {
        super(block.getDefaultState(), FabricBlockSettings.copy(block));
    }
}
