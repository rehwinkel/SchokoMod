package com.deerangle.items.bars;

import com.deerangle.items.ItemSchokoBar;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAppleGold;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemSchokoBarGold extends ItemSchokoBar {

	public ItemSchokoBarGold() {
		super("gold", 6);
	}
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		player.addPotionEffect(new PotionEffect(Potion.field_76444_x.id, 2400, 0));
		player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 100, 2));
		return super.onEaten(stack, world, player);
	}

}
