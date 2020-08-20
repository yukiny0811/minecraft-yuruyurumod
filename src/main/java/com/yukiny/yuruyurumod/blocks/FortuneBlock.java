package com.yukiny.yuruyurumod.blocks;

import com.yukiny.yuruyurumod.YuruyuruMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import java.util.Random;

//クリックするたびにランダムな数字が表示されるブロック

public class FortuneBlock extends Block {
    public FortuneBlock(){
        super(Material.ROCK);
        setCreativeTab(YuruyuruMod.yuruTab);
        setRegistryName("fortune_block");
        setUnlocalizedName(YuruyuruMod.MODID + "_fortune_block");
        setHardness(30);
    }

    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
        super.onBlockClicked(worldIn, pos, playerIn);

        Random random = new Random();
        int randomNumber = random.nextInt(5);

        String text = Integer.toString(randomNumber);

        if(!worldIn.isRemote){
            playerIn.addChatComponentMessage(new TextComponentString("Life is Tech!" + text));
        }
    }
}
