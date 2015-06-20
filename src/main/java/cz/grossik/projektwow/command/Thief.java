package cz.grossik.projektwow.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import cz.grossik.projektwow.Reference;
import cz.grossik.projektwow.handler.PlayerClassHandler;

/**
@Author KakesRevenge
 */

public class Thief extends CommandBase {
	
	@Override
    public String getCommandName() {
        return "thief";
    }
    
    @Override
    public String getCommandUsage(ICommandSender CommandSender) {
        return "/thief";
    }
    
    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }
    
    @Override
    public void processCommand(ICommandSender sender, String[] ArrayOfStr) {
     	EntityPlayer player = getCommandSenderAsPlayer(sender);
        String name = player.getCommandSenderName();
        PlayerClassHandler props = PlayerClassHandler.get(player);
        int playerclass = props.CurrentClass;
        
        switch(playerclass) {
        case Reference.Unset:
        	props.CurrentClass = Reference.Thief;
        	player.addChatComponentMessage(new ChatComponentText("Now you are a Thief"));
			player.refreshDisplayName();
        	break;
        case Reference.Thief:
        	player.addChatComponentMessage(new ChatComponentText("You are already a Thief"));
        	break;
        case Reference.Warrior:
        	player.addChatComponentMessage(new ChatComponentText("You are already a different class"));
        	break;
        case Reference.Wizard:
        	player.addChatComponentMessage(new ChatComponentText("You are already a different class"));
        	break;
        }
    }   
}