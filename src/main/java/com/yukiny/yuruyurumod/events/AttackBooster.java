package com.yukiny.yuruyurumod.events;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AttackBooster {

    @SubscribeEvent
    public void onEntityHit(LivingAttackEvent event){
        Entity attacker = event.getSource().getEntity();
        Entity target = event.getEntityLiving();

        if(target == null) return;

        if(attacker == null) return;

        if(!(attacker instanceof EntityPlayer)) return;

        EntityPlayer player = (EntityPlayer) attacker;

        if(player.getHeldItemMainhand() == null) return;

        Item item = Items.GOLDEN_APPLE;

        if(player.getHeldItemMainhand().getItem() == item){
            event.getEntityLiving().attackEntityFrom(DamageSource.causeIndirectMagicDamage(player, null), 100f);
        }
    }
}
