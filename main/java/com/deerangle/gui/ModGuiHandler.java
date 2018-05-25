package com.deerangle.gui;

import com.deerangle.block.entity.TileEntityDistiller;
import com.deerangle.block.entity.TileEntityMixer;
import com.deerangle.block.entity.TileEntityPacker;
import com.deerangle.gui.container.ContainerDistiller;
import com.deerangle.gui.container.ContainerMixer;
import com.deerangle.gui.container.ContainerPacker;
import com.deerangle.gui.gui.GuiDistiller;
import com.deerangle.gui.gui.GuiMixer;
import com.deerangle.gui.gui.GuiPacker;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ModGuiHandler implements IGuiHandler {
	
	public static final int distiller_gui_id = 0;
	public static final int mixer_gui_id = 1;
	public static final int packer_gui_id = 2;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID){
		case distiller_gui_id: 
			return new ContainerDistiller(player.inventory, (TileEntityDistiller) world.getTileEntity(new BlockPos(x, y, z)));
		case mixer_gui_id: 
			return new ContainerMixer(player.inventory, (TileEntityMixer) world.getTileEntity(new BlockPos(x, y, z)));
		case packer_gui_id: 
			return new ContainerPacker(player.inventory, (TileEntityPacker) world.getTileEntity(new BlockPos(x, y, z)));
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID){
		case distiller_gui_id: 
			return new GuiDistiller(player.inventory, (TileEntityDistiller) world.getTileEntity(new BlockPos(x, y, z)));
		case mixer_gui_id: 
			return new GuiMixer(player.inventory, (TileEntityMixer) world.getTileEntity(new BlockPos(x, y, z)));
		case packer_gui_id: 
			return new GuiPacker(player.inventory, (TileEntityPacker) world.getTileEntity(new BlockPos(x, y, z)));
		}
		return null;
	}

}
