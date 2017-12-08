package com.deerangle.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ModItems {
	
	public static Item schokoBarNormal;
	
	public static void load(){
		initialize();
		register();
	}

	private static void initialize() {
		schokoBarNormal = new ItemSchokoBar("normal");
	}

	private static void register() {
		GameRegistry.registerItem(schokoBarNormal, "schokoBarNormal");
	}
	
}
