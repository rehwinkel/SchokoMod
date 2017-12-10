package com.deerangle.items;

import com.deerangle.main.SchokoMod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSchokoBarGlass extends ItemSchokoBar {

	public ItemSchokoBarGlass() {
		super("glass");
	}
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		world.playSoundAtEntity(player, SchokoMod.MODID + ":glass", 1, 1);
		player.setHealth(player.getHealth() - 4);
		return super.onEaten(stack, world, player);
	}


}
