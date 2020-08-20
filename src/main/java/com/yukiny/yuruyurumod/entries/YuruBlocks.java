package com.yukiny.yuruyurumod.entries;

import com.yukiny.yuruyurumod.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class YuruBlocks {

    public static Block myBlock;
    public static Block myBlock2;
    public static Block fortuneBlock;
    public static Block fortuneBlock2;
    public static Block soundBlock;
    public static Block rainbowBlock;
    public static Block colorBlock;
    public static Block myRedstoneBlock;
    public static Block footprintSandBlock;
    public static Block disappearGlassBlock;
    public static Block myTeleporterBlock;

    public static void init(){
        myBlock = new MyBlock();
        myBlock2 = new MyBlock2();
        fortuneBlock = new FortuneBlock();
        fortuneBlock2 = new FortuneBlock2();
        soundBlock = new SoundBlock();
        rainbowBlock = new RainbowBlock();
        colorBlock = new ColorBlock();
        myRedstoneBlock = new MyRedstoneBlock();
        footprintSandBlock = new FootprintSandBlock();
        disappearGlassBlock = new DisappearGlassBlock();
        myTeleporterBlock = new MyTeleporterBlock();
    }

    public static void register(boolean isClient){
        registerBlock(myBlock, isClient);
        registerBlock(myBlock2, isClient);
        registerBlock(fortuneBlock, isClient);
        registerBlock(fortuneBlock2, isClient);
        registerBlock(soundBlock, isClient);
        registerBlock(rainbowBlock, isClient);
        registerBlock(colorBlock, isClient);
        registerBlock(myRedstoneBlock, isClient);
        registerBlock(footprintSandBlock, isClient);
        registerBlock(disappearGlassBlock, Blocks.GLASS, isClient);
        registerBlock(myTeleporterBlock, Blocks.PORTAL, isClient);
    }

    private static void registerBlock(Block block, boolean isClient){
        GameRegistry.register(block);
        GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
        if(isClient){
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
        }
    }

    private static void registerBlock(Block block, Block textureBlock, boolean isClient){
        GameRegistry.register(block);
        GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
        if(isClient){
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(textureBlock.getRegistryName(), "inventory"));
        }
    }
}
