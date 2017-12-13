package com.deerangle.main;

import cpw.mods.fml.client.registry.RenderingRegistry;
import io.netty.handler.codec.ReplayingDecoder;

public class ClientProxy extends ServerProxy{
	
	public static int rendererWeed;
	public static int renderPass;

	public void registerRenderThings(){
		rendererWeed = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new BlockWeedBushRenderer());
	}
	
}
