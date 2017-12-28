package com.deerangle.item;

import com.deerangle.main.NoahsChocolate;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemChocolateBar extends ItemFood {

	public static String[] types = new String[] { "normal", "dark", "light", "full", "lite", "cookie", "nut", "smartie",
			"joghurt", "colored_white", "colored_orange", "colored_magenta", "colored_light_blue", "colored_yellow",
			"colored_lime", "colored_pink", "colored_gray", "colored_silver", "colored_cyan", "colored_purple",
			"colored_blue", "colored_brown", "colored_green", "colored_red", "colored_black", "bed", "mushroom",
			"flower", "lilypad", "gold", "steve", "lsd", "troll", "fish", "quartz", "cobble", "spider", "creeper",
			"ender", "wither" };

	public ItemChocolateBar() {
		super(0, false);
		this.setRegistryName("chocolate_bar");
		this.setCreativeTab(NoahsChocolate.bars);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			for (int i = 0; i < types.length; i++) {
				items.add(new ItemStack(this, 1, i));
			}
		}
	}

	@Override
	public int getMetadata(ItemStack stack) {
		return this.getMetadata(stack.getItemDamage());
	}

	@Override
	public int getMetadata(int damage) {
		return damage;
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return "item.chocolate_bar_" + types[stack.getMetadata()];
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
		if (entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entityLiving;
			int meta = stack.getMetadata();
			player.getFoodStats().addStats(new ItemFood(getHungerAmount(meta), isWolfFood(meta)), stack);
			worldIn.playSound((EntityPlayer) null, player.posX, player.posY, player.posZ,
					SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F,
					worldIn.rand.nextFloat() * 0.1F + 0.9F);
			this.onFoodEaten(meta, stack, worldIn, player);
			player.addStat(StatList.getObjectUseStats(this));

			if (player instanceof EntityPlayerMP) {
				CriteriaTriggers.CONSUME_ITEM.trigger((EntityPlayerMP) player, stack);
			}
		}

		stack.shrink(1);
		return stack;
	}

	private void onFoodEaten(int meta, ItemStack stack, World worldIn, EntityPlayer player) {
		if (!worldIn.isRemote) {
			switch (types[meta]) {
			case "":
				System.out.println();
				break;

			default:
				break;
			}
		}
	}

	private boolean isWolfFood(int meta) {
		switch (types[meta]) {
		case "cow":
			return true;
		default:
			return false;
		}
	}

	private int getHungerAmount(int meta) {
		switch (types[meta]) {
		case "nut":
			return 6;
		case "full":
			return 6;
		case "cookie":
			return 6;
		case "joghurt":
			return 6;
		case "smartie":
			return 6;
		default:
			return 4;
		}
	}

}
