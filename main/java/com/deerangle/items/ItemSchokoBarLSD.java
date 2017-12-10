package com.deerangle.items;

import com.deerangle.main.SchokoMod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemSchokoBarLSD extends ItemSchokoBar {

	public ItemSchokoBarLSD() {
		super("lSD");
	}
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		player.addPotionEffect(new PotionEffect(SchokoMod.lsdPotion.id, 30 * 20, effect));
		player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 30 * 20, 2));
		player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 30 * 20, 0));
		return super.onEaten(stack, world, player);
	}

}
