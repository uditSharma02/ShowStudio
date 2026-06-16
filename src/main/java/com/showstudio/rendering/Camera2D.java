package com.showstudio.rendering;

public class Camera2D {

    private double zoom = 1.0;

    private double offsetX;

    private double offsetY;

    public double getZoom() {
        return zoom;
    }

    public void setZoom(double zoom) {
        this.zoom = zoom;
    }

    public double getOffsetX() {
        return offsetX;
    }

    public double getOffsetY() {
        return offsetY;
    }
}