package com.deerangle.main;

import com.deerangle.tile.TileEntitySchokoMixer;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class ContainerSchokoMixer extends Container {

	public ContainerSchokoMixer(IInventory inv, TileEntitySchokoMixer te) {
		this.addSlotToContainer(new Slot(te, 0, 100, 100));
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}

}
