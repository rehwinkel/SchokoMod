package com.deerangle.effects;

import org.lwjgl.opengl.GL11;

import com.deerangle.main.SchokoMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class SchokoPotion extends Potion {

	public SchokoPotion(int id) {
		super(id, false, 9533525);
	}
	
//	@Override
//	public boolean hasStatusIcon() {
//		return false;
//	}
//	
//	@Override
//	public void renderInventoryEffect(int x, int y, PotionEffect effect, Minecraft mc) {
//		mc.renderEngine.bindTexture(new ResourceLocation(SchokoMod.MODID + ":textures/items/bars/schokoBarNormal.png"));
//		GL11.glEnable(GL11.GL_BLEND);
//		mc.currentScreen.drawTexturedModalRect(x + 6, y + 7, 0, 0, 16, 16);
//	}

	@Override
	public Potion setIconIndex(int x, int y) {
		super.setIconIndex(x, y);
		return this;
	}

	@Override
	public String getName() {
		return StatCollector.translateToLocal("potion.schoko");
	}
}
