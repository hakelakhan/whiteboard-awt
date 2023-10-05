package org.example.ui;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class WhiteBoardApp extends JFrame {


    public WhiteBoardApp() {
        setTitle("Whiteboard JFrame Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Create the main content panel (white background) occupying 90% of JFrame
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(new BorderLayout());

        // Calculate the size for the mainPanel (90% of JFrame)
        int width = (int) (getWidth() * 0.9);
        int height = (int) (getHeight() * 0.9);
        mainPanel.setPreferredSize(new Dimension(width, height));
        mainPanel.addMouseMotionListener(new MouseMotionHandler(mainPanel));
        mainPanel.addMouseListener(new MouseHandler(mainPanel));

        // Create the bottom panel with 5 buttons
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 5));
        Color[] bottomButtonColors = {Color.RED, Color.GREEN, Color.BLACK, Color.BLUE,
                Color.YELLOW, Color.ORANGE
        };
        String[] bottomButtonNames = {"RED", "GREEN", "BLACK", "BLUE", "YELLOW", "ORANGE"};

        for (int i = 1; i <= 5; i++) {
            JButton colorButton = new JButton(bottomButtonNames[i - 1]);
            colorButton.addActionListener(new ColorButtonHandler(bottomButtonColors[i - 1]));
            bottomPanel.add(colorButton);
        }

        // Create the right panel with 5 buttons
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(5, 1));
        for (int i = 1; i <= 5; i++) {
            rightPanel.add(new JButton("Button " + i));
        }

        // Add the panels to the main content panel
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        mainPanel.add(rightPanel, BorderLayout.EAST);

        // Add the main content panel to the JFrame
        add(mainPanel, BorderLayout.CENTER);

        pack(); // Pack the JFrame to fit the preferred size of the mainPanel
        setLocationRelativeTo(null); // Center the JFrame on the screen
    }
}
