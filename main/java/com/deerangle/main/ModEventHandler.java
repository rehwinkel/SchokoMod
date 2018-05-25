package com.deerangle.main;

import com.deerangle.effect.GuiLSD;
import com.deerangle.effect.ModPotions;
import com.deerangle.item.ItemChocolateBar;
import com.deerangle.item.ItemCocoaButter;
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
	public void onEntityUpdate(LivingUpdateEvent event) {
		if (event.getEntityLiving() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntityLiving();
			if (event.getEntityLiving().isPotionActive(ModPotions.schoko)) {
				float amp = player.getActivePotionEffect(ModPotions.schoko).getAmplifier();
				amp += 1;
				amp /= 3f;
				player.cameraPitch += -amp + (float) Math.random() * amp * 2;
				player.rotationYaw += -amp + (float) Math.random() * amp * 2;
				if (Math.random() < 0.015) {
					player.heal(1);
				}
			}

			if (event.getEntityLiving().isPotionActive(MobEffects.JUMP_BOOST)) {
				player.fallDistance = 0;
			}
			
			String thisUid = event.getEntityLiving().getUniqueID().toString();
			if(ItemChocolateBar.flyingPlayers.contains(thisUid)) {
				if(event.getEntityLiving().posY > 128) {
					event.getEntityLiving().removeActivePotionEffect(MobEffects.LEVITATION);
					ItemChocolateBar.flyingPlayers.remove(thisUid);
				}
			}
		}
	}

	@SubscribeEvent
	public void onRenderGui(RenderGameOverlayEvent.Post event) {
		if (event.getType() == ElementType.AIR) {
			new GuiLSD(Minecraft.getMinecraft());
		}
	}

}
