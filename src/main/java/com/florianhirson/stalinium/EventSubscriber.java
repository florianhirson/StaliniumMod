package com.florianhirson.stalinium;

import com.florianhirson.stalinium.block.BlockStalinium;
import com.florianhirson.stalinium.init.ModBlocks;
import com.florianhirson.stalinium.item.*;
import com.florianhirson.stalinium.material.StaliniumMaterials;
import net.minecraft.block.Block;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.awt.*;

@EventBusSubscriber(modid = Stalinium.MODID)
public final class EventSubscriber {

    @SubscribeEvent
    public static void registerBlocks(Register<Block> event) {
        final Block[] blocks = {
                new BlockStalinium("blockStalinium", "block_stalinium"),
        };

        event.getRegistry().registerAll(blocks);
    }

    @SubscribeEvent
    public static void registerItems(Register<Item> event) {
        final Item[] items = {
                new ItemStaliniumIngot("itemStaliniumIngot", "item_stalinium_ingot"),
                new ItemTea("itemTea", "item_tea"),

                new ItemStaliniumPickaxe(StaliniumMaterials.STALINIUM_TOOL, "itemStaliniumPickaxe", "item_stalinium_pickaxe"),
                new ItemStaliniumAxe(StaliniumMaterials.STALINIUM_TOOL, "itemStaliniumAxe", "item_stalinium_axe"),
                new ItemStaliniumShovel(StaliniumMaterials.STALINIUM_TOOL, "itemStaliniumShovel", "item_stalinium_shovel"),
                new ItemStaliniumHoe(StaliniumMaterials.STALINIUM_TOOL, "itemStaliniumHoe", "item_stalinium_hoe"),
                new ItemStaliniumSword(StaliniumMaterials.STALINIUM_TOOL, "itemStaliniumSword", "item_stalinium_sword"),

                new ItemStaliniumArmor(StaliniumMaterials.STALINIUM_ARMOR, EntityEquipmentSlot.HEAD, "itemStaliniumHelmet", "item_stalinium_helmet"),
                new ItemStaliniumArmor(StaliniumMaterials.STALINIUM_ARMOR, EntityEquipmentSlot.CHEST, "itemStaliniumChestplate", "item_stalinium_chestplate"),
                new ItemStaliniumArmor(StaliniumMaterials.STALINIUM_ARMOR, EntityEquipmentSlot.LEGS, "itemStaliniumLeggings", "item_stalinium_leggings"),
                new ItemStaliniumArmor(StaliniumMaterials.STALINIUM_ARMOR, EntityEquipmentSlot.FEET, "itemStaliniumBoots", "item_stalinium_boots")
        };

        final Item[] itemBlocks = {
                new ItemBlock(ModBlocks.BLOCK_STALINIUM).setRegistryName(ModBlocks.BLOCK_STALINIUM.getRegistryName()),
        };

        event.getRegistry().registerAll(items);
        event.getRegistry().registerAll(itemBlocks);
    }

}
