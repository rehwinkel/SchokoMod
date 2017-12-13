package com.deerangle.gui;

import org.lwjgl.opengl.GL11;

import com.deerangle.main.SchokoMod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;

public class GuiLSD extends Gui {

	public GuiLSD(Minecraft mc) {
		if (mc.thePlayer.isPotionActive(SchokoMod.lsdPotion.id)) {
			ScaledResolution scaled = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
			int width = scaled.getScaledWidth();
			int height = scaled.getScaledHeight();

			mc.getTextureManager().bindTexture(new ResourceLocation(SchokoMod.MODID + ":textures/gui/lsd.png"));
			drawDrawFullscreenImage(width, height, (int) (mc.getSystemTime() % 4));
		}
	}

	public static void drawDrawFullscreenImage(int width, int height, int index) {
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV(0.0D, (double) height, -90.0D, 0.0D, 0.25D * index);
		tessellator.addVertexWithUV((double) width, (double) height, -90.0D, 1.0D, 0.25D * index);
		tessellator.addVertexWithUV((double) width, 0.0D, -90.0D, 1.0D, 0.25D * index);
		tessellator.addVertexWithUV(0.0D, 0.0D, -90.0D, 0.0D, 0.25D * index);
		tessellator.draw();
		GL11.glDisable(GL11.GL_BLEND);
	}

}
