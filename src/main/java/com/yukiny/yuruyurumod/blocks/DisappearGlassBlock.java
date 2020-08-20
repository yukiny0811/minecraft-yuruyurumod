package com.yukiny.yuruyurumod.blocks;

import com.yukiny.yuruyurumod.YuruyuruMod;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

//時間が経つと自然消滅するガラスブロック

public class DisappearGlassBlock extends BlockGlass {
    public DisappearGlassBlock(){
        super(Material.GLASS, true);
        setCreativeTab(YuruyuruMod.yuruTab);
        setRegistryName("disappear_glass_block");
        setUnlocalizedName(YuruyuruMod.MODID + "_disappear_glass_block");
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        super.updateTick(worldIn, pos, state, rand);
        worldIn.setBlockToAir(pos);
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        super.onBlockAdded(worldIn, pos, state);
        worldIn.scheduleBlockUpdate(pos, this, 50, 1000);
    }
}
