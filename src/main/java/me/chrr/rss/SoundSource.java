package me.chrr.rss;

import me.chrr.rss.config.ConfigManager;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;

public enum SoundSource {
    //? if >=1.21.9 {
    CHESTS(Text.translatable("text.sound_source.chests"),
            SoundCategory.BLOCKS,
            SoundEvents.BLOCK_CHEST_OPEN,
            SoundEvents.BLOCK_CHEST_CLOSE),
    //?}

    //? if >=1.20.3 {
    CRAFTER(Text.translatable("block.minecraft.crafter"),
            SoundCategory.BLOCKS,
            SoundEvents.BLOCK_CRAFTER_CRAFT,
            SoundEvents.BLOCK_CRAFTER_FAIL),

    COPPER_BULB(Text.translatable("block.minecraft.copper_bulb"),
            SoundCategory.BLOCKS,
            SoundEvents.BLOCK_COPPER_BULB_TURN_OFF,
            SoundEvents.BLOCK_COPPER_BULB_TURN_ON),
    //?}

    PISTON(Text.translatable("block.minecraft.piston"),
            SoundCategory.BLOCKS,
            SoundEvents.BLOCK_PISTON_CONTRACT,
            SoundEvents.BLOCK_PISTON_EXTEND),

    DISPENSER(Text.translatable("block.minecraft.dispenser"),
            SoundCategory.BLOCKS,
            SoundEvents.BLOCK_DISPENSER_DISPENSE,
            SoundEvents.BLOCK_DISPENSER_FAIL,
            SoundEvents.BLOCK_DISPENSER_LAUNCH),

    DOORS(Text.translatable("text.sound_source.doors"),
            SoundCategory.BLOCKS,

            //? if >=1.20.3 {
            SoundEvents.BLOCK_COPPER_DOOR_OPEN,
            SoundEvents.BLOCK_COPPER_DOOR_CLOSE,
            //?}

            SoundEvents.BLOCK_IRON_DOOR_OPEN,
            SoundEvents.BLOCK_IRON_DOOR_CLOSE,
            SoundEvents.BLOCK_WOODEN_DOOR_OPEN,
            SoundEvents.BLOCK_WOODEN_DOOR_CLOSE,
            SoundEvents.BLOCK_BAMBOO_WOOD_DOOR_OPEN,
            SoundEvents.BLOCK_BAMBOO_WOOD_DOOR_CLOSE,
            SoundEvents.BLOCK_CHERRY_WOOD_DOOR_OPEN,
            SoundEvents.BLOCK_CHERRY_WOOD_DOOR_CLOSE,
            SoundEvents.BLOCK_NETHER_WOOD_DOOR_OPEN,
            SoundEvents.BLOCK_NETHER_WOOD_DOOR_CLOSE),

    TRAPDOORS(Text.translatable("text.sound_source.trapdoors"),
            SoundCategory.BLOCKS,

            //? if >=1.20.3 {
            SoundEvents.BLOCK_COPPER_TRAPDOOR_OPEN,
            SoundEvents.BLOCK_COPPER_TRAPDOOR_CLOSE,
            //?}

            SoundEvents.BLOCK_IRON_TRAPDOOR_OPEN,
            SoundEvents.BLOCK_IRON_TRAPDOOR_CLOSE,
            SoundEvents.BLOCK_WOODEN_TRAPDOOR_OPEN,
            SoundEvents.BLOCK_WOODEN_TRAPDOOR_CLOSE,
            SoundEvents.BLOCK_BAMBOO_WOOD_TRAPDOOR_OPEN,
            SoundEvents.BLOCK_BAMBOO_WOOD_TRAPDOOR_CLOSE,
            SoundEvents.BLOCK_CHERRY_WOOD_TRAPDOOR_OPEN,
            SoundEvents.BLOCK_CHERRY_WOOD_TRAPDOOR_CLOSE,
            SoundEvents.BLOCK_NETHER_WOOD_TRAPDOOR_OPEN,
            SoundEvents.BLOCK_NETHER_WOOD_TRAPDOOR_CLOSE),

    FENCE_GATES(Text.translatable("text.sound_source.fence_gates"),
            SoundCategory.BLOCKS,
            SoundEvents.BLOCK_FENCE_GATE_OPEN,
            SoundEvents.BLOCK_FENCE_GATE_CLOSE,
            SoundEvents.BLOCK_CHERRY_WOOD_FENCE_GATE_OPEN,
            SoundEvents.BLOCK_CHERRY_WOOD_FENCE_GATE_CLOSE,
            SoundEvents.BLOCK_BAMBOO_WOOD_FENCE_GATE_OPEN,
            SoundEvents.BLOCK_BAMBOO_WOOD_FENCE_GATE_CLOSE,
            SoundEvents.BLOCK_NETHER_WOOD_FENCE_GATE_OPEN,
            SoundEvents.BLOCK_NETHER_WOOD_FENCE_GATE_CLOSE),

    PRESSURE_PLATES(Text.translatable("text.sound_source.pressure_plates"),
            SoundCategory.BLOCKS,
            SoundEvents.BLOCK_BAMBOO_WOOD_PRESSURE_PLATE_CLICK_OFF,
            SoundEvents.BLOCK_BAMBOO_WOOD_PRESSURE_PLATE_CLICK_ON,
            SoundEvents.BLOCK_CHERRY_WOOD_PRESSURE_PLATE_CLICK_OFF,
            SoundEvents.BLOCK_CHERRY_WOOD_PRESSURE_PLATE_CLICK_ON,
            SoundEvents.BLOCK_METAL_PRESSURE_PLATE_CLICK_OFF,
            SoundEvents.BLOCK_METAL_PRESSURE_PLATE_CLICK_ON,
            SoundEvents.BLOCK_NETHER_WOOD_PRESSURE_PLATE_CLICK_OFF,
            SoundEvents.BLOCK_NETHER_WOOD_PRESSURE_PLATE_CLICK_ON,
            SoundEvents.BLOCK_STONE_PRESSURE_PLATE_CLICK_OFF,
            SoundEvents.BLOCK_STONE_PRESSURE_PLATE_CLICK_ON,
            SoundEvents.BLOCK_WOODEN_PRESSURE_PLATE_CLICK_OFF,
            SoundEvents.BLOCK_WOODEN_PRESSURE_PLATE_CLICK_ON),

    BUTTONS(Text.translatable("text.sound_source.buttons"),
            SoundCategory.BLOCKS,
            SoundEvents.BLOCK_BAMBOO_WOOD_BUTTON_CLICK_OFF,
            SoundEvents.BLOCK_BAMBOO_WOOD_BUTTON_CLICK_ON,
            SoundEvents.BLOCK_BAMBOO_WOOD_BUTTON_CLICK_OFF,
            SoundEvents.BLOCK_CHERRY_WOOD_BUTTON_CLICK_ON,
            SoundEvents.BLOCK_NETHER_WOOD_BUTTON_CLICK_OFF,
            SoundEvents.BLOCK_NETHER_WOOD_BUTTON_CLICK_ON,
            SoundEvents.BLOCK_STONE_BUTTON_CLICK_OFF,
            SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON,
            SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_OFF,
            SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON),

    LEVER(Text.translatable("block.minecraft.lever"),
            SoundCategory.BLOCKS,
            SoundEvents.BLOCK_LEVER_CLICK),

    TRIPWIRE_HOOK(Text.translatable("block.minecraft.tripwire_hook"),
            SoundCategory.BLOCKS,
            SoundEvents.BLOCK_TRIPWIRE_CLICK_ON,
            SoundEvents.BLOCK_TRIPWIRE_CLICK_OFF),

    REDSTONE_TORCH(Text.translatable("block.minecraft.redstone_torch"),
            SoundCategory.BLOCKS,
            SoundEvents.BLOCK_REDSTONE_TORCH_BURNOUT),

    MINECART(Text.translatable("item.minecraft.minecart"),
            SoundCategory.NEUTRAL,
            SoundEvents.ENTITY_MINECART_RIDING);

    private static final HashMap<SoundEvent, SoundSource> SOUND_EVENT_TO_SOURCE = new HashMap<>() {{
        for (SoundSource source : SoundSource.values()) {
            for (SoundEvent soundEvent : source.soundEvents) {
                put(soundEvent, source);
            }
        }
    }};

    public final Text translation;
    public final SoundCategory originalCategory;
    public final SoundEvent[] soundEvents;

    SoundSource(Text translation, SoundCategory originalCategory, SoundEvent... soundEvents) {
        this.translation = translation;
        this.originalCategory = originalCategory;
        this.soundEvents = soundEvents;
    }

    @Nullable
    public static SoundSource fromSoundEvent(SoundEvent soundEvent) {
        return SOUND_EVENT_TO_SOURCE.get(soundEvent);
    }

    public boolean isChanged() {
        return ConfigManager.getInstance().getConfig().sources.getOrDefault(this, false);
    }
}