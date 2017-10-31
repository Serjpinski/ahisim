package flatland.ui;

import flatland.model.World;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class WorldPanel extends JPanel {

    private final World world;
    private final JLabel[][] grid;
    private final Thread updater;

    public WorldPanel(World world, Font font) {

        this.world = world;

        grid = new JLabel[world.width][world.height];

        for (int j = 0; j < world.height; j++) {

            for (int i = 0; i < world.width; i++) {

                JLabel label = new JLabel();
                label.setFont(font);
                label.setPreferredSize(new Dimension(font.getSize(), font.getSize()));
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setVerticalAlignment(JLabel.BOTTOM);
                label.setOpaque(true);
                label.setText("ç");

                grid[i][j] = label;
                this.add(grid[i][j]);
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

        for (int i = 0; i < world.width; i++) {

            for (int j = 0; j < world.height; j++) {

                //TODO remove this
                grid[i][j].setBackground(new Color(random.nextFloat(), random.nextFloat(), random.nextFloat()));
            }
        }
    }
}
