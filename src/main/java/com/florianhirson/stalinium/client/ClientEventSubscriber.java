package com.florianhirson.stalinium.client;

import com.florianhirson.stalinium.Stalinium;
import com.florianhirson.stalinium.init.ModBlocks;
import com.florianhirson.stalinium.init.ModItems;
import com.florianhirson.stalinium.material.StaliniumMaterials;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@Mod.EventBusSubscriber(modid = Stalinium.MODID, value = Side.CLIENT)

public final class ClientEventSubscriber {

    public static final Logger LOGGER =  LogManager.getLogger(Stalinium.MODID);

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        registerModel(ModItems.ITEM_STALINIUM_INGOT);
        registerModel(ModItems.ITEM_TEA);

        registerModel(ModItems.ITEM_STALINIUM_PICKAXE);
        registerModel(ModItems.ITEM_STALINIUM_AXE);
        registerModel(ModItems.ITEM_STALINIUM_SHOVEL);
        registerModel(ModItems.ITEM_STALINIUM_SWORD);
        registerModel(ModItems.ITEM_STALINIUM_HOE);

        registerModel(ModItems.ITEM_STALINIUM_HELMET);
        registerModel(ModItems.ITEM_STALINIUM_CHESTPLATE);
        registerModel(ModItems.ITEM_STALINIUM_LEGGINGS);
        registerModel(ModItems.ITEM_STALINIUM_BOOTS);

        registerModel(Item.getItemFromBlock(ModBlocks.BLOCK_STALINIUM));
    }

    private static void registerModel(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void onFogColorRender(EntityViewRenderEvent.FogColors event){

        if(event.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntity();

            List<ItemStack> armor  = (List<ItemStack>) player.getArmorInventoryList();
            boolean wearStaliniumArmor = true;

            for (ItemStack item : armor) {
                if(item.getItem() instanceof ItemArmor) {
                    ItemArmor itemArmor = (ItemArmor) item.getItem();
                    if(!itemArmor.getArmorMaterial().equals(StaliniumMaterials.STALINIUM_ARMOR)) {
                        wearStaliniumArmor = false;
                    }
                } else {
                    wearStaliniumArmor = false;
                }

            }

            if(wearStaliniumArmor) {
                event.setRed(255);
                event.setGreen(0);
                event.setBlue(0);
            }


        }

    }


}

