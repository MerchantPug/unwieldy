package net.merchantpug.unwieldy.mixin.client;

import net.merchantpug.unwieldy.Unwieldy;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasHolder;
import net.minecraft.client.texture.StatusEffectSpriteManager;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.registry.RegistryKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Environment(EnvType.CLIENT)
@Mixin(StatusEffectSpriteManager.class)
public abstract class StatusEffectSpriteManagerMixin extends SpriteAtlasHolder {

    public StatusEffectSpriteManagerMixin(TextureManager textureManager, Identifier atlasId, Identifier pathPrefix) {
        super(textureManager, atlasId, pathPrefix);
    }

    @Inject(method = "getSprite", at = @At(value = "RETURN"), cancellable = true)
    private void unwieldy$removeShieldFromEffectIcon(StatusEffect effect, CallbackInfoReturnable<Sprite> cir) {
        Optional<RegistryKey<StatusEffect>> effectKey = Registries.STATUS_EFFECT.getKey(effect);
        if (effectKey.isPresent() && Registries.STATUS_EFFECT.entryOf(effectKey.get()).isIn(Unwieldy.UNWIELDY_STATUS_EFFECT_TAG)) {
            cir.setReturnValue(this.getSprite(Unwieldy.identifier("unwieldy")));
        }
    }
}
