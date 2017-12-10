package com.deerangle.main;

import net.minecraft.potion.Potion;
import net.minecraft.util.StatCollector;

public class LSDPotion extends Potion {

	protected LSDPotion(int id) {
		super(id, false, 16711680);
	}
	
	@Override
	public Potion setIconIndex(int x, int y) {
		super.setIconIndex(x, y);
		return this;
	}
	
	@Override
	public String getName() {
		return StatCollector.translateToLocal("potion.lsd");
	}

}
