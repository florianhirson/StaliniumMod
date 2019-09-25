package com.florianhirson.stalinium.item;

import com.florianhirson.stalinium.Stalinium;
import net.minecraft.item.ItemAxe;

public class ItemStaliniumAxe extends ItemAxe {

    public ItemStaliniumAxe(ToolMaterial material, float damage, float speed, String unlocalizedName, String registryName) {
        super(material, damage, speed);

        setTranslationKey(Stalinium.MODID + "." + unlocalizedName);
        setRegistryName(registryName);

        setCreativeTab(Stalinium.STALINIUM_TAB);
    }

    public ItemStaliniumAxe(ToolMaterial material, String unlocalizedName, String registryName) {
        this(material, 69.0F, -3.1F, unlocalizedName, registryName);
    }
}
