package cz.grossik.projektwow.utils;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

/**
@Author KakesRevenge
 */
public class RecipeRemover {
	
	public static void removeAnyRecipe (ItemStack result) {
		List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
		for(int i = 0; i < recipes.size(); i++) {
			IRecipe irecipe = recipes.get(i);
			ItemStack recipeResult = irecipe.getRecipeOutput();
			
			if(ItemStack.areItemStacksEqual(result, recipeResult)) {
				recipes.remove(i++);
			}
		}
	}
}
