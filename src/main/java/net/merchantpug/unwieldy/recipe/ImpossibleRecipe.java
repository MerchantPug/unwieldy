package net.merchantpug.unwieldy.recipe;

import net.merchantpug.unwieldy.Unwieldy;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class ImpossibleRecipe extends SpecialCraftingRecipe {

    public ImpossibleRecipe(Identifier id, CraftingRecipeCategory category) {
        super(id, category);
    }

    @Override
    public boolean matches(CraftingInventory inventory, World world) {
        return false;
    }

    @Override
    public ItemStack craft(CraftingInventory inventory) {
        return null;
    }

    @Override
    public boolean fits(int width, int height) {
        return false;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Unwieldy.IMPOSSIBLE_RECIPE;
    }
}
