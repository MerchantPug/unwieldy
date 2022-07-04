package com.github.merchantpug.unwieldy.mixin;

import net.minecraft.item.ShieldItem;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.SimpleRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SimpleRegistry.class)
public abstract class SimpleRegistryMixin<T> {

    @Inject(method = "createEntry", at = @At("HEAD"), cancellable = true)
    private void preventCrash(T value, CallbackInfoReturnable<RegistryEntry.Reference<T>> cir) {
        if (value instanceof ShieldItem) {
            cir.cancel();
        }
    }
}
