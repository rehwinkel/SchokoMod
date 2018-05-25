package com.deerangle.main;

import net.minecraft.item.ItemStack;

public interface ItemHandlerConfig {

	public boolean isItemValid(int slot, ItemStack stack);

}
