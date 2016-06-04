package robert.gui;

import robert.model.Cell;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by robert on 03.06.16.
 */
public class Board extends JPanel implements Runnable {
    public static final int SIZE = 250;
    private Cell[][] cells = new Cell[SIZE][SIZE];
    private java.util.List<Cell> cellList = new ArrayList<>();
    private boolean running = false;

    public Board() {
        setBackground(Color.WHITE);

        int xy = SIZE * Cell.SIZE + 3;
        setSize(new Dimension(xy, xy));

        Cell.setCells(cells);

        for (int j, i = 0; i < SIZE; i++) {
            for (j = 0; j < SIZE; j++) {
                Cell cell = new Cell(i, j);
                cells[i][j] = cell;
                cellList.add(cell);
            }
        }
        clearBoard();
        System.out.println("Board ready");
    }


    private void clearBoard() {
        for (int j, i = 0; i < SIZE; i++) {
            for (j = 0; j < SIZE; j++) {
                cells[i][j].setRandomColor();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g.create();
        Rectangle rect;
        for (int x, y, j, i = 0; i < SIZE; i++) {
            for (j = 0; j < SIZE; j++) {
                graphics2D.setColor(cells[i][j].getColor());
                x = cells[i][j].getCordX();
                y = cells[i][j].getCordY();
                rect = new Rectangle(x, y, Cell.SIZE, Cell.SIZE);
                graphics2D.fill(rect);
            }
        }
    }

    public boolean isRunning() {
        return running;
    }

    public void stopThread() {
        this.running = false;
    }

    @Override
    public void run() {
        running = true;
        System.out.println("Board thread started");
        while (running) {
        Collections.shuffle(this.cellList, new Random(System.nanoTime())); // random access order
        for (Cell cell : cellList) {
            cell.check();
        }
    }
        System.out.println("Board thread finished");
    }
}
