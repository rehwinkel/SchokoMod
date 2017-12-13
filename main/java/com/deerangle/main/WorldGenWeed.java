package com.deerangle.main;

import java.util.Random;

import com.deerangle.tile.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenWeed extends WorldGenerator {
	private static final String __OBFID = "CL_00000426";
	private int mineableBlockMeta;

	public WorldGenWeed() {
		
	}

	public boolean generate(World world, Random random, int x, int y, int z) {
		if (world.getBlock(x, y - 1, z) == Blocks.grass || world.getBlock(x, y - 1, z) == Blocks.dirt) {
			if(world.isAirBlock(x, y, z)){
				world.setBlock(x, y, z, ModBlocks.weedBush);
				world.setBlockMetadataWithNotify(x, y, z, 3, 2);
			}
		}
		if (world.getBlock(x + 1, y - 1, z) == Blocks.grass || world.getBlock(x + 1, y - 1, z) == Blocks.dirt) {
			if(world.isAirBlock(x + 1, y, z)){
				if(Math.random() > 0.5){
					world.setBlock(x + 1, y, z, ModBlocks.weedBush);
					world.setBlockMetadataWithNotify(x + 1, y, z, 3, 2);
				}
			}
		}
		if (world.getBlock(x - 1, y - 1, z) == Blocks.grass || world.getBlock(x - 1, y - 1, z) == Blocks.dirt) {
			if(world.isAirBlock(x - 1, y, z)){
				if(Math.random() > 0.5){
					world.setBlock(x - 1, y, z, ModBlocks.weedBush);
					world.setBlockMetadataWithNotify(x - 1, y, z, 3, 2);
				}
			}
		}
		if (world.getBlock(x, y - 1, z + 1) == Blocks.grass || world.getBlock(x, y - 1, z + 1) == Blocks.dirt) {
			if(world.isAirBlock(x, y, z + 1)){
				if(Math.random() > 0.5){
					world.setBlock(x, y, z + 1, ModBlocks.weedBush);
					world.setBlockMetadataWithNotify(x, y, z + 1, 3, 2);
				}
			}
		}
		if (world.getBlock(x, y - 1, z - 1) == Blocks.grass || world.getBlock(x, y - 1, z - 1) == Blocks.dirt) {
			if(world.isAirBlock(x, y, z - 1)){
				if(Math.random() > 0.5){
					world.setBlock(x, y, z - 1, ModBlocks.weedBush);
					world.setBlockMetadataWithNotify(x, y, z - 1, 3, 2);
				}
			}
		}
		return true;
	}
}