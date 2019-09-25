package com.florianhirson.stalinium.material;

import com.florianhirson.stalinium.Stalinium;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class StaliniumMaterials {

    public static final Item.ToolMaterial STALINIUM_TOOL = EnumHelper.addToolMaterial(Stalinium.MODID+ ":" + "stalinium_tool", 3, 9000, 69, 420, 23);

    public static final ItemArmor.ArmorMaterial STALINIUM_ARMOR = EnumHelper.addArmorMaterial(Stalinium.MODID + ":stalinium_armor", Stalinium.MODID + ":stalinium", 9000, new int[]{9, 9, 9, 9}, 23, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 69);

}
