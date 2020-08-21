package com.yukiny.yuruyurumod.blocks;

import com.yukiny.yuruyurumod.YuruyuruMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentDamage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EnchanterBlock extends Block {
    public EnchanterBlock(){
        super(Material.IRON);
        setCreativeTab(YuruyuruMod.yuruTab);
        setRegistryName("enchanter_block");
        setUnlocalizedName(YuruyuruMod.MODID + "_enchanter_block");
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        if(worldIn.isRemote) return true;

        if(playerIn == null) return true;

        if(heldItem == null) return true;

        Item item = heldItem.getItem();
        if(!(item instanceof ItemSword)) return true;

        Enchantment enchantment = Enchantments.FLAME;

        if(heldItem.hasTagCompound()){
            NBTTagList tagList = heldItem.getEnchantmentTagList();
            for(int i = 0; i < tagList.tagCount(); i++){
                short id = tagList.getCompoundTagAt(i).getShort("id");
                if(Enchantment.getEnchantmentByID(id) == enchantment){
                    tagList.removeTag(i);
                }
            }
        }

        heldItem.addEnchantment(enchantment, enchantment.getMaxLevel());

        return true;
    }
}
