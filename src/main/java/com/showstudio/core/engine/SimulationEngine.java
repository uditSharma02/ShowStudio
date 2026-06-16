package com.showstudio.core.engine;

import com.showstudio.fireworks.Firework;

public class SimulationEngine {

    private final SimulationClock clock;

    private final Firework firework;

    public SimulationEngine() {

        clock = new SimulationClock();

        firework = new Firework();
    }

    public void update(double deltaTime) {

        clock.update(deltaTime);

        firework.update(deltaTime);
    }

    public double getCurrentTime() {
        return clock.getSimulationTime();
    }

    public Firework getFirework() {
        return firework;
    }
}