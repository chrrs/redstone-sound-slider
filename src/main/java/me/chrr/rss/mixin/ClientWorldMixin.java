package me.chrr.rss.mixin;

import me.chrr.rss.RedstoneSoundSlider;
import me.chrr.rss.SoundSource;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(ClientWorld.class)
public abstract class ClientWorldMixin {
    @Unique
    private boolean rss$shouldChangeCategory(SoundEvent event, SoundCategory category) {
        SoundSource source = SoundSource.fromSoundEvent(event);
        return source != null && source.isChanged() && source.originalCategory == category;
    }

    @ModifyArgs(method = "playSound(DDDLnet/minecraft/sound/SoundEvent;Lnet/minecraft/sound/SoundCategory;FFZJ)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/sound/PositionedSoundInstance;<init>(Lnet/minecraft/sound/SoundEvent;Lnet/minecraft/sound/SoundCategory;FFLnet/minecraft/util/math/random/Random;DDD)V"))
    public void changeCategory1(Args args) {
        if (rss$shouldChangeCategory(args.get(0), args.get(1))) {
            args.set(1, RedstoneSoundSlider.redstoneSoundCategory);
        }
    }

    //? if <1.21.5 {
    /*@ModifyArgs(method = "playSoundFromEntity(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/entity/Entity;Lnet/minecraft/registry/entry/RegistryEntry;Lnet/minecraft/sound/SoundCategory;FFJ)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/sound/EntityTrackingSoundInstance;<init>(Lnet/minecraft/sound/SoundEvent;Lnet/minecraft/sound/SoundCategory;FFLnet/minecraft/entity/Entity;J)V"))
    public void changeCategory2(Args args) {
        if (rss$shouldChangeCategory(args.get(0), args.get(1))) {
            args.set(1, RedstoneSoundSlider.redstoneSoundCategory);
        }
    }
    *///?}

    //? if >=1.21 && <1.21.5 {
    /*@ModifyArgs(method = "playSoundFromEntity(Lnet/minecraft/entity/Entity;Lnet/minecraft/sound/SoundEvent;Lnet/minecraft/sound/SoundCategory;FF)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/sound/EntityTrackingSoundInstance;<init>(Lnet/minecraft/sound/SoundEvent;Lnet/minecraft/sound/SoundCategory;FFLnet/minecraft/entity/Entity;J)V"))
    public void changeCategory3(Args args) {
        if (rss$shouldChangeCategory(args.get(0), args.get(1))) {
            args.set(1, RedstoneSoundSlider.redstoneSoundCategory);
        }
    }
    *///?}

    //? if >=1.21.5 {
    @ModifyArgs(method = "playSoundFromEntity",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/sound/EntityTrackingSoundInstance;<init>(Lnet/minecraft/sound/SoundEvent;Lnet/minecraft/sound/SoundCategory;FFLnet/minecraft/entity/Entity;J)V"))
    public void changeCategory4(Args args) {
        if (rss$shouldChangeCategory(args.get(0), args.get(1))) {
            args.set(1, RedstoneSoundSlider.redstoneSoundCategory);
        }
    }


    @ModifyArgs(method = "playSoundFromEntityClient",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/sound/EntityTrackingSoundInstance;<init>(Lnet/minecraft/sound/SoundEvent;Lnet/minecraft/sound/SoundCategory;FFLnet/minecraft/entity/Entity;J)V"))
    public void changeCategory5(Args args) {
        if (rss$shouldChangeCategory(args.get(0), args.get(1))) {
            args.set(1, RedstoneSoundSlider.redstoneSoundCategory);
        }
    }

    @ModifyArgs(method = "playSoundClient(Lnet/minecraft/sound/SoundEvent;Lnet/minecraft/sound/SoundCategory;FF)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/sound/EntityTrackingSoundInstance;<init>(Lnet/minecraft/sound/SoundEvent;Lnet/minecraft/sound/SoundCategory;FFLnet/minecraft/entity/Entity;J)V"))
    public void changeCategory6(Args args) {
        if (rss$shouldChangeCategory(args.get(0), args.get(1))) {
            args.set(1, RedstoneSoundSlider.redstoneSoundCategory);
        }
    }
    //?}
}
