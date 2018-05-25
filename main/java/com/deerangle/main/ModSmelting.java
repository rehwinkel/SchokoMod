package com.deerangle.main;

import com.deerangle.item.ModItems;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class ModSmelting {

	public static void preInit() {
		FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(ModItems.SCHOKO_DRINK, 1), new ItemStack(ModItems.SCHOKO_DRINK, 1, 1), 0.5F);
	}

}
