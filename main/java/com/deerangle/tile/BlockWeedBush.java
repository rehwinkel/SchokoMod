package com.deerangle.tile;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.deerangle.items.ModItems;
import com.deerangle.main.ClientProxy;
import com.deerangle.main.SchokoMod;
import com.sun.security.ntlm.Client;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockWeedBush extends Block implements IShearable {

	private IIcon icon;

	protected BlockWeedBush() {
		super(Material.leaves);
		this.setHardness(0.65F);
		this.setBlockName("weedBush");
		this.setBlockTextureName(SchokoMod.MODID + ":weedBush");
		this.setTickRandomly(true);
		this.setCreativeTab(SchokoMod.rest);
		this.setStepSound(soundTypeGrass);
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z);
		if (meta == 0) {
			this.setBlockBounds(0.25F, 0.0F, 0.25F, 1 - 0.25F, 1 - 0.5F, 1 - 0.25F);
		}
		if (meta == 1) {
			this.setBlockBounds(0.125F, 0.0F, 0.125F, 1 - 0.125F, 1 - 0.25F, 1 - 0.125F);
		}
		if (meta > 1) {
			this.setBlockBounds(0, 0, 0, 1, 1, 1);
		}
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		super.onNeighborBlockChange(world, x, y, z, block);
		if(!world.isRemote){
			if (world.getBlock(x, y - 1, z) != Blocks.grass && world.getBlock(x, y - 1, z) != Blocks.dirt) {
				world.setBlockToAir(x, y, z);
			}
		}
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		AxisAlignedBB box = null;
		int meta = world.getBlockMetadata(x, y, z);
		if (meta == 0) {
			box = AxisAlignedBB.getBoundingBox(0.25F + x, 0.0F + y, 0.25F + z, 1 - 0.25F + x, 1 - 0.5F + y,
					1 - 0.25F + z);
		}
		if (meta == 1) {
			box = AxisAlignedBB.getBoundingBox(0.125F + x, 0.0F + y, 0.125F + z, 1 - 0.125F + x, 1 - 0.25F + y,
					1 - 0.125F + z);
		}
		if (meta > 1) {
			box = AxisAlignedBB.getBoundingBox(0 + x, 0 + y, 0 + z, 1 + x, 1 + y, 1 + z);
		}
		return box;
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
		int meta = world.getBlockMetadata(x, y, z);
		if (meta < 3) {
			if (Math.random() < 0.1) {
				meta++;
				world.setBlockMetadataWithNotify(x, y, z, meta, 2);
			}
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
		return ClientProxy.renderPass == 1 ? icon : this.blockIcon;
	}

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		if (metadata > 2) {
			ret.add(new ItemStack(ModItems.weedBud));
		}
		return ret;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer p, int s, float fx, float fy,
			float fz) {
		if (world.getBlockMetadata(x, y, z) == 3) {
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
			p.inventory.addItemStackToInventory(new ItemStack(ModItems.weedBud));
		}
		return true;
	}

}
