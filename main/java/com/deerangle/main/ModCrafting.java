package com.deerangle.main;

import java.util.HashMap;

import com.deerangle.items.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModCrafting {

	public static void load() {
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.mortar), "o/o", " o ", 'o', Blocks.cobblestone, '/', Items.stick);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.cocoaPowder), ModItems.mortar, new ItemStack(Items.dye, 1, 3));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.cocoaButter), ModItems.mortar, ModItems.cocoaPowder);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.weed), ModItems.mortar, ModItems.weedBud);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.cocoaButter, 2), ModItems.cocoaButter, Items.milk_bucket);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.schokoDrink), ModItems.cocoaPowder, Items.sugar, ModItems.mug, Items.milk_bucket);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.smarties), ModItems.schokoIngot, new ItemStack(Items.dye, 1, 1));
		GameRegistry.addSmelting(new ItemStack(ModItems.schokoDrink), new ItemStack(ModItems.schokoDrink, 1, 1), 0);
		
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.mug, 4), "O O", "O O", "OOO", 'O', Items.clay_ball);
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.santaHat, 1), " R ", "RRR", "WWW", 'R', new ItemStack(Blocks.wool, 1, 14), 'W', new ItemStack(Blocks.wool, 1, 0));
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.triangle), " O ", "OOO", 'O', ModItems.schokoIngot);
	}

	public static boolean willStackOn(ItemStack top, ItemStack bottom) {
		if (top == null) {
			return false;
		}
		if (bottom == null) {
			return true;
		}
		if (top.getItem() == bottom.getItem()) {
			if (bottom.stackSize + top.stackSize <= bottom.getMaxStackSize()) {
				if (top.getItemDamage() == bottom.getItemDamage()) {
					return true;
				}
			}
		}
		return false;
	}

	public static ItemStack addItemStacks(ItemStack stacka, ItemStack stackb) {
		if (stacka == null) {
			return stackb;
		} else if (stackb == null) {
			return stacka;
		} else {
			ItemStack stack = stacka.copy();
			stack.stackSize += stackb.copy().stackSize;
			return stack;
		}
	}

}
