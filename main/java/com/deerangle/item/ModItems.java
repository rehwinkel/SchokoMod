package com.deerangle.item;

import com.deerangle.item.bars.ItemSchokoBar;
import com.deerangle.main.NoahsChocolate;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
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
	
//	public static Item schoko_bar_Apple;
//	public static Item schoko_bar_Cobble;
//	public static Item schoko_bar_Cow;
//	public static Item schoko_bar_Creeper;
//	public static Item schoko_bar_Christmas;
//	public static Item schoko_bar_Fish;
//	public static Item schoko_bar_Ender;
//	public static Item schoko_bar_Fire;
//	public static Item schoko_bar_Fireworks;
//	public static Item schoko_bar_Glass;
//	public static Item schoko_bar_Gold;
//	public static Item schoko_bar_Halloween;
//	public static Item schoko_bar_Illuminati;
//	public static Item schoko_bar_Lite;
//	public static Item schoko_bar_LSD;
//	public static Item schoko_bar_Portal;
//	public static Item schoko_bar_Quartz;
//	public static Item schoko_bar_Redstone;
//	public static Item schoko_bar_Steve;
//	public static Item schoko_bar_Windows;
//	public static Item schoko_bar_Rainbow;
//	public static Item schoko_bar_Wither;
//	public static Item schoko_bar_Colored;
//	public static Item schoko_bar_Glowstone;
//	public static Item schoko_bar_Book;
//	public static Item schoko_bar_Cobweb;
//	public static Item schoko_bar_Troll;

	public static Item schoko_bar_normal;
	public static Item schoko_bar_dark;
	public static Item schoko_bar_light;
	public static Item schoko_bar_cookie;
	public static Item schoko_bar_nut;
	public static Item schoko_bar_joghurt;
	public static Item schoko_bar_smartie;
	public static Item schoko_bar_full;
	public static Item schoko_bar_bed;
	public static Item schoko_bar_mushroom;
	public static Item schoko_bar_flower;
	public static Item schoko_bar_lilypad;
	
	public static Item schoko_ingot;
	public static Item santa_hat;
	public static Item smarties;
	public static Item schoko_drink;
	public static Item mortar_and_pestle;

	public static Item mug;
	public static Item cocoa_powder;
	public static Item cocoa_butter;
	public static Item cocoa_butter_diluted;
	public static Item weed_bud;
	public static Item weed;
	public static Item thc;
	public static Item error;
	public static Item triangle;
	
	public static void preInit(){
		schoko_bar_normal = new ItemSchokoBar("normal");
		schoko_bar_dark = new ItemSchokoBar("dark");
		schoko_bar_light = new ItemSchokoBar("light");
		schoko_bar_cookie = new ItemSchokoBar("cookie", 6);
		schoko_bar_nut = new ItemSchokoBar("nut", 6);
		schoko_bar_joghurt = new ItemSchokoBar("joghurt", 6);
		schoko_bar_smartie = new ItemSchokoBar("smartie", 6);
		schoko_bar_full = new ItemSchokoBar("full", 6);
		schoko_bar_bed = new ItemSchokoBarWeather(ItemSchokoBarWeather.EnumType.DAY);
		schoko_bar_mushroom = new ItemSchokoBarWeather(ItemSchokoBarWeather.EnumType.NIGHT);
		schoko_bar_flower = new ItemSchokoBarWeather(ItemSchokoBarWeather.EnumType.SUN);
		schoko_bar_lilypad = new ItemSchokoBarWeather(ItemSchokoBarWeather.EnumType.RAIN);
		
		schoko_ingot = new ItemSchokoIngot();
		santa_hat = new ItemSantaHat();
		smarties = new ItemSmarties();
		schoko_drink = new ItemSchokoDrink();
		mortar_and_pestle = new ItemMortar();
		mug = new Item().setUnlocalizedName("mug").setRegistryName("mug").setCreativeTab(NoahsChocolate.tab);
		cocoa_powder = new Item().setUnlocalizedName("cocoa_powder").setRegistryName("cocoa_powder").setCreativeTab(NoahsChocolate.tab);
		cocoa_butter = new Item().setUnlocalizedName("cocoa_butter").setRegistryName("cocoa_butter").setCreativeTab(NoahsChocolate.tab);
		cocoa_butter_diluted = new Item().setUnlocalizedName("cocoa_butter_diluted").setRegistryName("cocoa_butter_diluted").setCreativeTab(NoahsChocolate.tab);
		weed_bud = new ItemDesc().setUnlocalizedName("weed_bud").setRegistryName("weed_bud").setCreativeTab(NoahsChocolate.tab);
		weed = new Item().setUnlocalizedName("weed").setRegistryName("weed").setCreativeTab(NoahsChocolate.tab);
		thc = new Item().setUnlocalizedName("thc").setRegistryName("thc").setCreativeTab(NoahsChocolate.tab);
		error = new Item().setUnlocalizedName("error").setRegistryName("error").setCreativeTab(NoahsChocolate.tab);
		triangle = new Item().setUnlocalizedName("triangle").setRegistryName("triangle").setCreativeTab(NoahsChocolate.tab);
		
		MinecraftForge.EVENT_BUS.register(instance);
	}

	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> event){
		IForgeRegistry<Item> registry = event.getRegistry();
		
		registry.register(schoko_bar_normal);
		registry.register(schoko_bar_dark);
		registry.register(schoko_bar_light);
		registry.register(schoko_bar_cookie);
		registry.register(schoko_bar_nut);
		registry.register(schoko_bar_joghurt);
		registry.register(schoko_bar_smartie);
		registry.register(schoko_bar_full);
		registry.register(schoko_bar_bed);
		registry.register(schoko_bar_mushroom);
		registry.register(schoko_bar_flower);
		registry.register(schoko_bar_lilypad);

		registry.register(schoko_ingot);
		registry.register(santa_hat);
		registry.register(smarties);
		registry.register(schoko_drink);
		registry.register(mortar_and_pestle);
		registry.register(mug);
		registry.register(cocoa_powder);
		registry.register(cocoa_butter);
		registry.register(cocoa_butter_diluted);
		registry.register(weed_bud);
		registry.register(weed);
		registry.register(thc);
		registry.register(error);
		registry.register(triangle);
	}
	
	@SubscribeEvent
	public void registerModels(ModelRegistryEvent event){
		ModelLoader.setCustomModelResourceLocation(schoko_bar_normal, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":schoko_bar_normal", "inventory"));
		ModelLoader.setCustomModelResourceLocation(schoko_bar_dark, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":schoko_bar_dark", "inventory"));
		ModelLoader.setCustomModelResourceLocation(schoko_bar_light, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":schoko_bar_light", "inventory"));
		ModelLoader.setCustomModelResourceLocation(schoko_bar_cookie, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":schoko_bar_cookie", "inventory"));
		ModelLoader.setCustomModelResourceLocation(schoko_bar_nut, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":schoko_bar_nut", "inventory"));
		ModelLoader.setCustomModelResourceLocation(schoko_bar_joghurt, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":schoko_bar_joghurt", "inventory"));
		ModelLoader.setCustomModelResourceLocation(schoko_bar_smartie, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":schoko_bar_smartie", "inventory"));
		ModelLoader.setCustomModelResourceLocation(schoko_bar_full, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":schoko_bar_full", "inventory"));
		ModelLoader.setCustomModelResourceLocation(schoko_bar_bed, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":schoko_bar_bed", "inventory"));
		ModelLoader.setCustomModelResourceLocation(schoko_bar_mushroom, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":schoko_bar_mushroom", "inventory"));
		ModelLoader.setCustomModelResourceLocation(schoko_bar_flower, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":schoko_bar_flower", "inventory"));
		ModelLoader.setCustomModelResourceLocation(schoko_bar_lilypad, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":schoko_bar_lilypad", "inventory"));
		
		ModelLoader.setCustomModelResourceLocation(schoko_ingot, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":schoko_ingot_normal", "inventory"));
		ModelLoader.setCustomModelResourceLocation(schoko_ingot, 1, new ModelResourceLocation(NoahsChocolate.MODID + ":schoko_ingot_dark", "inventory"));
		ModelLoader.setCustomModelResourceLocation(schoko_ingot, 2, new ModelResourceLocation(NoahsChocolate.MODID + ":schoko_ingot_light", "inventory"));
		ModelLoader.setCustomModelResourceLocation(santa_hat, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":santa_hat", "inventory"));
		ModelLoader.setCustomModelResourceLocation(smarties, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":smarties", "inventory"));
		ModelLoader.setCustomModelResourceLocation(schoko_drink, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":schoko_drink", "inventory"));
		ModelLoader.setCustomModelResourceLocation(schoko_drink, 1, new ModelResourceLocation(NoahsChocolate.MODID + ":schoko_drink_hot", "inventory"));
		ModelLoader.setCustomModelResourceLocation(mortar_and_pestle, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":mortar_and_pestle", "inventory"));
		ModelLoader.setCustomModelResourceLocation(mug, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":mug", "inventory"));
		ModelLoader.setCustomModelResourceLocation(cocoa_powder, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":cocoa_powder", "inventory"));
		ModelLoader.setCustomModelResourceLocation(cocoa_butter, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":cocoa_butter", "inventory"));
		ModelLoader.setCustomModelResourceLocation(cocoa_butter_diluted, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":cocoa_butter_diluted", "inventory"));
		ModelLoader.setCustomModelResourceLocation(weed_bud, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":weed_bud", "inventory"));
		ModelLoader.setCustomModelResourceLocation(weed, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":weed", "inventory"));
		ModelLoader.setCustomModelResourceLocation(thc, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":thc", "inventory"));
		ModelLoader.setCustomModelResourceLocation(error, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":error", "inventory"));
		ModelLoader.setCustomModelResourceLocation(triangle, 0, new ModelResourceLocation(NoahsChocolate.MODID + ":triangle", "inventory"));
	}
	
}
