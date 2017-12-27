package com.deerangle.gui;

import java.util.ArrayList;
import java.util.List;

import com.deerangle.block.ModBlocks;
import com.deerangle.block.entity.TileEntityDistiller;
import com.deerangle.main.NoahsChocolate;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.config.GuiCheckBox;

public class GuiDistiller extends GuiContainer {

	private ResourceLocation texture;
	private ResourceLocation texture2;
	private InventoryPlayer playerInv;
	private TileEntityDistiller tileEntity;

	public GuiDistiller(InventoryPlayer inventory, TileEntityDistiller tileEntity) {
		super(new ContainerDistiller(inventory, tileEntity));
		texture = new ResourceLocation(NoahsChocolate.MODID + ":textures/gui/container/gui_distiller.png");
		texture2 = new ResourceLocation(NoahsChocolate.MODID + ":textures/blocks/distiller_fluid.png");
		
		this.playerInv = inventory;
		this.tileEntity = tileEntity;
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		
		GlStateManager.color(1, 1, 1, 1);
		mc.getTextureManager().bindTexture(texture);
		drawTexturedModalRect(x, y, 0, 0, xSize, ySize);

		//fluid
		int weeds = tileEntity.processedWeed;
		int val = weeds == 0 ? 0 : (int) (weeds * (23.0 / tileEntity.maxProcessedWeed)) + 1;
		val = (val > 23 ? 23 : val < 0 ? 0 : val);
		drawTexturedModalRect(x + 80, y + 29 + (23 - val), xSize + 64, 0, 16, 23 - (23 - val));

		//progress
		double progress = ((double) tileEntity.processTimeTHC / (double) tileEntity.maxProcessTimeTHC);
		int n3 = 22 - (int) (progress * 22);
		n3 = (tileEntity.processTimeTHC == 0 ? 0 : n3);
		drawTexturedModalRect(x + 102, y + 34, xSize + 19, 0, n3, 16);

		//fire
		double burn = ((double) tileEntity.burnTime / (double) tileEntity.maxBurnTime);
		int n = 12 - (int) (burn * 12);
		n = (burn == 0 ? 14 : n);
		n = (tileEntity.maxBurnTime == 0 ? 14 : n);
		drawTexturedModalRect(x + 27, y + 34 + n, xSize, 34 + n, 14, 14 + n);
		
		//bubbles
		double bubble = ((double) tileEntity.processTimeWeed / (double) tileEntity.maxProcessTimeWeed);
		int n2 = 19 - (int) (bubble * 19);
		n2 = (tileEntity.processTimeWeed == 0 ? 0 : n2);
		drawTexturedModalRect(x + 52, y + 35, xSize, 0, n2, 11);
		
		//fluid gauge
		drawTexturedModalRect(x + 80, y + 29, xSize, 11, 19, 23);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String name = I18n.format(ModBlocks.distiller.getUnlocalizedName() + ".name");
		fontRenderer.drawString(name, xSize / 2 - fontRenderer.getStringWidth(name) / 2, 6, 0x404040);
		fontRenderer.drawString(playerInv.getDisplayName().getUnformattedText(), 8, ySize - 94, 0x404040);

		mouseX = (mouseX - (width - xSize) / 2);
		mouseY = (mouseY - (height - ySize) / 2);

		if (mouseX >= 80 && mouseX < 96 && mouseY >= 29 && mouseY < 53) {
			List<String> text = new ArrayList<String>();
			text.add(I18n.format("info.thc") + ": " + tileEntity.processedWeed + "/" + tileEntity.maxProcessedWeed);
			drawHoveringText(text, mouseX, mouseY, this.fontRenderer);
		}
	}

}
