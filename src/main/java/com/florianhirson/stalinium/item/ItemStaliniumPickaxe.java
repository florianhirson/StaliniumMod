package com.florianhirson.stalinium.item;

import com.florianhirson.stalinium.Stalinium;
import net.minecraft.item.ItemPickaxe;

public class ItemStaliniumPickaxe extends ItemPickaxe {

    public ItemStaliniumPickaxe(ToolMaterial material, String unlocalizedName, String registryName) {
        super(material);
        setCreativeTab(Stalinium.STALINIUM_TAB);

        setTranslationKey(Stalinium.MODID + "." + unlocalizedName);
        setRegistryName(registryName);
    }
}
