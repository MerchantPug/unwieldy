package io.github.merchantpug.unwieldy.integration;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Arrays;

@Config(name = "unwieldy_client")
public class UnwieldyConfig implements ConfigData {
    public ArrayList<Identifier> effectsWithShieldIcons = new ArrayList<>(Arrays.asList(
            new Identifier("absorption"),
            new Identifier("fire_resistance"),
            new Identifier("resistance")
    ));
}
