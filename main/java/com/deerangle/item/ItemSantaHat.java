package com.deerangle.item;

import com.deerangle.main.NoahsChocolate;

import net.minecraft.entity.Entity;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.EnumHelper;

public class ItemSantaHat extends ItemArmor {

	private static ArmorMaterial mat = EnumHelper.addArmorMaterial("santa", "santa", 40, new int[] { 1, 0, 0, 0 }, 0, SoundEvents.BLOCK_CLOTH_HIT, 0);

	public ItemSantaHat() {
		super(mat, 0, EntityEquipmentSlot.HEAD);
		this.setUnlocalizedName("santa_hat");
		this.setRegistryName("santa_hat");
		this.setCreativeTab(NoahsChocolate.tab);
	}

	@Override
	public boolean isDamageable() {
		return false;
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
		return NoahsChocolate.MODID + ":textures/models/armor/santa.png";
	}

}
