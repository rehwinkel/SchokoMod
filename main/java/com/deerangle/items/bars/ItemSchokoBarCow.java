package com.deerangle.items.bars;

import com.deerangle.items.ItemSchokoBar;
import com.deerangle.main.SchokoMod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSchokoBarCow extends ItemSchokoBar {

	public ItemSchokoBarCow() {
		super("cow", 4, true);
	}
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		world.playSoundAtEntity(player, SchokoMod.MODID + ":cow", 1, 1);
		return super.onEaten(stack, world, player);
	}

}
