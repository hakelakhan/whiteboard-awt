package org.example.ui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTreeUI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter {
    private static WhiteBoardData whiteBoardData = WhiteBoardData.getInstance();
    private JPanel jPanel ;

    public MouseHandler(JPanel jPanel) {
        this.jPanel = jPanel;
    }

    public void mouseReleased(MouseEvent e) {
        // smoothen points and print on UI
        System.out.println("Mouse released");
        DataHandler.drawPoints(whiteBoardData.getPoints(), jPanel );

    }

}
