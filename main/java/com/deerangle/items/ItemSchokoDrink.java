package com.deerangle.items;

import java.util.List;

import com.deerangle.main.SchokoMod;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucketMilk;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemSchokoDrink extends ItemFood {

	private String[] types = new String[] { "normal", "hot" };
	private IIcon[] icons = new IIcon[types.length];

	public ItemSchokoDrink() {
		super(4, false);
		this.setUnlocalizedName("schokoDrink");
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		this.setMaxStackSize(1);
		this.setCreativeTab(SchokoMod.foods);
	}

	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for (int i = 0; i < types.length; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName(stack) + "_" + types[stack.getItemDamage()];
	}
	
	@Override
	public void registerIcons(IIconRegister register) {
		icons[0] = register.registerIcon(SchokoMod.MODID + ":schokoDrink" + "_" + types[0]);
		icons[1] = register.registerIcon(SchokoMod.MODID + ":schokoDrink" + "_" + types[1]);
	}

	@Override
	public IIcon getIconFromDamage(int damage) {
		return icons[damage];
	}

	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		player.addPotionEffect(new PotionEffect(SchokoMod.schokoPotion.id, 10 * 20, 0));
		if (stack.getItemDamage() > 0) {
			player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 10 * 20, 0));
		}
		if (!world.isRemote) {
			player.getEntityData().setInteger("Diabetis", player.getEntityData().getInteger("Diabetis") + 1);
		}
		super.onEaten(stack, world, player);
		return new ItemStack(ModItems.mug);
	}

	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.drink;
	}

}
