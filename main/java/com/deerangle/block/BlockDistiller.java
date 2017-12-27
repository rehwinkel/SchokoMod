package com.deerangle.block;

import com.deerangle.block.entity.TileEntityDistiller;
import com.deerangle.gui.ModGuiHandler;
import com.deerangle.item.ModItems;
import com.deerangle.main.NoahsChocolate;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class BlockDistiller extends Block {

	protected BlockDistiller() {
		super(Material.ROCK);
		this.setUnlocalizedName("distiller");
		this.setRegistryName("distiller");
		this.setCreativeTab(NoahsChocolate.tab);
		this.setHardness(1F);
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullBlock(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!worldIn.isRemote) {
			playerIn.openGui(NoahsChocolate.INSTANCE, ModGuiHandler.distiller_gui_id, worldIn, pos.getX(), pos.getY(),  pos.getZ());
		}
		return true;
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		TileEntityDistiller tileEntity = (TileEntityDistiller) worldIn.getTileEntity(pos);
		if(tileEntity != null){
			for(int i = 0; i < tileEntity.inventory.getSlots(); i++){
				ItemStack stack = tileEntity.inventory.getStackInSlot(i);
				EntityItem item = new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, stack);
				worldIn.spawnEntity(item);
			}
		}
		
		super.breakBlock(worldIn, pos, state);
	}

	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityDistiller();
	}

	@Override
	public boolean hasTileEntity() {
		return true;
	}

	@Override
	public boolean hasTileEntity(IBlockState state) {
		return hasTileEntity();
	}

}
