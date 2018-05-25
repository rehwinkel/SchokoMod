package com.deerangle.item;

import com.deerangle.main.NoahsChocolate;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

	public static final ModItems instance = new ModItems();
	
	public static Item SCHOKO_INGOT;
	public static Item SANTA_HAT;
	public static Item SMARTIES;
	public static Item SCHOKO_DRINK;
	public static Item MORTAR_PESTLE;
	public static Item MUG;
	public static Item COCOA_POWDER;
	public static Item COCOA_BUTTER;
	public static Item WEED_BUD;
	public static Item WEED;
	public static Item THC;
	public static Item ERROR;
	public static Item ENDER_CRUMBS;
	public static Item TRIANGLE;
	public static Item FLAVOR_ENHANCER;
	public static Item GRANOLA_BAR;
	public static Item WRAP_PAPER;
	public static Item WRAP_PAPER_USED;

	public static Item CHOCOLATE_BAR;
	
	public static void preInit(){
		SCHOKO_INGOT = new ItemSchokoIngot();
		SANTA_HAT = new ItemSantaHat();
		SMARTIES = new ItemSmarties();
		SCHOKO_DRINK = new ItemSchokoDrink();
		MORTAR_PESTLE = new ItemMortar();
		MUG = new Item().setUnlocalizedName("mug").setRegistryName("mug").setCreativeTab(NoahsChocolate.tab);
		COCOA_POWDER = new Item().setUnlocalizedName("cocoa_powder").setRegistryName("cocoa_powder").setCreativeTab(NoahsChocolate.tab);
		COCOA_BUTTER = new ItemCocoaButter();
		WEED_BUD = new ItemDesc().setUnlocalizedName("weed_bud").setRegistryName("weed_bud").setCreativeTab(NoahsChocolate.tab);
		WEED = new Item().setUnlocalizedName("weed").setRegistryName("weed").setCreativeTab(NoahsChocolate.tab);
		THC = new Item().setUnlocalizedName("thc").setRegistryName("thc").setCreativeTab(NoahsChocolate.tab);
		ERROR = new ItemDesc().setUnlocalizedName("error").setRegistryName("error").setCreativeTab(NoahsChocolate.tab);
		TRIANGLE = new Item().setUnlocalizedName("triangle").setRegistryName("triangle").setCreativeTab(NoahsChocolate.tab);
		ENDER_CRUMBS = new Item().setUnlocalizedName("ender_crumbs").setRegistryName("ender_crumbs").setCreativeTab(NoahsChocolate.tab);
		FLAVOR_ENHANCER = new Item().setUnlocalizedName("flavor_enhancer").setRegistryName("flavor_enhancer").setCreativeTab(NoahsChocolate.tab);
		GRANOLA_BAR = new ItemFood(8, false).setUnlocalizedName("granola_bar").setRegistryName("granola_bar").setCreativeTab(NoahsChocolate.tab);
		WRAP_PAPER = new Item().setUnlocalizedName("wrap_paper").setRegistryName("wrap_paper").setCreativeTab(NoahsChocolate.tab);
		WRAP_PAPER_USED = new Item().setUnlocalizedName("wrap_paper_used").setRegistryName("wrap_paper_used").setCreativeTab(NoahsChocolate.tab);
		
		CHOCOLATE_BAR = new ItemChocolateBar();
		
		MinecraftForge.EVENT_BUS.register(instance);
	}

	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> event){
		IForgeRegistry<Item> registry = event.getRegistry();

		registry.register(SCHOKO_INGOT);
		registry.register(SANTA_HAT);
		registry.register(SMARTIES);
		registry.register(SCHOKO_DRINK);
		registry.register(MORTAR_PESTLE);
		registry.register(MUG);
		registry.register(COCOA_POWDER);
		registry.register(COCOA_BUTTER);
		registry.register(WEED_BUD);
		registry.register(WEED);
		registry.register(THC);
		registry.register(ERROR);
		registry.register(TRIANGLE);
		registry.register(ENDER_CRUMBS);
		registry.register(FLAVOR_ENHANCER);
		registry.register(GRANOLA_BAR);
		registry.register(WRAP_PAPER);
		registry.register(WRAP_PAPER_USED);

		registry.register(CHOCOLATE_BAR);
	}
	
	@SubscribeEvent
	public void registerModels(ModelRegistryEvent event){
		ModelLoader.setCustomModelResourceLocation(SCHOKO_INGOT, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":schoko_ingot_normal", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SCHOKO_INGOT, 1, new ModelResourceLocation(NoahsChocolate.MODID + ":schoko_ingot_dark", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SCHOKO_INGOT, 2, new ModelResourceLocation(NoahsChocolate.MODID + ":schoko_ingot_light", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SANTA_HAT, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":santa_hat", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SMARTIES, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":smarties", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SCHOKO_DRINK, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":schoko_drink", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SCHOKO_DRINK, 1, new ModelResourceLocation(NoahsChocolate.MODID + ":schoko_drink_hot", "inventory"));
		ModelLoader.setCustomModelResourceLocation(MORTAR_PESTLE, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":mortar_and_pestle", "inventory"));
		ModelLoader.setCustomModelResourceLocation(MUG, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":mug", "inventory"));
		ModelLoader.setCustomModelResourceLocation(COCOA_POWDER, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":cocoa_powder", "inventory"));
		ModelLoader.setCustomModelResourceLocation(COCOA_BUTTER, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":cocoa_butter", "inventory"));
		ModelLoader.setCustomModelResourceLocation(COCOA_BUTTER, 1, new ModelResourceLocation(NoahsChocolate.MODID + ":cocoa_butter_diluted", "inventory"));
		ModelLoader.setCustomModelResourceLocation(WEED_BUD, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":weed_bud", "inventory"));
		ModelLoader.setCustomModelResourceLocation(WEED, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":weed", "inventory"));
		ModelLoader.setCustomModelResourceLocation(THC, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":thc", "inventory"));
		ModelLoader.setCustomModelResourceLocation(ERROR, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":error", "inventory"));
		ModelLoader.setCustomModelResourceLocation(TRIANGLE, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":triangle", "inventory"));
		ModelLoader.setCustomModelResourceLocation(ENDER_CRUMBS, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":ender_crumbs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(FLAVOR_ENHANCER, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":flavor_enhancer", "inventory"));
		ModelLoader.setCustomModelResourceLocation(GRANOLA_BAR, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":granola_bar", "inventory"));
		ModelLoader.setCustomModelResourceLocation(WRAP_PAPER, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":wrap_paper", "inventory"));
		ModelLoader.setCustomModelResourceLocation(WRAP_PAPER_USED, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":wrap_paper_used", "inventory"));

		for(int i = 0; i < ItemChocolateBar.types.length; i++){
			ModelLoader.setCustomModelResourceLocation(CHOCOLATE_BAR, i, new ModelResourceLocation(NoahsChocolate.MODID + ":chocolate_bar_" + ItemChocolateBar.types[i], "inventory"));
		}
	}
	
}
