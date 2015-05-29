package cz.grossik.projektwow.warrior.items;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import cz.grossik.projektwow.ProjektWow;
import cz.grossik.projektwow.items.ItemHandler;
import cz.grossik.projektwow.warrior.entity.EntityWoodenSpear;

public class Item_WoodenSpear extends Item{

	public Item_WoodenSpear()
	{
		this.setMaxStackSize(10);
	}
	
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack)
	{
		if (entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entityLiving;
			
		String name = player.getCommandSenderName();
		EntityWoodenSpear entityarrow = new EntityWoodenSpear(entityLiving.worldObj, entityLiving, 2.0F);
		
          if (!entityLiving.worldObj.isRemote)
          { 
        	if(ProjektWow.player_class.getString() == ProjektWow.Warrior)
      	    {
        	 player.inventory.consumeInventoryItem(ItemHandler.WoodenSpear);
        	 entityLiving.worldObj.spawnEntityInWorld(entityarrow);
	        }
            else
            {
        	    player.addChatComponentMessage(new ChatComponentTranslation("musis_byt_warrior"));
            }
	      }
	}
	return false;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
	{
		return itemstack; 
	}
}