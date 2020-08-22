package com.yukiny.yuruyurumod.items;

import com.yukiny.yuruyurumod.YuruyuruMod;
import com.yukiny.yuruyurumod.entities.EntityChasingArrow;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ChasingArrow extends ItemArrow {
    public ChasingArrow(){
        super();
        setCreativeTab(YuruyuruMod.yuruTab);
        setRegistryName("chasing_arrow");
        setUnlocalizedName(YuruyuruMod.MODID + "_chasing_arrow");
    }

    @Override
    public EntityArrow createArrow(World worldIn, ItemStack stack, EntityLivingBase shooter) {
        return new EntityChasingArrow(worldIn, shooter);
    }
}
