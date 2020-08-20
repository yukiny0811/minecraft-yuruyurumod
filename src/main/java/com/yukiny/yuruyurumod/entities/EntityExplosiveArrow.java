package com.yukiny.yuruyurumod.entities;

import com.yukiny.yuruyurumod.entries.YuruItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

//爆発矢のエンティティ

public class EntityExplosiveArrow extends EntityArrow {

    public static final int ENTITY_ID = 0;

    public EntityExplosiveArrow(World world){
        super(world);
    }

    public EntityExplosiveArrow(World world, EntityLivingBase shooter){
        super(world, shooter);
    }

    public EntityExplosiveArrow(World world, double x, double y, double z){
        super(world, x, y, z);
    }

    @Override
    protected ItemStack getArrowStack() {
        return new ItemStack(YuruItems.explosiveArrow);
    }

    @Override
    protected void onHit(RayTraceResult raytraceResultIn) {
        if(!worldObj.isRemote){
            float power = 4;
            boolean blockBreak = true;
            worldObj.createExplosion(this, posX, posY, posZ, power, blockBreak);
            this.setDead();
        }
    }
}
