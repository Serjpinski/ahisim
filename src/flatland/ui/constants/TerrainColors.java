package flatland.ui.constants;

import flatland.model.Terrain;

import java.awt.*;

public class TerrainColors {

    public static final Color UNDEFINED = Color.BLACK;
    public static final Color WATER = Color.BLUE;
    public static final Color PLAINS = Color.ORANGE;
    public static final Color MOUNTAIN = Color.RED;
    public static final Color FOREST = Color.GREEN;
    public static final Color DESERT = Color.YELLOW;
    public static final Color SWAMP = Color.GRAY;
    public static final Color ICE = Color.CYAN;

    public static Color getColor(Terrain terrain) {

        switch (terrain) {
            case UNDEFINED: return UNDEFINED;
            case WATER: return WATER;
            case PLAINS: return PLAINS;
            case MOUNTAIN: return MOUNTAIN;
            case FOREST: return FOREST;
            case DESERT: return DESERT;
            case SWAMP: return SWAMP;
            case ICE: return ICE;
            default: return null;
        }
    }
}
