package com.deerangle.main;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.ISubtypeRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.ingredients.IModIngredientRegistration;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.plugins.vanilla.furnace.FurnaceFuelCategory;

@JEIPlugin
public class NoahsChocolatePlugin implements IModPlugin {
	
	@Override
	public void registerItemSubtypes(ISubtypeRegistry subtypeRegistry) {
		//nothing
	}
	
	@Override
	public void registerIngredients(IModIngredientRegistration registry) {
		
	}
	
	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		//IJeiHelpers jeiHelpers = registry.getJeiHelpers();
		//IGuiHelper guiHelper = jeiHelpers.getGuiHelper();
		//registry.addRecipeCategories(new FurnaceFuelCategory(guiHelper));
	}
	
}
