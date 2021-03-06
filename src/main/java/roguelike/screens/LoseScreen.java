package roguelike.screens;

import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public class LoseScreen implements Screen {

    /**
     * Render output to the passed terminal.
     *
     * @param terminal AsciiPanel reference on which content is rendered
     */
    public void displayOutput(AsciiPanel terminal) {
        terminal.write("You lost.", 1, 1);
        terminal.writeCenter("-- press [enter] to restart --", 22);
    }

    /**
     * Respond to user input.
     *
     * @param key Key event occured while screen is displayed
     * @return Screen reference
     */
    public Screen respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
    }
}
