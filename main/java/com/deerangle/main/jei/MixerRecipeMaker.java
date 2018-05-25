package com.deerangle.main.jei;

import java.util.ArrayList;

import com.deerangle.item.ModItems;

import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.item.ItemStack;

public class MixerRecipeMaker {

	public static ArrayList<MixerRecipe> getMixerRecipes(IJeiHelpers jeiHelpers) {
		IStackHelper stackHelper = jeiHelpers.getStackHelper();

		ArrayList<MixerRecipe> recipes = new ArrayList<>();
		recipes.add(new MixerRecipe(0, new ItemStack(ModItems.SCHOKO_INGOT, 1, 2)));
		recipes.add(new MixerRecipe(1, new ItemStack(ModItems.SCHOKO_INGOT, 1, 0)));
		recipes.add(new MixerRecipe(2, new ItemStack(ModItems.SCHOKO_INGOT, 1, 1)));

		return recipes;
	}
	
}
