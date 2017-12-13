package com.deerangle.tile;

import com.deerangle.main.SchokoMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockWeedBushInv extends Block {

	protected BlockWeedBushInv() {
		super(Material.leaves);
		this.setHardness(0.65F);
		this.setBlockName("weedBushInv");
		this.setBlockTextureName(SchokoMod.MODID + ":weedBush");
		this.setBlockBounds(0.25F, 0.0F, 0.25F, 1 - 0.25F, 1 - 0.5F, 1 - 0.25F);
	}

}
