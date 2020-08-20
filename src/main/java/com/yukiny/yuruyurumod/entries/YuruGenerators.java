package com.yukiny.yuruyurumod.entries;

import com.yukiny.yuruyurumod.generators.MyWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class YuruGenerators {

    public static void register(){
        registerWorldGenerators();
    }

    private static void registerWorldGenerators(){
        GameRegistry.registerWorldGenerator(new MyWorldGenerator(YuruBlocks.myBlock, 1000), 1);
    }

}
