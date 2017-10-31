package flatland.ui;

import flatland.model.Terrain;
import flatland.model.entity.Entity;
import flatland.ui.constants.EntitySymbols;
import flatland.ui.constants.EntityColors;
import flatland.ui.constants.TerrainColors;

import javax.swing.*;
import java.awt.*;

public class Cell {

    public final JLabel label;

    private Terrain terrain;
    private Entity entity;

    public Cell(Terrain terrain, Entity entity, Font font) {
        this.terrain = terrain;
        this.entity = entity;

        label = new JLabel();
        label.setFont(font);
        label.setPreferredSize(new Dimension(font.getSize(), font.getSize()));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.BOTTOM);
        label.setOpaque(true);

        entityUpdated();
        terrainUpdated();
        label.setBackground(TerrainColors.getColor(terrain));
    }

    public void entityUpdated() {
        label.setText(EntitySymbols.getSymbol(entity));
        label.setForeground(EntityColors.getColor(entity));
    }

    public void terrainUpdated() {
        label.setBackground(TerrainColors.getColor(terrain));
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
        terrainUpdated();
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
        entityUpdated();
    }
}
