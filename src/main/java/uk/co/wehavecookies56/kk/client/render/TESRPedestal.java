package uk.co.wehavecookies56.kk.client.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import uk.co.wehavecookies56.kk.common.block.tile.TileEntityPedestal;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeyblade;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeychain;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.PedestalRotation;

/**
 * Created by Toby on 06/11/2016.
 */
public class TESRPedestal extends TileEntitySpecialRenderer<TileEntityPedestal> {

    private RenderItem renderItem;

    @Override
    public void renderTileEntityAt(TileEntityPedestal te, double x, double y, double z, float partialTicks, int destroyStage) {
        if(te != null && te instanceof TileEntityPedestal) {
            if (te.getStackInSlot(0) != null) {

                GlStateManager.pushAttrib();
                GlStateManager.pushMatrix();

                GlStateManager.translate(x, y, z);
                GlStateManager.disableRescaleNormal();
                this.renderItem = Minecraft.getMinecraft().getRenderItem();
                GlStateManager.pushMatrix();
                {
                	int rot = te.getRotation();
                    GlStateManager.translate(0.5, 1.3, 0.5);
                    GlStateManager.rotate(90*rot, 0, 1, 0);
                    GlStateManager.scale(0.02, 0.02, 0.02);
                    te.setKeyblade(te.getStackInSlot(0));
                    Item itemToRender = te.keyblade.getItem();
                    GL11.glPushAttrib(GL11.GL_ENABLE_BIT);
                    OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 128.0F, 128.0F);

                    if(itemToRender instanceof ItemKeyblade)
                 	  renderItem.renderItem(new ItemStack(itemToRender), ItemCameraTransforms.TransformType.NONE);
                    else if (itemToRender instanceof ItemKeychain)
                   	  renderItem.renderItem(new ItemStack(((ItemKeychain) itemToRender).getKeyblade()), ItemCameraTransforms.TransformType.NONE);
                    GL11.glPopAttrib();

                }
                GlStateManager.popMatrix();
                GlStateManager.popMatrix();
                GlStateManager.popAttrib();
            }
        }

        super.renderTileEntityAt(te, x, y, z, partialTicks, destroyStage);
    }
}