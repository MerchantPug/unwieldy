package net.merchantpug.unwieldy.mixin;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "net/minecraft/item/ItemGroup$EntriesImpl")
public class EntriesImplMixin {
    @Inject(method = "add", at = @At("HEAD"), cancellable = true)
    private void unwieldy$cancelAddingStackFromCreativeMenu(ItemStack stack, ItemGroup.StackVisibility visibility, CallbackInfo ci) {
        if (stack.isEmpty()) {
            ci.cancel();
        }
    }
}
