package com.florianhirson.stalinium.item;

import com.florianhirson.stalinium.Stalinium;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ItemStaliniumArmor extends ItemArmor {

    public ItemStaliniumArmor(ItemArmor.ArmorMaterial material, EntityEquipmentSlot equipmentSlot, String unlocalizedName, String registryName) {
        super(material, 0, equipmentSlot);

        setTranslationKey(Stalinium.MODID + "." + unlocalizedName);
        setRegistryName(registryName);
        setCreativeTab(Stalinium.STALINIUM_TAB);
    }
}
