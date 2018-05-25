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

public class MixerRecipeCategory implements IRecipeCategory {

	private IDrawable drawable;
	private String localizedName;
	private IDrawableAnimated arrow;

	public MixerRecipeCategory(IGuiHelper guiHelper) {
		ResourceLocation location = new ResourceLocation(NoahsChocolate.MODID, "textures/gui/container/gui_mixer.png");
		drawable = guiHelper.createDrawable(location, 37, 24, 108, 38);
		localizedName = I18n.format("gui.mixing");
		
		IDrawableStatic sArrow = guiHelper.createDrawable(location, 176, 0, 22, 16);
		arrow = guiHelper.createAnimatedDrawable(sArrow, 100, StartDirection.LEFT, false);
	}

	@Override
	public void drawExtras(Minecraft minecraft) {
		arrow.draw(minecraft, 49, 11);
	}
	
	@Override
	public String getUid() {
		return RecipeCategories.MIXER;
	}

	@Override
	public String getTitle() {
		return localizedName;
	}

	@Override
	public String getModName() {
		return NoahsChocolate.MODID;
	}

	@Override
	public IDrawable getBackground() {
		return drawable;
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, IRecipeWrapper recipeWrapper, IIngredients ingredients) {
		IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();

		guiItemStacks.init(0, true, 0, 0);
		guiItemStacks.init(1, true, 20, 0);
		guiItemStacks.init(2, true, 0, 20);
		guiItemStacks.init(3, true, 20, 20);
		guiItemStacks.init(4, false, 86, 10);
		
		guiItemStacks.set(ingredients);
	}

}
