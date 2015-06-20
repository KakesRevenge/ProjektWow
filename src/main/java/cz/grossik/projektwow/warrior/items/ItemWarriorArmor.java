package cz.grossik.projektwow.warrior.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import cz.grossik.projektwow.Reference;
import cz.grossik.projektwow.handler.PlayerClassHandler;
import cz.grossik.projektwow.utils.LogHelper;

/** @Autor Grossik 
 */
public class ItemWarriorArmor extends ItemArmor {


	public ItemWarriorArmor(ItemArmor.ArmorMaterial ArmorMaterial, int int1, int int2) {
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
    	if(entity instanceof EntityPlayer) {
    		EntityPlayer player = (EntityPlayer)entity;
            PlayerClassHandler props = PlayerClassHandler.get(player);
            int playerclass = props.CurrentClass;
          
            if(playerclass == Reference.Warrior) {
            	System.out.println("TRUE");
                return true;
            } else if (playerclass != Reference.Warrior) {
            	player.addChatComponentMessage(new ChatComponentText("You need to be a warrior"));
            }
        	LogHelper.info(playerclass);
    	}
		return true;
    }
    
    @Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
    	if(this.isValidArmor(itemstack, armorType, player) == true) {
    		this.UseItem(itemstack, world, player);
    	}
    	return itemstack;
    }
}
