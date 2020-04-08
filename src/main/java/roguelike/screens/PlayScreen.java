package roguelike.screens;

import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;

public class PlayScreen implements Screen {

    /**
     * Render output to the passed terminal.
     *
     * @param terminal AsciiPanel reference on which content is rendered
     */
    public void displayOutput(AsciiPanel terminal) {
        terminal.write("Game renders on the PlayScreen", 1, 1);
        terminal.writeCenter("-- press [escape] to lose or [enter] to win --", 22);
    }

    /**
     * Respond to user input.
     *
     * @param key Key event occured while screen is displayed
     * @return Screen reference
     */
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ESCAPE: return new LoseScreen();
            case KeyEvent.VK_ENTER: return new WinScreen();
            default : return this;
        }
    }
}
