package com.deerangle.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemSchokoBarWindows extends ItemSchokoBar {

	public ItemSchokoBarWindows() {
		super("windows");
	}
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		player.addChatMessage(new ChatComponentText("§a" + StatCollector.translateToLocal("windows.error")));
		player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("windows.error.text")));
		world.playSoundAtEntity(player, "windows", 1, 1);
		return super.onEaten(stack, world, player);
	}

}
