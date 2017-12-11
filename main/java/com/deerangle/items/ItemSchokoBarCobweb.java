package com.deerangle.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemSchokoBarCobweb extends ItemSchokoBar {

	public ItemSchokoBarCobweb() {
		super("cobweb");
	}

	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 30 * 20, 2));
		player.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 30 * 20, 4));
		if(!world.isRemote) {
			if()
		world.setBlock(player.posX, player.posY, player.posZ, Blocks.web);
		}
		return super.onEaten(stack, world, player);
	}
}
