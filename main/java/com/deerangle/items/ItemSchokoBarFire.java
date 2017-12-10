package com.deerangle.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSchokoBarFire extends ItemSchokoBar {

	public ItemSchokoBarFire() {
		super("fire", 0);
	}
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		player.setFire(5);
		return super.onEaten(stack, world, player);
	}

}
