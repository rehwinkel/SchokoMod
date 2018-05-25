package com.deerangle.main;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class NoahsUtil {

	public static void givePlayerItem(EntityPlayer player, ItemStack itemStack) {
		if(!player.inventory.addItemStackToInventory(itemStack)) {
			player.world.spawnEntity(new EntityItem(player.world, player.posX, player.posY + 0.5, player.posZ, itemStack));
		}
	}
	
}
