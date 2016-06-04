package robert.model;

import java.awt.*;
import java.util.Random;

/**
 * Created by robert on 03.06.16.
 */
public class Cell {
    private static int idCounter = 0;
    public static final int SIZE = 4; // default width & height
    private static Cell[][] cells;
    private static final Random random = new Random();
    private static final Conditions conditions = Conditions.getConditions();


    private int id;
    private final int x, y, cordX, cordY;
    private Color color;

    public Cell(int i, int j) {
        x = i;
        y = j;
        cordX = i * SIZE;
        cordY = j * SIZE;
        this.id = conditions.getRandomId();
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
            boolean done = false;
            while (!done) {
                try {
                    int i = random.nextInt(3);
                    int j = random.nextInt(3);
                    otherCell = cells[x - 1 + i][y - 1 + j];
                    this.id = otherCell.getId();
                    this.color = otherCell.getColor();
                    done = true;
                } catch (Exception e) {
                }
            }
        }
        //System.out.println("Check of " + toString() + " finished.");
    }

    @Override
    public String toString() {
        return "Cell{" +
                "x=" + x +
                ", y=" + y +
                ", color=" + color +
                ", id=" + id +
                '}';
    }

    public void setRandomId() {
        this.id = conditions.getRandomId();
    }
}
