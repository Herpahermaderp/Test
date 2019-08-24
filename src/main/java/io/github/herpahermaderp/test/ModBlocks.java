package io.github.herpahermaderp.test;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber(modid = Test.ID)
public class ModBlocks {
    static Block eyecage;
    
    public static void init() {
        eyecage = new BlockEyeCage("eyecage", Material.ROCK);
    }
    
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> e) {
        e.getRegistry().registerAll(eyecage);
    }
    
    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> e) {
        e.getRegistry().registerAll(new ItemBlock(eyecage).setRegistryName(eyecage.getRegistryName()));
    }
    
    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent e) {
        registerRender(Item.getItemFromBlock(eyecage));
    }
    
    public static void registerTileEntities() {
        registerTileEntity(TileEntityEyeCage.class, eyecage.getRegistryName());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEyeCage.class, new TileEntityEyeCageRenderer());
    }
    
    public static void registerRender(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
    
    public static void registerTileEntity(Class<? extends TileEntity> clazz, ResourceLocation loc) {
        GameRegistry.registerTileEntity(clazz, loc);
    }
}
