package com.showstudio.core.object;


public abstract class SimulationObject {

    protected boolean active = true;

    public abstract void update(double deltaTime);

    public boolean isActive() {
        return active;
    }
}