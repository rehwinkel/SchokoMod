package com.deerangle.items;

import com.deerangle.main.SchokoMod;

import net.minecraft.item.ItemFood;

public class ItemSmarties extends ItemFood {

	public ItemSmarties() {
		super(2, false);
		this.setUnlocalizedName("smarties");
		this.setTextureName(SchokoMod.MODID + ":smarties");
		this.setCreativeTab(SchokoMod.rest);
	}

}
