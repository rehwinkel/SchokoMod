package com.deerangle.main;

import com.deerangle.effects.GuiLSD;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

public class ModRenderHandler {

	@SubscribeEvent
	public void onRenderGui(RenderGameOverlayEvent.Post event) {
		if (event.type == ElementType.ALL) {
			new GuiLSD(Minecraft.getMinecraft(), event.partialTicks);
		}
	}

}
