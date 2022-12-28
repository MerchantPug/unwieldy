package net.merchantpug.unwieldy.mixin.fabricshieldlib;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShield;
import net.merchantpug.unwieldy.Unwieldy;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Items.class)
public class ItemsMixin {
    @Inject(method = "register(Ljava/lang/String;Lnet/minecraft/item/Item;)Lnet/minecraft/item/Item;", at = @At("HEAD"), cancellable = true)
    private static void unwieldy$unwieldy(String id, Item item, CallbackInfoReturnable<Item> cir) {
        if (item instanceof FabricShield) {
            cir.cancel();
        }
    }

    @Inject(method = "register(Lnet/minecraft/util/Identifier;Lnet/minecraft/item/Item;)Lnet/minecraft/item/Item;", at = @At("HEAD"), cancellable = true)
    private static void unwieldy$unwieldy(Identifier id, Item item, CallbackInfoReturnable<Item> cir) {
        if (item instanceof FabricShield) {
            cir.cancel();
        }
    }
}