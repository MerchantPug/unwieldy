package net.merchantpug.unwieldy.mixin;

import net.minecraft.item.ShieldItem;
import net.minecraft.registry.SimpleRegistry;
import net.minecraft.registry.entry.RegistryEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SimpleRegistry.class)
public abstract class SimpleRegistryMixin<T> {
    @Inject(method = "createEntry", at = @At("HEAD"), cancellable = true)
    private void unwieldy$preventCrash(T value, CallbackInfoReturnable<RegistryEntry.Reference<T>> cir) {
        if (value instanceof ShieldItem) {
            cir.cancel();
        }
    }
}
