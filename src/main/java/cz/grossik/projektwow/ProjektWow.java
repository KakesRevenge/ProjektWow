package cz.grossik.projektwow;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cz.grossik.projektwow.entity.EntityWoodenSpear;
import cz.grossik.projektwow.handler.CommandHandler;
import cz.grossik.projektwow.handler.GuiHandler;
import cz.grossik.projektwow.handler.ItemHandler;
import cz.grossik.projektwow.handler.RecipeHandler;
import cz.grossik.projektwow.handler.WoWEventHandler;
import cz.grossik.projektwow.help.EventHelper;
import cz.grossik.projektwow.help.Reference;
import cz.grossik.projektwow.proxy.ProxyCommon;
import cz.grossik.projektwow.worldtype.PWWorldType;

@Mod(modid = Reference.MODID,name = Reference.NAME, version = Reference.VERSION)
public class ProjektWow {
	
	@SidedProxy(clientSide = "cz.grossik.projektwow.proxy.ProxyClient", serverSide = "cz.grossik.projektwow.proxy.ProxyCommon")
    public static ProxyCommon proxy;
	@Instance(Reference.MODID)
	public static ProjektWow instance;
            
    public static CreativeTabs ProjektWowTab = new ProjektWowTab("ProjektWow"); 
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	proxy.registerRenderers();
    	EntityRegistry.registerModEntity(EntityWoodenSpear.class, EntityWoodenSpear.class.getSimpleName(), 7, this, 200, 2, true);
    	NetworkRegistry.INSTANCE.registerGuiHandler(ProjektWow.instance, new GuiHandler());
        ItemHandler.registerItems();
        EventHelper.register(EventHelper.Type.BOTH, new WoWEventHandler());
    }
    
    @EventHandler
    public void ServerLoad(FMLServerStartingEvent event) {	 
    	event.registerServerCommand(CommandHandler.warrior);
    	event.registerServerCommand(CommandHandler.wizard);
    	event.registerServerCommand(CommandHandler.thief);
    	event.registerServerCommand(CommandHandler.getClass);
    	event.registerServerCommand(CommandHandler.unset);
    }
    
	@EventHandler
	public static void init(FMLInitializationEvent event) {	
		PWWorldType.addCustomWorldTypes();
		RecipeHandler.registerRecipes();
	}
}