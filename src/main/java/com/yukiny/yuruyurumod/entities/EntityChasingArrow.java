package com.yukiny.yuruyurumod.entities;

import com.yukiny.yuruyurumod.YuruyuruMod;
import com.yukiny.yuruyurumod.entries.YuruItems;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.lwjgl.util.vector.Vector3f;

import javax.vecmath.Vector3d;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class EntityChasingArrow extends EntityArrow {
    public static final int ENTITY_ID = 6;
    private final float SEARCH_RANGE = 8f;
    private final double SPEED = 0.5d;

    public EntityChasingArrow(World world){
        super(world);
    }

    public EntityChasingArrow(World world, double x, double y, double z){
        super(world, x, y, z);
    }

    public EntityChasingArrow(World world, EntityLivingBase shooter){
        super(world, shooter);
    }

    @Override
    protected ItemStack getArrowStack() {
        return new ItemStack(YuruItems.chasingArrow);
    }

    @Override
    public void onUpdate() {
        if(this.inGround){
            super.onUpdate();
            return;
        }
        AxisAlignedBB boundingBox = new AxisAlignedBB(
                posX - SEARCH_RANGE / 2,
                posY - SEARCH_RANGE / 2,
                posZ - SEARCH_RANGE / 2,
                posX + SEARCH_RANGE / 2,
                posY + SEARCH_RANGE / 2,
                posZ + SEARCH_RANGE / 2
        );

        List<EntityLiving> list = worldObj.getEntitiesWithinAABB(EntityLiving.class, boundingBox);
        Optional<EntityLiving> first = list.stream()
                .min(Comparator.comparing(entityLiving -> entityLiving.getDistanceToEntity(this)));
        if(!first.isPresent()){
            super.onUpdate();
            return;
        }
        EntityLiving target = first.get();

        double dX = target.posX - this.posX;
        double dY = (target.posY + target.getEyeHeight()) - this.posY;
        double dZ = target.posZ - this.posZ;
        Vec3d vec3 = new Vec3d(dX, dY, dZ);
        vec3 = vec3.normalize();

        float speedMultiplier = 3f;

        this.motionX = vec3.xCoord * this.SPEED * speedMultiplier;
        this.motionY = vec3.yCoord * this.SPEED * speedMultiplier;
        this.motionZ = vec3.zCoord * this.SPEED * speedMultiplier;

        super.onUpdate();
    }
}
