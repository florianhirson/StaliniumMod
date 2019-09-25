package com.florianhirson.stalinium.util;

import com.florianhirson.stalinium.Stalinium;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class YeetUtils {

	public static void dropItemOnGround(ItemStack stack, World world, double x, double y, double z) {
		float dX = world.rand.nextFloat() * 0.8F + 0.1F;
		float dY = world.rand.nextFloat() * 0.8F + 0.1F;
		float dZ = world.rand.nextFloat() * 0.8F + 0.1F;

		EntityItem entityItem = new EntityItem(world, x + dX, y + dY, z + dZ, new ItemStack(stack.getItem(), stack.getCount(), stack.getItemDamage()));

		if (stack.hasTagCompound()) {
			entityItem.getItem().setTagCompound(stack.getTagCompound().copy());
		}

		float factor = 0.05F;
		entityItem.motionX = world.rand.nextGaussian() * factor;
		entityItem.motionY = world.rand.nextGaussian() * factor + 0.2F;
		entityItem.motionZ = world.rand.nextGaussian() * factor;
		world.spawnEntity(entityItem);
		stack.setCount(0);
	}

	/**
	 * Get a resource location with the domain of PneumaticCraft: Repressurized's mod ID.
	 *
	 * @param path the path
	 * @return a mod-specific ResourceLocation for the given path
	 */
	public static ResourceLocation RL(String path) {
		return new ResourceLocation(Stalinium.MODID, path);
	}
}
