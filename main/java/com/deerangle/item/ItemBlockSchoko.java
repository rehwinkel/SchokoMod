package com.deerangle.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOldLog;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockSchoko extends ItemBlock {

	public ItemBlockSchoko(Block block) {
		super(block);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}
	
	@Override
	public int getMetadata(int damage) {
		return damage;
	}
	
	@Override
	public int getMetadata(ItemStack stack) {
		return stack.getItemDamage();
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		String[] types = new String[] { "normal", "dark", "light" };
		return super.getUnlocalizedName() + "_" + types[stack.getMetadata()];
	}

}
