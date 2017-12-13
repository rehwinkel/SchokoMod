package com.deerangle.main;

import com.deerangle.tile.TileEntitySchokoMixer;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class ContainerSchokoMixer extends Container {

	public ContainerSchokoMixer(IInventory inv, TileEntitySchokoMixer te) {
		this.addSlotToContainer(new Slot(te, 0, 50, 50));
		
		for (int x = 0; x < 9; ++x) {
			this.addSlotToContainer(new Slot(inv, x, 8 + x * 18, 142));
		}

		for (int y = 0; y < 3; ++y) {
			for (int x = 0; x < 9; ++x) {
				this.addSlotToContainer(new Slot(inv, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
			}
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}

}
