package com.deerangle.items;

import com.deerangle.main.SchokoMod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemSchokoBar extends ItemFood {

	public ItemSchokoBar(String type, int food) {
		super(food, true);
		type = type.substring(0, 1).toUpperCase() + type.substring(1);
		this.setUnlocalizedName("schokoBar" + type);
		this.setCreativeTab(SchokoMod.tab);
		this.setTextureName(SchokoMod.MODID + ":schokoBar" + type);
	}
	
	public ItemSchokoBar(String type) {
		super(4, true);
		type = type.substring(0, 1).toUpperCase() + type.substring(1);
		this.setUnlocalizedName("schokoBar" + type);
		this.setCreativeTab(SchokoMod.tab);
		this.setTextureName(SchokoMod.MODID + ":schokoBar" + type);
	}
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		//player.addPotionEffect(new PotionEffect(Potion.digSpeed.getId(), 10*20, 1));
		return super.onEaten(stack, world, player);
	}

}
