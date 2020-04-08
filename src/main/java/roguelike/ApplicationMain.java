package roguelike;

import asciiPanel.AsciiPanel;
import javax.swing.JFrame;

public class ApplicationMain extends JFrame {
    private AsciiPanel terminal;

    /**
     * Starts a new AsciiPanel to being the game.
     */
    public ApplicationMain() {
        super();
        terminal = new AsciiPanel();
        terminal.write("Roguelike in Java : Terminal test", 1, 1);
        add(terminal);
        pack();
    }

    /**
     * Main function that calls ApplicationMain.
     * @param args Extra arguments if required
     */
    public static void main(String[] args) {
        ApplicationMain app = new ApplicationMain();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}
