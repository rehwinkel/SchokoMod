package com.deerangle.items;

import com.deerangle.main.SchokoMod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemSchokoBarWither extends ItemSchokoBar {

	public ItemSchokoBarWither() {
		super("wither");
	}
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		if(Math.random() < 0.08){
			player.addPotionEffect(new PotionEffect(Potion.wither.id, 10 * 20, effect));
			player.inventory.addItemStackToInventory(new ItemStack(Items.skull, 1, 1));
		}
		return super.onEaten(stack, world, player);
	}

}
