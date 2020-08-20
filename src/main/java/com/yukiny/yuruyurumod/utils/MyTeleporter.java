package com.yukiny.yuruyurumod.utils;

import com.yukiny.yuruyurumod.entries.YuruBlocks;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class MyTeleporter extends Teleporter {
    private WorldServer worldServerInstance;

    public MyTeleporter(WorldServer worldServer){
        super(worldServer);
        this.worldServerInstance = worldServer;
    }

    @Override
    public boolean makePortal(Entity entityIn) {
        return true;
    }

    @Override
    public boolean placeInExistingPortal(Entity entityIn, float rotationYaw) {
        double posX = entityIn.posX;
        double posY = 120d;
        double posZ = entityIn.posZ;

        while(true){
            if(worldServerInstance.getBlockState(new BlockPos(posX, posY, posZ)).getBlock() == Blocks.AIR){
                if(worldServerInstance.getBlockState(new BlockPos(posX, posY-1, posZ)).getBlock() == Blocks.AIR){
                    break;
                }
            }
            posY -= 1;
            if(posY == 2){
                posY = 60;
                worldServerInstance.setBlockToAir(new BlockPos(posX, posY, posZ));
                worldServerInstance.setBlockToAir(new BlockPos(posX, posY-1, posZ));
                break;
            }
        }
        this.worldServerInstance.setBlockState(new BlockPos(posX, posY, posZ + 2), YuruBlocks.myTeleporterBlock.getDefaultState());
        entityIn.setLocationAndAngles(posX, posY, posZ, rotationYaw, entityIn.rotationPitch);
        return true;
    }
}
