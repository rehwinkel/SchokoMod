package com.deerangle.items.bars;

import com.deerangle.items.ItemSchokoBar;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ItemSchokoBarApple extends ItemSchokoBar {

	public ItemSchokoBarApple() {
		super("apple");
	}

	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		if (!world.isRemote) {
			//TODO: Weblink
			player.addChatMessage(new ChatComponentText("§2The offical site of Apple: §3www.apple.com/de"));

		}
		return super.onEaten(stack, world, player);
	}

}
