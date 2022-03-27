package io.github.merchantpug.unwieldy;

import io.github.merchantpug.unwieldy.recipe.ImpossibleRecipe;
import net.fabricmc.api.ModInitializer;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.Language;

public class Unwieldy implements ModInitializer {
	public static final String MODID = "unwieldy";

	public static final SpecialRecipeSerializer<ImpossibleRecipe> IMPOSSIBLE_RECIPE = RecipeSerializer.register("unwieldy:crafting_impossible", new SpecialRecipeSerializer<>(ImpossibleRecipe::new));

	@Override
	public void onInitialize() {
	}

	public static String getShieldInLanguage() {
		if (Language.getInstance().hasTranslation("item.minecraft.shield")) {
			return Language.getInstance().get("item.minecraft.shield");
		}
		return "Shield";
	}

	public static Identifier identifier(String path) {
		return new Identifier(MODID, path);
	}
}
