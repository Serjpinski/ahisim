package flatland;

import flatland.model.Game;
import flatland.model.GameOptions;
import flatland.ui.GameWindow;

public class Flatland {

    private static final String APP_NAME = "Flatland";
    private static final int MAJOR_VERSION = 1;
    private static final int MINOR_VERSION = 0;
    private static final int DEVELOPMENT_VERSION = 0;

    private static final int FONT_SIZE = 10;

    public static void main(String[] args) {
        new GameWindow(new Game(new GameOptions(50, 30)),
                getTitle(), FONT_SIZE);
    }

    private static String getVersionString() {
        return MAJOR_VERSION + "." + MINOR_VERSION +
                (DEVELOPMENT_VERSION == 0 ? "" : "." + DEVELOPMENT_VERSION);
    }

    private static String getTitle() {
        return APP_NAME + " " + getVersionString();
    }
}
