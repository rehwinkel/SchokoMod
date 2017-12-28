package com.deerangle.item;

import com.deerangle.item.bars.ItemSchokoBar;
import com.deerangle.item.bars.ItemSchokoBarColored;
import com.deerangle.item.bars.ItemSchokoBarPotion;
import com.deerangle.item.bars.ItemSchokoBarWeather;
import com.deerangle.main.NoahsChocolate;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.EnumDyeColor;
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
	

//	public static Item schoko_bar_normal;
//	public static Item schoko_bar_dark;
//	public static Item schoko_bar_light;
//	public static Item schoko_bar_cookie;
//	public static Item schoko_bar_nut;
//	public static Item schoko_bar_joghurt;
//	public static Item schoko_bar_smartie;
//	public static Item schoko_bar_full;
//	public static Item schoko_bar_Lite; //remove diabetis
//	public static Item schoko_bar_weather;
//	public static Item schoko_bar_colored;
//	public static Item schoko_bar_potion;
//	public static Item schoko_bar_Cobble; //lose hunger and effect
//	public static Item schoko_bar_Quartz; //lose hunger and effect
//	public static Item schoko_bar_Spider; //place cobweb and effect
//	public static Item schoko_bar_Creeper; //explode
//	public static Item schoko_bar_Ender; //tp player
//	public static Item schoko_bar_Wither; //give item and effect by chance
//	public static Item schoko_bar_Fire; //ignite player
//	public static Item schoko_bar_Fireworks; //firework
//	public static Item schoko_bar_Glass; //damage and sound
//	public static Item schoko_bar_Windows; //sound and chat
//	public static Item schoko_bar_Apple; //chat
//	public static Item schoko_bar_Illuminati; //effects and sound
//	public static Item schoko_bar_Glowstone; //effect and sound
//	public static Item schoko_bar_Redstone; //effect and sound
//	public static Item schoko_bar_Halloween; //sound
//	public static Item schoko_bar_Rainbow; //sound
//	public static Item schoko_bar_Cow; //sound
//	public static Item schoko_bar_Christmas; //give item
//	public static Item schoko_bar_Portal; //tp to nether
//	public static Item schoko_bar_Book; //xp
	
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

	public static Item chocolate_bar;
	
	public static void preInit(){
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
		
		chocolate_bar = new ItemChocolateBar();
		
		MinecraftForge.EVENT_BUS.register(instance);
	}

	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> event){
		IForgeRegistry<Item> registry = event.getRegistry();

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

		registry.register(chocolate_bar);
	}
	
	@SubscribeEvent
	public void registerModels(ModelRegistryEvent event){
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

		for(int i = 0; i < ItemChocolateBar.types.length; i++){
			ModelLoader.setCustomModelResourceLocation(chocolate_bar, i, new ModelResourceLocation(NoahsChocolate.MODID + ":chocolate_bar_" + ItemChocolateBar.types[i], "inventory"));
		}
	}
	
}
