package com.deerangle.main.jei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.deerangle.item.ModItems;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PackerRecipe implements IRecipeWrapper {

	private List<List<ItemStack>> inputs;
	private ItemStack output;

	public PackerRecipe(int cocoaId, Item special, boolean useFlavor, int out) {
		this(cocoaId, useFlavor, out, new ItemStack(special));
	}

	public PackerRecipe(int cocoaId, Block special, boolean useFlavor, int out) {
		this(cocoaId, useFlavor, out, new ItemStack(special));
	}

	public PackerRecipe(int cocoaId, ItemStack special, boolean useFlavor, int out) {
		this(cocoaId, useFlavor, out, special);
	}

	public PackerRecipe(int cocoaId, boolean useFlavor, int out, Block... specials) {
		this(cocoaId, useFlavor, out, blockToStack(specials));
	}

	public PackerRecipe(int cocoaId, boolean useFlavor, int out, Item... specials) {
		this(cocoaId, useFlavor, out, blockToStack(specials));
	}
	
	private static ItemStack[] blockToStack(Block[] specials) {
		ItemStack[] stacks = new ItemStack[specials.length];
		for(int i = 0; i < stacks.length; i++) {
			stacks[i] = new ItemStack(specials[i]);
		}
		return stacks;
	}
	
	private static ItemStack[] blockToStack(Item[] specials) {
		ItemStack[] stacks = new ItemStack[specials.length];
		for(int i = 0; i < stacks.length; i++) {
			stacks[i] = new ItemStack(specials[i]);
		}
		return stacks;
	}
	
	public PackerRecipe(int cocoaId, boolean useFlavor, int out, ItemStack... specials) {
		inputs = new ArrayList<>();
		inputs.add(Collections.singletonList(new ItemStack(ModItems.WRAP_PAPER)));
		if(cocoaId >= 0) {
			inputs.add(Collections.singletonList(new ItemStack(ModItems.SCHOKO_INGOT, 1, cocoaId)));
		}else {
			inputs.add(Collections.singletonList(ItemStack.EMPTY));
		}
		
		if(useFlavor) {
			inputs.add(Collections.singletonList(new ItemStack(ModItems.FLAVOR_ENHANCER)));
		}else {
			inputs.add(Collections.singletonList(ItemStack.EMPTY));
		}
		
		List<ItemStack> specialList = new ArrayList<>();
		for(ItemStack i : specials){
			specialList.add(i);
		}
		inputs.add(specialList);
		
		output = new ItemStack(ModItems.CHOCOLATE_BAR, 1, out);
	}

	@Override
	public void getIngredients(IIngredients ingredients) {
		ingredients.setInputLists(ItemStack.class, inputs);
		ingredients.setOutput(ItemStack.class, output);
	}

}
