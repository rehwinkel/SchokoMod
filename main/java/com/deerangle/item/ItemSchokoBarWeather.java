package com.deerangle.item;

import com.deerangle.item.ItemSchokoBarWeather.EnumType;
import com.deerangle.item.bars.ItemSchokoBar;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSchokoBarWeather extends ItemSchokoBar {
	
	public ItemSchokoBarWeather(EnumType type) {
		super(type == EnumType.DAY ? "bed" : (type == EnumType.NIGHT ? "mushroom" : (type == EnumType.RAIN ? "lilypad" : "flower")));
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		if(stack.getItem().getUnlocalizedName().contains("bed")){
			if(!worldIn.isRemote){
				worldIn.setWorldTime(1000);
			}
		}
		
		if(stack.getItem().getUnlocalizedName().contains("mushroom")){
			if(!worldIn.isRemote){
				worldIn.setWorldTime(18000);
			}
		}
		
		if(stack.getItem().getUnlocalizedName().contains("lilypad")){
			if(!worldIn.isRemote){
		        worldIn.getWorldInfo().setRainTime(0);
		        worldIn.getWorldInfo().setRaining(true);
			}
		}
		
		if(stack.getItem().getUnlocalizedName().contains("flower")){
			if(!worldIn.isRemote){
		        worldIn.getWorldInfo().setRainTime(0);
		        worldIn.getWorldInfo().setThunderTime(0);
		        worldIn.getWorldInfo().setRaining(false);
		        worldIn.getWorldInfo().setThundering(false);
			}
		}
	}

	public enum EnumType {
		DAY,
		NIGHT,
		SUN,
		RAIN;
	}
	
}
