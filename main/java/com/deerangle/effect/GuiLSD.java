package com.deerangle.effect;

import org.lwjgl.opengl.GL11;

import com.deerangle.main.NoahsChocolate;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;

public class GuiLSD extends Gui {

	public GuiLSD(Minecraft mc) {
		if (mc.player.isPotionActive(ModPotions.lsd)) {
			ScaledResolution scaled = new ScaledResolution(mc);
			int width = scaled.getScaledWidth();
			int height = scaled.getScaledHeight();

			mc.getTextureManager().bindTexture(new ResourceLocation(NoahsChocolate.MODID + ":textures/gui/lsd.png"));
			drawDrawFullscreenImage(width, height, (int) (mc.getSystemTime() % 4));
		}
	}

	public static void drawDrawFullscreenImage(int width, int height, int index) {
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder bufferbuilder = tessellator.getBuffer();
        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferbuilder.pos(0.0D, (double) height, -90.0D).tex(0.0D, 0.25D * index).endVertex();
        bufferbuilder.pos((double) width, (double) height, -90.0D).tex(1.0D, 0.25D * index).endVertex();
        bufferbuilder.pos((double) width, 0.0D, -90.0D).tex(1.0D, 0.25D * index).endVertex();
        bufferbuilder.pos(0.0D, 0.0D, -90.0D).tex(0.0D, 0.25D * index).endVertex();
		tessellator.draw();
		GL11.glDisable(GL11.GL_BLEND);
	}

}
