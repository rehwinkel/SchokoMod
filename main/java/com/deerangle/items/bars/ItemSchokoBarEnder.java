package com.deerangle.items.bars;

import com.deerangle.items.ItemSchokoBar;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class ItemSchokoBarEnder extends ItemSchokoBar {

	public ItemSchokoBarEnder() {
		super("ender", 2, false);
	}
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		world.playSoundAtEntity(player, "mob.endermen.portal", 1, 1);
		int tries = 0;
		int x = (int) player.posX;
		int y = (int) player.posY;
		int z = (int) player.posZ;
		while(true){
			int x2 = x + (-8 + world.rand.nextInt(16));
			int y2 = y + world.rand.nextInt(4);
			int z2 = z + (-8 + world.rand.nextInt(16));
			if(world.isAirBlock(x2, y2, z2) && world.isAirBlock(x2, y2 + 1, z2)){
				player.setPosition(x2, y2, z2);
				break;
			}else{
				tries++;
			}
			
			if(tries > 512){
				break;
			}
		}
		return super.onEaten(stack, world, player);
	}

}
