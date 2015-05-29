package cz.grossik.projektwow.handler;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cz.grossik.projektwow.utils.Remover;

/**
@Author KakesRevenge
 */
public class RecipeHandler {
	
	public static void registerRecipes() {
		removeRecipes();

	}
	
	public static void removeRecipes() {
		Remover.removeAnyRecipe(new ItemStack(Items.iron_boots));
		Remover.removeAnyRecipe(new ItemStack(Items.iron_chestplate));
		Remover.removeAnyRecipe(new ItemStack(Items.iron_leggings));
		Remover.removeAnyRecipe(new ItemStack(Items.iron_helmet));
		
		Remover.removeAnyRecipe(new ItemStack(Items.chainmail_boots));
		Remover.removeAnyRecipe(new ItemStack(Items.chainmail_chestplate));
		Remover.removeAnyRecipe(new ItemStack(Items.chainmail_leggings));
		Remover.removeAnyRecipe(new ItemStack(Items.chainmail_helmet));
		
		Remover.removeAnyRecipe(new ItemStack(Items.diamond_boots));
		Remover.removeAnyRecipe(new ItemStack(Items.diamond_chestplate));
		Remover.removeAnyRecipe(new ItemStack(Items.diamond_leggings));
		Remover.removeAnyRecipe(new ItemStack(Items.diamond_helmet));
		
		Remover.removeAnyRecipe(new ItemStack(Items.golden_boots));
		Remover.removeAnyRecipe(new ItemStack(Items.golden_chestplate));
		Remover.removeAnyRecipe(new ItemStack(Items.golden_leggings));
		Remover.removeAnyRecipe(new ItemStack(Items.golden_helmet));
		
		Remover.removeAnyRecipe(new ItemStack(Items.leather_boots));
		Remover.removeAnyRecipe(new ItemStack(Items.leather_chestplate));
		Remover.removeAnyRecipe(new ItemStack(Items.leather_leggings));
		Remover.removeAnyRecipe(new ItemStack(Items.leather_helmet));
		
		Remover.removeAnyRecipe(new ItemStack(Items.iron_sword));
		Remover.removeAnyRecipe(new ItemStack(Items.diamond_sword));
		Remover.removeAnyRecipe(new ItemStack(Items.wooden_sword));
		Remover.removeAnyRecipe(new ItemStack(Items.stone_sword));
		Remover.removeAnyRecipe(new ItemStack(Items.bow));

	}

}