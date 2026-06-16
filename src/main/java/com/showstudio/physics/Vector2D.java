package com.showstudio.physics;

public class Vector2D {

    private double x;
    private double y;

    public Vector2D() {
        this(0, 0);
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D add(Vector2D other) {

        return new Vector2D(
                x + other.x,
                y + other.y
        );
    }

    public Vector2D multiply(double scalar) {

        return new Vector2D(
                x * scalar,
                y * scalar
        );
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}