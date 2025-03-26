package me.chrr.rss.mixin;

import me.chrr.rss.RedstoneSoundSlider;
import me.chrr.rss.SoundSource;
import net.minecraft.client.sound.MovingMinecartSoundInstance;
import net.minecraft.sound.SoundCategory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(MovingMinecartSoundInstance.class)
public abstract class MovingMinecartSoundInstanceMixin {
    @ModifyArg(method = "<init>",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/sound/MovingSoundInstance;<init>(Lnet/minecraft/sound/SoundEvent;Lnet/minecraft/sound/SoundCategory;Lnet/minecraft/util/math/random/Random;)V"),
            index = 1)
    private static SoundCategory changeCategory(SoundCategory category) {
        return SoundSource.MINECART.isChanged() ? RedstoneSoundSlider.redstoneSoundCategory : category;
    }
}
