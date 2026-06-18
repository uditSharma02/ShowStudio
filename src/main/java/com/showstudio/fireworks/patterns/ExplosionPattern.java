package com.showstudio.fireworks.patterns;

import com.showstudio.fireworks.Particle;

import java.util.List;

public interface ExplosionPattern {

    List<Particle> create(
            double centerX,
            double centerY
    );
}