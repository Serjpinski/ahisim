package flatland.model;

public class Game {

    public World world;

    public Game(GameOptions gameOptions) {
        this.world = new World(gameOptions.width, gameOptions.height);
    }
}
