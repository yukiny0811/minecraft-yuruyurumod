package com.yukiny.yuruyurumod.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

//プレイヤーを襲う牛のエンティティ

public class EntityBull extends EntityMob {
    public static final int ENTITY_ID = 1;
    public EntityBull(World world){
        super(world);

        tasks.taskEntries.clear();
        targetTasks.taskEntries.clear();
        tasks.addTask(0, new EntityAISwimming(this));
        tasks.addTask(1, new EntityAIAttackMelee(this, 1, false));
        tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0f));
        tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0f, false));
        tasks.addTask(7, new EntityAIWander(this, 1.0f));
        tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        tasks.addTask(0, new EntityAILookIdle(this));
        targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[]{EntityPlayer.class}));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0f);
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2f);
        getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0f);
        getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2.0f);
    }

    @Override
    public void onEntityUpdate() {
        if(!worldObj.isRemote){
            Entity target= getAttackTarget();
            if (target == null){
                getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2f);
            } else {
                getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5f);
                getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5f);
            }
        }
        super.onEntityUpdate();
    }
}
