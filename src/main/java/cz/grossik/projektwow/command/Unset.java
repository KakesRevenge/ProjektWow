package cz.grossik.projektwow.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import cz.grossik.projektwow.ProjektWow;
import cz.grossik.projektwow.Reference;
import cz.grossik.projektwow.handler.PlayerClassHandler;
import cz.grossik.projektwow.utils.LogHelper;

/**
@Author KakesRevenge
 */

public class Unset extends CommandBase {
	
	@Override
	public String getCommandName() {
        return "unset";
    }

	@Override
    public String getCommandUsage(ICommandSender par1ICommandSender) {
        return "/unset";
    }
	
	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender) {
     	EntityPlayer player = getCommandSenderAsPlayer(sender);
		boolean op = MinecraftServer.getServer().getConfigurationManager().func_152596_g(player.getGameProfile());
		return op;
	}
	
	@Override
    public void processCommand(ICommandSender sender, String[] ArrayOfStr) {
     	EntityPlayer player = getCommandSenderAsPlayer(sender);
        String name = player.getCommandSenderName();
        PlayerClassHandler props = PlayerClassHandler.get(player);
        int playerclass = props.CurrentClass;
    	LogHelper.info(playerclass);
    	
        if(playerclass != Reference.Unset) {
        	LogHelper.info(playerclass);
        	props.CurrentClass = Reference.Unset;
        	player.addChatComponentMessage(new ChatComponentText("Now you dont have any class"));
        }
	}
}