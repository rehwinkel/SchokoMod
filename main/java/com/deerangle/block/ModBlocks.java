package com.deerangle.block;

import java.util.ArrayList;

import com.deerangle.block.entity.TileEntityDistiller;
import com.deerangle.item.ItemBlockSchoko;
import com.deerangle.item.ModItems;
import com.deerangle.item.bars.ItemSchokoBar;
import com.deerangle.main.NoahsChocolate;

import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber
public class ModBlocks {

	public static final ModBlocks instance = new ModBlocks();

	public static Block schoko_block;
	public static Block present;
	public static Block bush_weed;
	public static Block distiller;
	
	public static void preInit() {
		schoko_block = new BlockSchoko();
		present = new BlockPresent();
		bush_weed = new BlockBushWeed();
		distiller = new BlockDistiller();
		
		MinecraftForge.EVENT_BUS.register(instance);
	}

	@SubscribeEvent
	public void registerBlocks(RegistryEvent.Register<Block> event){
		IForgeRegistry<Block> registry = event.getRegistry();

		registerBlock(registry, schoko_block, new ItemBlockSchoko(schoko_block));
		registerBlock(registry, present);
		registerBlock(registry, bush_weed);
		registerBlock(registry, distiller);
		
		GameRegistry.registerTileEntity(TileEntityDistiller.class, "distiller");
	}
	
	private ArrayList<ItemBlock> ITEM_BLOCKS = new ArrayList<ItemBlock>();

	private void registerBlock(IForgeRegistry<Block> registry, Block block) {
		registry.register(block);
		ItemBlock ib = new ItemBlock(block);
		ib.setRegistryName(block.getRegistryName());
		ITEM_BLOCKS.add(ib);
	}

	private void registerBlock(IForgeRegistry<Block> registry, Block block, ItemBlock ib) {
		registry.register(block);
		ib.setRegistryName(block.getRegistryName());
		ITEM_BLOCKS.add(ib);
	}

	
	@SubscribeEvent
	public void registerItem(RegistryEvent.Register<Item> event){
		IForgeRegistry<Item> registry = event.getRegistry();

		for(ItemBlock ib : ITEM_BLOCKS){
			registry.register(ib);
		}
	}
	
	@SubscribeEvent
	public void registerModels(ModelRegistryEvent event){
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(schoko_block), 0, new ModelResourceLocation(NoahsChocolate.MODID + ":schoko_block_normal", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(schoko_block), 1, new ModelResourceLocation(NoahsChocolate.MODID + ":schoko_block_dark", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(schoko_block), 2, new ModelResourceLocation(NoahsChocolate.MODID + ":schoko_block_light", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(present), 0, new ModelResourceLocation(NoahsChocolate.MODID + ":present", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(bush_weed), 0, new ModelResourceLocation(NoahsChocolate.MODID + ":bush_weed", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(distiller), 0, new ModelResourceLocation(NoahsChocolate.MODID + ":distiller", "inventory"));
	}
	
}
