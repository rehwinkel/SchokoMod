package com.deerangle.items;

import com.deerangle.main.SchokoMod;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class ItemSantaHat extends ItemArmor {

	private static ArmorMaterial mat = EnumHelper.addArmorMaterial("santa", 100, new int[] {0, 0, 0, 0}, 0);
	
	public ItemSantaHat() {
		super(mat, 0, 0);
		this.setUnlocalizedName("santaHat");
		this.setTextureName(SchokoMod.MODID + ":santaHat");
		this.setMaxDamage(0);
		this.setMaxStackSize(1);
		this.setCreativeTab(SchokoMod.rest);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		return SchokoMod.MODID + ":textures/armor/santa.png";
	}
	
	@Override
	public void setDamage(ItemStack stack, int damage) {
		stack.setItemDamage(0);
	}
	
	@Override
	public boolean isDamageable() {
		return false;
	}

}
