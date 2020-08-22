package com.yukiny.yuruyurumod.entries;

import com.yukiny.yuruyurumod.YuruyuruMod;
import com.yukiny.yuruyurumod.entities.*;
import com.yukiny.yuruyurumod.renders.RenderBull;
import com.yukiny.yuruyurumod.renders.RenderChasingArrow;
import com.yukiny.yuruyurumod.renders.RenderExplosiveArrow;
import com.yukiny.yuruyurumod.renders.RenderTobisuke;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Items;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class YuruEntities {

    public static void register(){

        EntityRegistry.registerModEntity(EntityBull.class, "bull", EntityBull.ENTITY_ID, YuruyuruMod.MODID, 50, 2, true, 0xffff00, 0xff0000);
        RenderingRegistry.registerEntityRenderingHandler(EntityBull.class, RenderBull::new);

        EntityRegistry.registerModEntity(EntityExplosiveArrow.class, "explosive_arrow", EntityExplosiveArrow.ENTITY_ID, YuruyuruMod.MODID, 50, 2, true);
        RenderingRegistry.registerEntityRenderingHandler(EntityExplosiveArrow.class, RenderExplosiveArrow::new);

        EntityRegistry.registerModEntity(EntityMySnowball.class, "my_snowball", EntityMySnowball.ENTITY_ID, YuruyuruMod.MODID, 50, 2, true);
        RenderingRegistry.registerEntityRenderingHandler(EntityMySnowball.class, manager -> new RenderSnowball<>(manager, Items.SNOWBALL, Minecraft.getMinecraft().getRenderItem()));

        EntityRegistry.registerModEntity(EntityTobisuke.class, "tobisuke", EntityTobisuke.ENTITY_ID, YuruyuruMod.MODID, 50, 2, true, 0xff0000, 0x00ff00);
        EntityRegistry.addSpawn(EntityTobisuke.class, 20, 15, 30, EnumCreatureType.CREATURE, YuruGenerators.entryOfIcebergBiome.biome);
        EntityRegistry.addSpawn(EntityTobisuke.class, 20, 15, 30, EnumCreatureType.CREATURE, YuruGenerators.entryOfMyBiome.biome);
        RenderingRegistry.registerEntityRenderingHandler(EntityTobisuke.class, RenderTobisuke::new);

        EntityRegistry.registerModEntity(EntityMyFireball.class, "my_fireball", EntityMyFireball.ENTITY_ID, YuruyuruMod.MODID, 50, 1, true);
        RenderingRegistry.registerEntityRenderingHandler(EntityMyFireball.class, manager -> new RenderFireball(manager, 1f));

        EntityRegistry.registerModEntity(EntityMyTNTPrimed.class, "my_tnt_primed", EntityMyTNTPrimed.ENTITY_ID, YuruyuruMod.MODID, 50, 1, true);
        RenderingRegistry.registerEntityRenderingHandler(EntityMyTNTPrimed.class, RenderTNTPrimed::new);

        EntityRegistry.registerModEntity(EntityChasingArrow.class, "chasing_arrow", EntityChasingArrow.ENTITY_ID, YuruyuruMod.MODID, 50, 1, true);
        RenderingRegistry.registerEntityRenderingHandler(EntityChasingArrow.class, RenderChasingArrow::new);

    }

}
