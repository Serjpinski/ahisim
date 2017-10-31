package flatland.ui;

import flatland.model.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameWindow extends JFrame implements KeyListener {

    private final Font font;
    private final WorldPanel worldPanel;

    public GameWindow(Game game, String title, int fontSize) {

        this.setTitle(title);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        font = new Font(Font.MONOSPACED, Font.BOLD, fontSize);
        worldPanel = new WorldPanel(game.world, font);

        this.add(worldPanel);
        this.addKeyListener(this);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_Q: onPressedQuit(); break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private void onPressedQuit() {

        worldPanel.stop();
        System.exit(0);
    }
}
