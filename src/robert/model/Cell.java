package robert.model;

import java.awt.*;
import java.util.Random;

/**
 * Created by robert on 03.06.16.
 */
public class Cell {
    private static int idCounter = 0;
    private static final int SIZE = 50; // default width & height
    private static final Random random = new Random();
    private final int location;

    private final int ID;
    private Color color;

    public Cell() {
        this.ID = idCounter++;
        location = ID * SIZE;
        color = Color.WHITE;
    }

    public void reset() {
        color = Color.WHITE;
    }

    public int getID() {
        return ID;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setRandomColor() {
        // new RGB color
        color = new Color(random.nextFloat(), random.nextFloat(), random.nextFloat());
    }

    public int getLocation() {
        return location;
    }
}
