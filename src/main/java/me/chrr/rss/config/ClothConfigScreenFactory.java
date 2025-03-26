package me.chrr.rss.config;

import me.chrr.rss.SoundSource;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import me.shedaniel.clothconfig2.impl.builders.SubCategoryBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ClothConfigScreenFactory {
    private ClothConfigScreenFactory() {
    }

    public static Screen create(Screen parent) {
        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(Text.of("Redstone Sound Slider"));
        ConfigEntryBuilder entryBuilder = builder.entryBuilder();

        Config config = ConfigManager.getInstance().getConfig();

        SubCategoryBuilder subCategory = entryBuilder.startSubCategory(Text.translatable("text.sound_source.include_hint"));
        for (SoundSource source : SoundSource.values()) {
            subCategory.add(entryBuilder.startBooleanToggle(
                            source.translation,
                            config.sources.getOrDefault(source, false))
                    .setDefaultValue(Config.DEFAULT.sources.getOrDefault(source, false))
                    .setSaveConsumer((value) -> config.sources.put(source, value))
                    .build());
        }

        builder.getOrCreateCategory(Text.empty())
                .addEntry(subCategory.setExpanded(true).build());

        return builder.build();
    }
}
