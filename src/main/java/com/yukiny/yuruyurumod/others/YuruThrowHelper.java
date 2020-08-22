package com.yukiny.yuruyurumod.others;

import net.minecraft.entity.Entity;
import net.minecraft.entity.IProjectile;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

public interface YuruThrowHelper {

    default void setHeadingFromThrower(Entity entityThrower, float rotationPitchIn, float rotationYawIn, float pitchOffset, float velocity, float inaccuracy, Entity thrown){
        float c = (float) Math.PI / 180;
        float mX = -MathHelper.sin(rotationYawIn * c) * MathHelper.cos(rotationPitchIn * c);
        float mY = -MathHelper.sin((rotationPitchIn + pitchOffset) * c);
        float mZ = MathHelper.cos(rotationYawIn * c) * MathHelper.cos(rotationPitchIn * c);
        setThrowableHeading(mX, mY, mZ, velocity, inaccuracy, thrown);
        thrown.motionX += entityThrower.motionX;
        thrown.motionZ += entityThrower.motionZ;
        if (!entityThrower.onGround) {
            thrown.motionY += entityThrower.motionY;
        }
    }

    default void setThrowableHeading(double x, double y, double z, float velocity, float inaccuracy, Entity thrown){
        float f = MathHelper.sqrt_double(x * x + y * y + z * z);
        x /= f;
        y /= f;
        z /= f;
        Random rand = new Random();
        x += rand.nextGaussian() * 0.0075 * inaccuracy;
        y += rand.nextGaussian() * 0.0075 * inaccuracy;
        z += rand.nextGaussian() * 0.0075 * inaccuracy;
        x *= velocity;
        y *= velocity;
        z *= velocity;
        thrown.motionX = x;
        thrown.motionY = y;
        thrown.motionZ = z;
        float f1 = MathHelper.sqrt_double(x * x + z * z);
        thrown.rotationYaw = (float) (MathHelper.atan2(x, z) * (180 / Math.PI));
        thrown.rotationPitch = (float) (MathHelper.atan2(y, f1) * (180 / Math.PI));
        thrown.prevRotationYaw = thrown.rotationYaw;
        thrown.prevRotationPitch = thrown.rotationPitch;
    }
}
