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

import java.util.Random;

//クロック回路の単体ブロックバージョン

public class MyRedstoneBlock extends Block {

    private static final PropertyInteger POWER = PropertyInteger.create("power", 0, 1);

    public MyRedstoneBlock(){
        super(Material.ROCK);
        setCreativeTab(YuruyuruMod.yuruTab);
        setRegistryName("my_redstone_block");
        setUnlocalizedName(YuruyuruMod.MODID + "_my_redstone_block");
        setHardness(30);
        setDefaultState(getDefaultState().withProperty(POWER, 0));
    }

    @Override
    public boolean canConnectRedstone(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side) {
        return true;
    }

    @Override
    public boolean canProvidePower(IBlockState state) {
        return true;
    }

    @Override
    public int getWeakPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
        if(blockState.getValue(POWER) == 1){
            return 15;
        }
        return 0;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(POWER, meta);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(POWER);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, POWER);
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        int power = state.getValue(POWER);

        if(power == 0){
            worldIn.setBlockState(pos, state.withProperty(POWER, 1));
        } else {
            worldIn.setBlockState(pos, state.withProperty(POWER, 0));
        }

        worldIn.scheduleBlockUpdate(pos, this, 50, 100);

    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        worldIn.scheduleBlockUpdate(pos, this, 50, 100);
    }
}
