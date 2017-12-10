package com.deerangle.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSchokoBarCreeper extends ItemSchokoBar {

	public ItemSchokoBarCreeper() {
		super("creeper", 10);
	}
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		if(!world.isRemote){
			world.createExplosion(player, player.posX, player.posY, player.posZ, 5F, true);
		}
		player.setHealth(player.getHealth() - 10);
		return super.onEaten(stack, world, player);
	}

}
