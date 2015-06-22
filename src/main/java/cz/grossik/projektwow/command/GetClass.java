package cz.grossik.projektwow.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import cz.grossik.projektwow.ProjektWow;
import cz.grossik.projektwow.handler.PlayerClassHandler;
import cz.grossik.projektwow.help.Reference;

/**
@Author KakesRevenge
 */

public class GetClass extends CommandBase {

    public String getCommandName() {
        return "class";
    }

    public String getCommandUsage(ICommandSender CommandSender) {
        return "/class";
    }
    
    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }
    
    public void processCommand(ICommandSender sender, String[] ArrayOfStr) {
     	EntityPlayer player = getCommandSenderAsPlayer(sender);
        String name = player.getCommandSenderName();
        PlayerClassHandler props = PlayerClassHandler.get(player);
        int playerclass = props.CurrentClass;
        
        switch (playerclass) {
        case Reference.Thief:
        	player.addChatComponentMessage(new ChatComponentText("You are Thief"));
        	break;
        case Reference.Warrior:
        	player.addChatComponentMessage(new ChatComponentText("You are Warrior"));
        	break;
        case Reference.Wizard:
        	player.addChatComponentMessage(new ChatComponentText("You are Wizard"));
        	break;
        case Reference.Unset:
        	player.addChatComponentMessage(new ChatComponentText("You dont have any class"));
        	break;
        }
    }   
}