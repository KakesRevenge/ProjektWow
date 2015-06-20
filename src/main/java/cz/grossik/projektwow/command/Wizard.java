package cz.grossik.projektwow.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import cz.grossik.projektwow.ProjektWow;
import cz.grossik.projektwow.Reference;
import cz.grossik.projektwow.handler.PlayerClassHandler;

/**
@Author KakesRevenge
 */

public class Wizard extends CommandBase {
	
	@Override
    public String getCommandName() {
        return "wizard";
    }
	
    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
    
    @Override
    public String getCommandUsage(ICommandSender par1ICommandSender) {
        return "/wizard";
    }
    
    @Override
    public void processCommand(ICommandSender sender, String[] ArrayOfStr) {
     	EntityPlayer player = getCommandSenderAsPlayer(sender);
        String name = player.getCommandSenderName();
        PlayerClassHandler props = PlayerClassHandler.get(player);
        int playerclass = props.CurrentClass;
        
        switch(playerclass) {
        case Reference.Unset:
        	props.CurrentClass = Reference.Wizard;
        	player.addChatComponentMessage(new ChatComponentText("Now you are a Wizard"));			
        	player.refreshDisplayName();
        	break;
        case Reference.Thief:
        	player.addChatComponentMessage(new ChatComponentText("You are already a different class"));
        	break;
        case Reference.Warrior:
        	player.addChatComponentMessage(new ChatComponentText("You are already a Wizard"));
        	break;
        case Reference.Wizard:
        	player.addChatComponentMessage(new ChatComponentText("You are already a different class"));
        	break;
        }
    }   
}      