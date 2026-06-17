package com.showstudio.fireworks;

import com.showstudio.core.object.SimulationObject;
import com.showstudio.physics.Vector2D;

public class Particle extends SimulationObject {

    private final Vector2D position;

    private final Vector2D velocity;

    private double lifetime = 2.0;

    private final double gravity = 100;

    public Particle(
            Vector2D position,
            Vector2D velocity
    ) {
        this.position = position;
        this.velocity = velocity;
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