package com.deerangle.item.bars;

import com.deerangle.effect.ModPotions;
import com.deerangle.main.NoahsChocolate;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

public class ItemSchokoBarColored extends ItemFood {

	public ItemSchokoBarColored() {
		super(4, false);
		this.setUnlocalizedName("schoko_bar_colored");
		this.setRegistryName("schoko_bar_colored");
		this.setCreativeTab(NoahsChocolate.bars);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName(stack) + "_" + EnumDyeColor.values()[stack.getMetadata()].getDyeColorName();
	}
	
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			for(int i = 0; i < EnumDyeColor.values().length; i++){
				items.add(new ItemStack(this, 1, i));
			}
		}
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
			player.addPotionEffect(new PotionEffect(ModPotions.schoko, 10 * 20, 0));
			player.getEntityData().setInteger("Diabetis", player.getEntityData().getInteger("Diabetis") + 1);
		}
	}

}
