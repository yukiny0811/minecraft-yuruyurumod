package com.yukiny.yuruyurumod.renders;

import com.yukiny.yuruyurumod.entities.EntityBull;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderBull extends RenderLiving<EntityBull> {
    private static final ResourceLocation COW_TEXTURES = new ResourceLocation("textures/entity/cow/cow.png");

    public RenderBull(RenderManager renderManager){
        super(renderManager, new ModelCow(), 0.7f);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityBull entity) {
        return COW_TEXTURES;
    }
}
