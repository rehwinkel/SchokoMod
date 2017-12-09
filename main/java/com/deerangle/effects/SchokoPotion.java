package com.deerangle.effects;

import net.minecraft.potion.Potion;

public class SchokoPotion extends Potion {

	public SchokoPotion(int id) {
		super(id, false, 16777215);
	}
	
	@Override
	public Potion setIconIndex(int x, int y) {
		super.setIconIndex(x, y);
		return this;
	}
	
	@Override
	public Potion setPotionName(String string) {
		return super.setPotionName(string);
	}
}
