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
    public static final int SIZE = 150;
    private Cell[][] cells = new Cell[SIZE * 2][SIZE];
    private java.util.List<Cell> cellList = new ArrayList<>();
    private boolean running = false;

    public Board() {
        setBackground(Color.WHITE);

        int xy = SIZE * Cell.SIZE;
        setSize(new Dimension(xy * 2, xy + 20));

        Cell.setCells(cells);

        for (int j, i = 0; i < SIZE * 2; i++) {
            for (j = 0; j < SIZE; j++) {
                Cell cell = new Cell(i, j);
                cells[i][j] = cell;
                cellList.add(cell);
            }
        }
        clearBoard();
        System.out.println("Board ready");
    }


    public void clearBoard() {
        Cell cell;
        for (int j, i = 0; i < SIZE * 2; i++) {
            for (j = 0; j < SIZE; j++) {
                cell = cells[i][j];
                cell.setRandomId();
                cell.serColorById(cell.getId());
            }
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g.create();
        Rectangle rect;
        for (int x, y, j, i = 0; i < SIZE * 2; i++) {
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
            repaint();
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
            }
        }
        System.out.println("Board thread finished");
    }
}
