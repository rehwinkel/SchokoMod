package com.deerangle.item;

import com.deerangle.main.NoahsChocolate;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

public class ItemSchokoDrink extends ItemFood {

	public ItemSchokoDrink() {
		super(4, false);
		this.setRegistryName("schoko_drink");
		this.setUnlocalizedName("schoko_drink");
		this.setCreativeTab(NoahsChocolate.tab);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		this.setMaxStackSize(1);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName() + (stack.getMetadata() > 0 ? "_hot" : "");
	}
	
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			items.add(new ItemStack(this, 1, 0));
			items.add(new ItemStack(this, 1, 1));
		}
	}
	
	@Override
	public int getMetadata(int damage) {
		return damage;
	}
	
	@Override
	public int getMetadata(ItemStack stack) {
		return stack.getItemDamage();
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.DRINK;
	}
	
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
		super.onItemUseFinish(stack, worldIn, entityLiving);
		return new ItemStack(ModItems.mug);
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		if (!worldIn.isRemote) {
			//TODO: player.addPotionEffect(new PotionEffect(NoahsChocolate.schokoPotion.id, 10 * 20, effect));
			player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 10 * 20, 0));
			if(stack.getMetadata() > 0){
				player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 10 * 20, 0));
			}
		}
	}

}
