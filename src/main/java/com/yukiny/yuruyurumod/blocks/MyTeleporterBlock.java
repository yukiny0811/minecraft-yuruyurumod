package com.yukiny.yuruyurumod.blocks;

import com.yukiny.yuruyurumod.YuruyuruMod;
import com.yukiny.yuruyurumod.entries.YuruGenerators;
import com.yukiny.yuruyurumod.utils.MyTeleporter;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class MyTeleporterBlock extends Block {
    public MyTeleporterBlock(){
        super(Material.ROCK);
        setCreativeTab(YuruyuruMod.yuruTab);
        setRegistryName("my_teleporter_block");
        setUnlocalizedName(YuruyuruMod.MODID + "_my_teleporter_block");
    }

    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, World worldIn, BlockPos pos) {
        return FULL_BLOCK_AABB.expandXyz(-0.05d);
    }

    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
        MinecraftServer server = worldIn.getMinecraftServer();

        if(server == null) return;
        PlayerList list = server.getPlayerList();
        int dest = entityIn.dimension == DimensionType.OVERWORLD.getId() ? YuruGenerators.myDimension.getId() : DimensionType.OVERWORLD.getId();
        Teleporter teleporter = new MyTeleporter(server.worldServerForDimension(dest));
        if(entityIn instanceof EntityPlayerMP){
            list.transferPlayerToDimension((EntityPlayerMP)entityIn, dest, teleporter);
        } else {
            int origin = entityIn.dimension;
            entityIn.dimension = dest;
            worldIn.removeEntityDangerously(entityIn);
            entityIn.isDead = false;
            list.transferEntityToWorld(entityIn, origin, server.worldServerForDimension(origin), server.worldServerForDimension(dest), teleporter);
        }
    }
}
