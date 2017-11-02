package flatland.model;

import flatland.model.entity.City;
import flatland.model.entity.Entity;
import flatland.model.entity.Nation;
import flatland.model.entity.unit.Unit;
import flatland.util.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class World {

    public int width;
    public int height;
    public Terrain[][] terrains;
    public Entity[][] entities;
    public List<Nation> nations;
    public Map<Nation, List<City>> cities;
    public Map<Nation, List<Unit>> units;

    public World(int width, int height) {

        this.width = width;
        this.height = height;

        terrains = generateInitialTerrain(width, height);

        nations = new ArrayList<>();

        entities = new Entity[width][height];
        cities = new HashMap<>();
        units = new HashMap<>();
    }

    private Terrain[][] generateInitialTerrain(int width, int height) {

        final int magic = (int) Math.round(Math.sqrt((width * height) / 2));
        final int initialSeeds = magic;
        final int totalPerRound = magic;
        final int coastRounds = (int) Math.round(Math.sqrt(magic));
        final int baseRounds = magic - coastRounds;

        Terrain[][] terrains = new Terrain[width][height];
        int added = 0;

        // Generate initial seeds
        while (added < initialSeeds) {
            int w = Utils.RANDOM.nextInt(width);
            int h = Utils.RANDOM.nextInt(height);
            if (terrains[w][h] == null) {
                terrains[w][h] = Terrain.PLAINS;
                added++;
            }
        }

        // Generate continent base shapes
        for (int i = 0; i < baseRounds; i++) {

            added = 0;

            while (added < totalPerRound) {

                int w = Utils.RANDOM.nextInt(width);
                int h = Utils.RANDOM.nextInt(height);

                if (terrains[w][h] == null) {

                    int neighs = Utils.ortogonalNeighboursWithValue(terrains, Terrain.PLAINS, w, h);

                    if (neighs > 0 && Utils.RANDOM.nextDouble() < 1.0 / (4 - neighs)) {

                        terrains[w][h] = Terrain.PLAINS;
                        added++;
                    }
                }
            }
        }

        // Generate continent coast shapes
        for (int i = 0; i < coastRounds; i++) {

            added = 0;

            while (added < totalPerRound) {

                int w = Utils.RANDOM.nextInt(width);
                int h = Utils.RANDOM.nextInt(height);

                if (terrains[w][h] == null && Utils.hasOrtogonalNeighboursWithValue(terrains, Terrain.PLAINS, w, h)) {

                    terrains[w][h] = Terrain.PLAINS;
                    added++;
                }
            }
        }

        // Fill gaps
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (terrains[i][j] == null &&
                        Utils.ortogonalNeighboursWithValue(terrains, Terrain.PLAINS, i, j) == 4) {
                    terrains[i][j] = Terrain.PLAINS;
                }
            }
        }

        // Fill empty with water
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (terrains[i][j] == null) {
                    terrains[i][j] = Terrain.WATER;
                }
            }
        }

        return terrains;
    }
}
