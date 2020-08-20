package com.yukiny.yuruyurumod.items;

import com.yukiny.yuruyurumod.YuruyuruMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

//一般的なオリジナルポーション

public class HiPotion extends ItemFood {
    public HiPotion(){
        super(1, 0.5f, false);
        setCreativeTab(YuruyuruMod.yuruTab);
        setRegistryName("hipotion");
        setUnlocalizedName(YuruyuruMod.MODID + "_hipotion");
        setAlwaysEdible(); //満腹でも食べられるようにする
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        super.onFoodEaten(stack, worldIn, player);

        Potion potion = MobEffects.SPEED;
        int duration = 200;
        int level = 0;

        int stackSize = stack.stackSize;
        if(stackSize >= 10){
            duration = 600;
            level = 1;
        }

        PotionEffect effect = new PotionEffect(potion, duration, level);
        player.addPotionEffect(effect);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean hasEffect(ItemStack stack) {
        return true; //アイテムを光らせる
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.DRINK; //食べ物にするか飲み物にするか
    }
}
