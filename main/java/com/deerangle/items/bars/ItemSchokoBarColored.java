package com.deerangle.items.bars;

import java.util.List;

import com.deerangle.main.ISchokoBar;
import com.deerangle.main.SchokoMod;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemSchokoBarColored extends ItemFood implements ISchokoBar {

	public String[] colors = new String[] {"black", "red", "green", "brown", "blue", "purple", "cyan", "silver", "gray", "pink", "lime", "yellow", "lightBlue", "magenta", "orange", "white"};
	public IIcon[] icons = new IIcon[colors.length];
	
	public ItemSchokoBarColored() {
		super(4, false);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setUnlocalizedName("schokoBarColored");
		this.setCreativeTab(SchokoMod.bars);
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
	public IIcon getIconFromDamage(int dmg) {
		return icons[dmg];
	}
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		player.addPotionEffect(new PotionEffect(SchokoMod.schokoPotion.id, 10 * 20, 0));
		if(!world.isRemote){
			player.getEntityData().setInteger("Diabetis", player.getEntityData().getInteger("Diabetis") + 1);
		}
		return super.onEaten(stack, world, player);
	}

}
