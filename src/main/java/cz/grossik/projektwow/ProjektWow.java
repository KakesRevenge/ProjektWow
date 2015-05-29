package cz.grossik.projektwow;

import java.io.File;

import net.minecraft.command.ICommand;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cz.grossik.projektwow.command.Command_Thief;
import cz.grossik.projektwow.command.Command_Warrior;
import cz.grossik.projektwow.command.Command_Wizard;
import cz.grossik.projektwow.event.Event;
import cz.grossik.projektwow.handler.GuiHandler;
import cz.grossik.projektwow.handler.RecipeHandler;
import cz.grossik.projektwow.items.ItemHandler;
import cz.grossik.projektwow.proxy.ProxyCommon;
import cz.grossik.projektwow.warrior.entity.EntityWoodenSpear;
import cz.grossik.projektwow.world_type.ProjektWow_WorldType;

@Mod(modid = ProjektWow.MODID, version = ProjektWow.VERSION)
public class ProjektWow {
	
    public static final String MODID = "Projekt Wow";
    public static final String VERSION = "0.0.23";
	@Instance(MODID)
	public static ProjektWow instance;
    @SidedProxy(clientSide = "cz.grossik.projektwow.proxy.ProxyClient", serverSide = "cz.grossik.projektwow.proxy.ProxyCommon")
    public static ProxyCommon proxy;
        
    public static final IAttribute attackDamages = new RangedAttribute("generic.attackDamages", 2.0D, 0.0D, Double.MAX_VALUE);
    
    public static CreativeTabs ProjektWowTab = new ProjektWowTab("ProjektWow");    
    public static Configuration config = new Configuration(new File("config/projekt_wow/class.cfg"));

	public static Property player_name;
	public static Property player_class;
	
	public static String Warrior = "Warrior";
	public static String Wizard = "Wizard";
	public static String Thief = "Thief";
	public static String nul = "null";
	
    public static ICommand warrior = new Command_Warrior();
    public static ICommand wizard = new Command_Wizard();
    public static ICommand thief = new Command_Thief();
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	proxy.registerRenderers();
   	    EntityRegistry.registerModEntity(EntityWoodenSpear.class, EntityWoodenSpear.class.getSimpleName(), 7, this, 200, 2, true);
   	    FMLCommonHandler.instance().bus().register(new Event());
        NetworkRegistry.INSTANCE.registerGuiHandler(ProjektWow.instance, new GuiHandler());
        
        GameRegistry.registerItem(ItemHandler.Sword, "SwordTest");
        GameRegistry.registerItem(ItemHandler.Wand, "WandTest");
        GameRegistry.registerItem(ItemHandler.Knife, "KnifeTest");
        
        GameRegistry.registerItem(ItemHandler.WoodenSpear, "wooden_spear");

    }
    
	@EventHandler
	public static void init(FMLInitializationEvent event) {	
		ProjektWow_WorldType.addCustomWorldTypes();
		RecipeHandler.registerRecipes();
	}
    
    @EventHandler
    public void ServerLoad(FMLServerStartingEvent event) {	 
    	event.registerServerCommand(this.warrior);
    	event.registerServerCommand(this.wizard);
    	event.registerServerCommand(this.thief);
    }
}