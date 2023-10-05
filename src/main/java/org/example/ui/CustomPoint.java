package org.example.ui;

import java.awt.*;
import java.util.Objects;

public class CustomPoint extends Point {
    private Color color;
    private int thickness = Constants.POINT_THICKNESS;

    public CustomPoint(Point point, Color color) {
        super(point);
        this.color = color;
    }

    public CustomPoint(int newX, int newY, Color color) {
        super(newX, newY);
        this.color = color;

    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CustomPoint that = (CustomPoint) o;
        return Objects.equals(color, that.color);
    }

    public int getThickness() {
        return thickness;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }
}
