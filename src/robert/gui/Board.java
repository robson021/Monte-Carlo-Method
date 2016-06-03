package robert.gui;

import robert.model.Cell;

import javax.swing.*;
import java.awt.*;

/**
 * Created by robert on 03.06.16.
 */
public class Board extends JPanel {
    private static final int SIZE = 1_000;
    private Cell[][] cells = new Cell[SIZE][SIZE];

    public Board() {
        setBackground(Color.WHITE);
        for (int j, i = 0; i < SIZE; i++) {
            for (j = 0; j < SIZE; j++) {
                cells[i][j] = new Cell();
            }
        }
        initNewBoard();
        System.out.println("Board ready");
    }

    public void initNewBoard() {
        clearBoard();
        repaint();
    }

    private void clearBoard() {
        for (int j, i = 0; i < SIZE; i++) {
            for (j = 0; j < SIZE; j++) {
                cells[i][j].reset();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g.create();
        Rectangle rect;
        for (int j, i = 0; i < SIZE; i++) {
            for (j = 0; j < SIZE; j++) {
                graphics2D.setColor(cells[i][j].getColor());
                int id = cells[i][j].getID();
                int xy = cells[i][j].getLocation();
                rect = new Rectangle(id, id, xy, xy);
                graphics2D.fill(rect);
            }
        }
    }
}
