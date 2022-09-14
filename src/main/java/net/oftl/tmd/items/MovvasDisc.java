package net.oftl.tmd.items;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.RecordItem;

import java.util.function.Supplier;

public class MovvasDisc extends RecordItem {

    public MovvasDisc(int comparatorValue, Supplier<SoundEvent> soundSupplier, Properties builder, int lengthInTicks) {
        super(comparatorValue, soundSupplier, builder, lengthInTicks);
    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return true;
    }
}
