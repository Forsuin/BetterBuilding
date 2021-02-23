package com.forsuin.betterbuilding;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;


public class BetterBuilding implements ModInitializer {
    public static String MOD_ID = "betterbuilding";

   public static final ItemGroup BETTER_BUILDING = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "stairs")).icon(() -> new ItemStack(BetterBuildingItems.DIRT_STAIRS)).build();

    @Override
    public void onInitialize(){
        BetterBuildingBlocks.initBlocks();
        BetterBuildingItems.initItems();
    }
}
