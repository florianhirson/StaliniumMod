package com.florianhirson.stalinium.item;

import com.florianhirson.stalinium.Stalinium;
import com.florianhirson.stalinium.entity.EntityYeet;
import com.florianhirson.stalinium.lib.Sounds;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ItemYeetGun extends Item {

    public ItemYeetGun(String unlocalizedName, String registryName) {
        setTranslationKey(Stalinium.MODID + "." + unlocalizedName);
        setRegistryName(registryName);
        setCreativeTab(Stalinium.STALINIUM_TAB);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {

        ItemStack iStack = playerIn.getHeldItem(handIn);


        double factor = 5;
        worldIn.playSound(playerIn.posX, playerIn.posY, playerIn.posZ, Sounds.YEET_SOUND, SoundCategory.PLAYERS, 1.0F, 0.7F + (float) factor * 0.2F, false);
        EntityYeet vortex = new EntityYeet(worldIn, playerIn);
        Vec3d directionVec = playerIn.getLookVec().normalize();
        vortex.posX += directionVec.x;
        vortex.posY += directionVec.y;
        vortex.posZ += directionVec.z;
        vortex.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 0.0F);
        vortex.motionX *= factor;
        vortex.motionY *= factor;
        vortex.motionZ *= factor;
        if (!worldIn.isRemote) worldIn.spawnEntity(vortex);


        return ActionResult.newResult(EnumActionResult.SUCCESS, iStack);
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return false;
    }
}
