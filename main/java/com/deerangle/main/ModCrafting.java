package com.deerangle.main;

import com.deerangle.items.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModCrafting {

	public static void load() {
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.mortar), "o/o", " o ", 'o', Blocks.cobblestone, '/', Items.stick);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.cocoaPowder), ModItems.mortar, new ItemStack(Items.dye, 1, 3));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.cocoaButter), ModItems.mortar, ModItems.cocoaPowder);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.cocoaButter, 2), ModItems.cocoaButter, Items.milk_bucket);
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.mug, 4), "O O", "O O", "OOO", 'O', Items.clay_ball);
	}
	
}
