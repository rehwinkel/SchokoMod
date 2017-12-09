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
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;

public class ItemSchokoBarFireworks extends ItemSchokoBar {

	public ItemSchokoBarFireworks() {
		super("fireworks", 3);
	}

	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		ItemStack s = new ItemStack(Items.fireworks);
		NBTTagCompound nbttagcompound1 = new NBTTagCompound();
		NBTTagList nbttaglist = new NBTTagList();
		NBTTagCompound explosions = new NBTTagCompound();
		explosions.setByte("Type", (byte) 0);
		explosions.setIntArray("Colors", new int[] { 9533525 });
		nbttaglist.appendTag(explosions);
		nbttagcompound1.setTag("Explosions", nbttaglist);
		nbttagcompound1.setByte("Flight", (byte) 1);
		world.makeFireworks(player.posX, player.posY, player.posZ, 0, 0, 0, nbttagcompound1);

		return super.onEaten(stack, world, player);
	}

}
