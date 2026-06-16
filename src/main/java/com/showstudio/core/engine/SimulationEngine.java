package com.showstudio.core.engine;

public class SimulationEngine {

    private final SimulationClock clock;

    public SimulationEngine() {
        this.clock = new SimulationClock();
    }

    public void update(double deltaTime) {

        clock.update(deltaTime);

    }

    public double getCurrentTime() {
        return clock.getSimulationTime();
    }
}