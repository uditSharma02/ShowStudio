package com.showstudio.core.engine;

public class SimulationClock {

    private double simulationTime;

    public void update(double deltaTime) {
        simulationTime += deltaTime;
    }

    public double getSimulationTime() {
        return simulationTime;
    }

    public void reset() {
        simulationTime = 0;
    }
}