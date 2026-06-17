package com.showstudio.fireworks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class FireworkManager {

    private final List<Firework> fireworks;

    private final Random random;

    private double launchTimer;

    public FireworkManager() {

        fireworks = new ArrayList<>();

        random = new Random();

        launchFirework();
    }

    public void update(double deltaTime) {

        launchTimer += deltaTime;

        if (launchTimer >= 1.5) {

            launchTimer = 0;

            launchFirework();
        }

        Iterator<Firework> iterator =
                fireworks.iterator();

        while (iterator.hasNext()) {

            Firework firework =
                    iterator.next();

            firework.update(deltaTime);

            if (!firework.isActive()
                    && firework.isExplosionHandled()) {

                iterator.remove();
            }
        }
    }

    private void launchFirework() {

        double x =
                200 + random.nextInt(1000);

        fireworks.add(
                new Firework(
                        x,
                        720
                )
        );
    }

    public List<Firework> getFireworks() {
        return fireworks;
    }
}