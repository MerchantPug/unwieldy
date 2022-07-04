package com.github.merchantpug.unwieldy.mixin;

import net.minecraft.item.ShieldItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Registry.class)
public abstract class RegistryMixin {
    @Inject(method = "register(Lnet/minecraft/util/registry/Registry;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", at = @At("HEAD"), cancellable = true)
    private static <V, T extends V> void cancelShieldRegistration0(Registry<? super T> registry, String id, T entry, CallbackInfoReturnable<T> cir) {
        if (entry instanceof ShieldItem) {
            cir.cancel();
        }
    }

    @Inject(method = "register(Lnet/minecraft/util/registry/Registry;Lnet/minecraft/util/Identifier;Ljava/lang/Object;)Ljava/lang/Object;", at = @At("HEAD"), cancellable = true)
    private static <V, T extends V> void cancelShieldRegistration1(Registry<V> registry, Identifier id, T entry, CallbackInfoReturnable<T> cir) {
        if (entry instanceof ShieldItem) {
            cir.cancel();
        }
    }

    @Inject(method = "register(Lnet/minecraft/util/registry/Registry;Lnet/minecraft/util/registry/RegistryKey;Ljava/lang/Object;)Ljava/lang/Object;", at = @At("HEAD"), cancellable = true)
    private static <V, T extends V> void cancelShieldRegistration2(Registry<V> registry, RegistryKey<V> key, T entry, CallbackInfoReturnable<T> cir) {
        if (entry instanceof ShieldItem) {
            cir.cancel();
        }
    }
}
