package com.deerangle.main.jei;

import com.deerangle.main.NoahsChocolate; 

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IDrawableAnimated;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class DistillerRecipeCategory implements IRecipeCategory {

	private IDrawable drawable;
	private String localizedName;

	private IDrawableAnimated flames;
	private IDrawableAnimated bubbles;
	private IDrawableAnimated arrow;
	private IDrawableAnimated fluid;
	private IDrawableStatic bars;

	public DistillerRecipeCategory(IGuiHelper guiHelper) {
		ResourceLocation location = new ResourceLocation(NoahsChocolate.MODID, "textures/gui/container/gui_distiller.png");
		
		IDrawableStatic sFlames = guiHelper.createDrawable(location, 176, 34, 14, 14);
		flames = guiHelper.createAnimatedDrawable(sFlames, 300, IDrawableAnimated.StartDirection.TOP, true);
		IDrawableStatic sBubbles = guiHelper.createDrawable(location, 176, 0, 19, 11);
		bubbles = guiHelper.createAnimatedDrawable(sBubbles, 200, IDrawableAnimated.StartDirection.LEFT, false);
		IDrawableStatic sArrow = guiHelper.createDrawable(location, 195, 0, 22, 16);
		arrow = guiHelper.createAnimatedDrawable(sArrow, 400, IDrawableAnimated.StartDirection.LEFT, false);
		IDrawableStatic sFluid = guiHelper.createDrawable(location, 240, 0, 16, 23);
		fluid = guiHelper.createAnimatedDrawable(sFluid, 3200, IDrawableAnimated.StartDirection.BOTTOM, false);
		bars = guiHelper.createDrawable(location, 176, 11, 12, 23);
		
		drawable = guiHelper.createDrawable(location, 25, 12, 130, 57);
		localizedName = I18n.format("gui.destillation");
	}

	@Override
	public void drawExtras(Minecraft minecraft) {
		flames.draw(minecraft, 1, 21);
		bubbles.draw(minecraft, 27, 23);
		arrow.draw(minecraft, 77, 22);
		fluid.draw(minecraft, 55, 17);
		bars.draw(minecraft, 55, 17);
	}
	
	@Override
	public String getUid() {
		return RecipeCategories.DISTILLER;
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
		guiItemStacks.init(2, false, 108, 20);
		
		guiItemStacks.set(ingredients);
	}

}
