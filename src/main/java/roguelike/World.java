package roguelike;

import java.awt.Color;

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

    public char getTileGlyph(int x, int y) {
        return tile(x, y).glyph();
    }

    public Color getTileColor(int x, int y) {
        return tile(x, y).color();
    }
}
