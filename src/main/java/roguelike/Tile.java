package roguelike;

import asciiPanel.AsciiPanel;

import java.awt.Color;

public enum Tile {
    FLOOR((char)250, AsciiPanel.yellow),
    WALL((char)177, AsciiPanel.yellow),
    BOUNDS('x',AsciiPanel.brightBlack);

    private char glyph;
    private Color color;

    public char glyph() {
        return glyph;
    }

    public Color color() {
        return color;
    }

    Tile(char glyph, Color color) {
        this.glyph = glyph;
        this.color = color;
    }
}
