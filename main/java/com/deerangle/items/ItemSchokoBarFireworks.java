package com.deerangle.items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFireworkSparkFX;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemFireball;
import net.minecraft.item.ItemFirework;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemSchokoBarFireworks extends ItemSchokoBar {

	public ItemSchokoBarFireworks() {
		super("fireworks", 3);
	}

	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		ItemStack stack2 = new ItemStack(Items.fireworks);

		NBTTagCompound nbttagcompound1 = new NBTTagCompound();
		NBTTagCompound nbttagcompound2 = new NBTTagCompound();

		nbttagcompound2.setIntArray("Colors", new int[] {9533525});
		nbttagcompound2.setBoolean("Flicker", true);
		nbttagcompound1.setTag("Explosion", nbttagcompound2);

		stack2.setTagCompound(nbttagcompound1);

		EntityFireworkRocket rocket = new EntityFireworkRocket(world, player.posX, player.posY, player.posZ, stack2);
		world.spawnEntityInWorld(rocket);
		
		//world.makeFireworks(p_92088_1_, p_92088_3_, p_92088_5_, p_92088_7_, p_92088_9_, p_92088_11_, p_92088_13_);

		// ItemFireworke
		return super.onEaten(stack, world, player);
	}

}
