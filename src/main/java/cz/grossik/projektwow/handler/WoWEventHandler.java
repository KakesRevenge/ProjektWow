package cz.grossik.projektwow.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.NameFormat;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cz.grossik.projektwow.help.Reference;

/**
@Author KakesRevenge
 */

public class WoWEventHandler {
	
	@SubscribeEvent
	public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
		NBTTagCompound playerData = event.player.getEntityData();
    	PlayerClassHandler props = PlayerClassHandler.get(event.player);
		if (!playerData.hasKey("")) {
    		props.CurrentClass = Reference.Unset;
        	playerData.setBoolean("itemGiven", true);
    	}
	}
	
	@SubscribeEvent
	public void LivingHurt(LivingHurtEvent event) {
		if(event.entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)event.entityLiving;
			ItemStack stack = player.getHeldItem();
			//if(event.source.getSourceOfDamage() instanceof EntityZombie) {
			if(stack != null && stack.getItem() == ItemHandler.Shield && player.isUsingItem() == true) {
				event.ammount = event.ammount - 1;
		    }
		}
	}
	
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event) {
		if (event.entity instanceof EntityPlayer && PlayerClassHandler.get((EntityPlayer) event.entity) == null)
			PlayerClassHandler.register((EntityPlayer) event.entity);
		if (event.entity instanceof EntityPlayer && event.entity.getExtendedProperties(PlayerClassHandler.Name) == null)
			event.entity.registerExtendedProperties(PlayerClassHandler.getPropertyName(), new PlayerClassHandler((EntityPlayer) event.entity));
	}
	
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
    public void NamingPlayers(NameFormat event) {
		PlayerClassHandler props = PlayerClassHandler.get(event.entityPlayer);
		int playerclass = props.CurrentClass;
		
		switch(playerclass) {
		case Reference.Warrior:
			event.displayname = Reference.WarriorName + event.username;
			break;
		case Reference.Thief:
			event.displayname = Reference.ThiefName + event.username;
			break;
		case Reference.Wizard:
			event.displayname = Reference.WizardName + event.username;
			break;
		}
	}
}
