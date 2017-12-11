package com.deerangle.items;

import java.util.List;

import com.deerangle.main.SchokoMod;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemSchokoBarColored extends ItemFood {

	public String[] colors = new String[] {"black", "red", "green", "brown", "blue", "purple", "cyan", "silver", "gray", "pink", "lime", "yellow", "lightBlue", "magenta", "orange", "white"};
	public IIcon[] icons = new IIcon[colors.length];
	
	public ItemSchokoBarColored() {
		super(4, false);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setUnlocalizedName("schokoBarColored");
		this.setCreativeTab(SchokoMod.tab);
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for(int i = 0; i < colors.length; i++){
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName() + "_" + colors[stack.getItemDamage()];
	}
	
	@Override
	public void registerIcons(IIconRegister register) {
		for(int i = 0; i < colors.length; i++){
			icons[i] = register.registerIcon(SchokoMod.MODID + ":bars/schokoBarColored" + "_" + colors[i]);
		}
	}
	
	@Override
	public IIcon getIcon(ItemStack stack, int pass) {
		return icons[stack.getItemDamage()];
	}

}
