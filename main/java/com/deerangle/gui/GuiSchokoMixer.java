package com.deerangle.gui;

import com.deerangle.main.SchokoMod;
import com.deerangle.tile.TileEntitySchokoMixer;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiSchokoMixer extends GuiContainer {

	private IInventory playerInv;
	private TileEntitySchokoMixer tileEntity;

	public GuiSchokoMixer(IInventory inv, TileEntitySchokoMixer te) {
		super(new ContainerSchokoMixer(inv, te));

		this.playerInv = inv;
		this.tileEntity = te;
		
		this.xSize = 176;
		this.ySize = 166;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int mouseX, int mouseY) {
		this.mc.getTextureManager().bindTexture(new ResourceLocation(SchokoMod.MODID + ":textures/gui/container/schokoMixerGui.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		int process = tileEntity.process == 0 ? 0 : (int) (((double) tileEntity.process / (double) tileEntity.processMax) * 24.0);
		this.drawTexturedModalRect(this.guiLeft + 79, this.guiTop + 35, this.xSize, 0, 24 - process, 17);
		
		if(tileEntity.slots[0] != null){
			this.drawTexturedModalRect(this.guiLeft + 35, this.guiTop + 25, 8, 84, 16, 16);
		}
		
		if(tileEntity.slots[1] != null){
			this.drawTexturedModalRect(this.guiLeft + 55, this.guiTop + 25, 8, 84, 16, 16);
		}
		
		if(tileEntity.slots[2] != null){
			this.drawTexturedModalRect(this.guiLeft + 35, this.guiTop + 45, 8, 84, 16, 16);
		}
		
		if(tileEntity.slots[3] != null){
			this.drawTexturedModalRect(this.guiLeft + 55, this.guiTop + 45, 8, 84, 16, 16);
		}
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
		String s = StatCollector.translateToLocal("tile.schokoMixer.name");
		this.fontRendererObj.drawString(s, 88 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
		this.fontRendererObj.drawString(StatCollector.translateToLocal(this.playerInv.getInventoryName()), 8, 72, 4210752);
	}

}
