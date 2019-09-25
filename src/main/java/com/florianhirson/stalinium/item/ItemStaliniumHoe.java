package com.florianhirson.stalinium.item;

import com.florianhirson.stalinium.Stalinium;
import net.minecraft.item.ItemHoe;

public class ItemStaliniumHoe extends ItemHoe {

    public ItemStaliniumHoe(ToolMaterial material, String unlocalizedName, String registryName) {
        super(material);
        setCreativeTab(Stalinium.STALINIUM_TAB);

        setTranslationKey(Stalinium.MODID + "." + unlocalizedName);
        setRegistryName(registryName);
    }
}
