package com.deerangle.tile;

import com.deerangle.main.SchokoMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPresent extends Block {

	private IIcon[] icons = new IIcon[3];

	protected BlockPresent() {
		super(Material.cloth);
		this.setBlockName("present");
		this.setBlockTextureName(SchokoMod.MODID + ":present");
		this.setHardness(2F);
		this.setCreativeTab(SchokoMod.tab);
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int meta) {
		ItemStack stack = new ItemStack(Items.coal, 3);
		world.spawnEntityInWorld(new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, stack));
		super.onBlockDestroyedByPlayer(world, x, y, z, meta);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister registerer) {
		icons[0] = registerer.registerIcon(this.textureName + "_top");
		icons[1] = registerer.registerIcon(this.textureName + "_bot");
		icons[2] = registerer.registerIcon(this.textureName);
	}
	
	@Override
	public IIcon getIcon(int side, int meta) {
		if(side == 0){
			return icons[0];
		}else if(side == 1){
			return icons[1];
		}
		return icons[2];
	}

}
