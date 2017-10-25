package flatland.model;

import flatland.model.entity.City;
import flatland.model.entity.Nation;
import flatland.model.entity.unit.Unit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class World {

    public Terrain[][] terrain;
    public List<Nation> nations;
    public Map<Nation, List<City>> cities;
    public Map<Nation, List<Unit>> units;

    public World(int width, int height) {

        terrain = new Terrain[width][height];
        cities = new HashMap<>();
    }
}
