package com.deerangle.items;

import com.deerangle.main.SchokoMod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemSchokoBarIlluminati extends ItemSchokoBar {

	public ItemSchokoBarIlluminati() {
		super("illuminati");
	}

	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		world.playSoundAtEntity(player, SchokoMod.MODID + ":xfiles", 10, 1);
		player.addPotionEffect(new PotionEffect(SchokoMod.schokoPotion.id, 26 * 20, 100));
		player.addPotionEffect(new PotionEffect(SchokoMod.lsdPotion.id, 26 * 20, 0));
		player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 26 * 20, 2));
		player.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 26 * 20, 2));
		player.addPotionEffect(new PotionEffect(Potion.blindness.id, 26 * 20, 2));
		player.addPotionEffect(new PotionEffect(Potion.confusion.id, 26 * 20, 2));
		player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 26 * 20, 4));
		return super.onEaten(stack, world, player);
	}

}
