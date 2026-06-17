package com.showstudio.core.engine;

import com.showstudio.fireworks.Firework;
import com.showstudio.fireworks.FireworkManager;
import com.showstudio.fireworks.Particle;
import com.showstudio.physics.Vector2D;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SimulationEngine {

    private final SimulationClock clock;

    private final FireworkManager fireworkManager;

    private final List<Particle> particles;

    public SimulationEngine() {

        clock = new SimulationClock();

        fireworkManager = new FireworkManager();

        particles = new ArrayList<>();
    }

    public void update(double deltaTime) {

        clock.update(deltaTime);

        fireworkManager.update(deltaTime);

        createExplosions();

        updateParticles(deltaTime);
    }

    private void createExplosions() {

        fireworkManager.getFireworks()
                .stream()
                .filter(Firework::hasExploded)
                .filter(f -> !f.isExplosionHandled())
                .forEach(f -> {

                    createExplosion(
                            f.getPosition().getX(),
                            f.getPosition().getY()
                    );

                    f.setExplosionHandled(true);
                });
    }

    private void updateParticles(
            double deltaTime
    ) {

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

    private void createExplosion(
            double centerX,
            double centerY
    ) {

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

    public FireworkManager getFireworkManager() {

        return fireworkManager;
    }

    public List<Particle> getParticles() {

        return particles;
    }
}