package com.deerangle.tile;

import java.util.ArrayList;
import java.util.Random;

import com.deerangle.items.ModItems;
import com.deerangle.main.ClientProxy;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class BlockWeedBush extends Block implements IShearable {

	protected BlockWeedBush() {
		super(Material.leaves);
		this.setHardness(0.65F);
		this.setBlockName("weedBush");
		this.useNeighborBrightness = true;
		this.setTickRandomly(true);
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
		System.out.println("hey!");
		world.setBlockMetadataWithNotify(x, y, z, 1, 2);
	}

	@Override
	public int getRenderType() {
		return ClientProxy.rendererWeed;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z) {
		return true;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(new ItemStack(this));
		return ret;
	}

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(new ItemStack(ModItems.weedBud));
		if (Math.random() < 0.4) {
			ret.add(new ItemStack(ModItems.weedBud));
		}
		return ret;
	}

}
