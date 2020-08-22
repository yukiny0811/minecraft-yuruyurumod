package com.yukiny.yuruyurumod.entries;

import com.yukiny.yuruyurumod.events.*;
import net.minecraftforge.common.MinecraftForge;

public class YuruEvents {

    public static void register(){
        MinecraftForge.EVENT_BUS.register(new WoodCut());
        MinecraftForge.EVENT_BUS.register(new SpeedWithDiamond());
        MinecraftForge.EVENT_BUS.register(new SpawnCreeper());
        MinecraftForge.EVENT_BUS.register(new Migawari());
        MinecraftForge.EVENT_BUS.register(new AttackBooster());
    }

}
