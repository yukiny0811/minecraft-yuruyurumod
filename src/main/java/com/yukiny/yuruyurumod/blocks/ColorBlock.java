package com.yukiny.yuruyurumod.blocks;

import com.yukiny.yuruyurumod.YuruyuruMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

//入力されるレッドストーン信号の強さによって色が変わるブロック

public class ColorBlock extends Block {

    private static final PropertyInteger STATE = PropertyInteger.create("state", 0, 3);

    public ColorBlock(){
        super(Material.ROCK);
        setCreativeTab(YuruyuruMod.yuruTab);
        setRegistryName("color_block");
        setUnlocalizedName(YuruyuruMod.MODID + "_color_block");
        setHardness(30);
        setDefaultState(getBlockState().getBaseState().withProperty(STATE, 0));
    }

    @Override
    public boolean canConnectRedstone(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side) {
        return true;
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn) {
        int power = worldIn.isBlockIndirectlyGettingPowered(pos);
        if(power != 0){
            System.out.println("start input");
            System.out.println("power = " + Integer.toString(power));
        } else{
            System.out.println("end input");
        }
        worldIn.setBlockState(pos, state.withProperty(STATE, power / 4));
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(STATE, meta);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(STATE);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, STATE);
    }
}
