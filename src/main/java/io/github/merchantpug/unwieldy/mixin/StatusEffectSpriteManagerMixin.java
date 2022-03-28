package io.github.merchantpug.unwieldy.mixin;

import io.github.merchantpug.unwieldy.Unwieldy;
import io.github.merchantpug.unwieldy.integration.UnwieldyConfig;
import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.StatusEffectSpriteManager;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.intellij.lang.annotations.JdkConstants;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Environment(EnvType.CLIENT)
@Mixin(StatusEffectSpriteManager.class)
public abstract class StatusEffectSpriteManagerMixin {

    @Inject(method = "getSprites", at = @At("RETURN"), cancellable = true)
    private void addBlankMobEffectToReturnValue(CallbackInfoReturnable<Stream<Identifier>> cir) {
        List<Identifier> identifierList = cir.getReturnValue().collect(Collectors.toList());
        identifierList.add(Unwieldy.identifier("unwieldy"));
        cir.setReturnValue(identifierList.stream());
    }

    @ModifyArg(method = "getSprite", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/texture/StatusEffectSpriteManager;getSprite(Lnet/minecraft/util/Identifier;)Lnet/minecraft/client/texture/Sprite;"))
    private Identifier removeShieldFromEvent(Identifier par1) {
        UnwieldyConfig config = AutoConfig.getConfigHolder(UnwieldyConfig.class).getConfig();
        if (config.effectsWithShieldIcons.stream().anyMatch(id -> id.equals(par1))) {
            return Unwieldy.identifier("unwieldy");
        }
        return par1;
    }
}
