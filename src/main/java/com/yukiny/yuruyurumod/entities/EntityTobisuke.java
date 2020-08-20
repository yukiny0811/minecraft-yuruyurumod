package com.yukiny.yuruyurumod.entities;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityTobisuke extends EntityTameable {
    public static final int ENTITY_ID = 2;
    private static final DataParameter<Float> DATA_HEALTH_ID = EntityDataManager.createKey(EntityWolf.class, DataSerializers.FLOAT);

    public EntityTobisuke(World world){
        super(world);
        setSize(0.9f, 0.9f);
        this.aiSit = new EntityAISit(this);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4f));
        this.tasks.addTask(5, new EntityAIFollowOwner(this, 1.0d, 10.0f, 2.0f));
        this.tasks.addTask(6, new EntityAIMate(this, 1.0d));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0d));
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(9, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        setTamed(false);
        this.spawnableBlock = Blocks.GRASS;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getAttributeMap().getAttributeInstance(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3d);
    }

    @Override
    public boolean isAIDisabled() {
        return false;
    }

    @Override
    protected void updateAITasks() {
        this.dataManager.set(DATA_HEALTH_ID, getHealth());
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(DATA_HEALTH_ID, getHealth());
    }

    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        return new EntityTobisuke(worldObj);
    }

    @Override
    public boolean isBreedingItem(@Nullable ItemStack stack) {
        return stack != null && stack.getItem() == Items.APPLE;
    }

    @Override
    protected boolean canDespawn() {
        return !isTamed() && ticksExisted > 2400;
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand, @Nullable ItemStack stack) {
        if (isTamed()) {
            if (isOwner(player) && !this.worldObj.isRemote && !this.isBreedingItem(stack)) {
                aiSit.setSitting(!isSitting());
                isJumping = false;
                navigator.clearPathEntity();
                setAttackTarget(null);
            }
        } else if (isBreedingItem(stack)) {
            if (!player.capabilities.isCreativeMode) {
                stack.stackSize -= 1;
            }
            if (!this.worldObj.isRemote) {
                setTamed(true);
                navigator.clearPathEntity();
                setAttackTarget(null);
                aiSit.setSitting(true);
                setHealth(20.F);
                setOwnerId(player.getUniqueID());
                playTameEffect(true);
                worldObj.setEntityState(this, (byte) 7);
            }
            return true;
        }
        return super.processInteract(player, hand, stack);
    }

    @Override
    public boolean getCanSpawnHere() {
        int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.getEntityBoundingBox().minY);
        int k = MathHelper.floor_double(this.posZ);
        BlockPos blockpos = new BlockPos(i, j, k);
        return this.worldObj.getBlockState(blockpos.down()).getBlock() == this.spawnableBlock;
    }


}
