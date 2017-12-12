package com.deerangle.items;

import java.util.List;

import com.deerangle.main.SchokoMod;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemSchokoIngot extends Item {

	private String[] types = new String[] {"normal", "black", "white"};
	private IIcon[] icons = new IIcon[types.length];
	
	public ItemSchokoIngot() {
		this.setUnlocalizedName("schokoIngot");
		this.setCreativeTab(SchokoMod.rest);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for(int i = 0; i < types.length; i++){
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName() + "_" + types[stack.getItemDamage()];
	}
	
	@Override
	public void registerIcons(IIconRegister register) {
		for(int i = 0; i < types.length; i++){
			icons[i] = register.registerIcon(SchokoMod.MODID + ":schokoIngot_" + types[i]);
		}
	}
	
	@Override
	public IIcon getIconFromDamage(int dmg) {
		return icons[dmg];
	}
	
}
