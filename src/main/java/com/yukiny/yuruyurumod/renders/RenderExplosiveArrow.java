package com.yukiny.yuruyurumod.renders;

import com.yukiny.yuruyurumod.YuruyuruMod;
import com.yukiny.yuruyurumod.entities.EntityExplosiveArrow;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderExplosiveArrow extends RenderArrow<EntityExplosiveArrow> {
    public static final ResourceLocation TEXTURE_EXPLOSIVE_ARROW = new ResourceLocation("yuruyurumod:textures/entity/explosive_arrow/explosive_arrow.png");
//    public static final ResourceLocation TEXTURE_EXPLOSIVE_ARROW = new ResourceLocation(YuruyuruMod.MODID, "textures/entity/explosive_arrow/explosive_arrow.png");

    public RenderExplosiveArrow(RenderManager manager){
        super(manager);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityExplosiveArrow entity) {
        return TEXTURE_EXPLOSIVE_ARROW;
    }
}
