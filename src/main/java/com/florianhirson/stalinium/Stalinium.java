package com.florianhirson.stalinium;

import com.florianhirson.stalinium.proxy.IProxy;
import com.florianhirson.stalinium.tabs.StaliniumTab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Stalinium.MODID, name = Stalinium.NAME, version = Stalinium.VERSION, acceptedMinecraftVersions = Stalinium.MC_VERSION)
public class Stalinium {

    public static final String MODID = "stalinium";
    public static final String NAME = "Stalinium Mod";
    public static final String VERSION = "0.0.1";
    public static final String MC_VERSION = "[1.12.2]";

    public static final Logger LOGGER =  LogManager.getLogger(Stalinium.MODID);

    public static final String CLIENT = "com.florianhirson.stalinium.proxy.ClientProxy";
    public static final String SERVER = "com.florianhirson.stalinium.proxy.ServerProxy";

    @SidedProxy(clientSide = Stalinium.CLIENT, serverSide = Stalinium.SERVER)
    public static IProxy proxy;

    public static final CreativeTabs STALINIUM_TAB = new StaliniumTab();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        LOGGER.info(Stalinium.NAME + "says hi!");
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
