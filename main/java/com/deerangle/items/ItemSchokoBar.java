package com.deerangle.items;

import com.deerangle.main.ExampleMod;

import net.minecraft.item.Item;

public class ItemSchokoBar extends Item {

	public ItemSchokoBar(String type) {
		type = type.substring(0, 1).toUpperCase() + type.substring(1);
		this.setUnlocalizedName("schokoBar" + type);
		this.setCreativeTab(ExampleMod.tab);
		this.setTextureName(ExampleMod.MODID + ":schokoBar" + type);
	}

}
