package com.deerangle.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ModItems {

	public static Item schokoBarApple;
	public static Item schokoBarBlack;
	public static Item schokoBarCobble;
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
	public static Item schokoBarRubiks;
	public static Item schokoBarSlot;
	public static Item schokoBarSmartie;
	public static Item schokoBarSteve;
	public static Item schokoBarWhite;
	public static Item schokoBarWood;
	public static Item schokoBarYouTube;
	
	public static void load(){
		initialize();
		register();
	}

	private static void initialize() {
		schokoBarApple = new ItemSchokoBar("apple");
		schokoBarBlack = new ItemSchokoBar("black");
		schokoBarCobble = new ItemSchokoBar("cobble");
		schokoBarCow = new ItemSchokoBar("cow");
		schokoBarCreeper = new ItemSchokoBar("creeper");
		schokoBarCristmas = new ItemSchokoBar("cristmas");
		schokoBarDoor = new ItemSchokoBar("door");
		schokoBarDrawing = new ItemSchokoBar("drawing");
		schokoBarEnder = new ItemSchokoBar("ender");
		schokoBarFire = new ItemSchokoBar("fire");
		schokoBarFireworks = new ItemSchokoBar("fireworks");
		schokoBarFlower = new ItemSchokoBar("flower");
		schokoBarFull = new ItemSchokoBar("full");
		schokoBarGlass = new ItemSchokoBar("glass");
		schokoBarGold = new ItemSchokoBar("gold");
		schokoBarHalloween = new ItemSchokoBar("halloween");
		schokoBarIlluminati = new ItemSchokoBar("illuminati");
		schokoBarJoghurt = new ItemSchokoBar("joghurt");
		schokoBarLite = new ItemSchokoBar("lite");
		schokoBarLSD = new ItemSchokoBar("lSD");
		schokoBarNormal = new ItemSchokoBar("normal");
		schokoBarNuts = new ItemSchokoBar("nuts");
		schokoBarPortal = new ItemSchokoBar("portal");
		schokoBarQuartz = new ItemSchokoBar("quartz");
		schokoBarRedstone = new ItemSchokoBar("redstone");
		schokoBarRubiks = new ItemSchokoBar("rubiks");
		schokoBarSlot = new ItemSchokoBar("slot");
		schokoBarSmartie = new ItemSchokoBar("smartie");
		schokoBarSteve = new ItemSchokoBar("steve");
		schokoBarWhite = new ItemSchokoBar("white");
		schokoBarWood = new ItemSchokoBar("wood");
		schokoBarYouTube = new ItemSchokoBar("youTube");
	}

	private static void register() {
		GameRegistry.registerItem(schokoBarApple, "schokoBarApple");
		GameRegistry.registerItem(schokoBarBlack, "schokoBarBlack");
		GameRegistry.registerItem(schokoBarCobble, "schokoBarCobble");
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
		GameRegistry.registerItem(schokoBarRubiks, "schokoBarRubiks");
		GameRegistry.registerItem(schokoBarSlot, "schokoBarSlot");
		GameRegistry.registerItem(schokoBarSmartie, "schokoBarSmartie");
		GameRegistry.registerItem(schokoBarSteve, "schokoBarSteve");
		GameRegistry.registerItem(schokoBarWhite, "schokoBarWhite");
		GameRegistry.registerItem(schokoBarWood, "schokoBarWood");
		GameRegistry.registerItem(schokoBarYouTube, "schokoBarYouTube");
	}
	
}
