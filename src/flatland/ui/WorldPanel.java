package flatland.ui;

import flatland.model.Terrain;
import flatland.model.World;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class WorldPanel extends JPanel {

    private final World world;
    private final Cell[][] grid;
    private final Thread updater;

    public WorldPanel(World world, Font font) {

        this.world = world;

        grid = new Cell[world.width][world.height];

        for (int j = 0; j < world.height; j++) {

            for (int i = 0; i < world.width; i++) {

                grid[i][j] = new Cell(world.terrain[i][j], world.entities[i][j], font);
                this.add(grid[i][j].label);
            }
        }

        this.setLayout(new GridLayout(world.height, world.width, 0, 0));

        updater = new Thread(() -> {

            while (true) {

                update();

                try {
                    Thread.sleep(10000);
                }
                catch (InterruptedException ignored) {}
            }
        });

        updater.start();
    }

    public void stop() {
        updater.interrupt();
    }

    public void update() {

        Random random = new Random();
        int max = Terrain.values().length;

        for (int i = 0; i < world.width; i++) {

            for (int j = 0; j < world.height; j++) {

                //TODO remove this
                grid[i][j].setTerrain(Terrain.values()[random.nextInt(max)]);
            }
        }
    }
}
