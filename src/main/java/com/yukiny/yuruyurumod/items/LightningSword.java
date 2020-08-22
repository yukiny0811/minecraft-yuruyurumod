package com.yukiny.yuruyurumod.items;

import com.yukiny.yuruyurumod.YuruyuruMod;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class LightningSword extends ItemSword {

    public LightningSword(){
        super(ToolMaterial.DIAMOND);
        setCreativeTab(YuruyuruMod.yuruTab);
        setRegistryName("lightning_sword");
        setUnlocalizedName(YuruyuruMod.MODID + "_lightning_sword");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
        worldIn.addWeatherEffect(new EntityLightningBolt(worldIn, playerIn.posX, playerIn.posY, playerIn.posZ, false));
        return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
    }
}
