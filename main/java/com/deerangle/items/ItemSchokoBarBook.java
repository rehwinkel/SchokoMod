package com.deerangle.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSchokoBarBook extends ItemSchokoBar {

	public ItemSchokoBarBook() {
		super("book");
	}

	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		if(!world.isRemote){
			player.addExperience(100);
		}
		return super.onEaten(stack, world, player);
	}
	
}
