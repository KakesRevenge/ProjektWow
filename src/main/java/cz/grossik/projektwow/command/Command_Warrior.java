package cz.grossik.projektwow.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;
import cz.grossik.projektwow.ProjektWow;

public class Command_Warrior extends CommandBase
{			
	public String getCommandName()
    {
        return "warrior";
    }

    public String getCommandUsage(ICommandSender par1ICommandSender)
    {
        return "/warrior";
    }
    public void processCommand(ICommandSender par1ICommandSender, String[] par2ArrayOfStr)
    {   
		EntityPlayer var3 = par2ArrayOfStr.length >= 2 ? getPlayer(par1ICommandSender, par2ArrayOfStr[1]) : getCommandSenderAsPlayer(par1ICommandSender);
        String name = var3.getCommandSenderName();
        
        if(ProjektWow.player_class.getString() == ProjektWow.Wizard || ProjektWow.player_class.getString() == ProjektWow.Thief)
        {
    	    var3.addChatComponentMessage(new ChatComponentTranslation("uz_si_za_jinou_tridu"));
        }
        else if(ProjektWow.player_class.getString() == ProjektWow.Warrior)
        {
        	var3.addChatComponentMessage(new ChatComponentTranslation("uz_si_za_warrior"));
        }
        else
        {
        ProjektWow.config.load();
        ProjektWow.player_class = ProjektWow.config.get(name, "Class", ProjektWow.Warrior).setValue(ProjektWow.Warrior);
        ProjektWow.config.save();
	    var3.addChatComponentMessage(new ChatComponentTranslation("pridal_ses_k_warrior"));
	    var3.inventory.addItemStackToInventory(new ItemStack(Items.stone_sword));

        }
    }
}