package com.deerangle.tile;

import java.util.ArrayList;

import com.deerangle.items.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class BlockWeedBush extends Block implements IShearable {

	protected BlockWeedBush() {
		super(Material.leaves);
		this.setHardness(0.65F);
	}

	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z) {
		return true;
	}

	@Override
	public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(new ItemStack(this));
		if(Math.random() < 0.4){
			ret.add(new ItemStack(ModItems.weedBud));
		}
		ret.add(new ItemStack(this));
		return ret;
	}
	
	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		if(Math.random() < 0.4){
			ret.add(new ItemStack(ModItems.weedBud));
		}
		return ret;
	}

}
