package com.yukiny.yuruyurumod.entities;

import com.yukiny.yuruyurumod.others.YuruThrowHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityMyFireball extends EntityLargeFireball implements YuruThrowHelper {

    public static final int ENTITY_ID = 4;

    public EntityMyFireball(World world){
        super(world);
    }

    public EntityMyFireball(World world, EntityLivingBase thrower){
        this(world);
        setPosition(thrower.posX, thrower.posY + thrower.getEyeHeight() - 0.1, thrower.posZ);
        this.shootingEntity = thrower;
    }

    @SideOnly(Side.CLIENT)
    public EntityMyFireball(World world, double x, double y, double z, double accelX, double accelY, double accelZ){
        super(world, x, y, z, accelX, accelY, accelZ);
    }

    @Override
    protected float getMotionFactor() {
        return 1f;
    }
}
