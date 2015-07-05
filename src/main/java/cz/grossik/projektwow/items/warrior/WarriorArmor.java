package cz.grossik.projektwow.items.warrior;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import cz.grossik.projektwow.handler.PlayerClassHandler;
import cz.grossik.projektwow.help.LogHelper;
import cz.grossik.projektwow.help.Reference;

/**
@Autor Grossik 
 */

public class WarriorArmor extends ItemArmor {


	public WarriorArmor(ItemArmor.ArmorMaterial ArmorMaterial, int int1, int int2) {
		super(ArmorMaterial, int1, int2);
	}

    
    public ItemStack UseItem(ItemStack itemstack, World world, EntityPlayer player) {
        int i = EntityLiving.getArmorPosition(itemstack) - 1;
        ItemStack itemstack1 = player.getCurrentArmor(i);
        if (itemstack1 == null) {
            player.setCurrentItemOrArmor(i + 1, itemstack.copy()); 
            itemstack.stackSize = 0;
        }
        return itemstack;
    }
    
    @Override
    public boolean isValidArmor(ItemStack stack, int armorType, Entity entity){
    		EntityPlayer player = (EntityPlayer)entity;
    		PlayerClassHandler props = PlayerClassHandler.get(player);
    		int playerclass = props.CurrentClass;
          
            switch(playerclass) {
            case Reference.Warrior:
            	player.addChatComponentMessage(new ChatComponentText("Warrior"));
                break;
            case Reference.Unset:
            	player.addChatComponentMessage(new ChatComponentText("Unset"));
                break;
            }
            /*if(playerclass == Reference.Warrior) {
            	System.out.println("TRUE");
                return true;
            }
            if (playerclass != Reference.Warrior) {
            	System.out.println("FALSE");
            	player.addChatComponentMessage(new ChatComponentText("You need to be a warrior"));
            	return false;
            }*/
        	LogHelper.info(playerclass);
    	return false;
    }
    
    
    @Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
        
    	int i = EntityLiving.getArmorPosition(itemstack) - 1;
        ItemStack itemstack1 = player.getCurrentArmor(i);

        if (itemstack1 == null)
        {
            player.setCurrentItemOrArmor(i + 1, itemstack.copy());
            itemstack.stackSize = 0;
        }
    	return itemstack;
    }
}
