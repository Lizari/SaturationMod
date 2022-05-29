package space.lizari;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Environment(EnvType.CLIENT)
public class Saturation implements ModInitializer {

    private ModConfig config;
    private static Saturation instance;
    public static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void onInitialize() {
        instance = this;

        this.config = AutoConfig.register(ModConfig.class, GsonConfigSerializer::new).getConfig();
        new Hud();
        LOGGER.info("Saturation Mod has been Initialized");
    }
    public ModConfig getConfig() {
        return this.config;
    }
    public static Saturation getInstance() {
        return instance;
    }

}
