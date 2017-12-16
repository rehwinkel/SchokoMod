package com.deerangle.main;

import java.util.ArrayList;
import java.util.HashMap;

import com.deerangle.items.ModItems;
import com.deerangle.tile.ModBlocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ModCrafting {

	public static ArrayList<ItemStack[]> pressRecipesItems = new ArrayList<ItemStack[]>();
	public static ArrayList<ItemStack> pressRecipesItem = new ArrayList<ItemStack>();

	public static void load() {
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.mortar), "o/o", " o ", 'o', Blocks.cobblestone, '/', Items.stick);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.cocoaPowder), ModItems.mortar, new ItemStack(Items.dye, 1, 3), new ItemStack(Items.dye, 1, 3), new ItemStack(Items.dye, 1, 3));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.cocoaButter), ModItems.mortar, ModItems.cocoaPowder, ModItems.cocoaPowder, ModItems.cocoaPowder);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.weed), ModItems.mortar, ModItems.weedBud);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.cocoaButterMilk, 2), ModItems.cocoaButter, Items.milk_bucket);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.schokoDrink), ModItems.cocoaPowder, Items.sugar, ModItems.mug, Items.milk_bucket);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.smarties), ModItems.schokoIngot, new ItemStack(Items.dye, 1, 1));
		GameRegistry.addSmelting(new ItemStack(ModItems.schokoDrink), new ItemStack(ModItems.schokoDrink, 1, 1), 0);
		
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.mug, 4), "O O", "O O", "OOO", 'O', Items.clay_ball);
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.santaHat, 1), " R ", "RRR", "WWW", 'R', new ItemStack(Blocks.wool, 1, 14), 'W', new ItemStack(Blocks.wool, 1, 0));
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.triangle), " O ", "OOO", 'O', ModItems.schokoIngot);

		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.schokoBlock, 1, 0), "OOO", "OOO", "OOO", 'O', new ItemStack(ModItems.schokoIngot, 1, 0));
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.schokoBlock, 1, 1), "OOO", "OOO", "OOO", 'O', new ItemStack(ModItems.schokoIngot, 1, 1));
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.schokoBlock, 1, 2), "OOO", "OOO", "OOO", 'O', new ItemStack(ModItems.schokoIngot, 1, 2));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.schokoIngot, 9, 0), new ItemStack(ModBlocks.schokoBlock, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.schokoIngot, 9, 1), new ItemStack(ModBlocks.schokoBlock, 1, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.schokoIngot, 9, 2), new ItemStack(ModBlocks.schokoBlock, 1, 2));

		GameRegistry.addRecipe(new ShapedOreRecipe(ModBlocks.schokoMixer, "OSO", "OCO", "OLO", 'O', "plankWood", 'L', "treeWood", 'S', ModItems.cocoaPowder, 'C', Blocks.crafting_table));
		GameRegistry.addRecipe(new ShapedOreRecipe(ModBlocks.schokoPress, "IPI", "ISI", "CCC", 'I', "ingotIron", 'P', Blocks.piston, 'S', new ItemStack(ModBlocks.schokoBlock, 1, 0), 'C', "cobblestone"));
		System.out.println("GEWG");
		
		//PRESS RECIPES!
		addPressRecipe(0, null, null, new ItemStack(ModItems.schokoBarNormal, 2)); //1
		addPressRecipe(1, null, null, new ItemStack(ModItems.schokoBarBlack, 2)); //2
		addPressRecipe(2, null, null, new ItemStack(ModItems.schokoBarWhite, 2)); //3
		addPressRecipe(0, new ItemStack(Blocks.double_plant, 1, 0), new ItemStack(ModItems.weed), new ItemStack(ModItems.schokoBarFlower, 2)); //4
		addPressRecipe(1, new ItemStack(Blocks.brown_mushroom), new ItemStack(ModItems.weed), new ItemStack(ModItems.schokoBarMushroom, 2)); //5
		for(int i = 0; i < 16; i++){
			addPressRecipe(2, new ItemStack(Items.dye, 1, i), null, new ItemStack(ModItems.schokoBarColored, 2, i)); //21
		}
		addPressRecipe(0, new ItemStack(Items.quartz), null, new ItemStack(ModItems.schokoBarQuartz, 2)); //22
		addPressRecipe(0, new ItemStack(Blocks.cobblestone), null, new ItemStack(ModItems.schokoBarCobble, 2)); //23
		addPressRecipe(2, new ItemStack(Blocks.web), null, new ItemStack(ModItems.schokoBarCobweb, 2)); //24
		addPressRecipe(0, new ItemStack(ModItems.weed), new ItemStack(Items.redstone), new ItemStack(ModItems.schokoBarRedstone, 1)); //25
		addPressRecipe(0, new ItemStack(ModItems.weed), new ItemStack(Items.glowstone_dust), new ItemStack(ModItems.schokoBarGlowstone, 1)); //26
		addPressRecipe(0, new ItemStack(Items.leather), null, new ItemStack(ModItems.schokoBarCow, 2)); //27
		addPressRecipe(0, new ItemStack(Items.ender_pearl), null, new ItemStack(ModItems.schokoBarEnder, 2)); //28
		addPressRecipe(2, new ItemStack(Blocks.glass), null, new ItemStack(ModItems.schokoBarGlass, 2)); //29
		addPressRecipe(1, new ItemStack(Items.gunpowder), new ItemStack(Items.gunpowder), new ItemStack(ModItems.schokoBarCreeper, 2)); //30
		addPressRecipe(1, new ItemStack(Items.fire_charge), new ItemStack(Items.fire_charge), new ItemStack(ModItems.schokoBarFire, 2)); //31
		addPressRecipe(0, new ItemStack(Items.fireworks), null, new ItemStack(ModItems.schokoBarFireworks, 2)); //32
		addPressRecipe(0, new ItemStack(ModItems.schokoIngot), null, new ItemStack(ModItems.schokoBarFull, 2)); //33
		addPressRecipe(0, new ItemStack(Blocks.gold_block), null, new ItemStack(ModItems.schokoBarGold, 2)); //34
		addPressRecipe(0, new ItemStack(ModItems.weed), new ItemStack(ModItems.weed), new ItemStack(ModItems.schokoBarLSD, 2)); //35
		addPressRecipe(0, new ItemStack(ModItems.error), null, new ItemStack(ModItems.schokoBarWindows, 2)); //36
		addPressRecipe(0, new ItemStack(Blocks.waterlily), new ItemStack(ModItems.weed), new ItemStack(ModItems.schokoBarLilypad, 2)); //37
		addPressRecipe(0, new ItemStack(Items.cookie), null, new ItemStack(ModItems.schokoBarCookie, 2)); //38
		addPressRecipe(0, new ItemStack(Blocks.lit_pumpkin), null, new ItemStack(ModItems.schokoBarHalloween, 2)); //39
		addPressRecipe(0, new ItemStack(Items.skull, 1, 3), null, new ItemStack(ModItems.schokoBarSteve, 2)); //40
		addPressRecipe(0, new ItemStack(Items.apple), null, new ItemStack(ModItems.schokoBarApple, 2)); //41
		addPressRecipe(0, new ItemStack(Items.enchanted_book), null, new ItemStack(ModItems.schokoBarBook, 2)); //42
		addPressRecipe(0, new ItemStack(Items.milk_bucket), null, new ItemStack(ModItems.schokoBarJoghurt, 2)); //43
		addPressRecipe(0, new ItemStack(Items.dye, 1, 3), new ItemStack(Items.dye, 1, 3), new ItemStack(ModItems.schokoBarNuts, 2)); //44
		addPressRecipe(0, new ItemStack(ModItems.santaHat), null, new ItemStack(ModItems.schokoBarChristmas, 2)); //45
		addPressRecipe(0, new ItemStack(ModItems.weed), new ItemStack(ModItems.triangle), new ItemStack(ModItems.schokoBarIlluminati, 2)); //46
		addPressRecipe(0, new ItemStack(Items.paper), new ItemStack(Items.paper), new ItemStack(ModItems.schokoBarLite, 2)); //47
		addPressRecipe(0, new ItemStack(Blocks.obsidian), new ItemStack(Blocks.obsidian), new ItemStack(ModItems.schokoBarPortal, 2)); //48
		addPressRecipe(0, new ItemStack(ModItems.schokoBarColored, 1, 1), new ItemStack(ModItems.schokoBarColored, 1, 4), new ItemStack(ModItems.schokoBarRainbow, 4)); //49
		addPressRecipe(0, new ItemStack(ModItems.smarties), null, new ItemStack(ModItems.schokoBarSmartie, 2)); //50
		addPressRecipe(1, new ItemStack(Blocks.soul_sand), null, new ItemStack(ModItems.schokoBarWither, 2)); //51
		addPressRecipe(0, new ItemStack(Items.poisonous_potato), null, new ItemStack(ModItems.schokoBarTroll, 2)); //52
		addPressRecipe(2, new ItemStack(Blocks.wool), null, new ItemStack(ModItems.schokoBarWool, 2)); //53
		addPressRecipe(0, new ItemStack(Items.fish), null, new ItemStack(ModItems.schokoBarFish, 2)); //54
	}

	/**
	 * @param type
	 *            normal, dark, light
	 */
	private static void addPressRecipe(int type, ItemStack add1, ItemStack add2, ItemStack out) {
		if (add1 == null && add2 == null) {
			ItemStack[] array = new ItemStack[1];
			array[0] = new ItemStack(ModItems.schokoIngot, 1, type);
			pressRecipesItems.add(array);
			pressRecipesItem.add(out.copy());
		} else if (add1 != null && add2 != null) {
			ItemStack[] array = new ItemStack[3];
			array[0] = new ItemStack(ModItems.schokoIngot, 1, type);
			array[1] = add1;
			array[2] = add2;
			pressRecipesItems.add(array);
			pressRecipesItem.add(out.copy());
		} else {
			ItemStack[] array = new ItemStack[2];
			array[0] = new ItemStack(ModItems.schokoIngot, 1, type);
			ItemStack use = add1 != null ? add1.copy() : null;
			if (use == null) {
				use = add2.copy();
			}
			array[1] = use;
			pressRecipesItems.add(array);
			pressRecipesItem.add(out.copy());
		}
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
