package com.deerangle.tile.entity;

import java.util.ArrayList;
import java.util.List;

import com.deerangle.items.ModItems;
import com.deerangle.main.SchokoMod;

import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.oredict.OreDictionary;

public class SchokoMixerNEI extends TemplateRecipeHandler {

	@Override
	public String getRecipeName() {
		return StatCollector.translateToLocal("tile.schokoMixer.name");
	}

	@Override
	public String getOverlayIdentifier() {
		return "schokoMixer";
	}

	@Override
	public String getGuiTexture() {
		return SchokoMod.MODID + ":textures/gui/container/schokoMixerGui.png";
	}

	// loads recipes from output
	@Override
	public void loadCraftingRecipes(String outputId, Object... results) {
		if ((outputId.equals("item") || outputId.equals("schokoMixer")) && (results.length > 0)) {
			loadCraftingRecipes((ItemStack) results[0]);
		}
	}

	// loads recipes from output
	@Override
	public void loadCraftingRecipes(ItemStack result) {
		if (result.getItem() == ModItems.schokoIngot) {
			CachedRecipe recipe = new CachedSchokoMixerRecipe(result.getItemDamage());
			arecipes.add(recipe);
		}
	}

	// load recipes from partial recipe input
	@Override
	public void loadUsageRecipes(String inputId, Object... ingredients) {
		if (ingredients.length >= 1 && ingredients[0] instanceof ItemStack)
			loadUsageRecipes((ItemStack) ingredients[0]);
	}

	// load recipes from partial recipe input
	@Override
	public void loadUsageRecipes(ItemStack ingredient) {
		if (ingredient.getItem() == ModItems.cocoaButter || ingredient.getItem() == Items.sugar) {
			arecipes.add(new CachedSchokoMixerRecipe(0));
			arecipes.add(new CachedSchokoMixerRecipe(1));
			arecipes.add(new CachedSchokoMixerRecipe(2));
		}

		if (ingredient.getItem() == ModItems.cocoaPowder) {
			arecipes.add(new CachedSchokoMixerRecipe(0));
			arecipes.add(new CachedSchokoMixerRecipe(1));
		}
	}

	@Override
	public void drawExtras(int recipe) {
		drawProgressBar(74, 24, 176, 0, 24, 17, 60, 0);
	}

	public class CachedSchokoMixerRecipe extends TemplateRecipeHandler.CachedRecipe {

		private PositionedStack ingredient0;
		private PositionedStack ingredient1;
		private PositionedStack ingredient2;
		private PositionedStack ingredient3;
		private PositionedStack output;

		public CachedSchokoMixerRecipe(int cocoa) {
			super();
			ingredient0 = new PositionedStack(new ItemStack(Items.sugar), 30, 14);
			ingredient1 = new PositionedStack(new ItemStack(ModItems.cocoaButter), 50, 14);
			ItemStack schoko = null;
			if (cocoa == 0) {
				schoko = new ItemStack(ModItems.schokoIngot, 1, cocoa);
				ingredient2 = new PositionedStack(new ItemStack(ModItems.cocoaPowder), 30, 34);
				ingredient3 = null;
			}
			if (cocoa == 1) {
				schoko = new ItemStack(ModItems.schokoIngot, 1, cocoa);
				ingredient2 = new PositionedStack(new ItemStack(ModItems.cocoaPowder), 30, 34);
				ingredient3 = new PositionedStack(new ItemStack(ModItems.cocoaPowder), 50, 34);
			}
			if (cocoa == 2) {
				schoko = new ItemStack(ModItems.schokoIngot, 1, cocoa);
				ingredient2 = null;
				ingredient3 = null;
			}
			output = new PositionedStack(schoko, 111, 24);
		}

		@Override
		public List<PositionedStack> getIngredients() {
			ArrayList<PositionedStack> list = new ArrayList<PositionedStack>();
			list.add(ingredient0);
			list.add(ingredient1);
			if (ingredient2 != null)
				list.add(ingredient2);
			if (ingredient3 != null)
				list.add(ingredient3);
			return list;
		}

		@Override
		public PositionedStack getResult() {
			return output;
		}

		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (!(obj instanceof CachedSchokoMixerRecipe)) {
				return false;
			}
			CachedSchokoMixerRecipe other = (CachedSchokoMixerRecipe) obj;
			if (ingredient0 == null) {
				if (other.ingredient0 != null)
					return false;
			} else if (ingredient0.item == null) {
				if (other.ingredient0.item != null)
					return false;
			} else if (!ItemStack.areItemStacksEqual(ingredient0.item, other.ingredient0.item)) {
				return false;
			}
			if (output == null) {
				if (other.output != null)
					return false;
			} else if (output.item == null) {
				if (other.output.item != null)
					return false;
			} else if (!ItemStack.areItemStacksEqual(output.item, other.output.item)) {
				return false;
			}
			return true;
		}

	}
}
