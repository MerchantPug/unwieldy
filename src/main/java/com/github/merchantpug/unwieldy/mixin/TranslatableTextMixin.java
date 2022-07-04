package com.github.merchantpug.unwieldy.mixin;

import com.github.merchantpug.unwieldy.Unwieldy;
import net.minecraft.text.*;
import org.apache.commons.lang3.StringUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.ArrayList;
import java.util.List;

@Mixin(TranslatableText.class)
public class TranslatableTextMixin {

    @Shadow private List<StringVisitable> translations;

    @Inject(method = "updateTranslations", at = @At(value = "INVOKE", target = "Lcom/google/common/collect/ImmutableList$Builder;build()Lcom/google/common/collect/ImmutableList;", shift = At.Shift.BY, by = 2))
    private void removeMentionsOfShields(CallbackInfo ci) {
        List<StringVisitable> newList = new ArrayList<>();
        for (StringVisitable stringVisitable : this.translations) {
            String string = stringVisitable.getString();
            if ((!StringUtils.containsIgnoreCase(string, Unwieldy.getShieldInLanguage()))) {
                newList.add(stringVisitable);
                continue;
            }
            StringVisitable visitable = StringVisitable.plain(StringUtils.replaceIgnoreCase(string, Unwieldy.getShieldInLanguage(), ""));
            newList.add(visitable);
        }
        this.translations = newList;
    }

    @Inject(method = "getArg", at = @At("RETURN"), locals = LocalCapture.CAPTURE_FAILHARD, cancellable = true)
    private void removeMentionsOfShieldsInArgs(int index, CallbackInfoReturnable<StringVisitable> cir, Object object) {
        if (object instanceof Text) {
            String textString = ((Text)object).getString();
            if (!StringUtils.containsIgnoreCase(textString, Unwieldy.getShieldInLanguage())) return;
            String newString = StringUtils.replaceIgnoreCase(textString, Unwieldy.getShieldInLanguage(), "");
            cir.setReturnValue(new LiteralText(newString).setStyle(((Text) object).getStyle()));
        }
    }
}
