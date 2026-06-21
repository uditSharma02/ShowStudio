package com.showstudio.fireworks;

import com.showstudio.core.object.SimulationObject;
import com.showstudio.physics.Vector2D;

public class Firework extends SimulationObject {

    private final Vector2D position;

    private final Vector2D velocity;

    private final double gravity = 120;
    private String explosionType = "RING";

    private boolean exploded;
    private boolean explosionHandled;
    public boolean isExplosionHandled() {
        return explosionHandled;
    }
    public void setExplosionHandled(boolean explosionHandled) {
        this.explosionHandled = explosionHandled;
    }

    public Firework(
            double startX,
            double startY,
            String explosionType
    ) {

        position = new Vector2D(
                startX,
                startY
        );

        velocity = new Vector2D(
                0,
                -300
        );

        this.explosionType =
                explosionType;
    }
    public String getExplosionType() {
        return explosionType;
    }

    @Override
    public void update(double deltaTime) {

        if (!active) {
            return;
        }

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

        // Firework reaches highest point
        if (velocity.getY() >= 0) {

            exploded = true;

            active = false;
        }
    }

    public Vector2D getPosition() {
        return position;
    }

    public boolean hasExploded() {
        return exploded;
    }
}