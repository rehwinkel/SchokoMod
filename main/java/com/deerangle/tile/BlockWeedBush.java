package com.deerangle.tile;

import java.util.ArrayList;
import java.util.Random;

import com.deerangle.items.ModItems;
import com.deerangle.main.ClientProxy;
import com.deerangle.main.SchokoMod;
import com.sun.security.ntlm.Client;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class BlockWeedBush extends Block implements IShearable {

	private IIcon icon;

	protected BlockWeedBush() {
		super(Material.leaves);
		this.setHardness(0.65F);
		this.setBlockName("weedBush");
		this.setBlockTextureName(SchokoMod.MODID + ":weedBush");
		this.setTickRandomly(true);
		this.setBlockBounds(0.25f, 0.0f, 0.25f, 1 - 0.25f, 1 - 0.5f, 1 - 0.25f);
	}

	@Override
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z);
		if (meta == 0) {
			return AxisAlignedBB.getBoundingBox(0.25F, 0.0F, 0.25F, 1 - 0.25F, 1 - 0.5F, 1 - 0.25F);
		}
		if (meta == 1) {
			return AxisAlignedBB.getBoundingBox(0.125F, 0.0F, 0.125F, 1 - 0.125F, 1 - 0.25F, 1 - 0.125F);
		}
		if (meta > 1) {
			return AxisAlignedBB.getBoundingBox(0, 0, 0, 1, 1, 1);
		}
		System.err.println("ERROR!");
		return null;
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
		System.out.println("hey!!");
		int meta = world.getBlockMetadata(x, y, z);
		if (meta < 3) {
			world.setBlockMetadataWithNotify(x, y, z, meta + 1, 2);
		}
	}

	@Override
	public int getRenderBlockPass() {
		return 1;
	}

	@Override
	public boolean canRenderInPass(int pass) {
		ClientProxy.renderPass = pass;
		return true;
	}

	@Override
	public int getRenderType() {
		if (ClientProxy.renderInv) {
			return 0;
		}
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
	public void registerBlockIcons(IIconRegister register) {
		super.registerBlockIcons(register);
		icon = register.registerIcon(this.textureName + "_grown");
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		return ClientProxy.renderPass == 1 && !ClientProxy.renderInv ? icon : this.blockIcon;
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
