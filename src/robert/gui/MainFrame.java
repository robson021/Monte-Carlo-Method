package robert.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by robert on 03.06.16.
 */
public class MainFrame extends JFrame {
    private static JFrame self = null;

    private final JPanel northPanel, southPanel;
    private final Board board;
    private Thread boardThread = null;

    private MainFrame() {
        super("Monte Carlo Method");
        setLayout(new BorderLayout());

        northPanel = new JPanel(new FlowLayout());
        board = new Board();


        JButton startButton = new JButton("Start");
        startButton.addActionListener(new StartButtonAction());
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
        //pack();
        Dimension size = board.getSize();
        size.setSize(size.getWidth(), size.getHeight() + 75);
        setSize(size);
        System.out.println("Main frame ready");
    }

    public static JFrame getFrame() {
        if (self == null) {
            self = new MainFrame();
        }
        return self;
    }

    private class StartButtonAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!board.isRunning()) {
                boardThread = new Thread(board);
                boardThread.start();
            }
        }
    }
}
