package io.github.merchantpug.unwieldy;

import io.github.merchantpug.unwieldy.integration.UnwieldyConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ClientModInitializer;

public class UnwieldyClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        AutoConfig.register(UnwieldyConfig.class, Toml4jConfigSerializer::new);
    }
}
