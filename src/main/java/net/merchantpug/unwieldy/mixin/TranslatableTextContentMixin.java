package net.merchantpug.unwieldy.mixin;

import net.merchantpug.unwieldy.Unwieldy;
import net.minecraft.text.StringVisitable;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;
import org.apache.commons.lang3.StringUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(TranslatableTextContent.class)
public class TranslatableTextContentMixin {
    @ModifyVariable(method = "updateTranslations", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/util/Language;get(Ljava/lang/String;)Ljava/lang/String;"))
    private String unwieldy$removeMentionsOfShields(String string) {
        if (StringUtils.containsIgnoreCase(string, Unwieldy.getShieldInLanguage())) {
            return string = StringUtils.replaceIgnoreCase(string, Unwieldy.getShieldInLanguage(), "");
        }
        return string;
    }

    @Inject(method = "getArg", at = @At(value = "RETURN", ordinal = 1), locals = LocalCapture.CAPTURE_FAILHARD, cancellable = true)
    private void unwieldy$removeMentionsOfShieldsInArgs(int index, CallbackInfoReturnable<StringVisitable> cir, Object object) {
        if (!(object instanceof Text)) {
            String textString = object.toString();
            if (!StringUtils.containsIgnoreCase(textString, Unwieldy.getShieldInLanguage())) return;
            String newString = StringUtils.replaceIgnoreCase(textString, Unwieldy.getShieldInLanguage(), "");
            cir.setReturnValue(StringVisitable.plain(newString));
        }
    }
}
