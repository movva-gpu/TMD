package net.oftl.tmd.items;

import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class CopyrightedRecordItem extends RecordItem {
    /**
     * For mod use, allows to create a music disc without having to create a new
     * SoundEvent before their registry event is fired.
     *
     * @param comparatorValue The value this music disc should output on the comparator. Must be between 0 and 15.
     * @param soundSupplier   A supplier that provides the sound that should be played. Use a
     *                        {@link RegistryObject < SoundEvent >} or a
     *                        {@link Holder <SoundEvent>} for this parameter.
     * @param builder         A set of {@link Item.Properties} that describe this item.
     * @param lengthInTicks   The length of the music disc track in ticks.
     */
    public CopyrightedRecordItem(int comparatorValue, Supplier<SoundEvent> soundSupplier, Properties builder, int lengthInTicks) {
        super(comparatorValue, soundSupplier, builder, lengthInTicks);
    }

    @Override
    public MutableComponent getDisplayName() {
        return Component.translatable(this.getDescriptionId() + ".copyright");
    }
}
