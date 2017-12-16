package com.deerangle.items.bars;

import com.deerangle.items.ISchokoBar;
import com.deerangle.main.SchokoMod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemSchokoBarTroll extends ItemFood implements ISchokoBar {

	public ItemSchokoBarTroll() {
		super(4, false);
		this.setUnlocalizedName("schokoBarTroll");
		this.setCreativeTab(SchokoMod.bars);
		this.setTextureName(SchokoMod.MODID + ":bars/schokoBarNormal");
	}

	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		player.addPotionEffect(new PotionEffect(SchokoMod.schokoPotion.id, 10 * 20, 0));
		player.addPotionEffect(new PotionEffect(Potion.poison.id, 5 * 20, 2));
		player.addPotionEffect(new PotionEffect(Potion.confusion.id, 5 * 20, 2));
		if(!world.isRemote){
			player.getEntityData().setInteger("Diabetis", player.getEntityData().getInteger("Diabetis") + 1);
		}
		return super.onEaten(stack, world, player);
	}
	
}
