package com.deerangle.items.bars;

import com.deerangle.items.ItemSchokoBar;
import com.deerangle.main.SchokoMod;

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
		if(!world.isRemote){
			player.addChatMessage(new ChatComponentText("§cError 0x" + world.rand.nextInt(10) + "" + world.rand.nextInt(10) + "" + world.rand.nextInt(10) + "" + world.rand.nextInt(10)));
			player.addChatMessage(new ChatComponentText("§7Chocolate.exe §fhas stopped working!"));
		}
		world.playSoundAtEntity(player, SchokoMod.MODID + ":windows", 1, 1);
		return super.onEaten(stack, world, player);
	}

}
