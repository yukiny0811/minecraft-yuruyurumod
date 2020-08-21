package com.yukiny.yuruyurumod;

import com.yukiny.yuruyurumod.entries.*;
import com.yukiny.yuruyurumod.tabs.YuruCreativeTab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = YuruyuruMod.MODID, version = YuruyuruMod.VERSION)
public class YuruyuruMod
{
    public static final String MODID = "yuruyurumod";
    public static final String VERSION = "1.0";

    public static final CreativeTabs yuruTab = new YuruCreativeTab("Yuru");

    @EventHandler
    public void preinit(FMLPreInitializationEvent event){
        boolean isClient = event.getSide().isClient();

        YuruSounds.register();

        YuruBlocks.register(isClient);

        YuruItems.register(isClient);

        YuruRecipes.register();

        YuruEntities.register();

        YuruGenerators.register();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
        YuruEvents.register();
    }
}
