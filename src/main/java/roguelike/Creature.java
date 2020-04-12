package roguelike;

import java.awt.Color;

public class Creature {

    private World world;
    private CreatureAi creatureAi;

    public int posx;
    public int posy;

    private char glyph;
    private Color color;

    public char getGlyph() {
        return glyph;
    }

    public Color getColor() {
        return color;
    }

    public void setCreatureAi(CreatureAi creatureAi) {
        this.creatureAi = creatureAi;
    }

    /**
     * Constructor for a creature.
     * @param world Reference to the World on which to render
     * @param glyph Glyph that represents the creature
     * @param color Color of the creature
     */
    public Creature(World world, char glyph, Color color) {
        this.world = world;
        this.glyph = glyph;
        this.color = color;
    }

    public void moveBy(int mx, int my) {
        creatureAi.onEnter(posx + mx, posy + my, world.tile(posx + mx, posy + my));
    }

    /**
     * Uses the World reference to dig the specific tile with the passed coordinates.
     * @param wx Coordinate X of the tile to dig
     * @param wy Coordinate Y of the tile to dig
     */
    public void dig(int wx, int wy) {
        world.dig(wx, wy);
    }


}
