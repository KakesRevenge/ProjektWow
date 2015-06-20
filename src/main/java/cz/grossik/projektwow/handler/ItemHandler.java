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
	/**Diamond**/
	public static Item DiamondHelmet = new ItemWarriorArmor(ItemWarriorArmor.ArmorMaterial.DIAMOND, 3, 0).setCreativeTab(ProjektWow.ProjektWowTab).setUnlocalizedName("helmetDiamond").setTextureName("diamond_helmet");
	public static Item DiamondChestplate = new ItemWarriorArmor(ItemWarriorArmor.ArmorMaterial.DIAMOND, 3, 1).setCreativeTab(ProjektWow.ProjektWowTab).setUnlocalizedName("chestplateDiamond").setTextureName("diamond_chestplate");
	public static Item DiamondLeggings = new ItemWarriorArmor(ItemWarriorArmor.ArmorMaterial.DIAMOND, 3, 2).setCreativeTab(ProjektWow.ProjektWowTab).setUnlocalizedName("leggingsDiamond").setTextureName("diamond_leggings");
	public static Item DiamondBoots = new ItemWarriorArmor(ItemWarriorArmor.ArmorMaterial.DIAMOND, 3, 3).setCreativeTab(ProjektWow.ProjektWowTab).setUnlocalizedName("bootsDiamond").setTextureName("diamond_boots");
	/****/
	/**Gold**/
	public static Item GoldHelmet = new ItemWarriorArmor(ItemWarriorArmor.ArmorMaterial.GOLD, 4, 0).setCreativeTab(ProjektWow.ProjektWowTab).setUnlocalizedName("helmetGold").setTextureName("gold_helmet");
	public static Item GoldChestplate = new ItemWarriorArmor(ItemWarriorArmor.ArmorMaterial.GOLD, 4, 1).setCreativeTab(ProjektWow.ProjektWowTab).setUnlocalizedName("chestplateGold").setTextureName("gold_chestplate");
	public static Item GoldLeggings = new ItemWarriorArmor(ItemWarriorArmor.ArmorMaterial.GOLD, 4, 2).setCreativeTab(ProjektWow.ProjektWowTab).setUnlocalizedName("leggingsGold").setTextureName("gold_leggings");
	public static Item GoldBoots = new ItemWarriorArmor(ItemWarriorArmor.ArmorMaterial.GOLD, 4, 3).setCreativeTab(ProjektWow.ProjektWowTab).setUnlocalizedName("bootsGold").setTextureName("gold_boots");
	/**Iron**/
	public static Item IronHelmet = new ItemWarriorArmor(ItemWarriorArmor.ArmorMaterial.IRON, 2, 0).setCreativeTab(ProjektWow.ProjektWowTab).setUnlocalizedName("helmetIron").setTextureName("iron_helmet");
	public static Item IronChestplate = new ItemWarriorArmor(ItemWarriorArmor.ArmorMaterial.IRON, 2, 1).setCreativeTab(ProjektWow.ProjektWowTab).setUnlocalizedName("chestplateIron").setTextureName("iron_chestplate");
	public static Item IronLeggings = new ItemWarriorArmor(ItemWarriorArmor.ArmorMaterial.IRON, 2, 2).setCreativeTab(ProjektWow.ProjektWowTab).setUnlocalizedName("leggingsIron").setTextureName("iron_leggings");
	public static Item IronBoots = new ItemWarriorArmor(ItemWarriorArmor.ArmorMaterial.IRON, 2, 3).setCreativeTab(ProjektWow.ProjektWowTab).setUnlocalizedName("bootsIron").setTextureName("iron_boots");
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
        GameRegistry.registerItem(GoldHelmet, "helmetGold");
        GameRegistry.registerItem(GoldChestplate, "chestplateGold");
        GameRegistry.registerItem(GoldLeggings, "leggingsGold");
        GameRegistry.registerItem(GoldBoots, "bootsGold");
        GameRegistry.registerItem(IronHelmet, "helmetIron");
        GameRegistry.registerItem(IronChestplate, "chestplateIron");
        GameRegistry.registerItem(IronLeggings, "leggingsIron");
        GameRegistry.registerItem(IronBoots, "bootsIron");
        
        GameRegistry.registerItem(ItemHandler.WoodenSpear, "wooden_spear");
	}
	
}