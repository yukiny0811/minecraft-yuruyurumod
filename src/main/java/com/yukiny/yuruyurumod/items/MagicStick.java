package com.yukiny.yuruyurumod.items;

import com.yukiny.yuruyurumod.YuruyuruMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

//一般的な魔法の杖

public class MagicStick extends ItemSword {
    public MagicStick(){
        super(EnumHelper.addToolMaterial("magic_stick", 4, 200, 16.0f, 1.0f, 22));
        setCreativeTab(YuruyuruMod.yuruTab);
        setRegistryName("magic_stick");
        setUnlocalizedName(YuruyuruMod.MODID + "_magic_stick");
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        int time = 2; //秒数
        attacker.setFire(time);

        World world = target.worldObj;
        BlockPos pos = target.getPosition();
        Entity entity;

        if(target instanceof EntityVillager){
            entity = new EntityZombie(world);
            entity.setPosition(pos.getX(), pos.getY(), pos.getZ());
        } else {
            entity = new EntityPig(world);
            entity.setPosition(pos.getX(), pos.getY(), pos.getZ());
        }
        world.spawnEntityInWorld(entity);

        target.setDead();

        return super.hitEntity(stack, target, attacker);
    }
}
