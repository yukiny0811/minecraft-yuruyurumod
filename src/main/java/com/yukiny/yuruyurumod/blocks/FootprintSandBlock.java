package com.yukiny.yuruyurumod.blocks;

import com.yukiny.yuruyurumod.YuruyuruMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

//足跡砂。踏むと色が濃くなる。時間が経つともとに戻る。

public class FootprintSandBlock extends Block {

    private static final PropertyInteger COLOR = PropertyInteger.create("color", 0, 4);
    private static final AxisAlignedBB BLOCK_COLLISION = new AxisAlignedBB(0, 0, 0, 1, 0.9f, 1);

    public FootprintSandBlock(){
        super(Material.SAND);
        setCreativeTab(YuruyuruMod.yuruTab);
        setRegistryName("footprint_sand_block");
        setUnlocalizedName(YuruyuruMod.MODID + "_footprint_sand_block");
        setDefaultState(getDefaultState().withProperty(COLOR, 0));
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(COLOR, meta);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(COLOR);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, COLOR);
    }

    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
        if(!(entityIn instanceof EntityPlayer)) return;
        if(worldIn.getBlockState(pos).getValue(COLOR) == 4) return;
        worldIn.setBlockState(pos, worldIn.getBlockState(pos).withProperty(COLOR, 4));
        worldIn.scheduleBlockUpdate(pos.toImmutable(), this, 5, 100);
    }

    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, World worldIn, BlockPos pos) {
        return BLOCK_COLLISION;
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        int next = state.getValue(COLOR) - 1;
        if(next < 0) return;
        worldIn.setBlockState(pos, state.withProperty(COLOR, next));
        if( next == 0) return;
        worldIn.scheduleBlockUpdate(pos, this, 5, 100);
    }
}
