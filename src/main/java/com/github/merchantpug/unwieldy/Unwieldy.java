package com.github.merchantpug.unwieldy;

import com.github.merchantpug.unwieldy.recipe.ImpossibleRecipe;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.Language;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Unwieldy implements ModInitializer {
	public static final String MODID = "unwieldy";
	public static final Logger LOGGER = LogManager.getLogger(Unwieldy.class);
	public static String VERSION = "";

	public static final SpecialRecipeSerializer<ImpossibleRecipe> IMPOSSIBLE_RECIPE = RecipeSerializer.register("unwieldy:crafting_impossible", new SpecialRecipeSerializer<>(ImpossibleRecipe::new));

	public static final TagKey<StatusEffect> UNWIELDY_STATUS_EFFECT_TAG = TagKey.of(Registry.MOB_EFFECT_KEY, identifier("unwieldy"));

	@Override
	public void onInitialize() {
		FabricLoader.getInstance().getModContainer(MODID).ifPresent(modContainer -> {
			VERSION = modContainer.getMetadata().getVersion().getFriendlyString();
			if(VERSION.contains("+")) {
				VERSION = VERSION.split("\\+")[0];
			}
			if(VERSION.contains("-")) {
				VERSION = VERSION.split("-")[0];
			}
		});
		LOGGER.info("Unwieldy " + VERSION + " has initialized. The game is now unable to hold a shield upright.");
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
