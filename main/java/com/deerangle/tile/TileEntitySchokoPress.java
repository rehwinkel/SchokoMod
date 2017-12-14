package com.deerangle.tile;

import java.util.ArrayList;
import java.util.HashMap;

import com.deerangle.items.ModItems;
import com.deerangle.main.ModCrafting;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileEntitySchokoPress extends TileEntity implements IInventory {

	public ItemStack[] slots = new ItemStack[5];

	public int process = 0;
	public int processMax = 60;

	private ArrayList<ItemStack[]> recipesItems = new ArrayList<ItemStack[]>();
	private ArrayList<ItemStack> recipesItem = new ArrayList<ItemStack>();

	public TileEntitySchokoPress() {
		addRecipe(0, null, null, new ItemStack(ModItems.schokoBarNormal, 2)); //1
		addRecipe(1, null, null, new ItemStack(ModItems.schokoBarBlack, 2)); //2
		addRecipe(2, null, null, new ItemStack(ModItems.schokoBarWhite, 2)); //3
		addRecipe(0, new ItemStack(Blocks.double_plant, 1, 0), null, new ItemStack(ModItems.schokoBarFlower, 2)); //4
		addRecipe(1, new ItemStack(Blocks.brown_mushroom), null, new ItemStack(ModItems.schokoBarMushroom, 2)); //5
		for(int i = 0; i < 16; i++){
			addRecipe(2, new ItemStack(Items.dye, 1, i), null, new ItemStack(ModItems.schokoBarColored, 2, i)); //21
		}
		addRecipe(0, new ItemStack(Items.quartz), null, new ItemStack(ModItems.schokoBarQuartz, 2)); //22
		addRecipe(0, new ItemStack(Blocks.cobblestone), null, new ItemStack(ModItems.schokoBarCobble, 2)); //23
		addRecipe(2, new ItemStack(Blocks.web), null, new ItemStack(ModItems.schokoBarCobweb, 2)); //24
		addRecipe(0, new ItemStack(ModItems.weed), new ItemStack(Items.redstone), new ItemStack(ModItems.schokoBarRedstone, 1)); //25
		addRecipe(0, new ItemStack(ModItems.weed), new ItemStack(Items.glowstone_dust), new ItemStack(ModItems.schokoBarGlowstone, 1)); //26
		addRecipe(0, new ItemStack(Items.leather), null, new ItemStack(ModItems.schokoBarCow, 2)); //27
		addRecipe(0, new ItemStack(Items.ender_pearl), null, new ItemStack(ModItems.schokoBarEnder, 2)); //28
		addRecipe(2, new ItemStack(Blocks.glass), null, new ItemStack(ModItems.schokoBarGlass, 2)); //29
		addRecipe(1, new ItemStack(Items.gunpowder), new ItemStack(Items.gunpowder), new ItemStack(ModItems.schokoBarCreeper, 2)); //30
		addRecipe(1, new ItemStack(Items.fire_charge), new ItemStack(Items.fire_charge), new ItemStack(ModItems.schokoBarFire, 2)); //31
		addRecipe(0, new ItemStack(Items.fireworks), null, new ItemStack(ModItems.schokoBarFireworks, 2)); //32
		addRecipe(0, new ItemStack(ModItems.schokoIngot), null, new ItemStack(ModItems.schokoBarFull, 2)); //33
		addRecipe(0, new ItemStack(Blocks.gold_block), null, new ItemStack(ModItems.schokoBarGold, 2)); //34
		addRecipe(0, new ItemStack(ModItems.weed), new ItemStack(ModItems.weed), new ItemStack(ModItems.schokoBarLSD, 2)); //35
		addRecipe(0, new ItemStack(ModItems.error), null, new ItemStack(ModItems.schokoBarWindows, 2)); //36
		addRecipe(0, new ItemStack(Blocks.waterlily), null, new ItemStack(ModItems.schokoBarLilypad, 2)); //37
		addRecipe(0, new ItemStack(Items.cookie), null, new ItemStack(ModItems.schokoBarCookie, 2)); //38
		addRecipe(0, new ItemStack(Blocks.lit_pumpkin), null, new ItemStack(ModItems.schokoBarHalloween, 2)); //39
		addRecipe(0, new ItemStack(Items.skull, 1, 3), null, new ItemStack(ModItems.schokoBarSteve, 2)); //40
		addRecipe(0, new ItemStack(Items.apple), null, new ItemStack(ModItems.schokoBarApple, 2)); //41
		addRecipe(0, new ItemStack(Items.enchanted_book), null, new ItemStack(ModItems.schokoBarBook, 2)); //42
		addRecipe(0, new ItemStack(Items.milk_bucket), null, new ItemStack(ModItems.schokoBarJoghurt, 2)); //43
		addRecipe(0, new ItemStack(Blocks.cocoa), null, new ItemStack(ModItems.schokoBarNuts, 2)); //44
		addRecipe(0, new ItemStack(ModItems.santaHat), null, new ItemStack(ModItems.schokoBarChristmas, 2)); //45
		addRecipe(0, new ItemStack(ModItems.weed), new ItemStack(ModItems.triangle), new ItemStack(ModItems.schokoBarIlluminati, 2)); //46
		addRecipe(0, new ItemStack(Items.paper), new ItemStack(Items.paper), new ItemStack(ModItems.schokoBarLite, 2)); //47
		addRecipe(0, new ItemStack(Blocks.obsidian), new ItemStack(Blocks.obsidian), new ItemStack(ModItems.schokoBarPortal, 2)); //48
		addRecipe(0, new ItemStack(ModItems.schokoBarColored, 1, 1), new ItemStack(ModItems.schokoBarColored, 1, 4), new ItemStack(ModItems.schokoBarRainbow, 2)); //49
		addRecipe(0, new ItemStack(ModItems.smarties), null, new ItemStack(ModItems.schokoBarSmartie, 2)); //50

		addRecipe(0, new ItemStack(ModItems.smarties), null, new ItemStack(ModItems.schokoBarDoor, 2)); //51
		addRecipe(0, new ItemStack(ModItems.smarties), null, new ItemStack(ModItems.schokoBarDrawing, 2)); //52
		addRecipe(0, new ItemStack(ModItems.smarties), null, new ItemStack(ModItems.schokoBarSlot, 2)); //53
		addRecipe(0, new ItemStack(ModItems.smarties), null, new ItemStack(ModItems.schokoBarYouTube, 2)); //54
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
					}
					if (ItemStack.areItemStacksEqual(in[1], test3)) {
						if (ItemStack.areItemStacksEqual(in[2], test2)) {
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
