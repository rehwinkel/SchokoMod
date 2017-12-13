package com.deerangle.gui;

import com.deerangle.tile.TileEntitySchokoMixer;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerSchokoMixer extends Container {

	public ContainerSchokoMixer(IInventory inv, TileEntitySchokoMixer te) {
		this.addSlotToContainer(new Slot(te, 0, 35, 25));
		this.addSlotToContainer(new Slot(te, 1, 35, 45));
		this.addSlotToContainer(new Slot(te, 2, 55, 25));
		this.addSlotToContainer(new Slot(te, 3, 55, 45));
		this.addSlotToContainer(new Slot(te, 4, 116, 35));

		for (int x = 0; x < 9; ++x) {
			this.addSlotToContainer(new Slot(inv, x, 8 + x * 18, 142));
		}

		for (int y = 0; y < 3; ++y) {
			for (int x = 0; x < 9; ++x) {
				this.addSlotToContainer(new Slot(inv, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
			}
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) {
		ItemStack previous = null;
		Slot slot = (Slot) this.inventorySlots.get(fromSlot);

		if (slot != null && slot.getHasStack()) {
			ItemStack current = slot.getStack();
			previous = current.copy();

			if (fromSlot < 5) {
				if (!this.mergeItemStack(current, 5, 41, false))
					return null;
			} else {
				if (!this.mergeItemStack(current, 0, 4, true))
					return null;
			}

			if (current.stackSize == 0) {
				slot.putStack((ItemStack) null);
			} else {
				slot.onSlotChanged();
			}
			if (current.stackSize == previous.stackSize)
				return null;
			slot.onPickupFromSlot(playerIn, current);
		}
		return previous;
	}

}
