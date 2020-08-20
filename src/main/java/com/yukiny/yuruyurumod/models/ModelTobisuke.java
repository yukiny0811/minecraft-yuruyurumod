package com.yukiny.yuruyurumod.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTobisuke extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer head;

    public ModelTobisuke(){
        float f = 4.0F;

        head = new ModelRenderer(this, 0, 0).setTextureSize(64, 64);

        head.setTextureOffset(0, 0);
        head.addBox(-3.0F, -1.0F, -7.0F, 6, 6, 6);

        head.setTextureOffset(24, 0);
        head.addBox(-1.5F, 3.0F, -8.0F, 3, 1, 1);
        head.setRotationPoint(0.0F, 0.0F + f + 9.0F, 0.0F);

        body = new ModelRenderer(this, 0, 0).setTextureSize(64, 64);

        body.setTextureOffset(0, 18);
        body.addBox(-4.5F, -6.0F, -7.5F, 9, 6, 12);

        body.setTextureOffset(30, 0);
        body.addBox(-5.5F, -5.0F, -7.0F, 1, 4, 8);

        body.setTextureOffset(30, 0);
        body.addBox(4.5F, -5.0F, -7.0F, 1, 4, 8);
        body.setRotationPoint(0.0F, 0.0F + f + 20.0F, 0.0F);
    }

    @Override
    public void setRotationAngles(float time, float speed, float miscAngle, float yaw, float pitch, float scale, Entity entity) {
        super.setRotationAngles(time, speed, miscAngle, yaw, pitch, scale, entity);
        head.rotateAngleY = yaw / (180F / (float) Math.PI) * 0.25F;
    }

    @Override
    public void render(Entity entity, float time, float speed, float miscAngle, float yaw, float pitch, float scale) {
        setRotationAngles(time, speed, miscAngle, yaw, pitch, scale, entity);
        head.render(scale);
        body.render(scale);
    }
}
