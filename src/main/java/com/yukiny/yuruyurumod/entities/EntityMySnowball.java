package com.yukiny.yuruyurumod.entities;

//オリジナル雪玉エンティティ

import net.minecraft.block.Block;
import net.minecraft.block.BlockSnowBlock;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityMySnowball extends EntitySnowball {
    public static final int ENTITY_ID = 3;
    private static final float DAMAGE = 2.0f;

    public EntityMySnowball(World world){
        super(world);
    }

    public EntityMySnowball(World world, EntityLivingBase thrower){
        super(world, thrower);
    }

    public EntityMySnowball(World world, double x, double y, double z){
        super(world, x, y, z);
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if(result.typeOfHit == RayTraceResult.Type.BLOCK){
            switch (result.sideHit){
                case NORTH:
                case SOUTH:
                case EAST:
                case WEST:
                case UP:
                case DOWN:
                    Block block = worldObj.getBlockState(result.getBlockPos()).getBlock();
                    if(block instanceof BlockSnowBlock){
                        worldObj.setBlockToAir(result.getBlockPos());
                    }
                    break;
            }
        } else if (result.typeOfHit == RayTraceResult.Type.ENTITY){
            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, getThrower()), DAMAGE);
        }
        for(int i = 0; i < 8; i++){
            worldObj.spawnParticle(EnumParticleTypes.SNOWBALL, posX, posY, posZ, 0, 0, 0);
        }
        if(!worldObj.isRemote){
            setDead();
        }
        super.onImpact(result);
    }
}
