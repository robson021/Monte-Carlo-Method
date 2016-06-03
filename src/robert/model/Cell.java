package robert.model;

import java.awt.*;
import java.util.Random;

/**
 * Created by robert on 03.06.16.
 */
public class Cell {
    private static int idCounter = 0;
    public static final int SIZE = 2; // default width & height
    private static final Random random = new Random();

    private final int ID, cordX, cordY;
    private Color color;

    public Cell(int i, int j) {
        cordX = i * SIZE;
        cordY = j * SIZE;
        this.ID = idCounter++;
        //if (ID == 0) color = Color.BLACK;
        //if (ID == 1599) color = Color.BLUE;
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

    public int getCordX() {
        return cordX;
    }

    public int getCordY() {
        return cordY;
    }
}
