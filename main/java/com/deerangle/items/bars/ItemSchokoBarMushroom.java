package com.deerangle.items.bars;

import com.deerangle.main.SchokoMod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSchokoBarMushroom extends ItemFood {

	public ItemSchokoBarMushroom() {
		super(4, false);
		this.setUnlocalizedName("schokoBarMushroom");
		this.setCreativeTab(SchokoMod.bars);
		this.setTextureName(SchokoMod.MODID + ":bars/schokoBarMushroom");
	}
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		if(!world.isRemote){
			world.setWorldTime(18000);
		}
		return super.onEaten(stack, world, player);
	}

}
