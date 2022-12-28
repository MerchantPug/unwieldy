// TODO Reimplement Origins compat once a 1.19.3 version releases.
/*
package net.merchantpug.unwieldy.mixin.origins;

import com.google.gson.JsonElement;
import io.github.apace100.apoli.power.PowerType;
import io.github.apace100.apoli.power.PowerTypeRegistry;
import io.github.apace100.origins.Origins;
import io.github.apace100.origins.origin.Origin;
import io.github.apace100.origins.origin.OriginManager;
import net.merchantpug.unwieldy.Unwieldy;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(OriginManager.class)
public class OriginManagerMixin {
    @Inject(method = "lambda$apply$0", at = @At(value = "INVOKE", target = "Lio/github/apace100/origins/origin/Origin;fromJson(Lnet/minecraft/util/Identifier;Lcom/google/gson/JsonObject;)Lio/github/apace100/origins/origin/Origin;", ordinal = 0, shift = At.Shift.BY, by = 2), locals = LocalCapture.CAPTURE_FAILHARD)
    private static void unwieldy$addUnwieldyPowerToData(Identifier id, JsonElement je, CallbackInfo ci, Origin origin) {
        PowerType<?> powerType = PowerTypeRegistry.get(Origins.identifier("no_shield"));
        if (origin.hasPowerType(powerType)) {
            powerType = PowerTypeRegistry.get(Unwieldy.identifier("true_nature"));
        }
        origin.add(powerType);
    }
}
*/
