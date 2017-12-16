package com.deerangle.main;

import com.deerangle.items.ModItems;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

public class ModEventHandler {

	@SubscribeEvent
	public void onEntityUpdate(LivingUpdateEvent event){
		if(event.entityLiving instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			//effects
			if(event.entityLiving.isPotionActive(SchokoMod.schokoPotion.id)){
				float amp = player.getActivePotionEffect(SchokoMod.schokoPotion).getAmplifier();
				amp += 1;
				amp /= 1.5f;
				player.cameraPitch += -amp + (float) Math.random() * amp*2;
				player.rotationYaw += -amp + (float) Math.random() * amp*2;
				player.setAIMoveSpeed(10);
				if(Math.random() < 0.015){
					player.heal(1);
				}
			}
			
			if(event.entityLiving.isPotionActive(Potion.jump.id)){
				player.fallDistance = 0;
			}
		}
	}

	@SubscribeEvent
	public void onPlayerChat(ServerChatEvent event){
		if(event.message.contains("0/0") || event.message.contains("0:0")){
			event.player.inventory.addItemStackToInventory(new ItemStack(ModItems.error));
			event.player.addChatMessage(new ChatComponentText("§7An unexpected Error occured!"));
			event.player.addChatMessage(new ChatComponentText("§cCan't divide 0 by 0!"));
			event.setCanceled(true);
		}
	}
	
}
