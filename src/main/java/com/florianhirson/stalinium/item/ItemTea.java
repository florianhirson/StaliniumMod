package com.florianhirson.stalinium.item;

import com.florianhirson.stalinium.Stalinium;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemTea extends Item {

    public ItemTea(String unlocalizedName, String registryName) {
        setCreativeTab(Stalinium.STALINIUM_TAB);
        setRegistryName(registryName);
        setTranslationKey(Stalinium.MODID + "." + unlocalizedName);
    }
}
