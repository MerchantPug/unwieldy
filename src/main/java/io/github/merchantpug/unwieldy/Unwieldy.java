package io.github.merchantpug.unwieldy;

import io.github.merchantpug.unwieldy.recipe.ImpossibleRecipe;
import net.fabricmc.api.ModInitializer;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Unwieldy implements ModInitializer {
	public static final String MODID = "unwieldy";

	public static SpecialRecipeSerializer<?> IMPOSSIBLE_RECIPE = new SpecialRecipeSerializer<>(ImpossibleRecipe::new);

	@Override
	public void onInitialize() {
		Registry.register(Registry.RECIPE_SERIALIZER, identifier("crafting_impossible"), IMPOSSIBLE_RECIPE);
	}

	public Identifier identifier(String path) {
		return new Identifier(MODID, path);
	}
}
