package net.merchantpug.unwieldy.mixin.fabricshieldlib;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShield;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.SimpleRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SimpleRegistry.class)
public abstract class SimpleRegistryMixin<T> {
    @Inject(method = "createEntry", at = @At("HEAD"), cancellable = true)
    private void unwieldy$preventCrash(T value, CallbackInfoReturnable<RegistryEntry.Reference<T>> cir) {
        if (value instanceof FabricShield) {
            cir.cancel();
        }
    }
}
