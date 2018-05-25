package com.deerangle.main.jei;

import com.deerangle.block.ModBlocks; 
import com.deerangle.gui.container.ContainerDistiller;
import com.deerangle.gui.container.ContainerMixer;
import com.deerangle.gui.container.ContainerPacker;
import com.deerangle.gui.gui.GuiDistiller;
import com.deerangle.gui.gui.GuiMixer;
import com.deerangle.gui.gui.GuiPacker;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.ISubtypeRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.ingredients.IModIngredientRegistration;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import mezz.jei.api.recipe.transfer.IRecipeTransferRegistry;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.ShapedOreRecipe;

@JEIPlugin
public class NoahsChocolatePlugin implements IModPlugin {
	
	@Override
	public void register(IModRegistry registry) {
		IJeiHelpers jeiHelpers = registry.getJeiHelpers();

		registry.addRecipes(DistillerRecipeMaker.getDistillerRecipes(jeiHelpers), RecipeCategories.DISTILLER);
		registry.addRecipes(MixerRecipeMaker.getMixerRecipes(jeiHelpers), RecipeCategories.MIXER);
		registry.addRecipes(PackerRecipeMaker.getPackerRecipes(jeiHelpers), RecipeCategories.PACKER);

		registry.addRecipeCatalyst(new ItemStack(ModBlocks.DISTILLER), RecipeCategories.DISTILLER, VanillaRecipeCategoryUid.FUEL);
		registry.addRecipeCatalyst(new ItemStack(ModBlocks.MIXER), RecipeCategories.MIXER);
		registry.addRecipeCatalyst(new ItemStack(ModBlocks.PACKER), RecipeCategories.PACKER);

		registry.addRecipeClickArea(GuiDistiller.class, 102, 34, 22, 15, RecipeCategories.DISTILLER, VanillaRecipeCategoryUid.FUEL);
		registry.addRecipeClickArea(GuiMixer.class, 86, 34, 22, 15, RecipeCategories.MIXER);
		registry.addRecipeClickArea(GuiPacker.class, 103, 35, 22, 15, RecipeCategories.PACKER);
		
		IRecipeTransferRegistry recipeTransferRegistry = registry.getRecipeTransferRegistry();
		recipeTransferRegistry.addRecipeTransferHandler(ContainerDistiller.class, RecipeCategories.DISTILLER, 0, 1, 1, 36);
		recipeTransferRegistry.addRecipeTransferHandler(ContainerMixer.class, RecipeCategories.MIXER, 0, 4, 5, 36);
		recipeTransferRegistry.addRecipeTransferHandler(ContainerPacker.class, RecipeCategories.PACKER, 0, 4, 5, 36);
	}
	
	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		IJeiHelpers jeiHelpers = registry.getJeiHelpers();
		IGuiHelper guiHelper = jeiHelpers.getGuiHelper();

		registry.addRecipeCategories(new DistillerRecipeCategory(guiHelper));
		registry.addRecipeCategories(new MixerRecipeCategory(guiHelper));
		registry.addRecipeCategories(new PackerRecipeCategory(guiHelper));
	}
	
}
