package roguelike;

public class PlayerAi extends CreatureAi {

    public PlayerAi(Creature creature) {
        super(creature);
    }

    /**
     * Player specific implementation of onEnter() intelligence.
     *
     * <p> Player onEnter() checks if the tile it is walking on is diggable.
     * If diggable, the dig function is called which changes the WALL tile to a FLOOR tile.
     * If not diggable, the player is set to the new coordinates </p>
     * @param x Tile postion x coordinate
     * @param y Tie position y coordinate
     * @param tile Reference to tile the player is entering
     */
    public void onEnter(int x, int y, Tile tile) {
        if (tile.isGround()) {
            creature.posx = x;
            creature.posy = y;
        } else if (tile.isDiggable()) {
            creature.dig(x,y);
        }
    }

}
