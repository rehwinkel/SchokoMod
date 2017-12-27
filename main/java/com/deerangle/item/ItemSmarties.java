package com.deerangle.item;

import com.deerangle.item.bars.ItemSchokoBar;
import com.deerangle.main.NoahsChocolate;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemSmarties extends ItemFood {

	public ItemSmarties() {
		super(2, false);
		this.setUnlocalizedName("smarties");
		this.setRegistryName("smarties");
		this.setCreativeTab(NoahsChocolate.tab);
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		if (!worldIn.isRemote) {
			//TODO: player.addPotionEffect(new PotionEffect(NoahsChocolate.schokoPotion.id, 10 * 20, 0));
			player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 10 * 20, 0));
			player.getEntityData().setInteger("Diabetis", player.getEntityData().getInteger("Diabetis") + 1);
		}
		super.onFoodEaten(stack, worldIn, player);
	}

}
