package com.florianhirson.stalinium.tabs;

import com.florianhirson.stalinium.Stalinium;
import com.florianhirson.stalinium.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class StaliniumTab extends CreativeTabs {

    public StaliniumTab() {
        super(Stalinium.MODID);
    }


    @SideOnly(Side.CLIENT)
    @Override
    public ItemStack createIcon() {
        return new ItemStack(ModItems.ITEM_STALINIUM_INGOT);
    }
}
