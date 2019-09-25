package com.florianhirson.stalinium.item;

import com.florianhirson.stalinium.Stalinium;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemStaliniumIngot extends Item {

    public ItemStaliniumIngot(String unlocalizedName, String registryName) {
        setTranslationKey(Stalinium.MODID + "." + unlocalizedName);
        setRegistryName(registryName);
        setCreativeTab(Stalinium.STALINIUM_TAB);
    }
}
