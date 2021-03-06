package robert.model;

import java.awt.*;
import java.util.Random;

/**
 * Created by robert on 03.06.16.
 */
public class Cell {
    public static final int SIZE = 3; // default width & height
    private static Cell[][] cells;
    private static final Random random = new Random();
    private static final Conditions conditions = Conditions.getConditions();


    private int id;
    private final int x, y, cordX, cordY;
    private Color color;
    private boolean modified = false;

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

    private void setId(int id) {
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    private void setColor(Color color) {
        this.color = color;
    }

    public void serColorById(int id) {
        // new RGB color
        color = conditions.getColorById(id);
    }

    public static void setCells(Cell[][] cells) {
        Cell.cells = cells;
    }



    public int getCordX() {
        return cordX;
    }

    public int getCordY() {
        return cordY;
    }

    public void check() {
        Cell otherCell;
        int myEnergy = this.calculateEnergy();

        // pick random neighbour
        for (int i = 0; i < 35; i++) { // finite amount of attempts, otherwise program will freeze
            int _x = random.nextInt(3) + x - 1;
            int _y = random.nextInt(3) + y - 1;
            try {
                otherCell = cells[_x][_y];
                int otherEnergy = otherCell.calculateEnergy();
                if (otherCell != this && !otherCell.modified && myEnergy <= otherEnergy) {
                    //System.out.println("my: " +myEnergy +"; other: " + otherEnergy);
                    otherCell.setId(this.id);
                    otherCell.setColor(this.color);
                    otherCell.modified = true;
                    break;
                }
            } catch (Exception e) {
            }
        }
    }

    private int calculateEnergy() {
        Cell otherCell;
        int myEnergy = 0;
        for (int j, i = x - 1; i < x + 2; i++) {
            for (j = y - 1; j < y + 2; j++) {
                if (i == x && j == y) continue;
                try {
                    otherCell = cells[i][j];
                    if (otherCell.id != this.id) {
                        ++myEnergy;
                    }
                } catch (Exception e) {
                }
            }
        }
        return myEnergy;
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

    public void setModified() {
        this.modified = false;
    }

    public void setRandomId() {
        this.id = conditions.getRandomId();
    }


}
