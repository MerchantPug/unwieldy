package io.github.merchantpug.unwieldy.mixin;

import io.github.merchantpug.unwieldy.Unwieldy;
import net.minecraft.text.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Mixin(TranslatableText.class)
public class TranslatableTextMixin {
    @Shadow private List<StringVisitable> translations;

    @Inject(method = "updateTranslations", at = @At(value = "INVOKE", target = "Lcom/google/common/collect/ImmutableList$Builder;build()Lcom/google/common/collect/ImmutableList;", shift = At.Shift.BY, by = 2))
    private void removeMentionsOfShields(CallbackInfo ci) {
        List<StringVisitable> newList = new ArrayList<>();
        for (StringVisitable stringVisitable : this.translations) {
            String string = stringVisitable.getString();
            if (!Pattern.compile(Pattern.quote(Unwieldy.getShieldInLanguage()), Pattern.CASE_INSENSITIVE).matcher(string).matches()) {
                newList.add(stringVisitable);
                continue;
            }
            StringVisitable visitable = StringVisitable.plain(Pattern.compile(Pattern.quote(Unwieldy.getShieldInLanguage()), Pattern.CASE_INSENSITIVE).matcher(string).replaceAll(""));
            newList.add(visitable);
        }
        this.translations = newList;
    }

    @Inject(method = "getArg", at = @At("RETURN"), locals = LocalCapture.CAPTURE_FAILHARD, cancellable = true)
    private void removeMentionsOfShieldsInArgs(int index, CallbackInfoReturnable<StringVisitable> cir, Object object) {
        if (object instanceof Text) {
            String jsonText = Text.Serializer.toJson((Text)object);
            if (!Pattern.compile(Pattern.quote(Unwieldy.getShieldInLanguage()), Pattern.CASE_INSENSITIVE).matcher(jsonText).matches()) return;
            jsonText = Pattern.compile(Pattern.quote(Unwieldy.getShieldInLanguage()), Pattern.CASE_INSENSITIVE).matcher(jsonText).replaceAll("");
            cir.setReturnValue(Text.Serializer.fromJson(jsonText));
        }
    }
}
