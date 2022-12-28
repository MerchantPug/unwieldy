package net.merchantpug.unwieldy.mixin.fabricshieldlib;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShield;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Registry.class)
public interface RegistryMixin {
    @Inject(method = "register(Lnet/minecraft/registry/Registry;Lnet/minecraft/registry/RegistryKey;Ljava/lang/Object;)Ljava/lang/Object;", at = @At("HEAD"), cancellable = true)
    private static <V, T extends V> void unwieldy$cancelShieldRegistration0(Registry<V> registry, RegistryKey<V> key, T entry, CallbackInfoReturnable<T> cir) {
        if (entry instanceof FabricShield) {
            cir.cancel();
        }
    }

    @Inject(method = "method_47984", at = @At("HEAD"), cancellable = true)
    private static <V, T extends V> void unwieldy$cancelShieldRegistration1(Registry<T> registry, RegistryKey<T> registryKey, T entry, CallbackInfoReturnable<RegistryEntry.Reference<T>> cir) {
        if (entry instanceof FabricShield) {
            cir.cancel();
        }
    }

    @Inject(method = "register(Lnet/minecraft/registry/Registry;ILjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", at = @At("HEAD"), cancellable = true)
    private static <V, T extends V> void unwieldy$cancelShieldRegistration2(Registry<V> registry, int rawId, String id, T entry, CallbackInfoReturnable<T> cir) {
        if (entry instanceof FabricShield) {
            cir.cancel();
        }
    }
}
