package com.deerangle.items;

import com.deerangle.main.SchokoMod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemSchokoBarSteve extends ItemSchokoBar {

	public ItemSchokoBarSteve() {
		super("steve", 8);
	}
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		player.addPotionEffect(new PotionEffect(Potion.confusion.id, 10 * 20, 2));
		player.addPotionEffect(new PotionEffect(Potion.poison.id, 10 * 20, 0));
		return super.onEaten(stack, world, player);
	}

}
