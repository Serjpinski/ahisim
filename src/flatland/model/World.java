package flatland.model;

import flatland.model.entity.City;

import java.util.ArrayList;
import java.util.List;

public class World {

    public Terrain[][] terrain;
    public List<City> cities;

    public World(int width, int height) {

        terrain = new Terrain[width][height];
        cities = new ArrayList<>();
    }
}
