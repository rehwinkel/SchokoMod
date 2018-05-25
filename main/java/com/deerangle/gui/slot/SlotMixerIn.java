package com.deerangle.gui.slot;

import java.util.ArrayList;
import java.util.List;

import com.deerangle.item.ModItems;

import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import scala.actors.threadpool.Arrays;

public class SlotMixerIn extends SlotItemHandler {

	public SlotMixerIn(IItemHandler teInv, int index, int xPosition, int yPosition) {
		super(teInv, index, xPosition, yPosition);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		Item[] validItemArray = new Item[] {ModItems.COCOA_BUTTER, ModItems.COCOA_POWDER, Items.SUGAR};
		List<Item> validItems = Arrays.asList(validItemArray);
		return validItems.contains(stack.getItem());
	}

}
