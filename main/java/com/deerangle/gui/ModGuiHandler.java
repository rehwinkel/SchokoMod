package com.deerangle.gui;

import com.deerangle.block.entity.TileEntityDistiller;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ModGuiHandler implements IGuiHandler {
	
	public static final int distiller_gui_id = 0;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID){
		case distiller_gui_id: 
			return new ContainerDistiller(player.inventory, (TileEntityDistiller) world.getTileEntity(new BlockPos(x, y, z)));
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID){
		case distiller_gui_id: 
			return new GuiDistiller(player.inventory, (TileEntityDistiller) world.getTileEntity(new BlockPos(x, y, z)));
		}
		return null;
	}

}
