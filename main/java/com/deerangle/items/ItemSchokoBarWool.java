package com.deerangle.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSchokoBarWool extends ItemSchokoBar {

	public ItemSchokoBarWool() {
		super("wool");
	}

	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		player.fallDistance = 0;
		player.motionX = 0;
		player.motionY = 0;
		player.motionZ = 0;
		return super.onEaten(stack, world, player);
	}

}
