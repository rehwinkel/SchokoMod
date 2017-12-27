package com.deerangle.item;

import com.deerangle.main.NoahsChocolate;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;

public class ItemSchokoIngot extends Item {

	public ItemSchokoIngot() {
		this.setUnlocalizedName("schoko_ingot");
		this.setRegistryName("schoko_ingot");
		this.setCreativeTab(NoahsChocolate.tab);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}
	
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			items.add(new ItemStack(this, 1, 0));
			items.add(new ItemStack(this, 1, 1));
			items.add(new ItemStack(this, 1, 2));
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		String[] types = new String[] { "normal", "dark", "light" };
		return super.getUnlocalizedName() + "_" + types[stack.getMetadata()];
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
