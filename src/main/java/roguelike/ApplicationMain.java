package roguelike;

import asciiPanel.AsciiPanel;
import roguelike.screens.Screen;
import roguelike.screens.StartScreen;

import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ApplicationMain extends JFrame implements KeyListener {
    private AsciiPanel terminal;
    private Screen screen;

    /**
     * Starts a new AsciiPanel to begin the game.
     */
    private ApplicationMain() {
        super();
        terminal = new AsciiPanel(80, 30);
        add(terminal);
        pack();
        screen = new StartScreen();
        addKeyListener(this);
        repaint();
    }

    /**
     * Main function that calls ApplicationMain.
     *
     * @param args Extra arguments if required
     */
    public static void main(String[] args) {
        ApplicationMain app = new ApplicationMain();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }

    /**
     * Re-renders the screen.
     *
     * <p> Causes AWT runtime system to execute the update() method which clears the screen
     * and calls the paint() method </p>
     */
    public void repaint() {
        terminal.clear();
        screen.displayOutput(terminal);
        super.repaint();
    }

    /**
     * Invoked when a key has been typed.
     *
     * @param e KeyEvent reference
     */
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Invoked when a key has been pressed.
     *
     * @param e KeyEvent reference
     */
    public void keyPressed(KeyEvent e) {
        screen = screen.respondToUserInput(e);
        repaint();
    }

    /**
     * Invoked when a key has been released.
     *
     * @param e KeyEvent reference
     */
    public void keyReleased(KeyEvent e) {
    }
}
