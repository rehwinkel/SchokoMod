package com.deerangle.gui;

import com.deerangle.tile.entity.TileEntitySchokoPress;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerSchokoPress extends Container {

	public ContainerSchokoPress(IInventory inv, TileEntitySchokoPress te) {
		this.addSlotToContainer(new SlotSchokoPressSchoko(te, 0, 35, 25));
		this.addSlotToContainer(new SlotSchokoPressPaper(te, 1, 55, 25));
		this.addSlotToContainer(new Slot(te, 2, 35, 45));
		this.addSlotToContainer(new Slot(te, 3, 55, 45));
		this.addSlotToContainer(new SlotSchokoOut(te, 4, 116, 35));

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
	protected boolean mergeItemStack(ItemStack stack, int start, int end, boolean backwards) {
		boolean flag1 = false;
		int k = start;

		if (backwards) {
			k = end - 1;
		}

		Slot slot;
		ItemStack itemstack1;

		if (stack.isStackable()) {
			while (stack.stackSize > 0 && (!backwards && k < end || backwards && k >= start)) {
				slot = (Slot) this.inventorySlots.get(k);
				itemstack1 = slot.getStack();

				if (itemstack1 != null && itemstack1.getItem() == stack.getItem()
						&& (!stack.getHasSubtypes() || stack.getItemDamage() == itemstack1.getItemDamage())
						&& ItemStack.areItemStackTagsEqual(stack, itemstack1)) {
					int l = itemstack1.stackSize + stack.stackSize;

					if (l <= stack.getMaxStackSize()) {
						stack.stackSize = 0;
						itemstack1.stackSize = l;
						slot.onSlotChanged();
						flag1 = true;
					} else if (itemstack1.stackSize < stack.getMaxStackSize()) {
						stack.stackSize -= stack.getMaxStackSize() - itemstack1.stackSize;
						itemstack1.stackSize = stack.getMaxStackSize();
						slot.onSlotChanged();
						flag1 = true;
					}
				}

				if (backwards) {
					--k;
				} else {
					++k;
				}
			}
		}

		if (stack.stackSize > 0) {
			if (backwards) {
				k = end - 1;
			} else {
				k = start;
			}

			while (!backwards && k < end || backwards && k >= start) {
				slot = (Slot) this.inventorySlots.get(k);
				itemstack1 = slot.getStack();

				if (itemstack1 == null) {
					if(slot.isItemValid(stack.copy())){
						slot.putStack(stack.copy());
						slot.onSlotChanged();
						stack.stackSize = 0;
						flag1 = true;
						break;
					}
				}

				if (backwards) {
					--k;
				} else {
					++k;
				}
			}
		}

		return flag1;
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
				if (!this.mergeItemStack(current, 0, 4, false))
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
