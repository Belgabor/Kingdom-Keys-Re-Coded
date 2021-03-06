package uk.co.wehavecookies56.kk.client.model.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Moogle - Wehavecookies56
 * Created using Tabula 5.1.0
 */
public class ModelMoogle extends ModelBase {
    public ModelRenderer shape1;
    public ModelRenderer shape2;
    public ModelRenderer shape3;
    public ModelRenderer shape4;
    public ModelRenderer shape5;
    public ModelRenderer shape7;
    public ModelRenderer shape8;
    public ModelRenderer shape6;
    public ModelRenderer shape9;
    public ModelRenderer shape11;
    public ModelRenderer shape13;
    public ModelRenderer shape14;
    public ModelRenderer shape12;

    public ModelMoogle() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.shape13 = new ModelRenderer(this, 16, 30);
        this.shape13.setRotationPoint(-2.0F, 1.0F, -2.0F);
        this.shape13.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.shape6 = new ModelRenderer(this, 10, 10);
        this.shape6.setRotationPoint(-4.5F, 10.5F, -0.5F);
        this.shape6.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
        this.setRotateAngle(shape6, 0.0F, 0.0F, -0.4363323129985824F);
        this.shape7 = new ModelRenderer(this, 21, 0);
        this.shape7.setRotationPoint(2.0F, 9.3F, -0.6F);
        this.shape7.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
        this.setRotateAngle(shape7, 0.0F, 0.0F, 0.4363323129985824F);
        this.shape3 = new ModelRenderer(this, 0, 22);
        this.shape3.setRotationPoint(-0.5F, -1.0F, -0.5F);
        this.shape3.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(-1.5F, -4.0F, -1.5F);
        this.shape1.addBox(0.0F, 0.0F, 0.0F, 3, 3, 3, 0.0F);
        this.shape9 = new ModelRenderer(this, 21, 8);
        this.shape9.setRotationPoint(0.5F, 12.0F, 0.0F);
        this.shape9.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(shape9, 0.5759586531581287F, 0.0F, 0.0F);
        this.shape8 = new ModelRenderer(this, 0, 9);
        this.shape8.setRotationPoint(-1.5F, 12.0F, 0.0F);
        this.shape8.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(shape8, 0.5759586531581287F, 0.0F, 0.0F);
        this.shape14 = new ModelRenderer(this, 25, 30);
        this.shape14.setRotationPoint(1.0F, 1.0F, -2.0F);
        this.shape14.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.shape5 = new ModelRenderer(this, 33, 0);
        this.shape5.setRotationPoint(-2.0F, 8.0F, -2.0F);
        this.shape5.addBox(0.0F, 0.0F, 0.0F, 4, 4, 4, 0.0F);
        this.shape11 = new ModelRenderer(this, 29, 9);
        this.shape11.setRotationPoint(1.0F, 8.5F, 2.0F);
        this.shape11.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(shape11, -0.18203784098300857F, 0.5918411493512771F, 0.0F);
        this.shape2 = new ModelRenderer(this, 35, 20);
        this.shape2.setRotationPoint(-3.0F, 2.0F, -3.0F);
        this.shape2.addBox(0.0F, 0.0F, 0.0F, 6, 6, 6, 0.0F);
        this.shape12 = new ModelRenderer(this, 29, 9);
        this.shape12.setRotationPoint(-2.0F, 8.5F, 2.0F);
        this.shape12.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(shape12, -0.18203784098300857F, -0.5918411493512771F, 0.0F);
        this.shape4 = new ModelRenderer(this, 0, 15);
        this.shape4.setRotationPoint(-1.5F, 4.0F, -4.0F);
        this.shape4.addBox(0.0F, 0.0F, 0.0F, 3, 2, 1, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.shape13.render(f5);
        this.shape6.render(f5);
        this.shape7.render(f5);
        this.shape3.render(f5);
        this.shape1.render(f5);
        this.shape9.render(f5);
        this.shape8.render(f5);
        this.shape14.render(f5);
        this.shape5.render(f5);
        this.shape11.render(f5);
        this.shape2.render(f5);
        this.shape12.render(f5);
        this.shape4.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
