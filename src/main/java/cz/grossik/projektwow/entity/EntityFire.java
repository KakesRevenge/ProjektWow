package cz.grossik.projektwow.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


/**
@Autor Grossik 
Edited by KakesRevenge
 */

public class EntityFire extends EntityFireball {
	
    public int field_92057_e = 1;

    public EntityFire(World world) {
        super(world);
    }

	public EntityFire(World par1World, EntityLivingBase par2EntityLivingBase, double posX, double posY, double posZ, double vX, double vY, double vZ) {
        super(par1World, par2EntityLivingBase, vX, vY, vZ);
        this.setPosition(posX, posY, posZ);
        Double d3 = (double)MathHelper.sqrt_double(vX * vX + vY * vY + vZ * vZ);
        this.accelerationX = vX / d3 * 0.1D;
        this.accelerationY = vY / d3 * 0.1D;
        this.accelerationZ = vZ / d3 * 0.1D;
    }
	
    @SideOnly(Side.CLIENT)
    public EntityFire(World world, double par2, double par3, double par4, double par5, double par6, double par7) {
        super(world, par2, par3, par4, par5, par6, par7);
    }

    public EntityFire(World world, EntityLivingBase EntityLiving, double par3, double par4, double par5) {
        super(world, EntityLiving, par3, par4, par5);
    }
    
    protected void onImpact(MovingObjectPosition MovObjPos) {
        if (!this.worldObj.isRemote) {
            if (MovObjPos.entityHit != null) {
            	MovObjPos.entityHit.attackEntityFrom(DamageSource.causeFireballDamage(this, this.shootingEntity), 6.0F);
            	MovObjPos.entityHit.setFire(100);
            }
            this.setDead();
        }
    }

    public void writeEntityToNBT(NBTTagCompound NBTTagCompound) {
        super.writeEntityToNBT(NBTTagCompound);
        NBTTagCompound.setInteger("ExplosionPower", this.field_92057_e);
    }

    public void readEntityFromNBT(NBTTagCompound NBTTagCompound) {
        super.readEntityFromNBT(NBTTagCompound);
        
        if (NBTTagCompound.hasKey("ExplosionPower", 99)) {
            this.field_92057_e = NBTTagCompound.getInteger("ExplosionPower");
        }
    }
}