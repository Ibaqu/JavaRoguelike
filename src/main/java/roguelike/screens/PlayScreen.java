package roguelike.screens;

import asciiPanel.AsciiPanel;
import roguelike.World;
import roguelike.WorldBuilder;

import java.awt.event.KeyEvent;

public class PlayScreen implements Screen {

    private World world;

    // Width and Height of the play screen
    private int playWidth;
    private int playHeight;

    // Width and Height of Terminal Screen
    private int screenWidth;
    private int screenHeight;

    // Coordinates on the tile map
    private int tileX;
    private int tileY;

    /**
     * PlayScreen constructor.
     *
     * <p> Sets the Terminal Screen max height and max width.
     * Calls createWorld function to start the World generation </p>
     */
    public PlayScreen() {
        screenHeight = 21;
        screenWidth = 80;
        playHeight = 32;
        playWidth = 90;

        createWorld();
    }

    /**
     * Render tiles and other output to the passed terminal.
     *
     * <p> Player X (tileX - left) and Player Y (tileY - top) makes sure that the Player stays at the center when
     * the Play screen scrolls in the middle of the World map </p>
     *
     * @param terminal AsciiPanel reference on which content is rendered
     */
    public void displayOutput(AsciiPanel terminal) {
        int left = getScrollX();
        int top = getScrollY();

        displayTiles(terminal, left, top);

        terminal.write('X', tileX - left, tileY - top);
        terminal.writeCenter("-- press [escape] to lose or [enter] to win --", 22);

        // Display Play screen position
        terminal.writeCenter("-- Game info --", 23);
        terminal.write("Left :" + left + ". Top : " + top,0, 24);
        terminal.write("Tile X :" + tileX + ". Tile Y : " + tileY,0, 25);
        terminal.write("Player X :" + (tileX - left) + ". Player Y : " + (tileY - top),0, 26);
    }

    /**
     * Respond to user input.
     *
     * @param key Key event occured while screen is displayed
     * @return Screen reference
     */
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                return new LoseScreen();
            case KeyEvent.VK_ENTER:
                return new WinScreen();
            case KeyEvent.VK_LEFT:
                scrollBy(-1, 0);
                break;
            case KeyEvent.VK_RIGHT:
                scrollBy(1, 0);
                break;
            case KeyEvent.VK_UP:
                scrollBy(0, -1);
                break;
            case KeyEvent.VK_DOWN:
                scrollBy(0, 1);
                break;
            default:
                break;
        }
        return this;
    }

    /**
     * Creates the World using the WorldBuilder.
     *
     * <p> Does not render the world. Simply calls WorldBuilder with set params for the Tile Map </p>
     */
    private void createWorld() {
        world = new WorldBuilder(playWidth, playHeight).makeCaves().build();
    }

    public int getScrollX() {
        return Math.max(0, Math.min(tileX - screenWidth / 2, world.width() - screenWidth));
    }

    public int getScrollY() {
        return Math.max(0, Math.min(tileY - screenHeight / 2, world.height() - screenHeight));
    }

    /**
     * Render the tiles by iterating through each defined tile in the tile set.
     *
     * <p> Renders from top left to bottom right. Takes left and top to know which part to render </p>
     * @param terminal Reference to the terminal
     * @param left Left most tile value
     * @param top Top most tile value
     */
    private void displayTiles(AsciiPanel terminal, int left, int top) {
        for (int x = 0; x < screenWidth; x++) {
            for (int y = 0; y < screenHeight; y++) {
                int wx = x + left;
                int wy = y + top;

                terminal.write(world.getTileGlyph(wx, wy), x, y, world.getTileColor(wx, wy));
            }
        }
    }

    /**
     * Scroll the Screen within screenWidth and screenHeight bounds.
     *
     * @param mx Move left(-1) or right(+1)
     * @param my Move up(-1) or down(+1)
     */
    private void scrollBy(int mx, int my) {
        tileX = Math.max(0, Math.min(tileX + mx, world.width() - 1));
        tileY = Math.max(0, Math.min(tileY + my, world.height() - 1));
    }

}
