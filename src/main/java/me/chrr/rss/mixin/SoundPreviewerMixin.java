package me.chrr.rss.mixin;

//? if >=1.21.9 {

import me.chrr.rss.RedstoneSoundSlider;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.client.sound.SoundManager;
import net.minecraft.client.sound.SoundPreviewer;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SoundPreviewer.class)
public abstract class SoundPreviewerMixin {
    @Shadow
    private static boolean canPlaySound(SoundManager manager) {
        return false;
    }

    @Shadow
    @Nullable
    private static SoundInstance currentSoundPreview;

    @Inject(method = "preview", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/sound/SoundPreviewer;stopPreviewOfOtherCategory(Lnet/minecraft/client/sound/SoundManager;Lnet/minecraft/sound/SoundCategory;)V"), cancellable = true)
    private static void previewRedstoneCategory(SoundManager manager, SoundCategory category, float pitch, CallbackInfo ci) {
        if (category == RedstoneSoundSlider.redstoneSoundCategory) {
            ci.cancel();

            if (canPlaySound(manager)) {
                currentSoundPreview = PositionedSoundInstance.master(SoundEvents.BLOCK_PISTON_EXTEND, 1.0F, pitch);
                manager.play(currentSoundPreview);
            }
        }
    }
}

//?} else {
/*import org.spongepowered.asm.mixin.Mixin;

@Mixin(me.chrr.rss.RedstoneSoundSlider.class)
public class SoundPreviewerMixin {
}
*///?}
