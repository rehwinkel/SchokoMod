package com.deerangle.tile;

import java.util.ArrayList;
import java.util.HashMap;

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

	private ArrayList<ItemStack[]> recipesItems = new ArrayList<ItemStack[]>();
	private ArrayList<ItemStack> recipesItem = new ArrayList<ItemStack>();

	public TileEntitySchokoPress() {
		addRecipe(0, null, null, new ItemStack(ModItems.schokoBarNormal, 2));
		addRecipe(1, null, null, new ItemStack(ModItems.schokoBarBlack, 2));
		addRecipe(2, null, null, new ItemStack(ModItems.schokoBarWhite, 2));
		addRecipe(0, new ItemStack(Blocks.double_plant, 1, 0), null, new ItemStack(ModItems.schokoBarFlower, 2));
	}

	/**
	 * @param type
	 *            normal, dark, light
	 */
	private void addRecipe(int type, ItemStack add1, ItemStack add2, ItemStack out) {
		if (add1 == null && add2 == null) {
			ItemStack[] array = new ItemStack[1];
			array[0] = new ItemStack(ModItems.schokoIngot, 1, type);
			recipesItems.add(array);
			recipesItem.add(out.copy());
		} else if (add1 != null && add2 != null) {
			ItemStack[] array = new ItemStack[3];
			array[0] = new ItemStack(ModItems.schokoIngot, 1, type);
			array[1] = add1;
			array[2] = add2;
			recipesItems.add(array);
			recipesItem.add(out.copy());
		} else {
			ItemStack[] array = new ItemStack[2];
			array[0] = new ItemStack(ModItems.schokoIngot, 1, type);
			ItemStack use = add1 != null ? add1.copy() : null;
			if (use == null) {
				use = add2.copy();
			}
			array[1] = use;
			recipesItems.add(array);
			recipesItem.add(out.copy());
		}
	}

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
			setInventorySlotContents(4, ModCrafting.addItemStacks(getStackInSlot(4), getPressResult()));
			this.decrStackSize(0, 1);
			this.decrStackSize(1, 1);
			this.decrStackSize(2, 1);
			this.decrStackSize(3, 1);
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

		// START RECIPES!
		for(int i = 0; i < recipesItem.size(); i++){
			ItemStack out = recipesItem.get(i);
			ItemStack[] in = recipesItems.get(i);
			if(in.length == 1){
				if (in[0].getItemDamage() == test0.getItemDamage()) {
					if (test2 == null && test3 == null) {
						return out.copy();
					}
				}
			}
			if(in.length == 2){
				if (in[0].getItemDamage() == test0.getItemDamage()) {
					if (ItemStack.areItemStacksEqual(in[1], test3) && test2 == null) {
						return out.copy();
					}
					if (ItemStack.areItemStacksEqual(in[1], test2) && test3 == null) {
						return out.copy();
					}
				}
			}
			if(in.length == 3){
				if (in[0].getItemDamage() == test0.getItemDamage()) {
					if (ItemStack.areItemStacksEqual(in[1], test2)) {
						if (ItemStack.areItemStacksEqual(in[2], test3)) {
							return out.copy();
						}
						if (ItemStack.areItemStacksEqual(in[3], test2)) {
							return out.copy();
						}
					}
				}
			}
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
