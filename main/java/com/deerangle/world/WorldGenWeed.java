package com.deerangle.world;

import java.util.Random;

import com.deerangle.block.BlockBushWeed;
import com.deerangle.block.ModBlocks;

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenWeed extends WorldGenerator {

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos) {
		setBushAt(worldIn, pos.offset(EnumFacing.NORTH), false, true);
		setBushAt(worldIn, pos.offset(EnumFacing.SOUTH), false, true);
		setBushAt(worldIn, pos.offset(EnumFacing.WEST), false, true);
		setBushAt(worldIn, pos.offset(EnumFacing.EAST), false, true);
		if(rand.nextBoolean()){
			setBushAt(worldIn, pos, true, false);
			setBushAt(worldIn, pos.offset(EnumFacing.UP), false, true);
		}else{
			setBushAt(worldIn, pos, false, false);
		}
		return true;
	}
	
	private boolean setBushAt(World worldIn, BlockPos pos, boolean b, boolean isRandom){
		if(isRandom){
			if(worldIn.rand.nextFloat() > 0.7F){
				return false;
			}
		}
		
		if(worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos)){
			BlockPos lowPos = pos.offset(EnumFacing.DOWN);
			if(((BlockBushWeed) ModBlocks.BUSH_WEED).canSustain(worldIn, lowPos, worldIn.getBlockState(lowPos))){
				if(b){
					worldIn.setBlockState(pos, ModBlocks.BUSH_WEED.getDefaultState().withProperty(BlockBushWeed.AGE, 2));
				}else{
					worldIn.setBlockState(pos, ModBlocks.BUSH_WEED.getDefaultState());
				}
			}
			return true;
		}
		
		return false;
	}
	
//	public boolean generate(World worldIn, Random rand, BlockPos position) {
//		for (int i = 0; i < 20; ++i) {
//			BlockPos blockpos = position.add(rand.nextInt(4) - rand.nextInt(4), 0, rand.nextInt(4) - rand.nextInt(4));
//
//			if (worldIn.isAirBlock(blockpos)) {
//				BlockPos blockpos1 = blockpos.down();
//
//				if (worldIn.getBlockState(blockpos1.west()).getMaterial() == Material.WATER
//						|| worldIn.getBlockState(blockpos1.east()).getMaterial() == Material.WATER
//						|| worldIn.getBlockState(blockpos1.north()).getMaterial() == Material.WATER
//						|| worldIn.getBlockState(blockpos1.south()).getMaterial() == Material.WATER) {
//					int j = 2 + rand.nextInt(rand.nextInt(3) + 1);
//
//					for (int k = 0; k < j; ++k) {
//						if (Blocks.REEDS.canBlockStay(worldIn, blockpos)) {
//							worldIn.setBlockState(blockpos.up(k), ModBlocks.bush_weed.getDefaultState(), 2);
//						}
//					}
//				}
//			}
//		}
//
//		return true;
//	}
	
}
