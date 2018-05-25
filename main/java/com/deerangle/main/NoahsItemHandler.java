package com.deerangle.main;

import java.util.ArrayList;
import java.util.List;

import com.deerangle.gui.container.ContainerMixer;

import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import scala.Array;

public class NoahsItemHandler extends ItemStackHandler {

	private ItemHandlerConfig config;

	public NoahsItemHandler(int slots, ItemHandlerConfig config) {
		super(slots);
		this.config = config;
	}

	@Override
	public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
		if(!config.isItemValid(slot, stack)) {
			return stack;
		}
		return super.insertItem(slot, stack, simulate);
	}

	public ItemStack insertItemForced(int slot, ItemStack stack) {
		return super.insertItem(slot, stack, false);
	}
	
}
