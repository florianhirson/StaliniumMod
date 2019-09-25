package com.florianhirson.stalinium.lib;

import com.florianhirson.stalinium.Stalinium;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static com.florianhirson.stalinium.util.YeetUtils.RL;

@Mod.EventBusSubscriber
@GameRegistry.ObjectHolder(Stalinium.MODID)
public class Sounds {
    @GameRegistry.ObjectHolder("yeet_gun")
    public static final SoundEvent YEET_SOUND = null;


    @SubscribeEvent
    public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
        event.getRegistry().registerAll(
                buildSound("yeet_gun")
        );
    }

    private static SoundEvent buildSound(String key) {
        return new SoundEvent(RL(key)).setRegistryName(key);
    }
}
