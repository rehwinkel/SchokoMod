package com.deerangle.items.bars;

import com.deerangle.items.ItemSchokoBar;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.ClickEvent.Action;
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
			ChatComponentText txt = new ChatComponentText("§7Visit the offical Apple site at §2www.apple.com/de");
			txt.getChatStyle().setChatClickEvent(new ClickEvent(Action.OPEN_URL, "https://www.apple.com/de/"));
			player.addChatMessage(txt);

		}
		return super.onEaten(stack, world, player);
	}

}
