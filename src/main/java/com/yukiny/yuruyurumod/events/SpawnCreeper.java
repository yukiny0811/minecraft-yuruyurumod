package com.yukiny.yuruyurumod.events;

import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class SpawnCreeper {

    @SubscribeEvent
    public void onPlayerPlaceBlock(BlockEvent.PlaceEvent event){
        if(event.getWorld().isRemote) return;

        if(event.getPlacedBlock() == null) return;

        Block block = event.getPlacedBlock().getBlock();

        if(block != Blocks.PUMPKIN && block != Blocks.LIT_PUMPKIN) return;

        BlockPos pos = event.getPos();
        BlockPos pos1 = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ());
        BlockPos pos2 = new BlockPos(pos.getX(), pos.getY() - 2, pos.getZ());

        World world = event.getWorld();
        Block block1 = world.getBlockState(pos1).getBlock();
        Block block2 = world.getBlockState(pos2).getBlock();

        if(block1 == Blocks.STONE && block2 == Blocks.STONE){
            EntityCreeper creeper = new EntityCreeper(world);
            creeper.setLocationAndAngles(pos.getX(), pos.getY() + 2, pos.getZ(), 0, 0);
            creeper.setRotationYawHead(creeper.rotationYaw);
            creeper.setRenderYawOffset(creeper.rotationYaw);
            world.spawnEntityInWorld(creeper);

            world.setBlockToAir(pos);
            world.setBlockToAir(pos1);
            world.setBlockToAir(pos2);
        }
    }
}
