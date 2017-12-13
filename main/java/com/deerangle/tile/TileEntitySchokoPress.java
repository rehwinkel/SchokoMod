package com.deerangle.tile;

import com.deerangle.items.ModItems;
import com.deerangle.main.ModCrafting;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySchokoPress extends TileEntity implements IInventory {

	public ItemStack[] slots = new ItemStack[5];

	public int process = 0;
	public int processMax = 60;

	@Override
	public void updateEntity() {
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);

		processStart();
		process();

		super.updateEntity();
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

	private void processStart() {
		if (process == 0) {
			if (getStackInSlot(0) != null && getStackInSlot(1) != null) {
				if (ModCrafting.willStackOn(getPressResult(), getStackInSlot(4))) {
					process = processMax;
				}
			}
		}
	}

	private void process() {
		if (process > 0) {
			if (getStackInSlot(0) != null && getStackInSlot(1) != null) {
				if (ModCrafting.willStackOn(getPressResult(), getStackInSlot(4))) {
					process--;

					if (process == 0) {
						processEnd(true);
					}
					return;
				}
			}
		}
		processEnd(false);
	}

	private void processEnd(boolean success) {
		if (success) {
			this.decrStackSize(0, 1);
			this.decrStackSize(1, 1);
			this.decrStackSize(2, 1);
			this.decrStackSize(3, 1);
			setInventorySlotContents(4, ModCrafting.addItemStacks(getStackInSlot(4), getPressResult()));
		} else {
			process = 0;
		}
	}

	private ItemStack getPressResult() {
		ItemStack test0 = null;
		if (getStackInSlot(0) != null) {
			test0 = getStackInSlot(0).copy();
			test0.stackSize = 1;
		}
		ItemStack test1 = null;
		if (getStackInSlot(1) != null) {
			test1 = getStackInSlot(1).copy();
			test1.stackSize = 1;
		}
		ItemStack test2 = null;
		if (getStackInSlot(2) != null) {
			test2 = getStackInSlot(2).copy();
			test2.stackSize = 1;
		}
		ItemStack test3 = null;
		if (getStackInSlot(3) != null) {
			test3 = getStackInSlot(3).copy();
			test3.stackSize = 1;
		}

		//START RECIPES!
		if (test0.getItemDamage() == 0 && test2 == null && test3 == null) {
			return new ItemStack(ModItems.schokoBarNormal, 2);
		}
		if (test0.getItemDamage() == 1 && test2 == null && test3 == null) {
			return new ItemStack(ModItems.schokoBarBlack, 2);
		}
		if (test0.getItemDamage() == 2 && test2 == null && test3 == null) {
			return new ItemStack(ModItems.schokoBarWhite, 2);
		}
		if (test0.getItemDamage() == 0 && test2 == new ItemStack(Blocks.tallgrass, 1, 0) && test3 == null) {
			return new ItemStack(ModItems.schokoBarFlower, 2);
		}
		return null;
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

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);

		NBTTagList list = tag.getTagList("Items", 10);
		for (int i = 0; i < list.tagCount(); ++i) {
			NBTTagCompound stackTag = list.getCompoundTagAt(i);
			int slot = stackTag.getByte("Slot") & 255;
			this.setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(stackTag));
		}

		process = tag.getInteger("Process");
	}

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);

		NBTTagList list = new NBTTagList();
		for (int i = 0; i < this.getSizeInventory(); ++i) {
			if (this.getStackInSlot(i) != null) {
				NBTTagCompound stackTag = new NBTTagCompound();
				stackTag.setByte("Slot", (byte) i);
				this.getStackInSlot(i).writeToNBT(stackTag);
				list.appendTag(stackTag);
			}
		}
		tag.setTag("Items", list);

		tag.setInteger("Process", process);
	}

}
