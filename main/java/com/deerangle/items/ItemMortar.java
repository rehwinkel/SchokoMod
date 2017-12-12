package com.deerangle.items;

import com.deerangle.main.SchokoMod;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemMortar extends Item {

	public ItemMortar() {
		this.setUnlocalizedName("mortar");
		this.setTextureName(SchokoMod.MODID + ":mortar");
		this.setCreativeTab(SchokoMod.rest);
		this.setMaxStackSize(1);
		this.setContainerItem(this);
	}
	
	@Override
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack stack) {
		return false;
	}
	
}
