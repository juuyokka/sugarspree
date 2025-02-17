package dev.lactose.createsugarspree.common.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;

public class VeganEggItem extends Item {
    public VeganEggItem(Properties properties) {
        super(properties);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) { return UseAnim.DRINK; }

    @Override
    public SoundEvent getDrinkingSound() { return SoundEvents.GENERIC_DRINK; }

    @Override
    public SoundEvent getEatingSound() { return SoundEvents.GENERIC_DRINK; }
}
