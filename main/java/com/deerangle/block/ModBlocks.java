package com.deerangle.block;

import java.util.ArrayList;  

import com.deerangle.block.entity.*;
import com.deerangle.item.ItemBlockSchoko;
import com.deerangle.item.ModItems;
import com.deerangle.main.NoahsChocolate;

import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
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

	public static Block SCHOKO_BLOCK;
	public static Block PRESENT;
	public static Block BUSH_WEED;
	public static Block DISTILLER;
	public static Block MIXER;
	public static Block PACKER;
	
	public static void preInit() {
		SCHOKO_BLOCK = new BlockSchoko();
		PRESENT = new BlockPresent();
		BUSH_WEED = new BlockBushWeed();
		DISTILLER = new BlockDistiller();
		MIXER = new BlockMixer();
		PACKER = new BlockPacker();
		
		MinecraftForge.EVENT_BUS.register(instance);
	}

	@SubscribeEvent
	public void registerBlocks(RegistryEvent.Register<Block> event){
		IForgeRegistry<Block> registry = event.getRegistry();

		registerBlock(registry, SCHOKO_BLOCK, new ItemBlockSchoko(SCHOKO_BLOCK));
		registerBlock(registry, PRESENT);
		registerBlock(registry, BUSH_WEED);
		registerBlock(registry, DISTILLER);
		registerBlock(registry, MIXER);
		registerBlock(registry, PACKER);

		GameRegistry.registerTileEntity(TileEntityDistiller.class, new ResourceLocation(NoahsChocolate.MODID, "distiller"));
		GameRegistry.registerTileEntity(TileEntityMixer.class, new ResourceLocation(NoahsChocolate.MODID, "mixer"));
		GameRegistry.registerTileEntity(TileEntityPacker.class, new ResourceLocation(NoahsChocolate.MODID, "packer"));
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
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(SCHOKO_BLOCK), 0, new ModelResourceLocation(NoahsChocolate.MODID + ":schoko_block_normal", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(SCHOKO_BLOCK), 1, new ModelResourceLocation(NoahsChocolate.MODID + ":schoko_block_dark", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(SCHOKO_BLOCK), 2, new ModelResourceLocation(NoahsChocolate.MODID + ":schoko_block_light", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(PRESENT), 0, new ModelResourceLocation(NoahsChocolate.MODID + ":present", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BUSH_WEED), 0, new ModelResourceLocation(NoahsChocolate.MODID + ":bush_weed", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(DISTILLER), 0, new ModelResourceLocation(NoahsChocolate.MODID + ":distiller", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(MIXER), 0, new ModelResourceLocation(NoahsChocolate.MODID + ":mixer", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(PACKER), 0, new ModelResourceLocation(NoahsChocolate.MODID + ":packer", "inventory"));
	}
	
}
