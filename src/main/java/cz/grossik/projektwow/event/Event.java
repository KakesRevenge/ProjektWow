package cz.grossik.projektwow.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cz.grossik.projektwow.ProjektWow;
import cz.grossik.projektwow.items.ItemHandler;

public class Event extends Thread {
	
	@SubscribeEvent
	public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        String name = event.player.getCommandSenderName();
        NBTTagCompound playerData = event.player.getEntityData();
    	
        if (!playerData.hasKey("firstLogin")) {
         ProjektWow.config.load();
         ProjektWow.player_class = ProjektWow.config.get(name, "Class", ProjektWow.nul);
         ProjektWow.player_name = ProjektWow.config.get(name, "Player", name);
         playerData.setBoolean("firstLogin", true); 
    	 ProjektWow.config.save();
        }
	}
	
	@SubscribeEvent
	public void LivingHurt(LivingHurtEvent event) {
		if(event.entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)event.entityLiving;
			if(player.getCurrentEquippedItem() == new ItemStack(ItemHandler.Shield)) {
				event.ammount = 0F;
			}
		}
	}
 }