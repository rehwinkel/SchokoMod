package com.deerangle.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ModItems {

	public static Item schokoBarApple;
	public static Item schokoBarBlack;
	public static Item schokoBarCobble;
	public static Item schokoBarCookie;
	public static Item schokoBarCow;
	public static Item schokoBarCreeper;
	public static Item schokoBarCristmas;
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
	public static Item schokoBarWood;
	public static Item schokoBarYouTube;
	
	public static void load(){
		initialize();
		register();
	}

	private static void initialize() {
		//DONE:
		schokoBarCow = new ItemSchokoBarCow();
		schokoBarFull = new ItemSchokoBar("full", 6, false, 2);
		schokoBarEnder = new ItemSchokoBarEnder();
		schokoBarNormal = new ItemSchokoBar("normal");
		schokoBarBlack = new ItemSchokoBar("black");
		schokoBarWhite = new ItemSchokoBar("white");
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
		//TODO: 
		schokoBarApple = new ItemSchokoBar("apple");
		schokoBarCobble = new ItemSchokoBar("cobble");
		schokoBarCreeper = new ItemSchokoBar("creeper");
		schokoBarCristmas = new ItemSchokoBar("cristmas");
		schokoBarDoor = new ItemSchokoBar("door");
		schokoBarDrawing = new ItemSchokoBar("drawing");
		schokoBarFlower = new ItemSchokoBar("flower");
		schokoBarGlass = new ItemSchokoBar("glass");
		schokoBarHalloween = new ItemSchokoBar("halloween");
		schokoBarIlluminati = new ItemSchokoBar("illuminati");
		schokoBarPortal = new ItemSchokoBar("portal");
		schokoBarQuartz = new ItemSchokoBar("quartz");
		schokoBarRedstone = new ItemSchokoBar("redstone");
		schokoBarSlot = new ItemSchokoBar("slot");
		schokoBarSteve = new ItemSchokoBar("steve");
		schokoBarWood = new ItemSchokoBar("wood");
		schokoBarYouTube = new ItemSchokoBar("youTube");
	}

	private static void register() {
		GameRegistry.registerItem(schokoBarApple, "schokoBarApple");
		GameRegistry.registerItem(schokoBarBlack, "schokoBarBlack");
		GameRegistry.registerItem(schokoBarCobble, "schokoBarCobble");
		GameRegistry.registerItem(schokoBarCookie, "schokoBarCookie");
		GameRegistry.registerItem(schokoBarCow, "schokoBarCow");
		GameRegistry.registerItem(schokoBarCreeper, "schokoBarCreeper");
		GameRegistry.registerItem(schokoBarCristmas, "schokoBarCristmas");
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
		GameRegistry.registerItem(schokoBarWood, "schokoBarWood");
		GameRegistry.registerItem(schokoBarYouTube, "schokoBarYouTube");
	}
	
}
