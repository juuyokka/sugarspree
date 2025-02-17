package dev.lactose.createsugarspree.register;

import com.tterrag.registrate.util.entry.ItemEntry;
import dev.lactose.createsugarspree.BuildConfig;
import dev.lactose.createsugarspree.common.items.VeganEggItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import static dev.lactose.createsugarspree.CreateSugarSpree.REGISTRATE;

public class ModItems {
    public static CreativeModeTab itemGroup = new CreativeModeTab(BuildConfig.MODID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.SUGAR);
        }
    };

    static {
        REGISTRATE.creativeModeTab(() -> itemGroup);
    }

    public static final ItemEntry<VeganEggItem> VEGAN_EGG = REGISTRATE.item("vegan_egg_bottle", VeganEggItem::new)
            .properties(p -> p
                    .food(new FoodProperties.Builder().nutrition(4).build())
                    .craftRemainder(Items.GLASS_BOTTLE))
            .register();

    public static void register() {
    }
}
