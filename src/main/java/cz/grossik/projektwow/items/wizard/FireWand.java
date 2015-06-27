package cz.grossik.projektwow.items.wizard;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import cz.grossik.projektwow.entity.EntityFire;
import cz.grossik.projektwow.handler.ItemHandler;

/**
@Autor Grossik 
 */

public class FireWand extends WandBase  {

	public static int cooldown = 72000; 
	public static int defaultCharges = 64;
	
	public FireWand() {
		super();
        this.setMaxDamage(defaultCharges + 1);
	}
	
	@Override 
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
	{		
		return cooldown;
	}

	@Override 
	public void onPlayerStoppedUsing (ItemStack srcItemStack, World world, EntityPlayer playerEntity, int timeRemain)
	{       
        int j = this.getMaxItemUseDuration(srcItemStack) - timeRemain;

        ArrowLooseEvent event = new ArrowLooseEvent(playerEntity, srcItemStack, j);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return;
        }
        
		EntityFire entityFire = new EntityFire(world);
        if (!world.isRemote)
        {
	       	double vecX = (double)(-MathHelper.sin(playerEntity.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(playerEntity.rotationPitch / 180.0F * (float)Math.PI));
	       	double vecY = (double)(-MathHelper.sin(playerEntity.rotationPitch / 180.0F * (float)Math.PI));
	       	double vecZ = (double)( MathHelper.cos(playerEntity.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(playerEntity.rotationPitch / 180.0F * (float)Math.PI));    	
	        double deltaX = (double)(-MathHelper.sin(playerEntity.rotationYaw / 180.0F * (float)Math.PI));
	       	double deltaZ = (double)( MathHelper.cos(playerEntity.rotationYaw / 180.0F * (float)Math.PI)); 	
	        world.spawnEntityInWorld(new EntityFire(world,playerEntity, playerEntity.posX+deltaX,playerEntity.posY+1,playerEntity.posZ+deltaZ,  vecX, vecY, vecZ));        }        
	}
	
	@Override
	public ItemStack onEaten (ItemStack srcItemStack, World world, EntityPlayer playerEntity)
	{      
	    return srcItemStack;
    }
	
	@Override
	public ItemStack onItemRightClick(ItemStack srcItemStack, World world, EntityPlayer playerEntity)
	{
        ArrowNockEvent event = new ArrowNockEvent(playerEntity, srcItemStack);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return event.result;
        }
        
        if (playerEntity.capabilities.isCreativeMode || playerEntity.inventory.hasItem(ItemHandler.Wand))
        {
        playerEntity.setItemInUse(srcItemStack, this.getMaxItemUseDuration(srcItemStack));
	    }
        return srcItemStack;
	 }

	@Override 
	public boolean onItemUse(ItemStack srcItemStack, EntityPlayer playerEntity, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		return super.onItemUse(srcItemStack, playerEntity, world, par4, par5, par6, par7, par8, par9, par10);
	}
}