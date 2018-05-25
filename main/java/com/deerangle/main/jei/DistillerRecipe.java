package com.deerangle.main.jei;

import java.util.Collections;
import java.util.List;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;

public class DistillerRecipe implements IRecipeWrapper {

	private ItemStack input;
	private ItemStack output;

	public DistillerRecipe(ItemStack in, ItemStack out) {
		this.input = in;
		this.output = out;
	}

	@Override
	public void getIngredients(IIngredients ingredients) {
		ingredients.setInput(ItemStack.class, input);
		ingredients.setOutput(ItemStack.class, output);
	}

}
