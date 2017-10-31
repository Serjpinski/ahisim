package flatland.model;

import flatland.model.entity.City;
import flatland.model.entity.Nation;
import flatland.model.entity.unit.Unit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class World {

    public int width;
    public int height;
    public Terrain[][] terrain;
    public List<Nation> nations;
    public Map<Nation, List<City>> cities;
    public Map<Nation, List<Unit>> units;

    public World(int width, int height) {

        this.width = width;
        this.height = height;
        terrain = new Terrain[width][height];
        cities = new HashMap<>();
    }
}
