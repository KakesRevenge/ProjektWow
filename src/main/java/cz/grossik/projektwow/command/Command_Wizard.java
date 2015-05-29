package cz.grossik.projektwow.command;

import java.io.File;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.common.config.Configuration;
import cz.grossik.projektwow.ProjektWow;

public class Command_Wizard extends CommandBase
{	
    public String getCommandName()
    {
        return "wizard";
    }
    @Override
    public int getRequiredPermissionLevel()
    {
        return 0;
    }
    
    public String getCommandUsage(ICommandSender par1ICommandSender)
    {
        return "/wizard";
    }
    public void processCommand(ICommandSender par1ICommandSender, String[] par2ArrayOfStr)
    {
    	EntityPlayer var3 = getCommandSenderAsPlayer(par1ICommandSender);
        String name = var3.getCommandSenderName();
        
        if(ProjektWow.player_class.getString() == ProjektWow.Warrior || ProjektWow.player_class.getString() == ProjektWow.Thief)
        {
    	    var3.addChatComponentMessage(new ChatComponentTranslation("uz_si_za_jinou_tridu"));
        }
        else if(ProjektWow.player_class.getString() == ProjektWow.Wizard)
        {
        	var3.addChatComponentMessage(new ChatComponentTranslation("uz_si_za_wizard"));
        }
        else
        {
            ProjektWow.config.load();    
            ProjektWow.player_class = ProjektWow.config.get(name, "Class", ProjektWow.Wizard).setValue(ProjektWow.Wizard);
            ProjektWow.config.save();
    	    var3.addChatComponentMessage(new ChatComponentTranslation("pridal_ses_k_wizard"));
        }
    }
}      