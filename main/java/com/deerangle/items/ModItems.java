package com.deerangle.items;

import com.deerangle.items.bars.ItemSchokoBarApple;
import com.deerangle.items.bars.ItemSchokoBarBook;
import com.deerangle.items.bars.ItemSchokoBarChristmas;
import com.deerangle.items.bars.ItemSchokoBarCobweb;
import com.deerangle.items.bars.ItemSchokoBarColored;
import com.deerangle.items.bars.ItemSchokoBarCow;
import com.deerangle.items.bars.ItemSchokoBarCreeper;
import com.deerangle.items.bars.ItemSchokoBarEnder;
import com.deerangle.items.bars.ItemSchokoBarFire;
import com.deerangle.items.bars.ItemSchokoBarFireworks;
import com.deerangle.items.bars.ItemSchokoBarFlower;
import com.deerangle.items.bars.ItemSchokoBarGlass;
import com.deerangle.items.bars.ItemSchokoBarGlowstone;
import com.deerangle.items.bars.ItemSchokoBarGold;
import com.deerangle.items.bars.ItemSchokoBarHalloween;
import com.deerangle.items.bars.ItemSchokoBarIlluminati;
import com.deerangle.items.bars.ItemSchokoBarLSD;
import com.deerangle.items.bars.ItemSchokoBarLilypad;
import com.deerangle.items.bars.ItemSchokoBarLite;
import com.deerangle.items.bars.ItemSchokoBarMushroom;
import com.deerangle.items.bars.ItemSchokoBarPortal;
import com.deerangle.items.bars.ItemSchokoBarRainbow;
import com.deerangle.items.bars.ItemSchokoBarRedstone;
import com.deerangle.items.bars.ItemSchokoBarSteve;
import com.deerangle.items.bars.ItemSchokoBarStone;
import com.deerangle.items.bars.ItemSchokoBarWindows;
import com.deerangle.main.SchokoMod;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGlass;
import net.minecraft.item.Item;

public class ModItems {

	public static Item schokoBarApple;
	public static Item schokoBarBlack;
	public static Item schokoBarCobble;
	public static Item schokoBarCookie;
	public static Item schokoBarCow;
	public static Item schokoBarCreeper;
	public static Item schokoBarChristmas;
	public static Item schokoBarDoor;
	public static Item schokoBarDrawing;
	public static Item schokoBarEnder;
	public static Item schokoBarFire;
	public static Item schokoBarFireworks;
	public static Item schokoBarFlower;
	public static Item schokoBarFull;
	public static Item schokoBarGlass;
	public static Item schokoBarGold;
	public static Item schokoBarHalloween;
	public static Item schokoBarIlluminati;
	public static Item schokoBarJoghurt;
	public static Item schokoBarLite;
	public static Item schokoBarLSD;
	public static Item schokoBarNormal;
	public static Item schokoBarNuts;
	public static Item schokoBarPortal;
	public static Item schokoBarQuartz;
	public static Item schokoBarRedstone;
	public static Item schokoBarSlot;
	public static Item schokoBarSmartie;
	public static Item schokoBarSteve;
	public static Item schokoBarWindows;
	public static Item schokoBarWhite;
	public static Item schokoBarRainbow;
	public static Item schokoBarYouTube;
	public static Item schokoBarColored;
	public static Item schokoBarMushroom;
	public static Item schokoBarLilypad;
	public static Item schokoBarGlowstone;
	public static Item schokoBarBook;
	public static Item schokoBarCobweb;

	public static Item schokoIngot;
	public static Item mortar;
	public static Item cocoaPowder;
	public static Item cocoaButter;
	public static Item schokoDrink;
	public static Item mug;
	public static Item weedBud;

	public static void load() {
		initialize();
		register();
	}

	private static void initialize() {
		schokoBarCow = new ItemSchokoBarCow();
		schokoBarFull = new ItemSchokoBar("full", 6, false, 2);
		schokoBarEnder = new ItemSchokoBarEnder();
		schokoBarNormal = new ItemSchokoBar("normal");
		schokoBarBlack = new ItemSchokoBar("black", 5);
		schokoBarWhite = new ItemSchokoBar("white", 3);
		schokoBarCookie = new ItemSchokoBar("cookie", 5);
		schokoBarJoghurt = new ItemSchokoBar("joghurt", 5);
		schokoBarSmartie = new ItemSchokoBar("smartie", 6);
		schokoBarFireworks = new ItemSchokoBarFireworks();
		schokoBarGold = new ItemSchokoBarGold();
		schokoBarFire = new ItemSchokoBarFire();
		schokoBarLite = new ItemSchokoBarLite();
		schokoBarNuts = new ItemSchokoBar("nuts", 5);
		schokoBarLSD = new ItemSchokoBarLSD();
		schokoBarWindows = new ItemSchokoBarWindows();
		schokoBarCobble = new ItemSchokoBarStone("cobble");
		schokoBarQuartz = new ItemSchokoBarStone("quartz");
		schokoBarCreeper = new ItemSchokoBarCreeper();
		schokoBarHalloween = new ItemSchokoBarHalloween();
		schokoBarRedstone = new ItemSchokoBarRedstone();
		schokoBarFlower = new ItemSchokoBarFlower();
		schokoBarIlluminati = new ItemSchokoBarIlluminati();
		schokoBarPortal = new ItemSchokoBarPortal();
		schokoBarGlass = new ItemSchokoBarGlass();
		schokoBarSteve = new ItemSchokoBarSteve();
		schokoBarChristmas = new ItemSchokoBarChristmas();
		schokoBarColored = new ItemSchokoBarColored();
		schokoBarMushroom = new ItemSchokoBarMushroom();
		schokoBarLilypad = new ItemSchokoBarLilypad();
		schokoBarBook = new ItemSchokoBarBook();
		schokoBarGlowstone = new ItemSchokoBarGlowstone();
		schokoBarCobweb = new ItemSchokoBarCobweb();
		schokoBarRainbow = new ItemSchokoBarRainbow();
		schokoBarApple = new ItemSchokoBarApple();
		// TODO:
		schokoBarDoor = new ItemSchokoBar("door");
		schokoBarDrawing = new ItemSchokoBar("drawing");
		schokoBarSlot = new ItemSchokoBar("slot");
		schokoBarYouTube = new ItemSchokoBar("youTube");

		schokoIngot = new ItemSchokoIngot();
		mortar = new ItemMortar();
		cocoaPowder = new Item().setUnlocalizedName("cocoaPowder").setTextureName(SchokoMod.MODID + ":cocoaPowder").setCreativeTab(SchokoMod.rest);
		cocoaButter = new Item().setUnlocalizedName("cocoaButter").setTextureName(SchokoMod.MODID + ":cocoaButter").setCreativeTab(SchokoMod.rest);
		mug = new Item().setUnlocalizedName("mug").setTextureName(SchokoMod.MODID + ":mug").setCreativeTab(SchokoMod.rest);
		schokoDrink = new ItemSchokoDrink();
		weedBud = new Item().setUnlocalizedName("weedBud").setTextureName(SchokoMod.MODID + ":weedBud").setCreativeTab(SchokoMod.rest);
	}

	private static void register() {
		GameRegistry.registerItem(schokoBarApple, "schokoBarApple");
		GameRegistry.registerItem(schokoBarBlack, "schokoBarBlack");
		GameRegistry.registerItem(schokoBarCobble, "schokoBarCobble");
		GameRegistry.registerItem(schokoBarCookie, "schokoBarCookie");
		GameRegistry.registerItem(schokoBarCow, "schokoBarCow");
		GameRegistry.registerItem(schokoBarCreeper, "schokoBarCreeper");
		GameRegistry.registerItem(schokoBarChristmas, "schokoBarChristmas");
		GameRegistry.registerItem(schokoBarDoor, "schokoBarDoor");
		GameRegistry.registerItem(schokoBarDrawing, "schokoBarDrawing");
		GameRegistry.registerItem(schokoBarEnder, "schokoBarEnder");
		GameRegistry.registerItem(schokoBarFire, "schokoBarFire");
		GameRegistry.registerItem(schokoBarFireworks, "schokoBarFireworks");
		GameRegistry.registerItem(schokoBarFlower, "schokoBarFlower");
		GameRegistry.registerItem(schokoBarFull, "schokoBarFull");
		GameRegistry.registerItem(schokoBarGlass, "schokoBarGlass");
		GameRegistry.registerItem(schokoBarGold, "schokoBarGold");
		GameRegistry.registerItem(schokoBarHalloween, "schokoBarHalloween");
		GameRegistry.registerItem(schokoBarIlluminati, "schokoBarIlluminati");
		GameRegistry.registerItem(schokoBarJoghurt, "schokoBarJoghurt");
		GameRegistry.registerItem(schokoBarLite, "schokoBarLite");
		GameRegistry.registerItem(schokoBarLSD, "schokoBarLSD");
		GameRegistry.registerItem(schokoBarNormal, "schokoBarNormal");
		GameRegistry.registerItem(schokoBarNuts, "schokoBarNuts");
		GameRegistry.registerItem(schokoBarPortal, "schokoBarPortal");
		GameRegistry.registerItem(schokoBarQuartz, "schokoBarQuartz");
		GameRegistry.registerItem(schokoBarRedstone, "schokoBarRedstone");
		GameRegistry.registerItem(schokoBarSlot, "schokoBarSlot");
		GameRegistry.registerItem(schokoBarSmartie, "schokoBarSmartie");
		GameRegistry.registerItem(schokoBarSteve, "schokoBarSteve");
		GameRegistry.registerItem(schokoBarWhite, "schokoBarWhite");
		GameRegistry.registerItem(schokoBarWindows, "schokoBarWindows");
		GameRegistry.registerItem(schokoBarRainbow, "schokoBarRainbow");
		GameRegistry.registerItem(schokoBarYouTube, "schokoBarYouTube");
		GameRegistry.registerItem(schokoBarColored, "schokoBarColored");
		GameRegistry.registerItem(schokoBarMushroom, "schokoBarMushroom");
		GameRegistry.registerItem(schokoBarLilypad, "schokoBarLilypad");
		GameRegistry.registerItem(schokoBarGlowstone, "schokoBarGlowstone");
		GameRegistry.registerItem(schokoBarBook, "schokoBarBook");
		GameRegistry.registerItem(schokoBarCobweb, "schokoBarCobweb");

		GameRegistry.registerItem(schokoIngot, "schokoIngot");
		GameRegistry.registerItem(mortar, "mortar");
		GameRegistry.registerItem(cocoaPowder, "cocoaPowder");
		GameRegistry.registerItem(cocoaButter, "cocoaButter");
		GameRegistry.registerItem(schokoDrink, "schokoDrink");
		GameRegistry.registerItem(mug, "mug");
		GameRegistry.registerItem(weedBud, "weedBud");
	}

}
