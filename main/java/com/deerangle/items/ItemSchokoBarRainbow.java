package com.deerangle.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSchokoBarRainbow extends ItemSchokoBar {

	public ItemSchokoBarRainbow() {
		super("rainbow");
	}
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		//TODO: add effect
		return super.onEaten(stack, world, player);
	}

}
