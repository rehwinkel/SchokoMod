package com.deerangle.block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.deerangle.item.ModItems;
import com.deerangle.main.NoahsChocolate;
import com.deerangle.main.NoahsUtil;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEnchantmentTable;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPotato;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBushWeed extends Block implements IPlantable, IShearable {

	public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 3);

	public BlockBushWeed() {
		super(Material.LEAVES);
		this.setHardness(0.2F);
		this.setUnlocalizedName("bush_weed");
		this.setRegistryName("bush_weed");
		this.setCreativeTab(NoahsChocolate.tab);
		this.setSoundType(SoundType.PLANT);
		this.setDefaultState(this.getDefaultState().withProperty(AGE, 0));
		this.setTickRandomly(true);
	}
	
	@Override
	public boolean canPlaceTorchOnTop(IBlockState state, IBlockAccess world, BlockPos pos) {
		return false;
	}
	
	@Override
	public boolean canPlaceBlockOnSide(World worldIn, BlockPos pos, EnumFacing side) {
		if(side == EnumFacing.UP){
			BlockPos pos2 = pos.offset(EnumFacing.DOWN);
			if(canSustain(worldIn, pos2, worldIn.getBlockState(pos2))){
				return true;
			}
		}
		
		return false;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		switch (getAge(state)) {
		case 0:
			return new AxisAlignedBB(0.25, 0, 0.25, 0.75, 0.5, 0.75);
		case 1:
			return new AxisAlignedBB(0.125, 0, 0.125, 0.875, 0.75, 0.875);
		case 2:
			return new AxisAlignedBB(0, 0, 0, 1, 1, 1);
		case 3:
			return new AxisAlignedBB(0, 0, 0, 1, 1, 1);
		}
		return null;
	}

	@Override
	public int getLightOpacity(IBlockState state) {
		return 0;
	}

	@Override
	public int getLightOpacity(IBlockState state, IBlockAccess world, BlockPos pos) {
		return getLightOpacity(state);
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return this.getAge(state) > 1;
	}

	@Override
	public boolean isFullBlock(IBlockState state) {
		return this.getAge(state) > 1;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isTranslucent(IBlockState state) {
		return true;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { AGE });
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return getAge(state);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(AGE, meta);
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (rand.nextFloat() < 0.5) {
			if (worldIn.getLightFromNeighbors(pos.up()) >= 8) {
				grow(worldIn, rand, pos, state);
			}
		}
	}

	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos) {
		return true;
	}

	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		drops.add(new ItemStack(this));
	}

	@Override
	public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
		if (!worldIn.isRemote) {
			if (this.getAge(worldIn.getBlockState(pos)) > 2) {
				NoahsUtil.givePlayerItem(playerIn, new ItemStack(ModItems.WEED_BUD));
				this.setAge(worldIn, pos, 2);
			}
		}
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		onBlockClicked(worldIn, pos, playerIn);
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
	}

	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) { 
		NonNullList<ItemStack> list = NonNullList.create();
		getDrops(list, world, pos, world.getBlockState(pos), fortune);
		return list;
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
		return EnumPlantType.Plains;
	}

	@Override
	public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
		return null;
	}

	/**
	 * Checks, whether the given block pos can sustain This.
	 */
	public boolean canSustain(World worldIn, BlockPos pos, IBlockState state){
		Block block = state.getBlock();
		return block == Blocks.GRASS || block == Blocks.DIRT || (block == this && this.getAge(state) >= 2);
	}
	
	@Override
	public void onNeighborChange(IBlockAccess world, BlockPos pos, BlockPos neighbor) {
		if(!canSustain((World) world, pos.offset(EnumFacing.DOWN), world.getBlockState(pos.offset(EnumFacing.DOWN)))){
			((World) world).setBlockToAir(pos);
		}
	}
	
	@Override
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block blockIn, BlockPos fromPos) {
		if(!canSustain((World) world, pos.offset(EnumFacing.DOWN), world.getBlockState(pos.offset(EnumFacing.DOWN)))){
			((World) world).setBlockToAir(pos);
		}
	}

	@Override
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return 50;
	}

	@Override
	public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return true;
	}

	@Override
	public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return 10;
	}

	private boolean isMaxAge(IBlockState state) {
		return this.getAge(state) >= this.getMaxAge();
	}

	private int getAge(IBlockState state) {
		return state.getValue(AGE).intValue();
	}

	private int getMaxAge() {
		return 3;
	}

	private void setAge(World worldIn, BlockPos pos, int i) {
		worldIn.setBlockState(pos, this.getDefaultState().withProperty(AGE, i), 2);
	}

	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		int i = state.getValue(AGE).intValue() + 1;
		int max = getMaxAge();

		if (i > max) {
			i = max;
		}

		worldIn.setBlockState(pos, this.getDefaultState().withProperty(AGE, i), 2);

		if (rand.nextFloat() < 0.25F && isMaxAge(state)) {
			growUp(worldIn, rand, pos, state);
		}
	}

	private void growUp(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		if (getBushesUnderneath(worldIn, pos) < 2) {
			if (worldIn.isAirBlock(pos.offset(EnumFacing.UP))) {
				worldIn.setBlockState(pos.offset(EnumFacing.UP), getDefaultState());
			}
		}
	}
	
	private int getBushesUnderneath(World worldIn, BlockPos pos){
		int countDown = 0;
		for (int i = 0; i < 8; i++) {
			if (worldIn.getBlockState(pos.offset(EnumFacing.DOWN, i)).getBlock() != this) {
				countDown = i - 1;
				break;
			}
		}
		
		return countDown;
	}

}
