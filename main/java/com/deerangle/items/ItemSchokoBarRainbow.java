package com.deerangle.items;

import com.deerangle.main.SchokoMod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSchokoBarRainbow extends ItemSchokoBar {

	public ItemSchokoBarRainbow() {
		super("rainbow");
	}
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		world.playSoundAtEntity(player, SchokoMod.MODID + ":rainbow", 1, 1);
		return super.onEaten(stack, world, player);
	}

}
