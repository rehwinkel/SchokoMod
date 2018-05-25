package com.deerangle.gui.gui;

import com.deerangle.block.ModBlocks;
import com.deerangle.block.entity.TileEntityMixer;
import com.deerangle.block.entity.TileEntityPacker;
import com.deerangle.gui.container.ContainerPacker;
import com.deerangle.main.NoahsChocolate;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiPacker extends GuiContainer {

	private InventoryPlayer playerInv;
	private TileEntityPacker tileEntity;
	private ResourceLocation texture;

	public GuiPacker(InventoryPlayer inventory, TileEntityPacker tileEntity) {
		super(new ContainerPacker(inventory, tileEntity));
		texture = new ResourceLocation(NoahsChocolate.MODID + ":textures/gui/container/gui_packer.png");
		
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
		
		//TODO: finish gui!
		float prog = 22.0f * ((float) tileEntity.progress / tileEntity.maxProgress);
		drawTexturedModalRect(x + 103, y + 35, xSize, 0, (int) prog, 16);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String name = I18n.format(ModBlocks.PACKER.getUnlocalizedName() + ".name");
		fontRenderer.drawString(name, xSize / 2 - fontRenderer.getStringWidth(name) / 2, 6, 0x404040);
		fontRenderer.drawString(playerInv.getDisplayName().getUnformattedText(), 8, ySize - 94, 0x404040);
	}

}
