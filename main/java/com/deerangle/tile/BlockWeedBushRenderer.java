package com.deerangle.tile;

import com.deerangle.main.ClientProxy;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;

public class BlockWeedBushRenderer implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
		renderer.renderBlockAsItem(ModBlocks.weedBushInv, 0, 0.8F);
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		Tessellator t = Tessellator.instance;
		for (int i = 0; i < 8; i++) {
			t.addVertex(0, 0, 0);
		}
		int meta = world.getBlockMetadata(x, y, z);
		if (ClientProxy.renderPass == 0) {
			if (meta == 0) {
				renderer.setRenderBounds(0.25F, 0.0F, 0.25F, 1 - 0.25F, 1 - 0.5F, 1 - 0.25F);
			}
			if (meta == 1) {
				renderer.setRenderBounds(0.125F, 0.0F, 0.125F, 1 - 0.125F, 1 - 0.25F, 1 - 0.125F);
			}
			if (meta > 1) {
				renderer.setRenderBounds(0, 0, 0, 1, 1, 1);
			}
			renderer.renderStandardBlock(block, x, y, z);
		}

		if (ClientProxy.renderPass == 1) {
			if (meta == 3) {
				renderer.setRenderBounds(0, 0, 0, 1, 1, 1);
				renderer.renderStandardBlock(block, x, y, z);
			}
		}

		return true;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return true;
	}

	@Override
	public int getRenderId() {
		return ClientProxy.rendererWeed;
	}

}