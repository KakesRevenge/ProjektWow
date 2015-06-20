package cz.grossik.projektwow;

import java.io.File;

import net.minecraft.command.ICommand;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cz.grossik.projektwow.command.Thief;
import cz.grossik.projektwow.command.Warrior;
import cz.grossik.projektwow.command.Wizard;
import cz.grossik.projektwow.command.GetClass;
import cz.grossik.projektwow.handler.GuiHandler;
import cz.grossik.projektwow.handler.ItemHandler;
import cz.grossik.projektwow.handler.RecipeHandler;
import cz.grossik.projektwow.handler.WoWEventHandler;
import cz.grossik.projektwow.proxy.ProxyCommon;
import cz.grossik.projektwow.utils.EventHelper;
import cz.grossik.projektwow.warrior.entity.EntityWoodenSpear;
import cz.grossik.projektwow.world_type.ProjektWow_WorldType;

@Mod(modid = Reference.MODID,name = Reference.NAME, version = Reference.VERSION)
public class ProjektWow {
	@Instance(Reference.MODID)
	public static ProjektWow instance;
    @SidedProxy(clientSide = "cz.grossik.projektwow.proxy.ProxyClient", serverSide = "cz.grossik.projektwow.proxy.ProxyCommon")
    public static ProxyCommon proxy;
            
    public static CreativeTabs ProjektWowTab = new ProjektWowTab("ProjektWow"); 
    
    public static ICommand warrior = new Warrior();
    public static ICommand wizard = new Wizard();
    public static ICommand thief = new Thief();
    public static ICommand getClass = new GetClass();
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	proxy.registerRenderers();
    	EntityRegistry.registerModEntity(EntityWoodenSpear.class, EntityWoodenSpear.class.getSimpleName(), 7, this, 200, 2, true);
    	NetworkRegistry.INSTANCE.registerGuiHandler(ProjektWow.instance, new GuiHandler());
        ItemHandler.registerItems();
        EventHelper.register(EventHelper.Type.BOTH, new WoWEventHandler());
    }
    
	@EventHandler
	public static void init(FMLInitializationEvent event) {	
		ProjektWow_WorldType.addCustomWorldTypes();
		RecipeHandler.registerRecipes();
	}
    
    @EventHandler
    public void ServerLoad(FMLServerStartingEvent event) {	 
    	event.registerServerCommand(warrior);
    	event.registerServerCommand(wizard);
    	event.registerServerCommand(thief);
    	event.registerServerCommand(getClass);
    }
}