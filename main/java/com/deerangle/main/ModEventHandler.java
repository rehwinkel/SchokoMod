package com.deerangle.main;

import com.deerangle.effect.GuiLSD;
import com.deerangle.effect.ModPotions;
import com.deerangle.item.ModItems;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModEventHandler {

	@SubscribeEvent
	public void onEntityUpdate(LivingUpdateEvent event){
		if(event.getEntityLiving() instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer) event.getEntityLiving();
			//effects
			if(event.getEntityLiving().isPotionActive(ModPotions.schoko)){
				float amp = player.getActivePotionEffect(ModPotions.schoko).getAmplifier();
				amp += 1;
				amp /= 1.5f;
				player.cameraPitch += -amp + (float) Math.random() * amp*2;
				player.rotationYaw += -amp + (float) Math.random() * amp*2;
				player.setAIMoveSpeed(10);
				if(Math.random() < 0.015){
					player.heal(1);
				}
			}
			
			if(event.getEntityLiving().isPotionActive(MobEffects.JUMP_BOOST)){
				player.fallDistance = 0;
			}
		}
	}
	
	@SubscribeEvent
	public void onPlayerChat(ServerChatEvent event){
		if(event.getMessage().contains("0/0") || event.getMessage().contains("0:0")){
			event.getPlayer().inventory.addItemStackToInventory(new ItemStack(ModItems.error));
			event.getPlayer().sendMessage(new TextComponentString("§7An unexpected Error occured!"));
			event.getPlayer().sendMessage(new TextComponentString("§cCan't divide 0 by 0!"));
			event.setCanceled(true);
		}
	}
	
	@SubscribeEvent
	public void onRenderGui(RenderGameOverlayEvent.Post event) {
		if (event.getType() == ElementType.AIR) {
			new GuiLSD(Minecraft.getMinecraft());
		}
	}
	
}
