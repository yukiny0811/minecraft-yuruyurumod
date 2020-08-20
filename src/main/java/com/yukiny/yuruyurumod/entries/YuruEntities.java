package com.yukiny.yuruyurumod.entries;

import com.yukiny.yuruyurumod.YuruyuruMod;
import com.yukiny.yuruyurumod.entities.EntityBull;
import com.yukiny.yuruyurumod.entities.EntityExplosiveArrow;
import com.yukiny.yuruyurumod.entities.EntityMySnowball;
import com.yukiny.yuruyurumod.renders.RenderBull;
import com.yukiny.yuruyurumod.renders.RenderExplosiveArrow;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Items;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class YuruEntities {

    public static void register(){
        EntityRegistry.registerModEntity(EntityBull.class, "bull", EntityBull.ENTITY_ID, YuruyuruMod.MODID, 50, 2, true, 0xffff00, 0xff0000);
        RenderingRegistry.registerEntityRenderingHandler(EntityBull.class, RenderBull::new);

        EntityRegistry.registerModEntity(EntityExplosiveArrow.class, "explosive_arrow", EntityExplosiveArrow.ENTITY_ID, YuruyuruMod.MODID, 10, 2, true);
        RenderingRegistry.registerEntityRenderingHandler(EntityExplosiveArrow.class, RenderExplosiveArrow::new);

        EntityRegistry.registerModEntity(EntityMySnowball.class, "my_snowball", EntityMySnowball.ENTITY_ID, YuruyuruMod.MODID, 10, 2, true);
        RenderingRegistry.registerEntityRenderingHandler(EntityMySnowball.class, manager -> new RenderSnowball<>(manager, Items.SNOWBALL, Minecraft.getMinecraft().getRenderItem()));
    }
}
