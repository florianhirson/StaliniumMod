package com.florianhirson.stalinium.entity;

import com.florianhirson.stalinium.Stalinium;
import net.minecraft.entity.Entity;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.registries.IForgeRegistry;

import static com.florianhirson.stalinium.util.YeetUtils.RL;

@Mod.EventBusSubscriber
public class EntityRegistrator {
    private static int ID = 1;

    @SubscribeEvent
    public static void onEntityRegister(RegistryEvent.Register<EntityEntry> event) {
        IForgeRegistry<EntityEntry> r = event.getRegistry();
        registerEntity(r, EntityYeet.class, "yeet", "Yeet", 80, 1, true);
    }

    private static void registerEntity(IForgeRegistry<EntityEntry> reg, Class<? extends Entity> cls, String id, String name, int range, int freq, boolean sendVelocityUpdates) {
        reg.register(EntityEntryBuilder.create()
                .entity(cls)
                .id(RL(id), ID++)
                .name(name)
                .tracker(range, freq, sendVelocityUpdates)
                .build());
    }
}
