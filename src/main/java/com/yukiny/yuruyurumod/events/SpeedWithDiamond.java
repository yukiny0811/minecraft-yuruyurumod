package com.yukiny.yuruyurumod.events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class SpeedWithDiamond {

    private static final Item EVENT_ITEM = Items.DIAMOND;
    private static final Potion EVENT_EFFECT = MobEffects.SPEED;

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event){
        if(event.player == null) return;

        EntityPlayer player = event.player;
        ItemStack heldItem = player.getHeldItemMainhand();

        if(heldItem == null) return;

        if(heldItem.getItem() != EVENT_ITEM) return;

        if(player.isPotionActive(EVENT_EFFECT)) return;

        player.addPotionEffect(new PotionEffect(EVENT_EFFECT, 1, 10));

    }

}
