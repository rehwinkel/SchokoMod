package com.deerangle.block;

import java.util.ArrayList; 
import java.util.Random;

import com.deerangle.main.NoahsChocolate;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPresent extends Block {

	public BlockPresent() {
		super(Material.CLOTH);
		this.setUnlocalizedName("present");
		this.setRegistryName("present");
		this.setHardness(1F);
	}

	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		Random rand = world instanceof World ? ((World)world).rand : RANDOM;
		
		if(rand.nextFloat() < 0.01){
			drops.add(new ItemStack(Items.DIAMOND));
		}else{
			drops.add(new ItemStack(Items.COAL, 1));
		}
	}
	
}
