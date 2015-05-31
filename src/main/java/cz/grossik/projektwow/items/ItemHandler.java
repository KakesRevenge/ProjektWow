package cz.grossik.projektwow.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import cz.grossik.projektwow.ProjektWow;
import cz.grossik.projektwow.thief.items.Item_Knife;
import cz.grossik.projektwow.warrior.items.Item_TestSword;
import cz.grossik.projektwow.warrior.items.Item_WoodenSpear;
import cz.grossik.projektwow.warrior.items.Shield;
import cz.grossik.projektwow.wizard.items.Item_Wand;

public class ItemHandler {
		
	//WARRIOR
	public static Item WoodenSpear = new Item_WoodenSpear().setCreativeTab(ProjektWow.ProjektWowTab).setUnlocalizedName("wooden_spear");
	public static Item Shield = new Shield(ToolMaterial.IRON);
	
	/**TEST**/
	public static Item Sword = new Item_TestSword(ToolMaterials.WARRIOR).setCreativeTab(ProjektWow.ProjektWowTab).setUnlocalizedName("Sword");
	/****/

	//WIZARD
	
	/**TEST**/
    public static Item Wand = new Item_Wand().setCreativeTab(ProjektWow.ProjektWowTab).setUnlocalizedName("Wand");
	/****/

	//THIEF
    
	/**TEST**/
	public static Item Knife = new Item_Knife().setCreativeTab(ProjektWow.ProjektWowTab).setUnlocalizedName("Knife");
	/****/
	
	//ZBYTEK
	
	public static void registerItems() {
		GameRegistry.registerItem(ItemHandler.Sword, "SwordTest");
        GameRegistry.registerItem(ItemHandler.Wand, "WandTest");
        GameRegistry.registerItem(ItemHandler.Knife, "KnifeTest");
        GameRegistry.registerItem(ItemHandler.Shield, "Shield");
        
        GameRegistry.registerItem(ItemHandler.WoodenSpear, "wooden_spear");
	}
	
}