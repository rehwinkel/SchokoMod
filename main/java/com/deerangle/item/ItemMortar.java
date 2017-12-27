package com.deerangle.item;

import com.deerangle.main.NoahsChocolate;

import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemBucketMilk;
import net.minecraft.item.ItemStack;

public class ItemMortar extends Item {

	public ItemMortar(){
		this.setUnlocalizedName("mortar_and_pestle");
		this.setRegistryName("mortar_and_pestle");
		this.setCreativeTab(NoahsChocolate.tab);
	}
	
	@Override
	public boolean hasContainerItem(ItemStack stack) {
		return true;
	}
	
	@Override
	public ItemStack getContainerItem(ItemStack itemStack) {
		return new ItemStack(this);
	}
	
}
