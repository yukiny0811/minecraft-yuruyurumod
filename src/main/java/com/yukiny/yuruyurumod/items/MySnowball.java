package com.yukiny.yuruyurumod.items;

import com.yukiny.yuruyurumod.YuruyuruMod;
import com.yukiny.yuruyurumod.entities.EntityMySnowball;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemSnowball;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

//オリジナル雪玉

public class MySnowball extends ItemSnowball {
    public MySnowball(){
        setCreativeTab(YuruyuruMod.yuruTab);
        setRegistryName("my_snowball");
        setUnlocalizedName(YuruyuruMod.MODID + "_my_snowball");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
        if(!playerIn.capabilities.isCreativeMode){
            itemStackIn.stackSize -= 1;
        }
        worldIn.playSound(null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5f, 0.4f / (itemRand.nextFloat() * 0.4f + 0.8f));
        if(!worldIn.isRemote){
            EntityMySnowball ball = new EntityMySnowball(worldIn, playerIn);
            ball.setHeadingFromThrower(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0f, 1.5f, 1f);
            worldIn.spawnEntityInWorld(ball);
        }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn);
    }
}
