package com.showstudio.fireworks;

import com.showstudio.core.object.SimulationObject;
import com.showstudio.physics.Vector2D;
import javafx.scene.paint.Color;

public class Particle extends SimulationObject {

    private final Vector2D position;
    private final double maxLifetime = 2.0;

    private final Vector2D velocity;

    private double lifetime = 2.0;

    private final double gravity = 100;
    private final Color color;
    public double getOpacity() {

        return Math.max(
                0,
                lifetime / maxLifetime
        );
    }
    public Particle(
            Vector2D position,
            Vector2D velocity,
            Color color
    ) {
        this.position = position;
        this.velocity = velocity;
        this.color = color;
    }
    public Color getColor() {
        return color;
    }

    @Override
    public void update(double deltaTime) {

        velocity.setY(
                velocity.getY()
                        + gravity * deltaTime
        );

        position.setX(
                position.getX()
                        + velocity.getX() * deltaTime
        );

        position.setY(
                position.getY()
                        + velocity.getY() * deltaTime
        );

        lifetime -= deltaTime;

        if (lifetime <= 0) {
            active = false;
        }
    }

    public Vector2D getPosition() {
        return position;
    }

    public double getLifetime() {
        return lifetime;
    }
}