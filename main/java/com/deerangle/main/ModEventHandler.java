package com.deerangle.main;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

public class ModEventHandler {

	@SubscribeEvent
	public void onEntityUpdate(LivingUpdateEvent event){
		if(event.entityLiving.isPotionActive(SchokoMod.schokoPotion.id)){
			event.entityLiving.stepHeight = 2;
		}
	}
	
}
