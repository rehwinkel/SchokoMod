package com.deerangle.tile;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemBlockSchoko extends ItemBlockWithMetadata {

	private String[] types = new String[] { "normal", "black", "white" };
	
	public ItemBlockSchoko(Block b) {
		super(b, b);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName() + "_" + types[stack.getItemDamage()];
	}

}
