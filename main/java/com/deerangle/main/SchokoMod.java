package com.deerangle.main;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.deerangle.effects.LSDPotion;
import com.deerangle.effects.SchokoPotion;
import com.deerangle.gui.GuiSchokoMixer;
import com.deerangle.gui.GuiSchokoPress;
import com.deerangle.gui.ModGuiHandler;
import com.deerangle.items.ModItems;
import com.deerangle.tile.ModBlocks;
import com.deerangle.tile.entity.SchokoMixerNEI;
import com.deerangle.tile.entity.SchokoPressNEI;
import com.deerangle.tile.entity.TileEntitySchokoMixer;
import com.deerangle.tile.entity.TileEntitySchokoPress;
import com.deerangle.world.OreGenerator;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Optional.Interface;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = SchokoMod.MODID, version = SchokoMod.VERSION)
public class SchokoMod {
	public static final String NAME = "Noah's Chocolate!";
	public static final String MODID = "noahschocolate";
	public static final String VERSION = "1.0.141";

	public static CreativeTabs bars = new CreativeTabs("schoko.bars") {
		@Override
		public Item getTabIconItem() {
			return ModItems.schokoBarNormal;
		}
	};

	public static CreativeTabs rest = new CreativeTabs("schoko") {
		@Override
		public Item getTabIconItem() {
			return ModItems.schokoIngot;
		}
	};

	public static Potion schokoPotion;
	public static Potion lsdPotion;

	@SidedProxy(clientSide = "com.deerangle.main.ClientProxy", serverSide = "com.deerangle.main.ServerProxy")
	public static ServerProxy proxy;

	@Instance
	public static SchokoMod instance;

	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		ModItems.load();
		ModBlocks.load();
		ModCrafting.load();
		proxy.registerRenderThings();

		loadPotions();

		MinecraftForge.EVENT_BUS.register(new ModEventHandler());
		MinecraftForge.EVENT_BUS.register(new ModRenderHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new ModGuiHandler());

		GameRegistry.registerTileEntity(TileEntitySchokoMixer.class, "schokoMixer");
		GameRegistry.registerTileEntity(TileEntitySchokoPress.class, "schokoPress");
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
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		schokoPotion = (new SchokoPotion(32)).setIconIndex(0, 0);
		lsdPotion = (new LSDPotion(33)).setIconIndex(0, 0);
		GameRegistry.registerWorldGenerator(new OreGenerator(), 0);
	}
	
	@EventHandler
	public void postinit(FMLPostInitializationEvent event) {
		proxy.postInit();
	}
}
