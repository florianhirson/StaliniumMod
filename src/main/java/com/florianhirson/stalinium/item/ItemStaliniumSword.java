package com.florianhirson.stalinium.item;

import com.florianhirson.stalinium.Stalinium;
import net.minecraft.item.ItemSword;

public class ItemStaliniumSword extends ItemSword {

    public ItemStaliniumSword(ToolMaterial material, String unlocalizedName, String registryName) {
        super(material);
        setCreativeTab(Stalinium.STALINIUM_TAB);

        setTranslationKey(Stalinium.MODID + "." + unlocalizedName);
        setRegistryName(registryName);
    }
}
