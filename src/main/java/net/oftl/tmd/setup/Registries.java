package net.oftl.tmd.setup;

import com.mojang.logging.LogUtils;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.oftl.tmd.TMDMod;
import net.oftl.tmd.items.CopyrightedRecordItem;
import org.slf4j.Logger;

import static net.oftl.tmd.TMDMod.res;

public class Registries {
    //Deferred Register
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TMDMod.MOD_ID);
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, TMDMod.MOD_ID);

    //Music Discs Registry Ojects
    public static final RegistryObject<Item> QUACKITY_SONG = makeCopyrightedMusicDisc("quackity_song",
            CreativeModeTab.TAB_MISC, Rarity.EPIC,218);
    public static final RegistryObject<Item> DISC_8_BIT_MADNESS = makeMusicDisc("8bit_madness",
            CreativeModeTab.TAB_MISC,61);
    public static final RegistryObject<Item> AETHER = makeMusicDisc("aether",
            CreativeModeTab.TAB_MISC,61);
    public static final RegistryObject<Item> FRUITY_HELL = makeMusicDisc("fruit_hell",
            CreativeModeTab.TAB_MISC,61);

    //Methods
    public static RegistryObject<Item> makeMusicDisc(String name, CreativeModeTab tab, int lengthInSeconds) {
            RegistryObject<SoundEvent> music = registerMusic(name);
            return registerRecordItem(name, tab, music, lengthInSeconds);
    }
    public static RegistryObject<Item> makeCopyrightedMusicDisc(String name, CreativeModeTab tab, Rarity rarity,
                                                                int lengthInSeconds) {
        RegistryObject<SoundEvent> music = registerMusic(name);
        return registerCopyrightedRecordItem(name, tab, rarity, music, lengthInSeconds);
    }
    public static RegistryObject<Item> makeMusicDisc(String name, CreativeModeTab tab, Rarity rarity,
                                                     int lengthInSeconds) {
            RegistryObject<SoundEvent> music = registerMusic(name);
            return registerRecordItem(name, tab, rarity, music, lengthInSeconds);
    }
    public static RegistryObject<SoundEvent> registerMusic(String name) {
        return registerSoundEvent("music_disc." + name);
    }
    public static RegistryObject<Item> registerRecordItem(String name, CreativeModeTab tab,
                                                          RegistryObject<SoundEvent> sound, int lengthInSeconds) {
        return ITEMS.register(name, () -> new RecordItem(5, sound,
                new Item.Properties().tab(tab).stacksTo(1).rarity(Rarity.RARE),lengthInSeconds * 20));
    }
    public static RegistryObject<Item> registerCopyrightedRecordItem(String name, CreativeModeTab tab, Rarity rarity,
                                                                     RegistryObject<SoundEvent> sound, int lengthInSeconds) {
        return ITEMS.register(name, () -> new CopyrightedRecordItem(5, sound,
                new Item.Properties().tab(tab).stacksTo(1).rarity(rarity),lengthInSeconds * 20));
    }
    public static RegistryObject<Item> registerRecordItem(String name, CreativeModeTab tab, Rarity rarity,
                                                          RegistryObject<SoundEvent> sound, int lengthInSeconds) {
        return ITEMS.register(name, () -> new RecordItem(5, sound,
                new Item.Properties().tab(tab).stacksTo(1).rarity(rarity),
                lengthInSeconds * 20));
    }
    public static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () ->
                new SoundEvent(res(name)));
    }

    //Register method
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        SOUND_EVENTS.register(eventBus);
    }
}
