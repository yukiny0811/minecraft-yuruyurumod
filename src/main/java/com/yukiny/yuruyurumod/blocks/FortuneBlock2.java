package com.yukiny.yuruyurumod.blocks;

import com.yukiny.yuruyurumod.YuruyuruMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

//持っているアイテムがGolden Appleだったときにチャットに"Golden Apple!"と表示するブロック

public class FortuneBlock2 extends Block {
    public FortuneBlock2(){
        super(Material.ROCK);
        setCreativeTab(YuruyuruMod.yuruTab);
        setRegistryName("fortune_block_2");
        setUnlocalizedName(YuruyuruMod.MODID + "_fortune_block_2");
        setHardness(30);
    }

    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
        super.onBlockClicked(worldIn, pos, playerIn);

        ItemStack heldItem = playerIn.getHeldItemMainhand();
        if(!worldIn.isRemote){
            if(heldItem != null){
                if(heldItem.getItem() == Items.GOLDEN_APPLE){
                    playerIn.addChatComponentMessage(new TextComponentString("Golden Apple!!!"));
                }
            }
        }
    }
}
