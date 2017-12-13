package com.deerangle.items.bars;

import com.deerangle.main.SchokoMod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSchokoBarLilypad extends ItemFood {

	public ItemSchokoBarLilypad() {
		super(4, false);
		this.setUnlocalizedName("schokoBarLilypad");
		this.setCreativeTab(SchokoMod.bars);
		this.setTextureName(SchokoMod.MODID + ":bars/schokoBarLilypad");
	}
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		if(!world.isRemote){
	        world.getWorldInfo().setRainTime(0);
	        world.getWorldInfo().setRaining(true);
		}
		return super.onEaten(stack, world, player);
	}

}
