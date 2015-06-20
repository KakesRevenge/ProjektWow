package cz.grossik.projektwow.handler;

import java.util.ArrayList;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cz.grossik.projektwow.utils.RecipeRemover;

/**
@Author KakesRevenge
 */
public class RecipeHandler {
	
	public static void registerRecipes() {
		removeRecipes();
		initRecipes();

	}
	
	public static void removeRecipes() {
		
		RecipeRemover.removeAnyRecipe(new ItemStack(Items.iron_boots));
		RecipeRemover.removeAnyRecipe(new ItemStack(Items.iron_chestplate));
		RecipeRemover.removeAnyRecipe(new ItemStack(Items.iron_leggings));
		RecipeRemover.removeAnyRecipe(new ItemStack(Items.iron_helmet));
		
		RecipeRemover.removeAnyRecipe(new ItemStack(Items.chainmail_boots));
		RecipeRemover.removeAnyRecipe(new ItemStack(Items.chainmail_chestplate));
		RecipeRemover.removeAnyRecipe(new ItemStack(Items.chainmail_leggings));
		RecipeRemover.removeAnyRecipe(new ItemStack(Items.chainmail_helmet));
		
		RecipeRemover.removeAnyRecipe(new ItemStack(Items.diamond_boots));
		RecipeRemover.removeAnyRecipe(new ItemStack(Items.diamond_chestplate));
		RecipeRemover.removeAnyRecipe(new ItemStack(Items.diamond_leggings));
		RecipeRemover.removeAnyRecipe(new ItemStack(Items.diamond_helmet));
		
		RecipeRemover.removeAnyRecipe(new ItemStack(Items.golden_boots));
		RecipeRemover.removeAnyRecipe(new ItemStack(Items.golden_chestplate));
		RecipeRemover.removeAnyRecipe(new ItemStack(Items.golden_leggings));
		RecipeRemover.removeAnyRecipe(new ItemStack(Items.golden_helmet));
		
		RecipeRemover.removeAnyRecipe(new ItemStack(Items.leather_boots));
		RecipeRemover.removeAnyRecipe(new ItemStack(Items.leather_chestplate));
		RecipeRemover.removeAnyRecipe(new ItemStack(Items.leather_leggings));
		RecipeRemover.removeAnyRecipe(new ItemStack(Items.leather_helmet));
		
		RecipeRemover.removeAnyRecipe(new ItemStack(Items.iron_sword));
		RecipeRemover.removeAnyRecipe(new ItemStack(Items.diamond_sword));
		RecipeRemover.removeAnyRecipe(new ItemStack(Items.wooden_sword));
		RecipeRemover.removeAnyRecipe(new ItemStack(Items.stone_sword));
		RecipeRemover.removeAnyRecipe(new ItemStack(Items.bow));

	}
	
	public static void initRecipes() {
		
	}

}
