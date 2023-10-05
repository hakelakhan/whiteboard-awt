package org.example.ui;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class WhiteBoardData {
    private static final LinkedHashSet<CustomPoint> pointSet = new LinkedHashSet<>();
    private static Color currentColor = Color.BLACK;
    private static final WhiteBoardData INSTANCE = new WhiteBoardData();

    private WhiteBoardData() {

    }

    public static WhiteBoardData getInstance() {
        return INSTANCE;
    }
    public static Color getCurrentColor() {
        return currentColor;
    }
    public void addPoint(CustomPoint point) {
        pointSet.add(point);
    }

    public static void setCurrentColor(Color currentColor) {
        WhiteBoardData.currentColor = currentColor;
    }
    public LinkedHashSet<CustomPoint> getPoints() {
        return pointSet;
    }

}
