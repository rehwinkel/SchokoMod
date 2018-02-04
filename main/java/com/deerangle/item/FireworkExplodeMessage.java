package com.deerangle.item;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleFirework;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class FireworkExplodeMessage implements IMessage {

	public double x;
	public double y;
	public double z;
	
	public FireworkExplodeMessage() {
		this(0, 0, 0);
	}
	
	public FireworkExplodeMessage(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		x = buf.readDouble();
		y = buf.readDouble();
		z = buf.readDouble();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeDouble(x);
		buf.writeDouble(y);
		buf.writeDouble(z);
	}

	public static class Handler implements IMessageHandler<FireworkExplodeMessage, IMessage> {
		@Override
		public IMessage onMessage(FireworkExplodeMessage message, MessageContext ctx) {
			Minecraft mc = Minecraft.getMinecraft(); 
			
			NBTTagCompound fireworks = new NBTTagCompound();
			NBTTagList explosions = new NBTTagList();
			NBTTagCompound explosion = new NBTTagCompound();

			fireworks.setByte("Flight", (byte) 1);
			explosion.setByte("Type", (byte) 0);
			explosion.setIntArray("Colors", new int[] { 9533525 });
			explosions.appendTag(explosion);

			fireworks.setTag("Explosions", explosions);
			mc.effectRenderer.addEffect(new ParticleFirework.Starter(mc.world, message.x, message.y, message.z, 0, 0, 0, mc.effectRenderer, fireworks));
			return null;
		}
	}
}
