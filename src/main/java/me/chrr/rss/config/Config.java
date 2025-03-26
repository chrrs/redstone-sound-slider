package me.chrr.rss.config;

import me.chrr.rss.SoundSource;

import java.util.HashMap;
import java.util.Map;

public class Config {
    public static Config DEFAULT = new Config();

    public int version = 1;

    public HashMap<SoundSource, Boolean> sources = new HashMap<>() {{
        //? if >=1.20.3 {
        put(SoundSource.CRAFTER, true);
        put(SoundSource.COPPER_BULB, true);
        //?}

        put(SoundSource.PISTON, true);
        put(SoundSource.DISPENSER, true);
        put(SoundSource.DOORS, false);
        put(SoundSource.FENCE_GATES, false);
        put(SoundSource.PRESSURE_PLATES, true);
        put(SoundSource.BUTTONS, false);
        put(SoundSource.LEVER, false);
        put(SoundSource.TRIPWIRE_HOOK, false);
        put(SoundSource.REDSTONE_TORCH, true);
        put(SoundSource.MINECART, true);
    }};

    public void upgrade() {
        this.version = DEFAULT.version;

        // Copy the missing sources from the default config.
        for (Map.Entry<SoundSource, Boolean> entry : DEFAULT.sources.entrySet()) {
            this.sources.computeIfAbsent(entry.getKey(), s -> entry.getValue());
        }
    }
}
