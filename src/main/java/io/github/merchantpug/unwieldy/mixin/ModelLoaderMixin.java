package io.github.merchantpug.unwieldy.mixin;

import io.github.merchantpug.unwieldy.Unwieldy;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashSet;

@Environment(EnvType.CLIENT)
@Mixin(ModelLoader.class)
public class ModelLoaderMixin {
    @Inject(method = "method_24150", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/TexturedRenderLayers;addDefaultTextures(Ljava/util/function/Consumer;)V"))
    private static void addNewOffhandInventorySlotToMap(HashSet hashSet, CallbackInfo ci) {
        hashSet.add(new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, Unwieldy.identifier("item/empty_armor_slot_offhand")));
    }
}
