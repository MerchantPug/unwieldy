package io.github.merchantpug.unwieldy.mixin;

import io.github.merchantpug.unwieldy.Unwieldy;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.regex.Pattern;

@Mixin(ClientPlayNetworkHandler.class)
public class ClientPlayNetworkHandlerMixin {
    @ModifyArg(method = "onGameMessage", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/InGameHud;addChatMessage(Lnet/minecraft/network/MessageType;Lnet/minecraft/text/Text;Ljava/util/UUID;)V"))
    private Text removeMentionsOfShields(Text message) {
        if (message.asString().contains(Unwieldy.getShieldInLanguage())) {
            return new LiteralText(Pattern.compile(Pattern.quote(Unwieldy.getShieldInLanguage()), Pattern.CASE_INSENSITIVE).matcher(message.asString()).replaceAll("")).setStyle(message.getStyle());
        }
        return message;
    }
}
