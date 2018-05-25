package com.deerangle.main.jei;

import java.util.ArrayList; 
import java.util.List;
import java.util.Map;

import com.deerangle.item.ModItems;

import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class DistillerRecipeMaker {

	public static ArrayList<DistillerRecipe> getDistillerRecipes(IJeiHelpers jeiHelpers) {
		IStackHelper stackHelper = jeiHelpers.getStackHelper();

		ArrayList<DistillerRecipe> recipes = new ArrayList<>();
		recipes.add(new DistillerRecipe(new ItemStack(ModItems.WEED), new ItemStack(ModItems.THC)));

		return recipes;
	}

}
