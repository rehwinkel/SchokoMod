package com.deerangle.block;

import com.deerangle.block.entity.TileEntityDistiller;
import com.deerangle.block.entity.TileEntityPacker;
import com.deerangle.gui.ModGuiHandler;
import com.deerangle.main.NoahsChocolate;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockPacker extends Block {

	public BlockPacker() {
		super(Material.IRON);
		this.setUnlocalizedName("packer");
		this.setRegistryName("packer");
		this.setCreativeTab(NoahsChocolate.tab);
		this.setHardness(1F);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!worldIn.isRemote) {
			playerIn.openGui(NoahsChocolate.INSTANCE, ModGuiHandler.packer_gui_id, worldIn, pos.getX(), pos.getY(),  pos.getZ());
		}
		return true;
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		TileEntityPacker tileEntity = (TileEntityPacker) worldIn.getTileEntity(pos);
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
		return new TileEntityPacker();
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state) {
		return this.hasTileEntity();
	}
	
	@Override
	public boolean hasTileEntity() {
		return true;
	}
	
}
