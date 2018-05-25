package com.deerangle.block.entity;

import com.deerangle.item.ModItems;
import com.deerangle.main.ItemHandlerConfig;
import com.deerangle.main.NoahsItemHandler;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityMixer extends TileEntity implements ITickable, ICapabilityProvider {

	private ItemHandlerConfig config = new ItemHandlerConfig() {
		
		@Override
		public boolean isItemValid(int slot, ItemStack stack) {
			if(slot == 4) return false;
			return true;
		}
		
	};
	public NoahsItemHandler inventory = new NoahsItemHandler(5, config);
	
	int toMake = -1;
	
	public int progress = 0;
	public int maxProgress = 100;
	
	@Override
	public void update() {
		if (!world.isRemote) {
			world.notifyBlockUpdate(getPos(), world.getBlockState(getPos()), world.getBlockState(getPos()), 0);
			this.markDirty();
			
			processIngredients();
			if(toMake != -1) {
				progress++;
			}else {
				progress = 0;
			}
			makeChocolate();
		}
	}
	
	private void makeChocolate() {
		if(toMake != -1 && progress == maxProgress) {
			inventory.extractItem(0, 1, false);
			inventory.extractItem(1, 1, false);
			inventory.extractItem(2, 1, false);
			inventory.extractItem(3, 1, false);
			inventory.insertItemForced(4, new ItemStack(ModItems.SCHOKO_INGOT, 1, cocoaToMeta(toMake)));
			progress = 0;
		}
	}

	private void processIngredients() {
		ItemStack o = inventory.getStackInSlot(4);
		if(o.getMaxStackSize() == o.getCount()) {
			toMake = -1;
			return;
		}
		
		int sugars = 0;
		int butter = 0;
		int cocoas = 0;
		for(int i = 0; i < 4; i++) {
			Item itm = inventory.getStackInSlot(i).getItem();
			if(itm == Items.SUGAR) sugars++;
			if(itm == ModItems.COCOA_BUTTER) butter++;
			if(itm == ModItems.COCOA_POWDER) cocoas++;
		}
		if(sugars == 1 && butter == 1) {
			toMake = cocoas;
		}else {
			toMake = -1;
			return;
		}
		if(o.isEmpty() || metaToCocoa(o.getMetadata()) == toMake) return;
		toMake = -1;
	}
	
	private int metaToCocoa(int meta) {
		switch(meta) {
		case 0:
			return 1;
		case 1:
			return 2;
		case 2:
			return 0;
		default:
			return -1;
		}
	}
	
	private int cocoaToMeta(int cocoa) {
		switch(cocoa) {
		case 0:
			return 2;
		case 1:
			return 0;
		case 2:
			return 1;
		default:
			return -1;
		}
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return true;
		}
		return super.hasCapability(capability, facing);
	}
	
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return (T) inventory;
		}
		return super.getCapability(capability, facing);
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setTag("inventory", inventory.serializeNBT());
		syncToNBT(compound);
		return super.writeToNBT(compound);
	}
	
	private void syncToNBT(NBTTagCompound compound) {
		compound.setInteger("progress", progress);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		NBTTagCompound tag = (NBTTagCompound) compound.getTag("inventory");
		if (tag != null) {
			inventory.deserializeNBT(tag);
		}
		syncFromNBT(compound);
		super.readFromNBT(compound);
	}
	
	private void syncFromNBT(NBTTagCompound compound) {
		progress = compound.getInteger("progress");
	}

	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		NBTTagCompound tag = new NBTTagCompound();
		syncToNBT(tag);
		SPacketUpdateTileEntity packet = new SPacketUpdateTileEntity(getPos(), 0, tag);
		return packet;
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		syncFromNBT(pkt.getNbtCompound());
	}
	
}