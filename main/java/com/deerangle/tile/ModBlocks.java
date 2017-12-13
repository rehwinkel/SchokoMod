package com.deerangle.tile;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class ModBlocks {

	public static Block present;
	public static Block schokoBlock;
	public static Block weedBush;
	public static Block weedBushInv;

	public static void load() {
		initialize();
		register();
	}

	private static void initialize() {
		present = new BlockPresent();
		schokoBlock = new BlockSchoko();
		weedBush = new BlockWeedBush();
		weedBushInv = new BlockWeedBushInv();
	}

	private static void register() {
		GameRegistry.registerBlock(present, "present");
		GameRegistry.registerBlock(weedBush, "weedBush");
		GameRegistry.registerBlock(weedBushInv, "weedBushInv");
		GameRegistry.registerBlock(schokoBlock, ItemBlockSchoko.class, "schokoBlock");
	}

}
