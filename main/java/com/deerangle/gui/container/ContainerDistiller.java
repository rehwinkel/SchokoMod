package com.deerangle.gui.container;

import com.deerangle.block.entity.TileEntityDistiller;
import com.deerangle.gui.slot.SlotDistillerFuel;
import com.deerangle.gui.slot.SlotDistillerIn;
import com.deerangle.gui.slot.SlotChocolateOut;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.event.entity.player.PlayerContainerEvent;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerDistiller extends Container {

	private TileEntity te;

	public ContainerDistiller(InventoryPlayer inventory, TileEntityDistiller tileEntity) {
		te = tileEntity;
		IItemHandler teInv = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);

		this.addSlotToContainer(new SlotDistillerIn(teInv, 0, 26, 13));
		this.addSlotToContainer(new SlotDistillerFuel(teInv, 1, 26, 52));
		this.addSlotToContainer(new SlotChocolateOut(teInv, 2, 134, 33));

		for (int x = 0; x < 9; ++x) {
			this.addSlotToContainer(new Slot(inventory, x, 8 + x * 18, 142));
		}
		for (int y = 0; y < 3; ++y) {
			for (int x = 0; x < 9; ++x) {
				this.addSlotToContainer(new Slot(inventory, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
			}
		}
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			int slots = 3;
			if (index < slots) {
				if (!this.mergeItemStack(itemstack1, slots, this.inventorySlots.size(), true)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.mergeItemStack(itemstack1, 0, slots, false)) {
				return ItemStack.EMPTY;
			}

			if (itemstack1.isEmpty()) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}
		}

		return itemstack;
	}

	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		te.markDirty();
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return true;
	}

}
