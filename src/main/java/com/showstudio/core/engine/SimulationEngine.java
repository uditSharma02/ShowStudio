package com.showstudio.core.engine;

import com.showstudio.fireworks.Firework;
import com.showstudio.fireworks.Particle;
import com.showstudio.physics.Vector2D;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SimulationEngine {

    private final SimulationClock clock;

    private final Firework firework;

    private final List<Particle> particles;

    public SimulationEngine() {

        clock = new SimulationClock();

        firework = new Firework();

        particles = new ArrayList<>();
    }

    public void update(double deltaTime) {

        clock.update(deltaTime);

        firework.update(deltaTime);

        // Create explosion once
        if (firework.hasExploded()
                && particles.isEmpty()) {

            createExplosion();
        }

        Iterator<Particle> iterator =
                particles.iterator();

        while (iterator.hasNext()) {

            Particle particle =
                    iterator.next();

            particle.update(deltaTime);

            if (!particle.isActive()) {

                iterator.remove();
            }
        }
    }

    private void createExplosion() {

        double centerX =
                firework.getPosition().getX();

        double centerY =
                firework.getPosition().getY();

        int count = 120;

        for (int i = 0; i < count; i++) {

            double angle =
                    (2 * Math.PI * i) / count;

            double speed = 150;

            double vx =
                    Math.cos(angle) * speed;

            double vy =
                    Math.sin(angle) * speed;

            particles.add(

                    new Particle(

                            new Vector2D(
                                    centerX,
                                    centerY
                            ),

                            new Vector2D(
                                    vx,
                                    vy
                            )
                    )
            );
        }
    }

    public double getCurrentTime() {

        return clock.getSimulationTime();
    }

    public Firework getFirework() {

        return firework;
    }

    public List<Particle> getParticles() {

        return particles;
    }
}