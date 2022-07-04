package com.github.merchantpug.unwieldy.mixin.fabricshieldlib;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShield;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ShieldItem;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Items.class)
public class ItemsMixin {
    @Inject(method = "register(Lnet/minecraft/util/Identifier;Lnet/minecraft/item/Item;)Lnet/minecraft/item/Item;", at = @At("RETURN"), cancellable = true)
    private static void unwieldy(Identifier id, Item item, CallbackInfoReturnable<Item> cir) {
        if (item instanceof FabricShield) {
            cir.cancel();;
        }
    }
}