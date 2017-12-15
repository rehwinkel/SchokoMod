package com.deerangle.main;

import java.util.ArrayList;
import java.util.List;

import com.deerangle.items.ModItems;
import com.deerangle.tile.TileEntitySchokoPress;

import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.oredict.OreDictionary;

public class SchokoPressNEI extends TemplateRecipeHandler {

	@Override
	public String getRecipeName() {
		return StatCollector.translateToLocal("tile.schokoPress.name");
	}

	@Override
	public String getOverlayIdentifier() {
		return "schokoPress";
	}

	@Override
	public String getGuiTexture() {
		return SchokoMod.MODID + ":textures/gui/container/schokoPressGui.png";
	}

	// loads recipes from output
	@Override
	public void loadCraftingRecipes(String outputId, Object... results) {
		if ((outputId.equals("item") || outputId.equals("schokoPress")) && (results.length > 0)) {
			loadCraftingRecipes((ItemStack) results[0]);
		}
	}

	// loads recipes from output
	@Override
	public void loadCraftingRecipes(ItemStack result) {
		if (result.getItem() instanceof ISchokoBar) {
			//hands in the bar itself
			CachedRecipe recipe = new CachedSchokoPressRecipe(result);
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
		System.out.println("call");
		if (ingredient.getItem() == ModItems.schokoIngot || ingredient.getItem() == Items.paper) {
			for(ItemStack i : TileEntitySchokoPress.recipesItem){
				//hands in the used ingredient
				arecipes.add(new CachedSchokoPressRecipe(i));
			}
			return;
		}else{
			for(int i = 0; i < TileEntitySchokoPress.recipesItem.size(); i++){
				ItemStack[] items = TileEntitySchokoPress.recipesItems.get(i);
				//hands in the used ingredient
				for(ItemStack stack : items){
					if(stack.getItem() == ingredient.getItem()){
						if(stack.getItemDamage() == ingredient.getItemDamage()){
							arecipes.add(new CachedSchokoPressRecipe(TileEntitySchokoPress.recipesItem.get(i)));
						}
					}
				}
			}
			return;
		}
	}

	@Override
	public void drawExtras(int recipe) {
		drawProgressBar(74, 24, 176, 0, 24, 17, 60, 0);
	}

	public class CachedSchokoPressRecipe extends TemplateRecipeHandler.CachedRecipe {

		private PositionedStack ingredient0;
		private PositionedStack ingredient1;
		private PositionedStack ingredient2;
		private PositionedStack ingredient3;
		private PositionedStack output;

//		public CachedSchokoPressRecipe(ItemStack ingredient, boolean b, int cocoa) {
//			super();
//			ingredient0 = new PositionedStack(new ItemStack(Items.sugar), 30, 14);
//			ingredient1 = new PositionedStack(new ItemStack(ModItems.cocoaButter), 50, 14);
//			ItemStack schoko = null;
//			if (cocoa == 0) {
//				schoko = new ItemStack(ModItems.schokoIngot, 1, cocoa);
//				ingredient2 = new PositionedStack(new ItemStack(ModItems.cocoaPowder), 30, 34);
//				ingredient3 = null;
//			}
//			if (cocoa == 1) {
//				schoko = new ItemStack(ModItems.schokoIngot, 1, cocoa);
//				ingredient2 = new PositionedStack(new ItemStack(ModItems.cocoaPowder), 30, 34);
//				ingredient3 = new PositionedStack(new ItemStack(ModItems.cocoaPowder), 50, 34);
//			}
//			if (cocoa == 2) {
//				schoko = new ItemStack(ModItems.schokoIngot, 1, cocoa);
//				ingredient2 = null;
//				ingredient3 = null;
//			}
//			output = new PositionedStack(schoko, 111, 24);
//		}

		public CachedSchokoPressRecipe(ItemStack stack) {
			output = new PositionedStack(stack, 111, 24);
		}

		@Override
		public List<PositionedStack> getIngredients() {
			ArrayList<PositionedStack> list = new ArrayList<PositionedStack>();
			if (ingredient0 != null)
				list.add(ingredient0);
			if (ingredient1 != null)
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
			if (!(obj instanceof CachedSchokoPressRecipe)) {
				return false;
			}
			CachedSchokoPressRecipe other = (CachedSchokoPressRecipe) obj;
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
