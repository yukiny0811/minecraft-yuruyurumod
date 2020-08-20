package com.yukiny.yuruyurumod.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

//オリジナルのクリエイティブタブ

public class YuruCreativeTab extends CreativeTabs {

    public YuruCreativeTab(String label){
        super(label);
    }

    @Override
    public Item getTabIconItem() {
        return Items.DIAMOND;
    }
}
