package com.deerangle.items;

import net.minecraft.block.BlockPortal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.world.World;

public class ItemSchokoBarPortal extends ItemSchokoBar {

	public ItemSchokoBarPortal() {
		super("portal");
	}
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		player.travelToDimension(-1);
		return super.onEaten(stack, world, player);
	}

}
