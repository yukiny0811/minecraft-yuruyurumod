package com.yukiny.yuruyurumod.entries;

import com.yukiny.yuruyurumod.items.*;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class YuruItems {

    public static Item magicStick = new MagicStick();
    public static Item hiPotion = new HiPotion();
    public static Item mySword = new MySword();
    public static Item twoWaySword = new TwoWaySword();
    public static Item explosiveArrow = new ExplosiveArrow();
    public static Item modeChangeSword = new ModeChangeSword();
    public static Item mySnowball = new MySnowball();

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
