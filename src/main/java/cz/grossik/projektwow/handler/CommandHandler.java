package cz.grossik.projektwow.handler;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import net.minecraft.command.ICommand;
import cz.grossik.projektwow.command.GetClass;
import cz.grossik.projektwow.command.Thief;
import cz.grossik.projektwow.command.Unset;
import cz.grossik.projektwow.command.Warrior;
import cz.grossik.projektwow.command.Wizard;

/**
@Author KakesRevenge
 */

public class CommandHandler {
	public static ICommand warrior = new Warrior();
    public static ICommand wizard = new Wizard();
    public static ICommand thief = new Thief();
    public static ICommand getClass = new GetClass();
    public static ICommand unset = new Unset();

}
