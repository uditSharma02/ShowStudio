package com.showstudio.core.engine;

import javafx.animation.AnimationTimer;

public class SimulationLoop {

    private final SimulationEngine engine;

    private long previousTime;

    private double fps;

    public SimulationLoop(SimulationEngine engine) {
        this.engine = engine;
    }

    public void start() {

        AnimationTimer timer =
                new AnimationTimer() {

                    @Override
                    public void handle(long now) {

                        if (previousTime == 0) {
                            previousTime = now;
                            return;
                        }

                        double deltaTime =
                                (now - previousTime)
                                        / 1_000_000_000.0;

                        previousTime = now;

                        fps = 1.0 / deltaTime;

                        engine.update(deltaTime);
                    }
                };

        timer.start();
    }

    public double getFps() {
        return fps;
    }
}