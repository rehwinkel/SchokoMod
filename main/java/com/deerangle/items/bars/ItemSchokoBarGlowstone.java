package com.deerangle.items.bars;

import com.deerangle.items.ItemSchokoBar;
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
		world.playSoundAtEntity(player, SchokoMod.MODID + ":sanic", 100, 1);
		player.addPotionEffect(new PotionEffect(Potion.jump.id, 12 * 20, 25));
		return super.onEaten(stack, world, player);
	}

}
