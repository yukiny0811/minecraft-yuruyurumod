package com.yukiny.yuruyurumod.entries;

import com.yukiny.yuruyurumod.YuruyuruMod;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class YuruSounds {

    public static SoundEvent sound1 = new SoundEvent(new ResourceLocation(YuruyuruMod.MODID, "sound1"));
    public static SoundEvent sound2 = new SoundEvent(new ResourceLocation(YuruyuruMod.MODID, "sound2"));
    public static SoundEvent sound3 = new SoundEvent(new ResourceLocation(YuruyuruMod.MODID, "sound3"));

    public static void register(){
        registerSound(sound1);
        registerSound(sound2);
        registerSound(sound3);
    }

    private static void registerSound(SoundEvent event){
        GameRegistry.register(event, event.getSoundName());
    }
}
