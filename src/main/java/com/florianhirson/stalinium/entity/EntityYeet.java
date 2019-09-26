package com.florianhirson.stalinium.entity;

import com.florianhirson.stalinium.util.YeetUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.IShearable;

import java.util.List;

public class EntityYeet extends EntityThrowable {

    private int hitCounter = 0;

    // clientside: rendering X offset of vortex, depends on which hand the vortex was fired from
    private float renderOffsetX = -Float.MAX_VALUE;

    public EntityYeet(World world) {
        super(world);
    }

    public EntityYeet(World world, EntityLivingBase thrower) {
        super(world, thrower);
    }

    public EntityYeet(World world, double par2, double par4, double par6) {
        super(world, par2, par4, par6);
    }

    @Override
    protected void entityInit() {
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        motionX *= 5; // equal to the potion effect friction. 0.95F
        motionY *= 5;
        motionZ *= 5;
        if (motionX * motionX + motionY * motionY + motionZ * motionZ < 0.1D) {
            setDead();
        }
    }

    public boolean hasRenderOffsetX() {
        return renderOffsetX > -Float.MAX_VALUE;
    }

    public float getRenderOffsetX() {
        return renderOffsetX;
    }

    public void setRenderOffsetX(float renderOffsetX) {
        this.renderOffsetX = renderOffsetX;
    }

    private boolean tryCutPlants(BlockPos pos) {
        Block block = world.getBlockState(pos).getBlock();
        if (block instanceof IPlantable || block instanceof BlockLeaves) {
            world.destroyBlock(pos, true);
            return true;
        }
        return false;
    }

    @Override
    public float getGravityVelocity() {
        return 0;
    }

    @Override
    protected void onImpact(RayTraceResult objectPosition) {
        if (objectPosition.entityHit != null) {
            Entity entity = objectPosition.entityHit;
            entity.motionX += motionX;
            entity.motionY += motionY;
            entity.motionZ += motionZ;
            if (!entity.world.isRemote && entity instanceof IShearable) {
                IShearable shearable = (IShearable) entity;
                BlockPos pos = new BlockPos(posX, posY, posZ);
                if (shearable.isShearable(ItemStack.EMPTY, world, pos)) {
                    List<ItemStack> drops = shearable.onSheared(ItemStack.EMPTY, world, pos, 0);
                    for (ItemStack stack : drops) {
                        YeetUtils.dropItemOnGround(stack, world, entity.posX, entity.posY, entity.posZ);
                    }
                }
            }
        } else {
            Block block = world.getBlockState(objectPosition.getBlockPos()).getBlock();
            if (block instanceof IPlantable || block instanceof BlockLeaves) {
                if (!world.isRemote) {
                    BlockPos pos = objectPosition.getBlockPos();
                    BlockPos.MutableBlockPos mPos = new BlockPos.MutableBlockPos(pos);
                    if (tryCutPlants(pos)) {
                        int plantsCut = 1;
                        for (int x = -1; x <= 1; x++) {
                            for (int y = -1; y <= 1; y++) {
                                for (int z = -1; z <= 1; z++) {
                                    if (x == 0 && y == 0 && z == 0) continue;
                                    mPos.setPos(pos.getX() + x, pos.getY() + y, pos.getZ() + z);
                                    if (tryCutPlants(mPos)) plantsCut++;
                                }
                            }
                        }
                        // slow the vortex down for each plant it broke
                        double mult = Math.pow(0.8D, plantsCut);
                        motionX *= mult;
                        motionY *= mult;
                        motionZ *= mult;
                    }
                }
            } else {
                setDead();
            }
        }
        hitCounter++;
        if (hitCounter > 20) setDead();
    }
}
