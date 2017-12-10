package com.deerangle.items;

import com.deerangle.main.SchokoMod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemSchokoBarRedstone extends ItemSchokoBar {

	public ItemSchokoBarRedstone() {
		super("redstone");
	}

	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		world.playSoundAtEntity(player, SchokoMod.MODID + ":dejavu", 100, 1);
		player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 14 * 20, 100));
		return super.onEaten(stack, world, player);
	}

}
