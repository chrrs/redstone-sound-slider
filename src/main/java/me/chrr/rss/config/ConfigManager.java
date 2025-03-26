package me.chrr.rss.config;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ConfigManager {
    private static final ConfigManager INSTANCE = new ConfigManager();

    private static final Gson GSON = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setPrettyPrinting()
            .create();

    private Config config = Config.DEFAULT;

    public void load() throws IOException {
        Path path = this.getConfigPath();
        if (path.toFile().isFile()) {
            this.config = GSON.fromJson(Files.readString(path), Config.class);
            this.config.upgrade();
        }

        this.save();
    }

    public void save() throws IOException {
        Files.writeString(this.getConfigPath(), GSON.toJson(config));
    }

    private Path getConfigPath() {
        return FabricLoader.getInstance().getConfigDir().resolve("redstone_sound_slider.json");
    }

    public Config getConfig() {
        return config;
    }

    public static ConfigManager getInstance() {
        return INSTANCE;
    }
}
