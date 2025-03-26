package me.chrr.rss;

import me.chrr.rss.config.ConfigManager;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.sound.SoundCategory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RedstoneSoundSlider implements ClientModInitializer {
    public static final Logger LOGGER = LogManager.getLogger();
    public static SoundCategory redstoneSoundCategory;

    @Override
    public void onInitializeClient() {
        try {
            ConfigManager.getInstance().load();
        } catch (Exception e) {
            RedstoneSoundSlider.LOGGER.error("could not load config", e);
        }
    }
}
