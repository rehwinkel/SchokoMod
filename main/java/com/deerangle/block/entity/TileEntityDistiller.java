package com.deerangle.block.entity;

import com.deerangle.item.ModItems;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityDistiller extends TileEntity implements ITickable, ICapabilityProvider {

	public ItemStackHandler inventory = new ItemStackHandler(3);

	public int burnTime;
	public int maxBurnTime;

	public int processTimeWeed;
	public int maxProcessTimeWeed = 200;

	public int processedWeed;
	public int maxProcessedWeed = 16;

	public int processTimeTHC;
	public int maxProcessTimeTHC = 400;

	@Override
	public void update() {
		if (!world.isRemote) {
			world.notifyBlockUpdate(getPos(), world.getBlockState(getPos()), world.getBlockState(getPos()), 0);
			this.markDirty();
			
			watchValues();
			burnFuel();
			processWeed();
			processTHC();
		}
	}

	private void watchValues() {
		if(burnTime < 0){
			burnTime = 0;
		}

		if(processTimeWeed < 0){
			processTimeWeed = 0;
		}

		if(processedWeed < 0){
			processedWeed = 0;
		}

		if(processTimeTHC < 0){
			processTimeTHC = 0;
		}

		if(processTimeWeed > maxProcessTimeWeed){
			processTimeWeed = maxProcessTimeWeed;
		}

		if(processedWeed > maxProcessedWeed){
			processedWeed = maxProcessedWeed;
		}

		if(processTimeTHC > maxProcessTimeTHC){
			processTimeTHC = maxProcessTimeTHC;
		}
	}

	private void burnFuel() {
		if (!inventory.getStackInSlot(1).isEmpty() && !inventory.getStackInSlot(0).isEmpty()) {
			if(processTimeTHC == 0){
				if (burnTime <= 1) {
					burnTime = TileEntityFurnace.getItemBurnTime(inventory.getStackInSlot(1)) + 1;
					maxBurnTime = burnTime;
					inventory.extractItem(1, 1, false);
				}
			}
		}
		
		if (burnTime >= 1) {
			burnTime--;
		}
	}

	private void processTHC() {
		if(processTimeTHC > 0) {
			processTimeTHC--;
			
			if(processTimeTHC == 0){
				endProcessTHC();
			}
		}else{
			if(processedWeed == maxProcessedWeed){
				startProcessTHC();
			}
		}
	}
	
	private void startProcessTHC() {
		processTimeTHC = maxProcessTimeTHC - 1;
	}

	private void endProcessTHC() {
		processedWeed = 0;
		processTimeTHC = 0;
		inventory.insertItem(2, new ItemStack(ModItems.thc), false);
	}

	private void processWeed() {
		if (canProcessWeedRun() && processTimeWeed > 0) {
			processTimeWeed--;

			if (processTimeWeed == 0) {
				endProcessWeed();
			}
		} else {
			if (processTimeWeed == 0) {
				startProcessWeed();
			} else {
				processTimeWeed = 0;
			}
		}
	}

	private boolean canProcessWeedRun() {
		if (burnTime > 0) {
			if (!inventory.getStackInSlot(0).isEmpty()) {
				if (processedWeed < maxProcessedWeed) {
					return true;
				}
			}
		}

		return false;
	}

	private void startProcessWeed() {
		if (canProcessWeedRun()) {
			processTimeWeed = maxProcessTimeWeed - 1;
		}
	}

	private void endProcessWeed() {
		inventory.extractItem(0, 1, false);
		processedWeed++;
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return true;
		}

		return super.hasCapability(capability, facing);
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
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

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		NBTTagCompound tag = (NBTTagCompound) compound.getTag("inventory");
		if (tag != null) {
			inventory.deserializeNBT(tag);
		}
		syncFromNBT(compound);
		super.readFromNBT(compound);
	}

	private void syncToNBT(NBTTagCompound tag) {
		NBTTagCompound compound = new NBTTagCompound();
		compound.setInteger("ProcessWeed", processTimeWeed);
		compound.setInteger("ProcessTHC", processTimeTHC);
		compound.setInteger("Weed", processedWeed);
		compound.setInteger("Burn", burnTime);
		compound.setInteger("MaxBurn", maxBurnTime);
		
		tag.setTag("ProcessInfo", compound);
	}

	private void syncFromNBT(NBTTagCompound tag) {
		NBTTagCompound compound = (NBTTagCompound) tag.getTag("ProcessInfo");
		processTimeWeed = compound.getInteger("ProcessWeed");
		processTimeTHC = compound.getInteger("ProcessTHC");
		processedWeed = compound.getInteger("Weed");
		burnTime = compound.getInteger("Burn");
		maxBurnTime = compound.getInteger("MaxBurn");
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
