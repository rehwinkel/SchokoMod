package com.deerangle.block.entity;

import com.deerangle.item.ModItems;
import com.deerangle.main.ItemHandlerConfig;
import com.deerangle.main.NoahsItemHandler;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;

public class TileEntityPacker extends TileEntity implements ITickable {

	private ItemHandlerConfig config = new ItemHandlerConfig() {

		@Override
		public boolean isItemValid(int slot, ItemStack stack) {
			if(slot == 0 && stack.getItem() == ModItems.WRAP_PAPER) return true;
			if(slot == 1 && stack.getItem() == ModItems.SCHOKO_INGOT) return true;
			if(slot == 2 && stack.getItem() == ModItems.FLAVOR_ENHANCER) return true;
			if(slot == 3) return true;
			return false;
		}
		
	};
	public NoahsItemHandler inventory = new NoahsItemHandler(5, config);

	public int current = -1;
	public int progress = 0;
	public int maxProgress = 100;

	@Override
	public void update() {
		if (!world.isRemote) {
			world.notifyBlockUpdate(getPos(), world.getBlockState(getPos()), world.getBlockState(getPos()), 0);
			this.markDirty();
			
			processIngredients();
			if(current != -1) {
				progress++;
			}else {
				progress = 0;
			}
			makeBars();
		}
	}
	
	private void makeBars() {
		if(progress >= maxProgress) {
			System.out.println("MAKING " + current);
			inventory.extractItem(0, 1, false);
			inventory.extractItem(1, 1, false);
			inventory.extractItem(2, 1, false);
			ItemStack specialSlot = inventory.getStackInSlot(3);
			if(specialSlot.getItem().hasContainerItem(specialSlot)) {
				inventory.setStackInSlot(3, specialSlot.getItem().getContainerItem(specialSlot));
			}else {
				inventory.extractItem(3, 1, false);
			}
			inventory.insertItemForced(4, new ItemStack(ModItems.CHOCOLATE_BAR, 1, current));
			progress = 0;
		}
	}

	private void processIngredients() {
		int wrappers = inventory.getStackInSlot(0).getCount();
		int choc = inventory.getStackInSlot(1).getCount();
		int cocoaId = inventory.getStackInSlot(1).getMetadata();
		int flavor = inventory.getStackInSlot(2).getCount();
		ItemStack special = inventory.getStackInSlot(3);
		ItemStack o = inventory.getStackInSlot(4);
		
		if(o.getMaxStackSize() == o.getCount()) {
			current = -1;
			return;
		}
		
		if(choc == 0) {
			cocoaId = -1;
			choc = 1;
		}
		if(wrappers > 0 && choc > 0) {
			int outId = PackerRecipe.getOutput(PackerRecipe.getAllRecipes(), cocoaId, flavor > 0, special);
			if(outId != -1) {
				if(outId == o.getMetadata() || o == ItemStack.EMPTY) {
					current = outId;
					return;
				}
			}
		}
		current = -1;
		return;
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
