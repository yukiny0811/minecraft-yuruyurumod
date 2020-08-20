package com.yukiny.yuruyurumod.renders;

import com.yukiny.yuruyurumod.entities.EntityTobisuke;
import com.yukiny.yuruyurumod.models.ModelTobisuke;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderTobisuke extends RenderLiving<EntityTobisuke> {
    private static final ResourceLocation TOBISUKE_TEXTURE = new ResourceLocation("yuruyurumod:textures/entity/tobisuke/tobisuke.png");

    public RenderTobisuke(RenderManager renderManager){
        super(renderManager, new ModelTobisuke(), 0.5f);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityTobisuke entity) {
        return TOBISUKE_TEXTURE;
    }
}
