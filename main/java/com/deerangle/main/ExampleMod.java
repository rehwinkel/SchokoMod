package com.deerangle.main;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

import com.deerangle.items.ModItems;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod {
	public static final String NAME = "Schoko Mod";
	public static final String MODID = "schokomod";
	public static final String VERSION = "1.0";

	public static CreativeTabs tab = new CreativeTabs("schoko") {
		@Override
		public Item getTabIconItem() {
			return ModItems.schokoBarNormal;
		}
	};

	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		ModItems.load();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		
	}
}
