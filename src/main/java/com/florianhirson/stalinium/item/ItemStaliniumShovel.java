package com.florianhirson.stalinium.item;

import com.florianhirson.stalinium.Stalinium;
import net.minecraft.item.ItemSpade;

public class ItemStaliniumShovel extends ItemSpade {

    public ItemStaliniumShovel(ToolMaterial material, String unlocalizedName, String registryName) {
        super(material);
        setCreativeTab(Stalinium.STALINIUM_TAB);

        setTranslationKey(Stalinium.MODID + "." + unlocalizedName);
        setRegistryName(registryName);
    }
}
