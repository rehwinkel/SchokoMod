package com.deerangle.gui;

import com.deerangle.main.SchokoMod;
import com.deerangle.tile.TileEntitySchokoMixer;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiSchokoMixer extends GuiContainer {

	public GuiSchokoMixer(IInventory inv, TileEntitySchokoMixer te) {
		super(new ContainerSchokoMixer(inv, te));

		this.xSize = 176;
		this.ySize = 166;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int mouseX, int mouseY) {
		this.mc.getTextureManager().bindTexture(new ResourceLocation(SchokoMod.MODID + ":textures/gui/container/schokoMixerGui.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
	}

}
