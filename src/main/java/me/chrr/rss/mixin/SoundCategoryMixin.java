package me.chrr.rss.mixin;

import me.chrr.rss.RedstoneSoundSlider;
import net.minecraft.sound.SoundCategory;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Arrays;

@Mixin(SoundCategory.class)
public abstract class SoundCategoryMixin {
    @Invoker("<init>")
    @SuppressWarnings("SameParameterValue")
    private static SoundCategory createSoundCategory(String internalName, int internalId, String name) {
        throw new AssertionError();
    }

    @Shadow
    @Final
    @Mutable
    private static SoundCategory[] field_15255;

    @Inject(method = "<clinit>", at = @At(value = "TAIL"))
    private static void addRedstoneCategory(CallbackInfo ci) {
        SoundCategory[] categories = Arrays.copyOf(field_15255, SoundCategory.values().length + 1);

        int id = field_15255[field_15255.length - 1].ordinal() + 1;
        RedstoneSoundSlider.redstoneSoundCategory
                = categories[categories.length - 1]
                = createSoundCategory("REDSTONE", id, "redstone");

        field_15255 = categories;
    }
}
