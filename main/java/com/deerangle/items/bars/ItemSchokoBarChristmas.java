package com.deerangle.items.bars;

import com.deerangle.items.ItemSchokoBar;
import com.deerangle.tile.ModBlocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSchokoBarChristmas extends ItemSchokoBar {

	public ItemSchokoBarChristmas() {
		super("cristmas", 6);
	}
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		player.inventory.addItemStackToInventory(new ItemStack(ModBlocks.present));
		return super.onEaten(stack, world, player);
	}

}
