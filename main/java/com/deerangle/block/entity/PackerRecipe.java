package com.deerangle.block.entity;

import java.util.ArrayList;
import java.util.List;

import com.deerangle.item.ModItems;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class PackerRecipe {

	public static List<PackerRecipe> getAllRecipes(){
		List<PackerRecipe> recipes = new ArrayList<>();
		
		recipes.add(new PackerRecipe(0, false, 0, ItemStack.EMPTY));
		recipes.add(new PackerRecipe(1, false, 1, ItemStack.EMPTY));
		recipes.add(new PackerRecipe(2, false, 2, ItemStack.EMPTY));
		recipes.add(new PackerRecipe(0, false, 3, new ItemStack(ModItems.SCHOKO_INGOT)));
		recipes.add(new PackerRecipe(-1, false, 4, new ItemStack(ModItems.WRAP_PAPER)));
		recipes.add(new PackerRecipe(0, false, 5, new ItemStack(Items.COOKIE)));
		recipes.add(new PackerRecipe(0, false, 6, new ItemStack(Items.DYE, 1, 3)));
		recipes.add(new PackerRecipe(0, false, 7, new ItemStack(ModItems.SMARTIES)));
		recipes.add(new PackerRecipe(0, false, 8, new ItemStack(Items.MILK_BUCKET)));
		for(int i = 0; i < 16; i++) {
			recipes.add(new PackerRecipe(2, false, 9 + i, new ItemStack(Items.DYE, 1, 15 - i)));
		}
		recipes.add(new PackerRecipe(0, false, 25, new ItemStack(Items.BREAD)));
		recipes.add(new PackerRecipe(0, true, 26, new ItemStack(ModItems.GRANOLA_BAR)));
		recipes.add(new PackerRecipe(2, false, 27, new ItemStack(Blocks.DOUBLE_PLANT)));
		recipes.add(new PackerRecipe(0, false, 28, new ItemStack(Items.SLIME_BALL)));
		recipes.add(new PackerRecipe(2, false, 29, new ItemStack(Items.GOLDEN_APPLE)));
		recipes.add(new PackerRecipe(1, false, 30, new ItemStack(Items.SKULL, 1, 3)));
		recipes.add(new PackerRecipe(0, false, 31, new ItemStack(ModItems.THC)));
		recipes.add(new PackerRecipe(0, false, 32, new ItemStack(Items.SPIDER_EYE), new ItemStack(Items.POISONOUS_POTATO)));
		recipes.add(new PackerRecipe(0, false, 33, new ItemStack(Items.FISH)));
		recipes.add(new PackerRecipe(0, false, 34, new ItemStack(Items.QUARTZ)));
		recipes.add(new PackerRecipe(0, false, 35, new ItemStack(Blocks.COBBLESTONE)));
		recipes.add(new PackerRecipe(1, false, 36, new ItemStack(Blocks.WEB)));
		recipes.add(new PackerRecipe(1, true, 37, new ItemStack(Items.GUNPOWDER)));
		recipes.add(new PackerRecipe(1, false, 38, new ItemStack(Items.ENDER_PEARL)));
		recipes.add(new PackerRecipe(1, false, 39, new ItemStack(Blocks.SOUL_SAND)));
		recipes.add(new PackerRecipe(1, false, 40, new ItemStack(Items.FLINT_AND_STEEL), new ItemStack(Items.FIRE_CHARGE)));
		recipes.add(new PackerRecipe(1, false, 41, new ItemStack(Items.FIREWORKS)));
		recipes.add(new PackerRecipe(2, false, 42, new ItemStack(Blocks.GLASS)));
		recipes.add(new PackerRecipe(0, false, 43, new ItemStack(ModItems.ERROR)));
		recipes.add(new PackerRecipe(0, false, 44, new ItemStack(Items.APPLE)));
		recipes.add(new PackerRecipe(0, true, 45, new ItemStack(Items.GLOWSTONE_DUST)));
		recipes.add(new PackerRecipe(0, true, 46, new ItemStack(Items.REDSTONE)));
		recipes.add(new PackerRecipe(0, true, 47, new ItemStack(ModItems.TRIANGLE)));
		recipes.add(new PackerRecipe(0, false, 48, new ItemStack(Items.BEEF), new ItemStack(Items.LEATHER)));
		ItemStack[] flowers = {new ItemStack(Blocks.RED_FLOWER, 1, 0), new ItemStack(Blocks.RED_FLOWER, 1, 1), new ItemStack(Blocks.RED_FLOWER, 1, 2), new ItemStack(Blocks.RED_FLOWER, 1, 4), new ItemStack(Blocks.RED_FLOWER, 1, 5), new ItemStack(Blocks.RED_FLOWER, 1, 7)};
		recipes.add(new PackerRecipe(2, false, 49, flowers));
		recipes.add(new PackerRecipe(1, true, 50, new ItemStack(Items.BOOK)));
		recipes.add(new PackerRecipe(2, true, 51, new ItemStack(Items.GHAST_TEAR)));
		recipes.add(new PackerRecipe(0, false, 52, new ItemStack(ModItems.SANTA_HAT)));
		recipes.add(new PackerRecipe(1, true, 53, new ItemStack(Blocks.PUMPKIN), new ItemStack(Blocks.LIT_PUMPKIN)));
		
		return recipes;
	}

	private int outputId;
	private boolean useFlavor;
	private int cocoaId;
	private List<ItemStack> specials;
	
	public PackerRecipe(int cocoaId, boolean flavor, int outputId, ItemStack... specials) {
		this.outputId = outputId;
		this.useFlavor = flavor;
		this.cocoaId = cocoaId;
		List<ItemStack> specialsList = new ArrayList<>();
		for(ItemStack i : specials) {
			specialsList.add(i);
		}
		this.specials = specialsList;
	}
	
	public static int getOutput(List<PackerRecipe> recipe, int cocoaId, boolean flavor, ItemStack special) {
		for(PackerRecipe r : recipe) {
			if(isValid(r, cocoaId, flavor, special)) {
				return r.outputId;
			}
		}
		return -1;
	}
	
	public static boolean isValid(PackerRecipe recipe, int cocoaId, boolean flavor, ItemStack special) {
		if(recipe.cocoaId == cocoaId && recipe.useFlavor == flavor) {
			boolean specialMatch = false;
			for(ItemStack i : recipe.specials) {
				ItemStack s = special.copy();
				s.setCount(1);
				if(ItemStack.areItemStacksEqual(i, s)){
					specialMatch = true;
					break;
				}
			}
			return specialMatch;
		}
		return false;
	}
	
}
