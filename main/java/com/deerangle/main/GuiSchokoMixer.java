package com.deerangle.main;

import com.deerangle.tile.TileEntitySchokoMixer;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;

public class GuiSchokoMixer extends GuiContainer {

	public GuiSchokoMixer(IInventory inv, TileEntitySchokoMixer te) {
		super(new ContainerSchokoMixer(inv, te));
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int mouseX, int mouseY) {

	}

}
