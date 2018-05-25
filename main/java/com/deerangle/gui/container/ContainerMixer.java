package com.deerangle.gui.container;

import com.deerangle.block.entity.TileEntityMixer;
import com.deerangle.gui.slot.SlotChocolateOut;
import com.deerangle.gui.slot.SlotMixerIn;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerMixer extends Container {

	private TileEntityMixer tileEntity;

	public ContainerMixer(InventoryPlayer inventory, TileEntityMixer tileEntity) {
		IItemHandler teInv = tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
		this.tileEntity = tileEntity;

		this.addSlotToContainer(new SlotMixerIn(teInv, 0, 38, 25));
		this.addSlotToContainer(new SlotMixerIn(teInv, 1, 58, 25));
		this.addSlotToContainer(new SlotMixerIn(teInv, 2, 38, 45));
		this.addSlotToContainer(new SlotMixerIn(teInv, 3, 58, 45));
		this.addSlotToContainer(new SlotChocolateOut(teInv, 4, 124, 35));

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

			int slotsIn = 4;
			int slotsOut = 5;
			if (index < slotsOut) {
				if (!this.mergeItemStack(itemstack1, slotsOut, this.inventorySlots.size(), true)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.mergeItemStack(itemstack1, 0, slotsIn, false)) {
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
	public boolean canInteractWith(EntityPlayer playerIn) {
		return true;
	}

}
