package com.yukiny.yuruyurumod.items;

import com.yukiny.yuruyurumod.YuruyuruMod;
import com.yukiny.yuruyurumod.entities.EntityExplosiveArrow;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

//爆発する矢

public class ExplosiveArrow extends ItemArrow {
    public ExplosiveArrow(){
        super();
        setCreativeTab(YuruyuruMod.yuruTab);
        setRegistryName("explosive_arrow");
        setUnlocalizedName(YuruyuruMod.MODID + "_explosive_arrow");
    }

    @Override
    public EntityArrow createArrow(World worldIn, ItemStack stack, EntityLivingBase shooter) {
        return new EntityExplosiveArrow(worldIn, shooter);
    }
}
