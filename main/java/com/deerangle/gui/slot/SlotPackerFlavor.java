package com.deerangle.gui.slot;

import com.deerangle.item.ModItems;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotPackerFlavor extends SlotItemHandler {

	public SlotPackerFlavor(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
		super(itemHandler, index, xPosition, yPosition);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		return stack.getItem() == ModItems.FLAVOR_ENHANCER;
	}

}
