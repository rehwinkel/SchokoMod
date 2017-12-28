package com.deerangle.item.bars;

import com.deerangle.effect.ModPotions;
import com.deerangle.main.NoahsChocolate;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemAppleGold;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

public class ItemSchokoBarPotion extends ItemFood {

	public ItemSchokoBarPotion() {
		super(4, false);
		this.setRegistryName("schoko_bar_potion");
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
			items.add(new ItemStack(this, 1, 4));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		String[] types = new String[] { "gold", "steve", "lsd", "troll", "fish" };
		return "item.schoko_bar_" + types[stack.getMetadata()];
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		if (!worldIn.isRemote) {
			switch (getMetadata(stack)) {
			case 0:
				player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 5 * 20, 1));
                player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 120 * 20, 0));
				break;
			case 1:
				player.addPotionEffect(new PotionEffect(MobEffects.POISON, 10 * 20, 2));
				break;
			case 2:
				player.addPotionEffect(new PotionEffect(ModPotions.lsd, 30 * 20, 0));
				break;
			case 3:
				player.addPotionEffect(new PotionEffect(MobEffects.POISON, 5 * 20, 2));
				break;
			case 4:
				player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 10 * 20, 0));
				break;
			}
			player.addPotionEffect(new PotionEffect(ModPotions.schoko, 10 * 20, 0));
			player.getEntityData().setInteger("Diabetis", player.getEntityData().getInteger("Diabetis") + 1);
		}
	}

	@Override
	public int getMetadata(int damage) {
		return damage;
	}

	@Override
	public int getMetadata(ItemStack stack) {
		return this.getMetadata(stack.getItemDamage());
	}

}
