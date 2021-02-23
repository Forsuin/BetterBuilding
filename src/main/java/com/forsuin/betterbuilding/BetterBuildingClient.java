
package com.forsuin.betterbuilding;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockRenderView;
import org.jetbrains.annotations.Nullable;

public class BetterBuildingClient implements ClientModInitializer {
    public static void init() {
        BlockRenderLayerMap.INSTANCE.putBlock(BetterBuildingBlocks.GLASS_STAIRS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BetterBuildingBlocks.WHITE_STAINED_GLASS_STAIRS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BetterBuildingBlocks.ORANGE_STAINED_GLASS_STAIRS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BetterBuildingBlocks.MAGENTA_STAINED_GLASS_STAIRS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BetterBuildingBlocks.LIGHT_BLUE_STAINED_GLASS_STAIRS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BetterBuildingBlocks.YELLOW_STAINED_GLASS_STAIRS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BetterBuildingBlocks.LIME_STAINED_GLASS_STAIRS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BetterBuildingBlocks.PINK_STAINED_GLASS_STAIRS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BetterBuildingBlocks.GRAY_STAINED_GLASS_STAIRS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BetterBuildingBlocks.LIGHT_GRAY_STAINED_GLASS_STAIRS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BetterBuildingBlocks.CYAN_STAINED_GLASS_STAIRS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BetterBuildingBlocks.PURPLE_STAINED_GLASS_STAIRS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BetterBuildingBlocks.BLUE_STAINED_GLASS_STAIRS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BetterBuildingBlocks.BROWN_STAINED_GLASS_STAIRS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BetterBuildingBlocks.GREEN_STAINED_GLASS_STAIRS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BetterBuildingBlocks.RED_STAINED_GLASS_STAIRS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BetterBuildingBlocks.BLACK_STAINED_GLASS_STAIRS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BetterBuildingBlocks.GRASS_BLOCK_STAIRS, RenderLayer.getCutout());
    }

    @Override
    public void onInitializeClient() {
        init();

        ColorProviderRegistry.BLOCK.register(new BlockColorProvider() {
            @Override
            public int getColor(BlockState state, @Nullable BlockRenderView world, @Nullable BlockPos pos, int tintIndex) {
                return world != null && pos != null ? BiomeColors.getGrassColor(world, pos) : GrassColors.getColor(0.5D, 1.0D);
            }
        }, BetterBuildingBlocks.GRASS_BLOCK_STAIRS);

        ColorProviderRegistry.ITEM.register(new ItemColorProvider() {
            @Override
            public int getColor(ItemStack stack, int tintIndex) {
                return GrassColors.getColor(0.5D, 1.0D);
            }
        }, BetterBuildingItems.GRASS_BLOCK_STAIRS);

    }
}