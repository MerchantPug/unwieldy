package io.github.merchantpug.unwieldy.mixin;

import io.github.merchantpug.unwieldy.Unwieldy;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import org.apache.commons.lang3.StringUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Environment(EnvType.CLIENT)
@Mixin(ClientPlayNetworkHandler.class)
public class ClientPlayNetworkHandlerMixin {
    @ModifyArg(method = "onGameMessage", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/InGameHud;addChatMessage(Lnet/minecraft/network/MessageType;Lnet/minecraft/text/Text;Ljava/util/UUID;)V"))
    private Text removeMentionsOfShields(Text message) {
        if (StringUtils.containsIgnoreCase(message.getString(), Unwieldy.getShieldInLanguage())) {
            String newString = StringUtils.replaceIgnoreCase(message.getString(), Unwieldy.getShieldInLanguage(), "");
            return new LiteralText(newString).setStyle(message.getStyle());
        }
        return message;
    }
}
