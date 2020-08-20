package com.yukiny.yuruyurumod.entries;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class YuruRecipes {

    public static void register(){
        addCreeperRecipe();
        addMyBlockRecipe();
    }

    private static void addCreeperRecipe(){
        NBTTagCompound creeperId = new NBTTagCompound();
        creeperId.setString("id", "Creeper");
        ItemStack creeperSpawnEgg = new ItemStack(Items.SPAWN_EGG);
        creeperSpawnEgg.setTagInfo("EntityTag", creeperId);
        GameRegistry.addRecipe(creeperSpawnEgg,
                " A ",
                "CBC",
                "CBC",
                'A', new ItemStack(Items.SKULL, 1, 4),
                'B', new ItemStack(Blocks.TNT),
                'C', new ItemStack(Items.GUNPOWDER));
    }

    private static void addMyBlockRecipe(){
        GameRegistry.addRecipe(new ItemStack(YuruBlocks.myBlock),
                "AAA",
                "AAA",
                "AAA",
                'A', new ItemStack(Blocks.DIRT));
    }

}
