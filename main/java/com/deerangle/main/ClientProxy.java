package com.deerangle.main;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.deerangle.gui.GuiSchokoMixer;
import com.deerangle.gui.GuiSchokoPress;
import com.deerangle.tile.BlockWeedBushRenderer;
import com.deerangle.tile.ModBlocks;
import com.deerangle.tile.entity.SchokoMixerNEI;
import com.deerangle.tile.entity.SchokoPressNEI;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Loader;
import io.netty.handler.codec.ReplayingDecoder;
import net.minecraft.item.ItemStack;

public class ClientProxy extends ServerProxy{
	
	public static int rendererWeed;
	public static int renderPass;

	public void registerRenderThings(){
		rendererWeed = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new BlockWeedBushRenderer());
	}
	
	public void postInit(){
		if (Loader.isModLoaded("CodeChickenCore") && Loader.isModLoaded("NotEnoughItems")) {
			try {
				Class api = Class.forName("codechicken.nei.api.API");
				Class iOverlayHandler = Class.forName("codechicken.nei.api.IOverlayHandler");
				Class iUsageHandler = Class.forName("codechicken.nei.recipe.IUsageHandler");
				Class iCraftingHandler = Class.forName("codechicken.nei.recipe.ICraftingHandler");
				Class defaultOverlayHandler = Class.forName("codechicken.nei.recipe.DefaultOverlayHandler");
				Method hideItem = api.getMethod("hideItem", ItemStack.class);
				Method registerUsageHandler = api.getMethod("registerUsageHandler", iUsageHandler);
				Method registerRecipeHandler = api.getMethod("registerRecipeHandler", iCraftingHandler);
				Method registerGuiOverlay = api.getMethod("registerGuiOverlay", Class.class, String.class);
				Method registerGuiOverlayHandler = api.getMethod("registerGuiOverlayHandler", Class.class, iOverlayHandler, String.class);
				
				hideItem.invoke(api, new ItemStack(ModBlocks.weedBushInv));
				hideItem.invoke(api, new ItemStack(ModBlocks.present));

				SchokoMixerNEI mixHandler = new SchokoMixerNEI();
				registerUsageHandler.invoke(api, mixHandler);
				registerRecipeHandler.invoke(api, mixHandler);
				registerGuiOverlay.invoke(api, GuiSchokoMixer.class, "schokoMixer");
				registerGuiOverlayHandler.invoke(api, GuiSchokoMixer.class, defaultOverlayHandler.newInstance(), "schokoMixer");

				SchokoPressNEI pressHandler = new SchokoPressNEI();
				registerUsageHandler.invoke(api, pressHandler);
				registerRecipeHandler.invoke(api, pressHandler);
				registerGuiOverlay.invoke(api, GuiSchokoPress.class, "schokoPress");
				registerGuiOverlayHandler.invoke(api, GuiSchokoPress.class, defaultOverlayHandler.newInstance(), "schokoPress");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			}
		}
	}
	
}
