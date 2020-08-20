package com.yukiny.yuruyurumod.blocks;

import com.yukiny.yuruyurumod.YuruyuruMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

//一般的なマイブロック

public class MyBlock extends Block {
    public MyBlock(){
        super(Material.ROCK);
        setCreativeTab(YuruyuruMod.yuruTab);
        setRegistryName("myblock");
        setUnlocalizedName(YuruyuruMod.MODID + "_myblock");
    }
}
