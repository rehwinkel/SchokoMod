package com.deerangle.main.jei;

import com.deerangle.main.NoahsChocolate; 

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IDrawableAnimated;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.IDrawableAnimated.StartDirection;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;

public class PackerRecipeCategory implements IRecipeCategory {

	private IDrawableStatic drawable;
	private String localizedName;
	
	private IDrawableAnimated arrow;

	public PackerRecipeCategory(IGuiHelper guiHelper) {
		ResourceLocation location = new ResourceLocation(NoahsChocolate.MODID, "textures/gui/container/gui_packer.png");
		drawable = guiHelper.createDrawable(location, 25, 24, 130, 38);
		localizedName = I18n.format("gui.packing");
		
		IDrawableStatic sArrow = guiHelper.createDrawable(location, 176, 0, 22, 16);
		arrow = guiHelper.createAnimatedDrawable(sArrow, 100, StartDirection.LEFT, false);
	}

	@Override
	public void drawExtras(Minecraft minecraft) {
		arrow.draw(minecraft, 78, 11);
	}

	@Override
	public String getUid() {
		return RecipeCategories.PACKER;
	}

	@Override
	public String getTitle() {
		return localizedName;
	}

	@Override
	public String getModName() {
		return NoahsChocolate.NAME;
	}

	@Override
	public IDrawable getBackground() {
		return drawable;
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, IRecipeWrapper recipeWrapper, IIngredients ingredients) {
		IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();

		guiItemStacks.init(0, true, 0, 0);
		guiItemStacks.init(1, true, 0, 20);
		guiItemStacks.init(2, true, 56, 10);
		guiItemStacks.init(3, true, 36, 10);
		guiItemStacks.init(4, false, 108, 10);
		
		guiItemStacks.set(ingredients);
	}

}
