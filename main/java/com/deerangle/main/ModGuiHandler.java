package com.deerangle.main;

import com.deerangle.tile.TileEntitySchokoMixer;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ModGuiHandler implements IGuiHandler {

	public static final int schokoMixerGui = 0;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID){
		case schokoMixerGui:
			return new ContainerSchokoMixer(player.inventory, (TileEntitySchokoMixer) world.getTileEntity(x, y, z));
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID){
		case schokoMixerGui:
			return new GuiSchokoMixer(player.inventory, (TileEntitySchokoMixer) world.getTileEntity(x, y, z));
		}
		return null;
	}

}
