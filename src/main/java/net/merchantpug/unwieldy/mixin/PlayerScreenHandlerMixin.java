package net.merchantpug.unwieldy.mixin;

import com.mojang.datafixers.util.Pair;
import net.merchantpug.unwieldy.Unwieldy;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.minecraft.screen.PlayerScreenHandler.BLOCK_ATLAS_TEXTURE;

@Mixin(targets = "net.minecraft.screen.PlayerScreenHandler$2")
public class PlayerScreenHandlerMixin {
    @Inject(method = "getBackgroundSprite", at = @At("RETURN"), cancellable = true)
    private void unwieldy$removeShieldOffhandSprite(CallbackInfoReturnable<Pair<Identifier, Identifier>> cir) {
        cir.setReturnValue(Pair.of(BLOCK_ATLAS_TEXTURE, Unwieldy.identifier("item/empty_armor_slot_offhand")));
    }
}
