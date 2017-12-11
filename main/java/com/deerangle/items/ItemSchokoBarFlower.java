package com.deerangle.items;

import com.deerangle.main.SchokoMod;

import net.minecraft.command.CommandWeather;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSchokoBarFlower extends ItemFood {

	public ItemSchokoBarFlower() {
		super(4, false);
		this.setUnlocalizedName("schokoBarFlower");
		this.setCreativeTab(SchokoMod.bars);
		this.setTextureName(SchokoMod.MODID + ":bars/schokoBarFlower");
	}
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		if(!world.isRemote){
			world.setWorldTime(1000);
	        world.getWorldInfo().setRainTime(0);
	        world.getWorldInfo().setThunderTime(0);
	        world.getWorldInfo().setRaining(false);
	        world.getWorldInfo().setThundering(false);
		}
		return super.onEaten(stack, world, player);
	}

}
