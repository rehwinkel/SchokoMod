package com.deerangle.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ModItems {

	public static Item schokoBarBlack;
	public static Item schokoBarApple;
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
		schokoBarNormal = new ItemSchokoBar("normal");
	}

	private static void register() {
		GameRegistry.registerItem(schokoBarNormal, "schokoBarNormal");
	}
	
}
