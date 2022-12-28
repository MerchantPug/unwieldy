package net.merchantpug.unwieldy.mixin;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Mixin(value = FabricItemGroupEntries.class, remap = false)
public class FabricItemGroupEntriesMixin {
    @Inject(method = "add", at = @At("HEAD"), cancellable = true)
    private void unwieldy$removeCreativeStack(ItemStack stack, ItemGroup.StackVisibility visibility, CallbackInfo ci) {
        if (stack.isEmpty()) {
            ci.cancel();
        }
    }

    @Inject(method = "prepend(Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ItemGroup$StackVisibility;)V", at = @At("HEAD"), cancellable = true)
    private void unwieldy$removePrependedCreativeStack(ItemStack stack, ItemGroup.StackVisibility visibility, CallbackInfo ci) {
        if (stack.isEmpty()) {
            ci.cancel();
        }
    }

    @ModifyVariable(method = "addAfter(Lnet/minecraft/item/ItemStack;Ljava/util/Collection;Lnet/minecraft/item/ItemGroup$StackVisibility;)V", at = @At("HEAD"), argsOnly = true)
    private Collection<ItemStack> unwieldy$removeAfterCreativeStackAfterStack(Collection<ItemStack> newStacks) {
        Collection<ItemStack> newNewStacks = new ArrayList<>(newStacks);
        newNewStacks.removeIf(ItemStack::isEmpty);
        return newNewStacks;
    }

    @ModifyVariable(method = "addAfter(Ljava/util/function/Predicate;Ljava/util/Collection;Lnet/minecraft/item/ItemGroup$StackVisibility;)V", at = @At("HEAD"), argsOnly = true)
    private Collection<ItemStack> unwieldy$removePAfterCreativeStackPredicate(Collection<ItemStack> newStacks) {
        Collection<ItemStack> newNewStacks = new ArrayList<>(newStacks);
        newNewStacks.removeIf(ItemStack::isEmpty);
        return newNewStacks;
    }

    @ModifyVariable(method = "addBefore(Lnet/minecraft/item/ItemStack;Ljava/util/Collection;Lnet/minecraft/item/ItemGroup$StackVisibility;)V", at = @At("HEAD"), argsOnly = true)
    private Collection<ItemStack> unwieldy$removeBeforeCreativeStackBeforeStack(Collection<ItemStack> newStacks) {
        Collection<ItemStack> newNewStacks = new ArrayList<>(newStacks);
        newNewStacks.removeIf(ItemStack::isEmpty);
        return newNewStacks;
    }

    @ModifyVariable(method = "addBefore(Ljava/util/function/Predicate;Ljava/util/Collection;Lnet/minecraft/item/ItemGroup$StackVisibility;)V", at = @At("HEAD"), argsOnly = true)
    private Collection<ItemStack> unwieldy$removeBeforeCreativeStackPredicate(Collection<ItemStack> newStacks) {
        Collection<ItemStack> newNewStacks = new ArrayList<>(newStacks);
        newNewStacks.removeIf(ItemStack::isEmpty);
        return newNewStacks;
    }

    @ModifyVariable(method = "addBefore(Ljava/util/function/Predicate;Ljava/util/Collection;Ljava/util/List;)V", at = @At("HEAD"), argsOnly = true)
    private static Collection<ItemStack> unwieldy$removeBeforeCreativeStackPredicatePrivate(Collection<ItemStack> newStacks) {
        Collection<ItemStack> newNewStacks = new ArrayList<>(newStacks);
        newNewStacks.removeIf(ItemStack::isEmpty);
        return newNewStacks;
    }

    @ModifyVariable(method = "addAfter(Ljava/util/function/Predicate;Ljava/util/Collection;Lnet/minecraft/item/ItemGroup$StackVisibility;)V", at = @At("HEAD"), argsOnly = true)
    private Collection<ItemStack> unwieldy$removeAfterCreativeStackPredicatePrivate(Collection<ItemStack> newStacks) {
        Collection<ItemStack> newNewStacks = new ArrayList<>(newStacks);
        newNewStacks.removeIf(ItemStack::isEmpty);
        return newNewStacks;
    }

    @ModifyVariable(method = "addBefore(Lnet/minecraft/item/ItemStack;Ljava/util/Collection;Ljava/util/List;)V", at = @At("HEAD"), argsOnly = true)
    private static Collection<ItemStack> unwieldy$removeBeforeCreativeStackAnchorStackPrivate(Collection<ItemStack> newStacks) {
        Collection<ItemStack> newNewStacks = new ArrayList<>(newStacks);
        newNewStacks.removeIf(ItemStack::isEmpty);
        return newNewStacks;
    }

    @ModifyVariable(method = "addAfter(Lnet/minecraft/item/ItemStack;Ljava/util/Collection;Ljava/util/List;)V", at = @At("HEAD"), argsOnly = true)
    private static Collection<ItemStack> unwieldy$removeAfterCreativeStackAnchorStackPrivate(Collection<ItemStack> newStacks) {
        Collection<ItemStack> newNewStacks = new ArrayList<>(newStacks);
        newNewStacks.removeIf(ItemStack::isEmpty);
        return newNewStacks;
    }

    @ModifyVariable(method = "addBefore(Lnet/minecraft/item/ItemConvertible;Ljava/util/Collection;Ljava/util/List;)V", at = @At("HEAD"), argsOnly = true)
    private static Collection<ItemStack> unwieldy$removeBeforeCreativeStackAnchorPrivate(Collection<ItemStack> newStacks) {
        Collection<ItemStack> newNewStacks = new ArrayList<>(newStacks);
        newNewStacks.removeIf(ItemStack::isEmpty);
        return newNewStacks;
    }

    @ModifyVariable(method = "addAfter(Lnet/minecraft/item/ItemConvertible;Ljava/util/Collection;Ljava/util/List;)V", at = @At("HEAD"), argsOnly = true)
    private static Collection<ItemStack> unwieldy$removeAfterCreativeStackAnchorPrivate(Collection<ItemStack> newStacks) {
        Collection<ItemStack> newNewStacks = new ArrayList<>(newStacks);
        newNewStacks.removeIf(ItemStack::isEmpty);
        return newNewStacks;
    }

    @Inject(method = "addBefore(Lnet/minecraft/item/ItemStack;Ljava/util/Collection;Ljava/util/List;)V", at = @At("HEAD"), cancellable = true)
    private static void unwieldy$cancelBeforeIfAnchorStackNull(ItemStack anchor, Collection<ItemStack> newStacks, List<ItemStack> addTo, CallbackInfo ci) {
        if (anchor == null) {
            ci.cancel();
        }
    }

    @Inject(method = "addAfter(Lnet/minecraft/item/ItemStack;Ljava/util/Collection;Ljava/util/List;)V", at = @At("HEAD"), cancellable = true)
    private static void unwieldy$cancelAfterIfAnchorStackNull(ItemStack anchor, Collection<ItemStack> newStacks, List<ItemStack> addTo, CallbackInfo ci) {
        if (anchor == null) {
            ci.cancel();
        }
    }

    @Inject(method = "addBefore(Lnet/minecraft/item/ItemConvertible;Ljava/util/Collection;Ljava/util/List;)V", at = @At("HEAD"), cancellable = true)
    private static void unwieldy$cancelBeforeIfAnchorNull(ItemConvertible anchor, Collection<ItemStack> newStacks, List<ItemStack> addTo, CallbackInfo ci) {
        if (anchor == null) {
            ci.cancel();
        }
    }

    @Inject(method = "addAfter(Lnet/minecraft/item/ItemConvertible;Ljava/util/Collection;Ljava/util/List;)V", at = @At("HEAD"), cancellable = true)
    private static void unwieldy$cancelAfterIfAnchorNull(ItemConvertible anchor, Collection<ItemStack> newStacks, List<ItemStack> addTo, CallbackInfo ci) {
        if (anchor == null) {
            ci.cancel();
        }
    }
}
