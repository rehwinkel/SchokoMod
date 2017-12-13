package com.deerangle.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySchokoMixer extends TileEntity implements IInventory {

	public ItemStack[] slots = new ItemStack[6];

	@Override
	public void updateEntity() {

	}

	@Override
	public int getSizeInventory() {
		return slots.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		if (slot < 0 || slot >= slots.length) {
			return null;
		}
		return slots[slot];
	}

	@Override
	public ItemStack decrStackSize(int slot, int count) {
		if (this.getStackInSlot(slot) != null) {
			ItemStack itemstack;

			if (this.getStackInSlot(slot).stackSize <= count) {
				itemstack = this.getStackInSlot(slot);
				this.setInventorySlotContents(slot, null);
				this.markDirty();
				return itemstack;
			} else {
				itemstack = this.getStackInSlot(slot).splitStack(count);

				if (this.getStackInSlot(slot).stackSize <= 0) {
					this.setInventorySlotContents(slot, null);
				} else {
					this.setInventorySlotContents(slot, this.getStackInSlot(slot));
				}

				this.markDirty();
				return itemstack;
			}
		} else {
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		ItemStack stack = this.getStackInSlot(slot);
		this.setInventorySlotContents(slot, null);
		return stack;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		if (slot > getSizeInventory() || slot < 0)
			return;

		if (stack != null && stack.stackSize > this.getInventoryStackLimit())
			stack.stackSize = this.getInventoryStackLimit();

		if (stack != null && stack.stackSize == 0)
			stack = null;

		this.slots[slot] = stack;
		this.markDirty();
	}

	@Override
	public String getInventoryName() {
		return "";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return true;
	}

	@Override
	public void openInventory() {

	}

	@Override
	public void closeInventory() {

	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack) {
		return true;
	}

}
