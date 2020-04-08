package roguelike.screens;

import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;

public interface Screen {

    /**
     * Render output to the passed terminal.
     * @param terminal AsciiPanel reference on which content is rendered
     */
    void displayOutput(AsciiPanel terminal);

    /**
     * Respond to user input.
     * @param key Key event occured while screen is displayed
     * @return Screen reference
     */
    Screen respondToUserInput(KeyEvent key);

}
