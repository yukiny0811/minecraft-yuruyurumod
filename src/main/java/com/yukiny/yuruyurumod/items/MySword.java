package com.yukiny.yuruyurumod.items;

import com.yukiny.yuruyurumod.YuruyuruMod;
import com.yukiny.yuruyurumod.entries.YuruBlocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

//一般的なオリジナル剣

public class MySword extends ItemSword {

    public MySword(){
        super(EnumHelper.addToolMaterial("mysword", 4, 200, 16f, 1f, 22));
        setCreativeTab(YuruyuruMod.yuruTab);
        setRegistryName("mysword");
        setUnlocalizedName(YuruyuruMod.MODID + "_mysword");
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        if(stack == null) return true;
        if(!(attacker instanceof EntityPlayer)) return true;
        target.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 1200, 0));
        target.setFire(100);
        BlockPos pos = new BlockPos(target.posX, target.posY, target.posZ);
        target.worldObj.setBlockState(pos, Blocks.GLASS.getDefaultState());
        target.worldObj.setBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), YuruBlocks.disappearGlassBlock.getDefaultState());
        return true;
    }
}
