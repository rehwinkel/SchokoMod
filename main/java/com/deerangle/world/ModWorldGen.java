package com.deerangle.world;

import java.util.Random;

import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenDeadBush;
import net.minecraftforge.fml.common.IWorldGenerator;

public class ModWorldGen implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		if (world.provider.getDimension() == 0) {
			int x = chunkX * 16 + random.nextInt(16) + 8;
			int z = chunkZ * 16 + random.nextInt(16) + 8;
			int y = world.getHeight(new BlockPos(x, 0, z)).getY();
			BlockPos pos = new BlockPos(x, y, z);
			if(random.nextFloat() < (world.getBiome(pos) == Biomes.SWAMPLAND ? 0.2 : 0.04)){
				(new WorldGenWeed()).generate(world, random, pos);
			}
		}
	}

}
