package roguelike;

import java.awt.Color;
import java.util.Map;

public class World {

    private Tile[][] tiles;
    private int width;
    private int height;

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }

    public char getTileGlyph(int x, int y) {
        return tile(x, y).glyph();
    }

    public Color getTileColor(int x, int y) {
        return tile(x, y).color();
    }

    /**
     * World constructor.
     *
     * <p> Constructs the world using the defined tile map </p>
     * @param tiles Map of defined tiles
     */
    public World(Tile[][] tiles) {
        this.tiles = tiles;
        this.width = tiles.length;
        this.height = tiles[0].length;
    }

    /**
     * Tile constructor.
     *
     * <p> Generates the tile layout of the game world </p>
     * @param x Width of the tile map
     * @param y Height of the tile map
     * @return
     */
    public Tile tile(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            return Tile.BOUNDS;
        } else {
            return tiles[x][y];
        }

    }

    /**
     * Function to dig walls.
     *
     * <p> Check if the tile is diggable and changes it to a FLOOR tile if true </p>
     * @param x Coordinate x on tile map
     * @param y Coordinate y on tile map
     */
    public void dig(int x, int y) {
        if (tile(x,y).isDiggable()) {
            tiles[x][y] = Tile.FLOOR;
        }
    }

    /**
     * Creature has to start at a random empty location.
     * @param creature Reference to the current creature
     */
    public void addAtEmptyLocation(Creature creature) {
        int x;
        int y;

        do {
            x = (int)(Math.random() * width);
            y = (int)(Math.random() * height);
        } while (!tile(x,y).isGround());

        creature.posx = x;
        creature.posy = y;
    }


}
