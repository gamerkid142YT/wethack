package org.proswiss.wethack;

import cookiedragon.eventsystem.EventDispatcher;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.proswiss.wethack.command.CommandManager;
import org.proswiss.wethack.event.listeners.Adapter;
import org.proswiss.wethack.event.listeners.CommandListener;
import org.proswiss.wethack.event.listeners.KeyListener;
import org.proswiss.wethack.module.ModuleManager;

@Mod(
        modid = Wethack.MOD_ID,
        name = Wethack.MOD_NAME,
        version = Wethack.VERSION
)
public class Wethack {

    public static final String MOD_ID = "wethack";
    public static final String MOD_NAME = "Wethack";
    public static final String VERSION = "1.0";

    /**
     * This is the instance of your mod as created by Forge. It will never be null.
     */
    @Mod.Instance(MOD_ID)
    public static Wethack INSTANCE;

    /**
     * This is the first initialization event.
     * The registry events below will have fired prior to entry to this method.
     */
    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
    }

    /**
     * This is the second initialization event. Initialize your managers here.
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

        // Put the KeyListener on the EventDispatcher Bus
        EventDispatcher.Companion.register(KeyListener.INSTANCE);
        EventDispatcher.Companion.subscribe(KeyListener.INSTANCE);

        // Put the CommandListener on the EventDispatcher Bus
        EventDispatcher.Companion.register(CommandListener.INSTANCE);
        EventDispatcher.Companion.subscribe(CommandListener.INSTANCE);

        // Put the Adapter on the Forge Event Bus
        MinecraftForge.EVENT_BUS.register(new Adapter());

        // Initialize the Module Manager. This initializes the modules.
        ModuleManager.initialize();

        // Initialize the Command Manager. This initializes the commands.
        CommandManager.initialize();
    }

    /**
     * This is the final initialization event.
     */
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {
    }
}
