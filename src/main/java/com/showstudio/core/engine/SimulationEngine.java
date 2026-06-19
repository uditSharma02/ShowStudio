package com.showstudio.core.engine;

import com.showstudio.fireworks.FireworkManager;
import com.showstudio.fireworks.Particle;
import com.showstudio.fireworks.patterns.HeartExplosion;
import com.showstudio.fireworks.patterns.RingExplosion;
import com.showstudio.fireworks.patterns.StarExplosion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class SimulationEngine {

    private final SimulationClock clock;

    private final FireworkManager fireworkManager;

    private final List<Particle> particles;

    private final RingExplosion ringExplosion;

    private final StarExplosion starExplosion;

    private final HeartExplosion heartExplosion;

    private final Random random;

    public SimulationEngine() {

        clock = new SimulationClock();

        fireworkManager = new FireworkManager();

        particles = new ArrayList<>();

        ringExplosion = new RingExplosion();

        starExplosion = new StarExplosion();

        heartExplosion = new HeartExplosion();

        random = new Random();
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
                .filter(f -> f.hasExploded())
                .filter(f -> !f.isExplosionHandled())
                .forEach(f -> {

                    int pattern =
                            random.nextInt(3);

                    if(pattern == 0) {

                        particles.addAll(

                                ringExplosion.create(

                                        f.getPosition().getX(),
                                        f.getPosition().getY()
                                )
                        );
                    }
                    else if(pattern == 1) {

                        particles.addAll(

                                starExplosion.create(

                                        f.getPosition().getX(),
                                        f.getPosition().getY()
                                )
                        );
                    }
                    else {

                        particles.addAll(

                                heartExplosion.create(

                                        f.getPosition().getX(),
                                        f.getPosition().getY()
                                )
                        );
                    }

                    f.setExplosionHandled(true);
                });
    }

    private void updateParticles(
            double deltaTime
    ) {

        Iterator<Particle> iterator =
                particles.iterator();

        while(iterator.hasNext()) {

            Particle particle =
                    iterator.next();

            particle.update(deltaTime);

            if(!particle.isActive()) {

                iterator.remove();
            }
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