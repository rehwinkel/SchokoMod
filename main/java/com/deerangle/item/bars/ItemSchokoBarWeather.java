package com.deerangle.item.bars;

import com.deerangle.main.NoahsChocolate;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

public class ItemSchokoBarWeather extends ItemFood {

	public ItemSchokoBarWeather() {
		super(4, false);
		this.setRegistryName("schoko_bar_weather");
		this.setCreativeTab(NoahsChocolate.bars);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			items.add(new ItemStack(this, 1, 0));
			items.add(new ItemStack(this, 1, 1));
			items.add(new ItemStack(this, 1, 2));
			items.add(new ItemStack(this, 1, 3));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		String[] types = new String[] { "bed", "mushroom", "flower", "lilypad" };
		return "item.schoko_bar_" + types[stack.getMetadata()];
	}

	@Override
	public int getMetadata(int damage) {
		return damage;
	}

	@Override
	public int getMetadata(ItemStack stack) {
		return stack.getItemDamage();
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		if (!worldIn.isRemote) {
			switch (getMetadata(stack)) {
			case 0:
				worldIn.setWorldTime(1000);
				break;
			case 1:
				worldIn.setWorldTime(18000);
				break;
			case 2:
				worldIn.getWorldInfo().setRainTime(0);
				worldIn.getWorldInfo().setThunderTime(0);
				worldIn.getWorldInfo().setRaining(false);
				worldIn.getWorldInfo().setThundering(false);
				break;
			case 3:
				worldIn.getWorldInfo().setRainTime(0);
				worldIn.getWorldInfo().setRaining(true);
				break;
			}
		}
	}

}
