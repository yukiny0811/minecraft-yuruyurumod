package com.yukiny.yuruyurumod.items;

import com.yukiny.yuruyurumod.YuruyuruMod;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

//右クリックで攻撃、回復のモードを切り替えられる。

public class TwoWaySword extends ItemSword {
    public TwoWaySword(){
        super(EnumHelper.addToolMaterial("mysword", 4, 200, 16f, 0f, 22));
        setCreativeTab(YuruyuruMod.yuruTab);
        setRegistryName("two_way_sword");
        setUnlocalizedName(YuruyuruMod.MODID + "_two_way_sword");
    }


    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {

        if(worldIn.isRemote) return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);

        NBTTagCompound nbt;
        if(itemStackIn.hasTagCompound()){
            nbt = itemStackIn.getTagCompound();
            if(nbt.hasKey("form")){
                nbt.setBoolean("form", !nbt.getBoolean("form"));
            } else {
                nbt.setBoolean("form", true);
            }
        } else {
            nbt = new NBTTagCompound();
            nbt.setBoolean("form", true);
        }
        itemStackIn.setTagCompound(nbt);

        boolean bool = nbt.getBoolean("form");
        if(bool){
            playerIn.addChatComponentMessage(new TextComponentString("sword mode has set to ATTACK MODE"));
        } else {
            playerIn.addChatComponentMessage(new TextComponentString("sword mode has set to HEAL MODE"));
        }


        return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        if(!(attacker instanceof EntityPlayer)) return super.hitEntity(stack, target, attacker);
        if(stack == null) return super.hitEntity(stack, target, attacker);
        if(stack.hasTagCompound()){
            NBTTagCompound nbt = stack.getTagCompound();
            if(nbt.hasKey("form")){
                boolean bool = nbt.getBoolean("form");
                if(bool){
                    target.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)attacker), 6f);
                } else {
                    target.heal(6f);
                }
            }
        }
        return super.hitEntity(stack, target, attacker);
    }
}
