package space.lizari;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.HungerManager;
import org.apache.logging.log4j.Level;

import java.math.BigDecimal;
import java.text.DecimalFormat;


@Environment(EnvType.CLIENT)
public class Hud implements HudRenderCallback {
    public Hud() {
        HudRenderCallback.EVENT.register(this);
    }

    @Override
    public void onHudRender(MatrixStack matrixStack, float tickDelta) {
        final ModConfig config = Saturation.getInstance().getConfig();
        final MinecraftClient client = MinecraftClient.getInstance();
        final ClientPlayerEntity player = client.player;

        if (!config.toggleHud)  return;
        if (player == null) return;

        final HungerManager manager = player.getHungerManager();
        final TextRenderer textRenderer = client.textRenderer;
        final BigDecimal saturation = BigDecimal.valueOf(manager.getSaturationLevel());
        final DecimalFormat formatter = new DecimalFormat("#.#");
        formatter.setMaximumFractionDigits(1);
        formatter.setMaximumIntegerDigits(2);
        final String text = formatter.format(saturation);
        Position.setDefaultValue(client.getWindow());

        if (config.toggleShadow) {
            textRenderer.drawWithShadow(matrixStack, text, config.position.getWidth(), config.position.getHeight(), config.text_color);
        } else {
            textRenderer.draw(matrixStack, text, config.position.getWidth(), config.position.getHeight(), config.text_color);
        }
    }
}