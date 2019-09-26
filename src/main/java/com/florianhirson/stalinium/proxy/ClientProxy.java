package com.florianhirson.stalinium.proxy;

import com.florianhirson.stalinium.Stalinium;
import com.florianhirson.stalinium.entity.EntityYeet;
import com.florianhirson.stalinium.render.RenderEntityYeet;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClientProxy implements IProxy {

    public static final Logger LOGGER =  LogManager.getLogger(Stalinium.MODID);

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        LOGGER.info(Stalinium.NAME + "Client proxy pre init");

        RenderingRegistry.registerEntityRenderingHandler(EntityYeet.class, RenderEntityYeet.FACTORY);
    }

    @Override
    public void init(FMLInitializationEvent event) {

    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }

}
