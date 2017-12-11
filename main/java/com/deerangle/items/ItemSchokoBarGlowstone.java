package com.deerangle.items;

import com.deerangle.main.SchokoMod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemSchokoBarGlowstone extends ItemSchokoBar {

	public ItemSchokoBarGlowstone() {
		super("glowstone");
	}

	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		world.playSoundAtEntity(player, SchokoMod.MODID + ":sanic", 20, 1);
		player.addPotionEffect(new PotionEffect(Potion.jump.id, 12 * 20, 100));
		return super.onEaten(stack, world, player);
	}

}
