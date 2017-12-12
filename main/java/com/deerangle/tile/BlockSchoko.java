package com.deerangle.tile;

import java.util.List;

import com.deerangle.effects.SchokoPotion;
import com.deerangle.main.SchokoMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockSchoko extends Block {

	private String[] types = new String[] { "normal", "black", "white" };
	private IIcon[] icons = new IIcon[types.length];

	protected BlockSchoko() {
		super(Material.cake);
		this.setBlockName("schokoBlock");
		this.setBlockTextureName(SchokoMod.MODID + ":schokoBlock");
		this.setCreativeTab(SchokoMod.rest);
		this.setHardness(3F);
	}

	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		for (int i = 0; i < types.length; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	@Override
	public void registerBlockIcons(IIconRegister register) {
		for (int i = 0; i < types.length; i++) {
			icons[i] = register.registerIcon(this.textureName + "_" + types[i]);
		}
	}
	
	@Override
	public int damageDropped(int meta) {
		return meta;
	}
	
	@Override
	public IIcon getIcon(int side, int meta) {
		return icons[meta];
	}

}
