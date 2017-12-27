package com.deerangle.item.bars;

import com.deerangle.effect.ModPotions;
import com.deerangle.main.NoahsChocolate;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemAppleGold;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemSchokoBar extends ItemFood {

	protected int effect = 0;

	public ItemSchokoBar(String type, int food) {
		this(type, food, false, 0);
	}

	public ItemSchokoBar(String type) {
		this(type, 4, false, 0);
	}

	public ItemSchokoBar(String type, int food, boolean wolf) {
		this(type, food, wolf, 0);
	}

	public ItemSchokoBar(String type, int food, boolean wolf, int effect) {
		super(food, wolf);
		this.effect = effect;
		this.setUnlocalizedName("schoko_bar_" + type);
		this.setRegistryName("schoko_bar_" + type);
		this.setCreativeTab(NoahsChocolate.bars);
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		if (!worldIn.isRemote) {
			player.addPotionEffect(new PotionEffect(ModPotions.schoko, 10 * 20, effect));
			player.getEntityData().setInteger("Diabetis", player.getEntityData().getInteger("Diabetis") + 1);
		}
	}

}
