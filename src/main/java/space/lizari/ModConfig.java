package space.lizari;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "saturation")
public class ModConfig implements ConfigData {

    @ConfigEntry.Gui.Tooltip
    public boolean toggleHud = true;

    @ConfigEntry.Gui.Tooltip
    public boolean toggleShadow = true;
    @ConfigEntry.ColorPicker
    public int text_color = 0xffffff;

    @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
    public Position position = Position.TOP_LEFT;
}
