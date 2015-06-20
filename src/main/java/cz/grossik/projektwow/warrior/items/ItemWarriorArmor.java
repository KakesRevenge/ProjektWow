package cz.grossik.projektwow.warrior.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import cz.grossik.projektwow.ProjektWow;
import cz.grossik.projektwow.Reference;
import cz.grossik.projektwow.handler.PlayerClassHandler;
import cz.grossik.projektwow.handler.WoWEventHandler;

/** @Autor Grossik 
 */
public class ItemWarriorArmor extends ItemArmor {


	public ItemWarriorArmor(ItemArmor.ArmorMaterial ArmorMaterial, int int1, int int2) 
	{
		super(ArmorMaterial, int1, int2);
	}

    
    public ItemStack UseItem(ItemStack itemstack, World world, EntityPlayer player)
    {
        int i = EntityLiving.getArmorPosition(itemstack) - 1;
        ItemStack itemstack1 = player.getCurrentArmor(i);

        if (itemstack1 == null)
        {
            player.setCurrentItemOrArmor(i + 1, itemstack.copy()); 
            itemstack.stackSize = 0;
        }

        return itemstack;
    }
    
    @Override
    public boolean isValidArmor(ItemStack stack, int armorType, Entity entity)
    {
    	if(entity instanceof EntityPlayer) {
   		 EntityPlayer player = (EntityPlayer)entity;
        PlayerClassHandler props = PlayerClassHandler.get(player);

        int playerclass = props.CurrentClass;
  
        switch(playerclass) {
        case Reference.Warrior:
            return true;  
		case Reference.Unset:
            player.addChatComponentMessage(new ChatComponentTranslation("Musis byt Warrior"));
            break;
        case Reference.Thief:
            player.addChatComponentMessage(new ChatComponentTranslation("Musis byt Warrior"));
            break;
        case Reference.Wizard:
            player.addChatComponentMessage(new ChatComponentTranslation("Musis byt Warrior"));
            break;
        	}
         }
    	return false;
    }
    
    @Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
    {
        PlayerClassHandler props = PlayerClassHandler.get(player);
        int playerclass = props.CurrentClass;
  
        switch(playerclass) {
        case Reference.Warrior:
    	    return this.UseItem(itemstack, world, player);
            break;
		case Reference.Unset:
            player.addChatComponentMessage(new ChatComponentTranslation("Musis byt Warrior"));
            break;
        case Reference.Thief:
            player.addChatComponentMessage(new ChatComponentTranslation("Musis byt Warrior"));
            break;
        case Reference.Wizard:
            player.addChatComponentMessage(new ChatComponentTranslation("Musis byt Warrior"));
            break;
      }
		return itemstack;
    }
}
