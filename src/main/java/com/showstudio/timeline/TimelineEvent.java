package com.showstudio.timeline;

public class TimelineEvent {

    private final double triggerTime;

    private final String eventType;

    private boolean executed;

    public TimelineEvent(
            double triggerTime,
            String eventType
    ) {
        this.triggerTime = triggerTime;
        this.eventType = eventType;
    }

    public double getTriggerTime() {
        return triggerTime;
    }

    public String getEventType() {
        return eventType;
    }

    public boolean isExecuted() {
        return executed;
    }

    public void setExecuted(
            boolean executed
    ) {
        this.executed = executed;
    }
}