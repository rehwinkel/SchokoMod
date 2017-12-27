package com.deerangle.main;

import com.deerangle.block.ModBlocks; 
import com.deerangle.effect.ModPotions;
import com.deerangle.gui.ModGuiHandler;
import com.deerangle.item.ModItems;
import com.deerangle.world.ModWorldGen;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.launchwrapper.injector.IndevVanillaTweakInjector;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = NoahsChocolate.MODID, version = NoahsChocolate.VERSION, name = NoahsChocolate.NAME)
public class NoahsChocolate {
	public static final String NAME = "Noah's Chocolate!";
	public static final String MODID = "noahschocolate"; 
	public static final String VERSION = "1.1.100";

	@Instance(MODID)
	public static NoahsChocolate INSTANCE = new NoahsChocolate();
	
	//@SidedProxy(clientSide = "com.deerangle.main.ClientProxy", serverSide = "com.deerangle.main.CommonProxy")
	//public static CommonProxy proxy;

	public static CreativeTabs bars = new CreativeTabs("schoko_bars") {
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(ModItems.schoko_bar_normal);
		}
	};

	public static CreativeTabs tab = new CreativeTabs("schoko") {
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(ModItems.schoko_ingot);
		}
	};
	
	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		ModItems.preInit(); 
		ModBlocks.preInit();
		ModPotions.preInit();
		ModSmelting.preInit();

		MinecraftForge.EVENT_BUS.register(new ModEventHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(INSTANCE, new ModGuiHandler());
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		GameRegistry.registerWorldGenerator(new ModWorldGen(), 0);
	}

	@EventHandler
	public void postinit(FMLPostInitializationEvent event) {
		
	}
}