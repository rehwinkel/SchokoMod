package com.deerangle.gui.gui;

import java.util.ArrayList;
import java.util.List;

import com.deerangle.block.ModBlocks;
import com.deerangle.block.entity.TileEntityMixer;
import com.deerangle.gui.container.ContainerMixer;
import com.deerangle.main.NoahsChocolate;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiMixer extends GuiContainer {

	private InventoryPlayer playerInv;
	private TileEntityMixer tileEntity;
	private ResourceLocation texture;

	public GuiMixer(InventoryPlayer inventory, TileEntityMixer tileEntity) {
		super(new ContainerMixer(inventory, tileEntity));
		texture = new ResourceLocation(NoahsChocolate.MODID + ":textures/gui/container/gui_mixer.png");
		
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
		
		float prog = 22.0f * ((float) tileEntity.progress / tileEntity.maxProgress);
		drawTexturedModalRect(x + 86, y + 35, xSize, 0, (int) prog, 16);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String name = I18n.format(ModBlocks.MIXER.getUnlocalizedName() + ".name");
		fontRenderer.drawString(name, xSize / 2 - fontRenderer.getStringWidth(name) / 2, 6, 0x404040);
		fontRenderer.drawString(playerInv.getDisplayName().getUnformattedText(), 8, ySize - 94, 0x404040);
	}

}
