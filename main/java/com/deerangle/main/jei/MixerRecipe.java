package com.deerangle.main.jei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.deerangle.item.ModItems;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class MixerRecipe implements IRecipeWrapper {

	private List<List<ItemStack>> inputs;
	private ItemStack output;

	public MixerRecipe(int cocoa, ItemStack output) {
		List<List<ItemStack>> inputLists = new ArrayList<>();

		List<ItemStack> butters = new ArrayList<>();
		butters.add(new ItemStack(ModItems.COCOA_BUTTER, 1, 0));
		butters.add(new ItemStack(ModItems.COCOA_BUTTER, 1, 1));
		inputLists.add(butters);
		inputLists.add(Collections.singletonList(new ItemStack(Items.SUGAR)));
		for(int i = 0; i < cocoa; i++) {
			inputLists.add(Collections.singletonList(new ItemStack(ModItems.COCOA_POWDER)));
		}
		
		this.inputs = inputLists;
		this.output = output;
	}

	@Override
	public void getIngredients(IIngredients ingredients) {
		ingredients.setInputLists(ItemStack.class, inputs);
		ingredients.setOutput(ItemStack.class, output);
	}

}
