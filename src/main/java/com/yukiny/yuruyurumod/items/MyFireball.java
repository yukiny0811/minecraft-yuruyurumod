package com.yukiny.yuruyurumod.items;

import com.yukiny.yuruyurumod.YuruyuruMod;
import com.yukiny.yuruyurumod.entities.EntityMyFireball;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class MyFireball extends Item {
    public MyFireball(){
        super();
        setCreativeTab(YuruyuruMod.yuruTab);
        setRegistryName("my_fireball");
        setUnlocalizedName(YuruyuruMod.MODID + "_my_fireball");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {

        if(!playerIn.capabilities.isCreativeMode){
            itemStackIn.stackSize -= 1;
        }

        if(!worldIn.isRemote){

            EntityMyFireball entity = new EntityMyFireball(worldIn, playerIn);

            float velocity = 1.5f;
            float inaccuracy = 1f;

            entity.setHeadingFromThrower(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0, velocity, inaccuracy, entity);
            worldIn.spawnEntityInWorld(entity);

        }

        return new ActionResult<>(EnumActionResult.SUCCESS, itemStackIn);
    }

}
