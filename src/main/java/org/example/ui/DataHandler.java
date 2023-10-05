package org.example.ui;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class DataHandler {
    public static void drawPoints(LinkedHashSet<CustomPoint> points, JPanel panel) {
        Graphics g =  panel.getGraphics();
        //SmoothenPoints
        LinkedHashSet<CustomPoint> pointsOutput = PointsSmoother.getSmoothenPoints(points);
        pointsOutput.forEach( pt -> {
            g.setColor(pt.getColor());
            g.fillRect(pt.x, pt.y, pt.getThickness(), pt.getThickness());
        });
        //panel.repaint();
        System.out.println("Repainted" + points.size());
    }

    //If points.size % FREQUENCY or mouseRelease draw the points
}
