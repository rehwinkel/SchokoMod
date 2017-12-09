package com.deerangle.effects;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.potion.Potion;
import net.minecraft.util.StatCollector;

public class SchokoPotion extends Potion {

	public SchokoPotion(int id) {
		super(id, false, 9533525);
	}
	
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
