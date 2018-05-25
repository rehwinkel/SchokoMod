package com.deerangle.main.jei;

import java.util.ArrayList;
import java.util.Collection;

import com.deerangle.item.ModItems;

import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PackerRecipeMaker {

	public static ArrayList<PackerRecipe> getPackerRecipes(IJeiHelpers jeiHelpers) {
		IStackHelper stackHelper = jeiHelpers.getStackHelper();

		ArrayList<PackerRecipe> recipes = new ArrayList<>();
		recipes.add(new PackerRecipe(0, ItemStack.EMPTY, false, 0));
		recipes.add(new PackerRecipe(1, ItemStack.EMPTY, false, 1));
		recipes.add(new PackerRecipe(2, ItemStack.EMPTY, false, 2));
		recipes.add(new PackerRecipe(0, ModItems.SCHOKO_INGOT, false, 3));
		recipes.add(new PackerRecipe(-1, ModItems.WRAP_PAPER, false, 4));
		recipes.add(new PackerRecipe(0, Items.COOKIE, false, 5));
		recipes.add(new PackerRecipe(0, new ItemStack(Items.DYE, 1, 3), false, 6));
		recipes.add(new PackerRecipe(0, ModItems.SMARTIES, false, 7));
		recipes.add(new PackerRecipe(0, Items.MILK_BUCKET, false, 8)); //TODO: only consume milk
		for(int i = 0; i < 16; i++) {
			recipes.add(new PackerRecipe(2, new ItemStack(Items.DYE, 1, 15 - i), false, 9 + i));
		}
		recipes.add(new PackerRecipe(0, Items.BREAD, false, 25));
		recipes.add(new PackerRecipe(0, ModItems.GRANOLA_BAR, true, 26));
		recipes.add(new PackerRecipe(2, Blocks.DOUBLE_PLANT, false, 27));
		recipes.add(new PackerRecipe(0, Items.SLIME_BALL, false, 28));
		recipes.add(new PackerRecipe(2, Items.GOLDEN_APPLE, false, 29));
		recipes.add(new PackerRecipe(1, new ItemStack(Items.SKULL, 1, 3), false, 30));
		recipes.add(new PackerRecipe(0, ModItems.THC, false, 31));
		recipes.add(new PackerRecipe(0, false, 32, Items.SPIDER_EYE, Items.POISONOUS_POTATO));
		recipes.add(new PackerRecipe(0, Items.FISH, false, 33));
		recipes.add(new PackerRecipe(0, Items.QUARTZ, false, 34));
		recipes.add(new PackerRecipe(0, Blocks.COBBLESTONE, false, 35));
		recipes.add(new PackerRecipe(1, Blocks.WEB, false, 36));
		recipes.add(new PackerRecipe(1, Items.GUNPOWDER, true, 37));
		recipes.add(new PackerRecipe(1, Items.ENDER_PEARL, false, 38));
		recipes.add(new PackerRecipe(1, Blocks.SOUL_SAND, false, 39));
		recipes.add(new PackerRecipe(1, false, 40, Items.FLINT_AND_STEEL, Items.FIRE_CHARGE));
		recipes.add(new PackerRecipe(1, Items.FIREWORKS, false, 41));
		recipes.add(new PackerRecipe(2, Blocks.GLASS, false, 42));
		recipes.add(new PackerRecipe(0, ModItems.ERROR, false, 43));
		recipes.add(new PackerRecipe(0, Items.APPLE, false, 44));
		recipes.add(new PackerRecipe(0, Items.GLOWSTONE_DUST, true, 45));
		recipes.add(new PackerRecipe(0, Items.REDSTONE, true, 46));
		recipes.add(new PackerRecipe(0, ModItems.TRIANGLE, true, 47));
		recipes.add(new PackerRecipe(0, false, 48, Items.BEEF, Items.LEATHER));
		ItemStack[] flowers = {new ItemStack(Blocks.RED_FLOWER, 1, 0), new ItemStack(Blocks.RED_FLOWER, 1, 1), new ItemStack(Blocks.RED_FLOWER, 1, 2), new ItemStack(Blocks.RED_FLOWER, 1, 4), new ItemStack(Blocks.RED_FLOWER, 1, 5), new ItemStack(Blocks.RED_FLOWER, 1, 7)};
		recipes.add(new PackerRecipe(2, false, 49, flowers));
		recipes.add(new PackerRecipe(1, Items.BOOK, true, 50));
		recipes.add(new PackerRecipe(2, Items.GHAST_TEAR, true, 51));
		recipes.add(new PackerRecipe(0, ModItems.SANTA_HAT, false, 52));
		recipes.add(new PackerRecipe(1, true, 53, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN));
		
		return recipes;
	}

}
