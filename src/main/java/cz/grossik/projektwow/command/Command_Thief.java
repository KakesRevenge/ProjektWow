package cz.grossik.projektwow.command;

import javax.security.auth.login.Configuration;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import cz.grossik.projektwow.ProjektWow;

public class Command_Thief extends CommandBase {

    public String getCommandName() {
        return "thief";
    }

    public String getCommandUsage(ICommandSender par1ICommandSender) {
        return "/thief";
    }
    
    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }
    
    public void processCommand(ICommandSender sender, String[] par2ArrayOfStr) {
     	EntityPlayer player = getCommandSenderAsPlayer(sender);
        String name = player.getCommandSenderName();
        
        if(ProjektWow.player_class.getString() == ProjektWow.Warrior || ProjektWow.player_class.getString() == ProjektWow.Wizard) {
        	player.addChatComponentMessage(new ChatComponentTranslation("uz_si_za_jinou_tridu"));
        } else if(ProjektWow.player_class.getString() == ProjektWow.Thief) {
        	player.addChatComponentMessage(new ChatComponentTranslation("uz_si_za_thief"));
        } else {
            ProjektWow.config.load();    
            ProjektWow.player_class = ProjektWow.config.get(name, "Class", ProjektWow.Thief).setValue(ProjektWow.Thief);
            ProjektWow.config.save();
            player.addChatComponentMessage(new ChatComponentTranslation("pridal_ses_k_thief"));
            player.inventory.addItemStackToInventory(new ItemStack(Items.apple));  
    	}
    }   
}