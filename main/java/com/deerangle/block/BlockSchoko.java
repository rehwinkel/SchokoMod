package com.deerangle.block;

import com.deerangle.main.NoahsChocolate; 

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;

public class BlockSchoko extends Block {

	private static final PropertyEnum TYPE = PropertyEnum.create("type", EnumSchokoBlock.class);

	public BlockSchoko() {
		super(Material.CAKE);
		this.setUnlocalizedName("schoko_block");
		this.setRegistryName("schoko_block");
		this.setCreativeTab(NoahsChocolate.tab);
		this.setHardness(2F);
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EnumSchokoBlock.NORMAL));
	}

	@Override
	public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> items) {
		items.add(new ItemStack(this, 1, 0));
		items.add(new ItemStack(this, 1, 1));
		items.add(new ItemStack(this, 1, 2));
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { TYPE });
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		EnumSchokoBlock val = EnumSchokoBlock.NORMAL;
		switch(meta){
		case 0:
			val = EnumSchokoBlock.NORMAL;
			break;
		case 1:
			val = EnumSchokoBlock.DARK;
			break;
		case 2:
			val = EnumSchokoBlock.LIGHT;
			break;
		}
		return getDefaultState().withProperty(TYPE, val);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		EnumSchokoBlock type = (EnumSchokoBlock) state.getValue(TYPE);
		return type.getId();
	}

	@Override
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}

	public enum EnumSchokoBlock implements IStringSerializable {
		NORMAL(0),
		DARK(1),
		LIGHT(2);
		
		public int id;
		private String name;

		private EnumSchokoBlock(int id) {
			this.id = id;
			this.name = name().toLowerCase();
		}

		@Override
		public String getName() {
			return name;
		}
		
		public int getId() {
			return id;
		}
		
		@Override
		public String toString() {
			return getName();
		}
		
	}
	
}
