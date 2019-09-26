package com.florianhirson.stalinium.render;

import com.florianhirson.stalinium.Stalinium;
import com.florianhirson.stalinium.entity.EntityYeet;
import com.florianhirson.stalinium.init.ModItems;
import com.florianhirson.stalinium.lib.Textures;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderEntityYeet extends RenderEntity {

    private static final ResourceLocation TEXTURE = new ResourceLocation("stalinium:textures/items/" + Textures.ITEM_YEET + ".png");

    public static final Logger LOGGER =  LogManager.getLogger(Stalinium.MODID);

    public static final IRenderFactory<EntityYeet> FACTORY = RenderEntityYeet::new;

    public RenderEntityYeet(RenderManager manager) {
        super(manager);
    }

    private void renderYeet(EntityYeet entity, double x, double y, double z, float var1, float partialTicks) {
        LOGGER.info(Stalinium.NAME + "Render entityYeet");

        if (!entity.hasRenderOffsetX()) {
            entity.setRenderOffsetX(calculateXoffset());
        }

        int circlePoints = 200;
        double radius = 0.5D;
        GlStateManager.pushMatrix();
        GlStateManager.enableRescaleNormal();
        GlStateManager.disableTexture2D();
        GlStateManager.color(0.8F, 0.8F, 0.8F, 0.7F);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.translate((float) x, (float) y, (float) z);
        GlStateManager.rotate(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks, 0.0F, 0.0F, 1.0F);

        GlStateManager.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks, 0.0F, 1.0F, 0.0F);

        for (int i = 0; i < circlePoints; i++) {
            float angleRadians = (float) i / (float) circlePoints * 2F * (float) Math.PI;
            GlStateManager.pushMatrix();
            GlStateManager.translate(radius * Math.sin(angleRadians), radius * Math.cos(angleRadians), 0);
            renderGust(entity.getRenderOffsetX());
            GlStateManager.popMatrix();
        }

        GlStateManager.disableRescaleNormal();
        GlStateManager.disableBlend();
        GlStateManager.enableTexture2D();
        GlStateManager.popMatrix();

    }

    private float calculateXoffset() {
        EntityPlayerSP player = Minecraft.getMinecraft().player;
        EnumHandSide hs = player.getPrimaryHand();
        if (player.getHeldItemMainhand().getItem() != ModItems.ITEM_YEET_GUN) {
            hs = hs.opposite();
        }
        // yeah, this is supposed to be asymmetric; it looks better that way
        return hs == EnumHandSide.RIGHT ? -4.0F : 16.0F;
    }

    private void renderGust(float xOffset) {
        byte b0 = 0;
        //float f2 = 0.0F;
        //float f3 = 0.5F;
        //float f4 = (0 + b0 * 10) / 16.0F;
        // float f5 = (5 + b0 * 10) / 16.0F;
        float f6 = 0.0F;
        float f7 = 0.15625F;
        float f8 = (5 + b0 * 10) / 16.0F;
        float f9 = (10 + b0 * 10) / 16.0F;
        float f10 = 0.05625F;
        GlStateManager.enableRescaleNormal();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        GlStateManager.rotate(45.0F, 1.0F, 0.0F, 0.0F);
        GlStateManager.scale(f10, f10, f10);
        GlStateManager.translate(xOffset, 0.0F, 0.0F);
        GlStateManager.glNormal3f(f10, 0.0F, 0.0F);
        BufferBuilder wr = Tessellator.getInstance().getBuffer();
        wr.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);

        wr.pos(-7.0D, -2.0D, -2.0D).tex(f6, f8).endVertex();
        wr.pos(-7.0D, -2.0D, 2.0D).tex(f7, f8).endVertex();
        wr.pos(-7.0D, 2.0D, 2.0D).tex(f7, f9).endVertex();
        wr.pos(-7.0D, 2.0D, -2.0D).tex(f6, f9).endVertex();

        double start = 0d;
        double end = 1 / 16d;
        wr.pos(-7.0D, -2.0D, -2.0D).tex(start, start).endVertex();
        wr.pos(-7.0D, -2.0D, 2.0D).tex(start, end).endVertex();
        wr.pos(-7.0D, 2.0D, 2.0D).tex(end, end).endVertex();
        wr.pos(-7.0D, 2.0D, -2.0D).tex(end, start).endVertex();
        Tessellator.getInstance().draw();
        GlStateManager.glNormal3f(-f10, 0.0F, 0.0F);

        wr.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
        wr.pos(-7.0D, 2.0D, -2.0D).tex(f6, f8).endVertex();
        wr.pos(-7.0D, 2.0D, 2.0D).tex(f7, f8).endVertex();
        wr.pos(-7.0D, -2.0D, 2.0D).tex(f7, f9).endVertex();
        wr.pos(-7.0D, -2.0D, -2.0D).tex(f6, f9).endVertex();
        Tessellator.getInstance().draw();

    }


    @Override
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
        LOGGER.info(Stalinium.NAME + "Render entityYeet");
        renderYeet((EntityYeet) par1Entity, par2, par4, par6, par8, par9);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity par1Entity) {
        return TEXTURE;
    }
}
