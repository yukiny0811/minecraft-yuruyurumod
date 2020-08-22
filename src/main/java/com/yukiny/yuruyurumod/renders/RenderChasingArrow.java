package com.yukiny.yuruyurumod.renders;

import com.yukiny.yuruyurumod.entities.EntityChasingArrow;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderChasingArrow extends RenderArrow<EntityChasingArrow> {
    private static final ResourceLocation TEXTURE_CHASING_ARROW = new ResourceLocation("textures/render/arrow.png");
    public RenderChasingArrow(RenderManager manager){
        super(manager);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityChasingArrow entity) {
        return TEXTURE_CHASING_ARROW;
    }
}
