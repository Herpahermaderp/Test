package io.github.herpahermaderp.test;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Test.ID, name = "Test", version = "0")
public class Test {
    public static final String ID = "test";
    
    @Instance
    public Test instance;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        ModBlocks.init();
        ModBlocks.registerTileEntities();
    }
}
