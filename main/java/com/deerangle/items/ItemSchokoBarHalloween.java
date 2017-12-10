package com.deerangle.items;

import com.deerangle.main.SchokoMod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSchokoBarHalloween extends ItemSchokoBar {

	public ItemSchokoBarHalloween() {
		super("halloween");
	}
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		world.playSoundAtEntity(player, SchokoMod.MODID + ":scream", 1, 1);
		return super.onEaten(stack, world, player);
	}

}
