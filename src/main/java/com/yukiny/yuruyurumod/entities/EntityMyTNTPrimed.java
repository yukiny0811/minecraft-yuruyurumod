package com.yukiny.yuruyurumod.entities;

import com.yukiny.yuruyurumod.others.YuruThrowHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.world.World;

public class EntityMyTNTPrimed extends EntityTNTPrimed implements YuruThrowHelper {

    public static final int ENTITY_ID = 5;

    public EntityMyTNTPrimed(World worldIn)
    {
        super(worldIn);
    }

    public EntityMyTNTPrimed(World worldIn, double x, double y, double z, EntityLivingBase igniter)
    {
        super(worldIn, x, y, z, igniter);
    }


}
