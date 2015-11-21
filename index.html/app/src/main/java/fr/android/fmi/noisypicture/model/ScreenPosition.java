package fr.android.fmi.noisypicture.model;

import android.graphics.Point;

public class ScreenPosition {

    private Point center;

    public ScreenPosition(Point center) {
        this.center = center;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }
}
