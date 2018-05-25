package com.deerangle.item;

import com.deerangle.main.NoahsChocolate;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemCocoaButter extends Item {

	public ItemCocoaButter() {
		this.setUnlocalizedName("cocoa_butter");
		this.setRegistryName("cocoa_butter");
		this.setCreativeTab(NoahsChocolate.tab);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}
	
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			items.add(new ItemStack(this, 1, 0));
			items.add(new ItemStack(this, 1, 1));
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		if(stack.getMetadata() > 0) {
			return super.getUnlocalizedName() + "_diluted";
		}
		return super.getUnlocalizedName();
	}
	
	@Override
	public int getMetadata(int damage) {
		return damage;
	}
	
	@Override
	public int getMetadata(ItemStack stack) {
		return stack.getItemDamage();
	}
	
}
