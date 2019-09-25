package com.florianhirson.stalinium.block;

import com.florianhirson.stalinium.Stalinium;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockStalinium extends Block {

    public BlockStalinium(String unlocalizedName, String registryName) {
        super(Material.ROCK);
        setCreativeTab(Stalinium.STALINIUM_TAB);
        setSoundType(SoundType.STONE);
        setTranslationKey(Stalinium.MODID + "." + unlocalizedName);
        setRegistryName(registryName);
    }

}