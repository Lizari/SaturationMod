package space.lizari;

import net.minecraft.client.util.Window;
public enum Position {
    TOP_LEFT(0, 0),
    TOP_CENTER(0, 0),
    TOP_RIGHT(0, 0),
    MID_LEFT(0, 0),
    MID_CENTER(0, 0),
    MID_RIGHT(0, 0),
    LOW_LEFT(0, 0),
    LOW_CENTER(0, 0),
    LOW_RIGHT(0, 0);

    private int height;
    private int width;

    Position(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public static void setDefaultValue(Window window) {
        final int height = window.getScaledHeight();
        final int width = window.getScaledWidth();
        final int offsetHeight = 5;
        final int offsetWidth = 5;
        final Position position = Saturation.getInstance().getConfig().position;

        switch (position) {
            case TOP_LEFT:
                Position.TOP_LEFT.setHeight(offsetHeight);
                Position.TOP_LEFT.setWidth(offsetWidth);
                break;
            case TOP_CENTER:
                Position.TOP_CENTER.setHeight(offsetHeight);
                Position.TOP_CENTER.setWidth(width / 2);
                break;
            case TOP_RIGHT:
                Position.TOP_RIGHT.setHeight(offsetHeight);
                Position.TOP_RIGHT.setWidth(width - 20);
                break;
            case MID_LEFT:
                Position.MID_LEFT.setHeight(height / 2);
                Position.MID_LEFT.setWidth(offsetWidth);
                break;
            case MID_CENTER:
                Position.MID_CENTER.setHeight(height / 2);
                Position.MID_CENTER.setWidth(width / 2);
                break;
            case MID_RIGHT:
                Position.MID_RIGHT.setHeight(height / 2);
                Position.MID_RIGHT.setWidth(width - 20);
                break;
            case LOW_LEFT:
                Position.LOW_LEFT.setHeight(height - 15);
                Position.LOW_LEFT.setWidth(offsetWidth);
                break;
            case LOW_CENTER:
                Position.LOW_CENTER.setHeight(height - 45);
                Position.LOW_CENTER.setWidth((width / 2) - 3);
                break;
            case LOW_RIGHT:
                Position.LOW_RIGHT.setHeight(height - 15);
                Position.LOW_RIGHT.setWidth(width - 20);
                break;
        }
    }
}
