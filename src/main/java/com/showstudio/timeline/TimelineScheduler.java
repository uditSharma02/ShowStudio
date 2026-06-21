package com.showstudio.timeline;

import java.util.ArrayList;
import java.util.List;

public class TimelineScheduler {

    private final List<TimelineEvent> events;

    public TimelineScheduler() {

        events = new ArrayList<>();

        createDemoTimeline();
    }

    private void createDemoTimeline() {

        events.add(
                new TimelineEvent(
                        1,
                        "RING"
                )
        );

        events.add(
                new TimelineEvent(
                        3,
                        "STAR"
                )
        );

        events.add(
                new TimelineEvent(
                        5,
                        "HEART"
                )
        );

        events.add(
                new TimelineEvent(
                        7,
                        "STAR"
                )
        );
    }

    public List<TimelineEvent> getEvents() {
        return events;
    }
}