package dev.lactose.createsugarspree;

import com.simibubi.create.foundation.data.CreateRegistrate;
import dev.lactose.createsugarspree.register.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(BuildConfig.MODID)
public class CreateSugarSpree {
	// Directly reference a log4j logger.
	private static final Logger LOGGER = LogManager.getLogger(BuildConfig.MODID);
	public static IEventBus modEventBus;

	public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(BuildConfig.MODID);

	public CreateSugarSpree() {
		modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		REGISTRATE.registerEventListeners(modEventBus);

		ModItems.register();

		DistExecutor.unsafeRunWhenOn(Dist.CLIENT,
				() -> ModPartials::load);
	}
}
