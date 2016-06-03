package robert.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by robert on 03.06.16.
 */
public class MainFrame extends JFrame {
    private static JFrame self = null;

    private final JPanel northPanel, southPanel;
    private final Board board;

    private MainFrame() {
        super("Monte Carlo Method");
        setLayout(new BorderLayout());

        northPanel = new JPanel(new FlowLayout());
        board = new Board();


        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");
        southPanel = new JPanel(new FlowLayout());
        southPanel.add(startButton);
        southPanel.add(stopButton);

        // adding to the frame
        this.add(northPanel, BorderLayout.NORTH);
        this.add(board, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);

        // Jframe properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);
        pack();
        System.out.println("Main frame ready");
    }

    public static JFrame getFrame() {
        if (self == null) {
            self = new MainFrame();
        }
        return self;
    }
}
