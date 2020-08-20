package com.yukiny.yuruyurumod.blocks;

import com.yukiny.yuruyurumod.YuruyuruMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

//マルチテクスチャのオリジナルブロック

public class MyBlock2 extends Block {
    public MyBlock2(){
        super(Material.ROCK);
        setCreativeTab(YuruyuruMod.yuruTab);
        setRegistryName("myblock2");
        setUnlocalizedName(YuruyuruMod.MODID + "_myblock2");
    }
}
