package com.yukiny.yuruyurumod.entries;

import com.yukiny.yuruyurumod.events.WoodCut;
import net.minecraftforge.common.MinecraftForge;

public class YuruEvents {

    public static void register(){
        MinecraftForge.EVENT_BUS.register(new WoodCut());
    }

}
