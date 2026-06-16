package com.showstudio.fireworks;

import com.showstudio.core.object.SimulationObject;
import com.showstudio.physics.Vector2D;

public class Firework extends SimulationObject {

    private final Vector2D position;

    private final Vector2D velocity;

    private final double gravity = 120;

    public Firework() {

        position =
                new Vector2D(
                        700,
                        720
                );

        velocity =
                new Vector2D(
                        0,
                        -300
                );
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
    }

    public Vector2D getPosition() {
        return position;
    }
}