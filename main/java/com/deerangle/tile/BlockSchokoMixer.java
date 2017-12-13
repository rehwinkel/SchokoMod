package com.deerangle.tile;

import com.deerangle.gui.ModGuiHandler;
import com.deerangle.main.SchokoMod;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSchokoMixer extends BlockContainer {

	private IIcon[] icons = new IIcon[3];

	protected BlockSchokoMixer() {
		super(Material.wood);
		this.setBlockName("schokoMixer");
		this.setBlockTextureName(SchokoMod.MODID + ":schokoMixer");
		this.setCreativeTab(SchokoMod.rest);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntitySchokoMixer();
	}

	@Override
	public void registerBlockIcons(IIconRegister register) {
		icons[0] = register.registerIcon(this.textureName);
		icons[2] = register.registerIcon(this.textureName + "_top");
		icons[1] = register.registerIcon(this.textureName + "_bot");
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		return side > 1 ? icons[0] : side == 0 ? icons[1] : icons[2];
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer p, int s, float fx, float fy, float fz) {
		if(!world.isRemote){
			p.openGui(SchokoMod.instance, ModGuiHandler.schokoMixerGui, world, x, y, z);
		}
		return true;
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int s) {
		TileEntitySchokoMixer mixer = (TileEntitySchokoMixer) world.getTileEntity(x, y, z);
		for(int i = 0; i < mixer.slots.length; i++){
			ItemStack item = mixer.slots[i];
			if(item != null){
				world.spawnEntityInWorld(new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, item));
			}
		}
		super.breakBlock(world, x, y, z, block, s);
	}

}
