package com.deerangle.effect;

import com.deerangle.block.ModBlocks;

import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModPotions {
	
	public static final ModPotions instance = new ModPotions();

	public static Potion lsd;
	public static Potion schoko;

	public static void preInit() {
		lsd = new PotionLSD();
		schoko = new PotionSchoko();

		MinecraftForge.EVENT_BUS.register(instance);
	}
	
	@SubscribeEvent
	public void registerPotions(RegistryEvent.Register<Potion> event) {
		event.getRegistry().register(lsd);
		event.getRegistry().register(schoko);
	}

}
