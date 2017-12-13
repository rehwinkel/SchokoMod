package com.deerangle.items.bars;

import com.deerangle.items.ItemSchokoBar;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemSchokoBarStone extends ItemSchokoBar {

	public ItemSchokoBarStone(String type) {
		super(type, 0);
	}

	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 600, 2));
		player.getFoodStats().addStats(-4, 0);
		return super.onEaten(stack, world, player);
	}
	
}
