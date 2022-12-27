package net.merchantpug.unwieldy.mixin;

import net.merchantpug.unwieldy.Unwieldy;
import net.minecraft.text.LiteralTextContent;
import org.apache.commons.lang3.StringUtils;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LiteralTextContent.class)
public class LiteralTextContentMixin {
    @Mutable
    @Shadow @Final private String string;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void unwieldy$removeMentionsOfShields(String string, CallbackInfo ci) {
        this.string = StringUtils.replaceIgnoreCase(this.string, Unwieldy.getShieldInLanguage(), "");
    }
}
