package com.yukiny.yuruyurumod.items;

import com.yukiny.yuruyurumod.YuruyuruMod;
import com.yukiny.yuruyurumod.entities.EntityMyTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class TNTThrower extends Item {
    public TNTThrower(){
        super();
        setCreativeTab(YuruyuruMod.yuruTab);
        setRegistryName("tnt_thrower");
        setUnlocalizedName(YuruyuruMod.MODID + "_tht_thrower");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {

        if(!playerIn.capabilities.isCreativeMode){
            itemStackIn.stackSize -= 1;
        }

        if(!worldIn.isRemote){
            EntityMyTNTPrimed tnt = new EntityMyTNTPrimed(worldIn, playerIn.posX, playerIn.posY, playerIn.posZ, playerIn);
            float velocity = 1.5f;
            float inaccuracy = 0;
            tnt.setHeadingFromThrower(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0, velocity, inaccuracy, tnt);
            worldIn.spawnEntityInWorld(tnt);
        }

        return new ActionResult<>(EnumActionResult.SUCCESS, itemStackIn);
    }
}
