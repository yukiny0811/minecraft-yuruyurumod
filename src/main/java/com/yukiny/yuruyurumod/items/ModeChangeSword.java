package com.yukiny.yuruyurumod.items;

import com.yukiny.yuruyurumod.YuruyuruMod;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.common.util.EnumHelper;

//剣を振ったときに効果が変わる。簡易版。メンバーに書かせるとき用。

public class ModeChangeSword extends ItemSword {

    private static int type = 0;

    public ModeChangeSword(){
        super(EnumHelper.addToolMaterial("mode_change_sword", 4, 200, 16f, 1f, 22));
        setCreativeTab(YuruyuruMod.yuruTab);
        setRegistryName("mode_change_sword");
        setUnlocalizedName(YuruyuruMod.MODID + "_mode_change_sword");
    }

    @Override
    public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
        if (stack == null) {
            return true;
        }
        if (!(entityLiving instanceof EntityPlayer)) {
            return true;
        }
        switch (type) {
            case 0:
                // ポーション
                entityLiving.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS,100,1200000));
                type = 1;
                break;

            case 1:
                // 天気を変えるコード
                WorldInfo info = entityLiving.worldObj.getWorldInfo();
                info.setRainTime(1000);
                info.setRaining(true);
                type = 2;
                break;
            case 2:
                // 雷を落とすコード

                entityLiving.getEntityWorld().addWeatherEffect(new EntityLightningBolt(entityLiving.getEntityWorld(),entityLiving.posX,
                        entityLiving.posY,entityLiving.posZ,
                        false));
                type = 0;
                break;

        }
        return true;
    }

}
