package com.deerangle.tile;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class ModBlocks {

	public static Block present;
	public static Block schokoBlock;

	public static void load() {
		initialize();
		register();
	}

	private static void initialize() {
		present = new BlockPresent();
		schokoBlock = new BlockSchoko();
	}

	private static void register() {
		GameRegistry.registerBlock(present, "present");
		GameRegistry.registerBlock(schokoBlock, ItemBlockSchoko.class, "schokoBlock");
	}

}
