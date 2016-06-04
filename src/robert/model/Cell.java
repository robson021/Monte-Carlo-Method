package robert.model;

import java.awt.*;
import java.util.Random;

/**
 * Created by robert on 03.06.16.
 */
public class Cell {
    //private static int idCounter = 0;
    public static final int SIZE = 3; // default width & height
    private static Cell[][] cells;
    private static final Random random = new Random();
    private static final Conditions conditions = Conditions.getConditions();


    private int id, cordX, cordY;
    private final int x, y;
    private Color color;

    public Cell(int i, int j) {
        x = i;
        y = j;
        cordX = i * SIZE;
        cordY = j * SIZE;
        this.id = random.nextInt(10);
    }

    /*public void reset() {
        color = Color.WHITE;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setRandomColor() {
        // new RGB color
        color = conditions.getRandomColor();
    }

    public int getX() {
        return x;
    }

    public static void setCells(Cell[][] cells) {
        Cell.cells = cells;
    }

    public int getY() {
        return y;
    }

    public int getCordX() {
        return cordX;
    }

    public int getCordY() {
        return cordY;
    }

    public void check() {
        int counter = 0;
        Cell otherCell;
        for (int j, i = x - 1; i < x + 2; i++) {
            for (j = y - 1; j < y + 2; j++) {
                if (i == x && j == y) continue; // skip checking myself
                try {
                    otherCell = this.cells[i][j];
                    if (otherCell.getId() != this.id) counter++;
                } catch (Exception e) {
                }
            }
        }
        if (id <= counter) {

        }
    }
}
