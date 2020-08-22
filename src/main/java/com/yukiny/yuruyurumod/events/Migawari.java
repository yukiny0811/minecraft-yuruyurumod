package com.yukiny.yuruyurumod.events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Migawari {
    private static final Item MIGAWARI_ITEM = Items.BONE;

    @SubscribeEvent
    public void onPlayerHurt(LivingHurtEvent event){
        if(event.getEntityLiving().worldObj.isRemote) return;

        if(!(event.getEntityLiving() instanceof EntityPlayer)) return;

        if(!(event.getEntityLiving().getHealth() - event.getAmount() <= 0)) return;

        InventoryPlayer inventory = ((EntityPlayer)event.getEntityLiving()).inventory;

        for(int i = 0; i < inventory.getSizeInventory(); i++){
            ItemStack stack = inventory.getStackInSlot(i);
            if(stack == null) continue;

            if(stack.getItem() != MIGAWARI_ITEM) continue;

            if(stack.stackSize == 1){
                inventory.removeStackFromSlot(i);
            } else {
                stack.stackSize -= 1;
            }
            event.setCanceled(true);
            return;
        }
    }
}
