package io.github.herpahermaderp.test;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class TileEntityEyeCageRenderer extends TileEntitySpecialRenderer<TileEntityEyeCage> {
    private final ModelEyeCage modelEyeCage = new ModelEyeCage();
    
    public TileEntityEyeCageRenderer() {}
    
    @Override
    public void render(TileEntityEyeCage te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        System.out.println("I'm happening");
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x + 0.5f, (float)y + 0.5f, (float)z + 0.5f);
        float f = (float)te.tickCount + partialTicks;
        GlStateManager.translate(0.0f, 0.1f + MathHelper.sin(f * 0.1f) * 0.01f, 0.0f);
        float f1;
        
        for(f1 = te.rotation - te.rotationPrev; f1 >= (float) Math.PI; f1 -= ((float)Math.PI * 2f)) {
            ;
        }
        
        while(f1 < -(float)Math.PI) {
            f1 += ((float)Math.PI *2f);
        }
        
        float f2 = te.rotationPrev + f1 * partialTicks;
        GlStateManager.rotate(-f2 * (180f / (float)Math.PI), 0.0f, 1.0f, 0.0f);
        GlStateManager.enableCull();
        this.modelEyeCage.render((Entity)null, f, 0f, 0f, 0f, 0f, 0.0625f);
        GlStateManager.popMatrix();
    }
}
