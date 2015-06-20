package cz.grossik.projektwow.handler;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import cpw.mods.fml.common.registry.GameRegistry;
import cz.grossik.projektwow.ProjektWow;
import cz.grossik.projektwow.items.ToolMaterials;
import cz.grossik.projektwow.warrior.items.ItemShield;
import cz.grossik.projektwow.warrior.items.ItemTestSword;
import cz.grossik.projektwow.warrior.items.ItemWarriorArmor;
import cz.grossik.projektwow.warrior.items.ItemWoodenSpear;
import cz.grossik.projektwow.wizard.items.ItemWand;

public class ItemHandler {
		
	//WARRIOR
	public static Item WoodenSpear = new ItemWoodenSpear().setCreativeTab(ProjektWow.ProjektWowTab).setUnlocalizedName("wooden_spear");
	public static Item Shield = new ItemShield(ToolMaterial.IRON);
	
	/**TEST**/
	public static Item Sword = new ItemTestSword(ToolMaterials.WARRIOR).setCreativeTab(ProjektWow.ProjektWowTab).setUnlocalizedName("Sword");
	
	//ARMOR	
	public static Item DiamondHelmet = new ItemWarriorArmor(ItemWarriorArmor.ArmorMaterial.DIAMOND, 3, 0).setCreativeTab(ProjektWow.ProjektWowTab).setUnlocalizedName("helmetDiamond").setTextureName("diamond_helmet");
	public static Item DiamondChestplate = new ItemWarriorArmor(ItemWarriorArmor.ArmorMaterial.DIAMOND, 3, 1).setCreativeTab(ProjektWow.ProjektWowTab).setUnlocalizedName("chestplateDiamond").setTextureName("diamond_chestplate");
	public static Item DiamondLeggings = new ItemWarriorArmor(ItemWarriorArmor.ArmorMaterial.DIAMOND, 3, 2).setCreativeTab(ProjektWow.ProjektWowTab).setUnlocalizedName("leggingsDiamond").setTextureName("diamond_leggings");
	public static Item DiamondBoots = new ItemWarriorArmor(ItemWarriorArmor.ArmorMaterial.DIAMOND, 3, 3).setCreativeTab(ProjektWow.ProjektWowTab).setUnlocalizedName("bootsDiamond").setTextureName("diamond_boots");
	/****/

	//WIZARD
	
	/**TEST**/
    public static Item Wand = new ItemWand().setCreativeTab(ProjektWow.ProjektWowTab).setUnlocalizedName("Wand");
	/****/

	//THIEF
	
	//ZBYTEK
	
	public static void registerItems() {
		GameRegistry.registerItem(ItemHandler.Sword, "SwordTest");
        GameRegistry.registerItem(ItemHandler.Wand, "WandTest");
        GameRegistry.registerItem(ItemHandler.Shield, "Shield");
        GameRegistry.registerItem(DiamondHelmet, "helmetDiamond");
        GameRegistry.registerItem(DiamondChestplate, "chestplateDiamond");
        GameRegistry.registerItem(DiamondLeggings, "leggingsDiamond");
        GameRegistry.registerItem(DiamondBoots, "bootsDiamond");
        
        GameRegistry.registerItem(ItemHandler.WoodenSpear, "wooden_spear");
	}
	
}