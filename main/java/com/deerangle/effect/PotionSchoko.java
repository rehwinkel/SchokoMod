package com.deerangle.effect;

import com.deerangle.main.NoahsChocolate;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.resources.I18n;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;

public class PotionSchoko extends Potion {

	private ResourceLocation texture;

	protected PotionSchoko() {
		super(false, 9533525);
		this.setRegistryName("potion_schoko");
		texture = new ResourceLocation(NoahsChocolate.MODID + ":textures/gui/schoko_effect.png");
	}
	
	@Override
	public String getName() {
		return I18n.format("potion.schoko");
	}
	
	@Override
	public void renderInventoryEffect(int x, int y, PotionEffect effect, Minecraft mc) {
		mc.getTextureManager().bindTexture(texture);
		Gui.drawModalRectWithCustomSizedTexture(x + 6, y + 7, 0, 0, 18, 18, 18, 18);
	}
	
	@Override
	public void renderHUDEffect(int x, int y, PotionEffect effect, Minecraft mc, float alpha) {
		mc.getTextureManager().bindTexture(texture);
		Gui.drawModalRectWithCustomSizedTexture(x + 3, y + 3, 0, 0, 18, 18, 18, 18);
	}
	
}
