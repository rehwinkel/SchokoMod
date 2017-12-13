package com.deerangle.tile;

import com.deerangle.items.ModItems;
import com.deerangle.main.ModCrafting;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySchokoMixer extends TileEntity implements IInventory {

	public ItemStack[] slots = new ItemStack[5];

	private int process = 0;
	private int processMax = 60;

	@Override
	public void updateEntity() {
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);

		processStart();
		process();

		super.updateEntity();
	}

	private void processStart() {
		if (process == 0) {
			if (getStackInSlot(0) != null && getStackInSlot(1) != null) {
				if (ModCrafting.willStackOn(getMixerResult(), getStackInSlot(4))) {
					process = processMax;
				}
			}
		}
	}

	private void process() {
		if (process > 0) {
			if (getStackInSlot(0) != null && getStackInSlot(1) != null) {
				if (ModCrafting.willStackOn(getMixerResult(), getStackInSlot(4))) {
					process--;

					if (process == 0) {
						processEnd();
					}
				}
			}
		}
	}

	private void processEnd() {
		this.decrStackSize(0, 1);
		this.decrStackSize(1, 1);
		this.decrStackSize(2, 1);
		this.decrStackSize(3, 1);
		setInventorySlotContents(4, ModCrafting.addItemStacks(getStackInSlot(4), getMixerResult()));
	}

	private ItemStack getMixerResult() {
		if (getStackInSlot(2) != null && getStackInSlot(3) != null) {
			return new ItemStack(ModItems.schokoIngot, 1, 1);
		}
		if (getStackInSlot(2) != null && getStackInSlot(3) == null) {
			return new ItemStack(ModItems.schokoIngot);
		}
		if (getStackInSlot(2) == null && getStackInSlot(3) != null) {
			return new ItemStack(ModItems.schokoIngot);
		}
		return new ItemStack(ModItems.schokoIngot, 1, 2);
	}

	@Override
	public S35PacketUpdateTileEntity getDescriptionPacket() {
		NBTTagCompound tagCompound = new NBTTagCompound();
		this.writeToNBTSync(tagCompound);
		S35PacketUpdateTileEntity pack = new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, tagCompound);
		return pack;
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		this.readFromNBTSync(pkt.func_148857_g());
	}

	public void writeToNBTSync(NBTTagCompound tag) {
		tag.setInteger("Process", process);
	}

	public void readFromNBTSync(NBTTagCompound tag) {
		process = tag.getInteger("Process");
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
