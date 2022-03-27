package io.github.merchantpug.unwieldy.mixin;

import io.github.merchantpug.unwieldy.Unwieldy;
import net.minecraft.text.LiteralText;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.regex.Pattern;

@Mixin(LiteralText.class)
public class LiteralTextMixin {
    @Mutable
    @Shadow @Final private String string;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void removeMentionsOfShields(String string, CallbackInfo ci) {
        this.string = Pattern.compile(Pattern.quote(Unwieldy.getShieldInLanguage()), Pattern.CASE_INSENSITIVE).matcher(string).replaceAll("");
    }
}
