package io.github.herpahermaderp.test;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelEyeCage extends ModelBase {
    public ModelRenderer p1 = (new ModelRenderer(this)).setTextureOffset(1, 1).addBox(3.0f, 7.0f, 6.0f, 1, 1, 4);
    
    public ModelEyeCage() {
        System.out.println("I exist");
        this.p1.setRotationPoint(0.0f, 0.0f, 0.0f);
    }
    
    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.p1.render(scale);
    }
}
