package com.yukiny.yuruyurumod.entries;

import com.yukiny.yuruyurumod.items.*;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class YuruItems {

    public static Item magicStick;
    public static Item hiPotion;
    public static Item mySword;
    public static Item twoWaySword;
    public static Item explosiveArrow;
    public static Item modeChangeSword;
    public static Item mySnowball;

    public static void init(){
        magicStick = new MagicStick();
        hiPotion = new HiPotion();
        mySword = new MySword();
        twoWaySword = new TwoWaySword();
        explosiveArrow = new ExplosiveArrow();
        modeChangeSword = new ModeChangeSword();
        mySnowball = new MySnowball();
    }

    public static void register(boolean isClient){
        registerItem(magicStick, isClient);
        registerItem(hiPotion, isClient);
        registerItem(mySword, isClient);
        registerItem(twoWaySword, isClient);
        registerItem(explosiveArrow, isClient);
        registerItem(modeChangeSword, isClient);
        registerItem(mySnowball, Items.SNOWBALL, isClient);
    }

    private static void registerItem(Item item, boolean isClient){
        GameRegistry.register(item);
        if(isClient){
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
        }
    }

    private static void registerItem(Item item, Item textureItem, boolean isClient){
        GameRegistry.register(item);
        if(isClient){
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(textureItem.getRegistryName(), "inventory"));
        }
    }
}
