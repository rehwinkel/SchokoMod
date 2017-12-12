package com.deerangle.main;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import com.deerangle.effects.LSDPotion;
import com.deerangle.effects.SchokoPotion;
import com.deerangle.items.ModItems;
import com.deerangle.tile.ModBlocks;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = SchokoMod.MODID, version = SchokoMod.VERSION)
public class SchokoMod {
	public static final String NAME = "Schoko Mod";
	public static final String MODID = "schokomod";
	public static final String VERSION = "1.0";

	public static CreativeTabs bars = new CreativeTabs("schoko.bars") {
		@Override
		public Item getTabIconItem() {
			return ModItems.schokoBarNormal;
		}
	};
	
	public static CreativeTabs rest = new CreativeTabs("schoko") {
		@Override
		public Item getTabIconItem() {
			return Item.getItemFromBlock(ModBlocks.present);
		}
	};

	public static Potion schokoPotion;
	public static Potion lsdPotion;

	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		ModItems.load();
		ModBlocks.load();
		ModCrafting.load();

		loadPotions();
	}

	private void loadPotions() {
		Potion[] potionTypes = null;

		for (Field f : Potion.class.getDeclaredFields()) {
			f.setAccessible(true);
			try {
				if (f.getName().equals("potionTypes") || f.getName().equals("field_76425_a")) {
					Field modfield = Field.class.getDeclaredField("modifiers");
					modfield.setAccessible(true);
					modfield.setInt(f, f.getModifiers() & ~Modifier.FINAL);

					potionTypes = (Potion[]) f.get(null);
					final Potion[] newPotionTypes = new Potion[256];
					System.arraycopy(potionTypes, 0, newPotionTypes, 0, potionTypes.length);
					f.set(null, newPotionTypes);
				}
			} catch (Exception e) {
				System.err.println("Severe error, please report this to the mod author:");
				System.err.println(e);
			}
		}

		MinecraftForge.EVENT_BUS.register(new ModEventHandler());
		MinecraftForge.EVENT_BUS.register(new ModRenderHandler());
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		schokoPotion = (new SchokoPotion(32)).setIconIndex(0, 0);
		lsdPotion = (new LSDPotion(33)).setIconIndex(0, 0);
	}
}
