package org.example.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.HashSet;
import java.util.Set;

public class MouseMotionHandler extends MouseMotionAdapter {
    private WhiteBoardData whiteBoardData = WhiteBoardData.getInstance();
    private JPanel jPanel ;

    public MouseMotionHandler(JPanel jPanel) {
        this.jPanel = jPanel;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //capture points, 10-15 points, bufferImage -printImage on UI
        whiteBoardData.addPoint(new CustomPoint(e.getPoint(), WhiteBoardData.getCurrentColor()));
        if(whiteBoardData.getPoints().size() % Constants.FREQUENCY == 0) {
            DataHandler.drawPoints(whiteBoardData.getPoints(), jPanel);
        }
    }
}
