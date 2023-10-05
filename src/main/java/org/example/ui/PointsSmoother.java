package org.example.ui;

import java.awt.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class PointsSmoother {
    public static LinkedHashSet<CustomPoint> getSmoothenPoints(LinkedHashSet<CustomPoint> points) {
        LinkedHashSet<CustomPoint> smoothenedPoints = new LinkedHashSet<>();
        if (points.size() < 2) {
            smoothenedPoints.addAll(points);
            return smoothenedPoints;
        }

        CustomPoint[] pointsArray = points.toArray(new CustomPoint[0]);

        for (int i = 0; i < pointsArray.length - 1; i++) {
            CustomPoint p1 = pointsArray[i];
            CustomPoint p2 = pointsArray[i + 1];

            // Calculate the distance between the two points
            int distance = (int) Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));

            if(distance > Constants.SMOOTHING_CRITICAL_DISTANCE) {
                continue;
            }
            // Determine the number of intermediate points to add for smoothening
            int numIntermediatePoints = distance / Constants.SMOOTHNESS; // You can adjust this value for desired smoothness

            for (int j = 0; j <= numIntermediatePoints; j++) {
                int newX = (int)(p1.getX() + (j * (p2.getX() - p1.getX())) / numIntermediatePoints);
                int newY = (int) (p1.getY() + (j * (p2.getY() - p1.getY())) / numIntermediatePoints);
                smoothenedPoints.add(new CustomPoint(newX, newY, p1.getColor()));
            }
        }

        // Add the last point
        smoothenedPoints.add(pointsArray[pointsArray.length - 1]);

        return smoothenedPoints;
    }
}
