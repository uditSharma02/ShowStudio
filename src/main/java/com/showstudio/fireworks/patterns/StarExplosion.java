package com.showstudio.fireworks.patterns;

import com.showstudio.fireworks.Particle;
import com.showstudio.physics.Vector2D;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StarExplosion
        implements ExplosionPattern {

    private final Random random =
            new Random();

    @Override
    public List<Particle> create(
            double centerX,
            double centerY
    ) {

        List<Particle> particles =
                new ArrayList<>();

        Color[] colors = {

                Color.RED,
                Color.BLUE,
                Color.GREEN,
                Color.ORANGE,
                Color.PURPLE,
                Color.WHITE
        };

        Color selectedColor =
                colors[
                        random.nextInt(
                                colors.length
                        )
                        ];

        int arms = 5;

        int particlesPerArm = 25;

        double speed = 180;

        for(int arm = 0;
            arm < arms;
            arm++) {

            double armAngle =
                    (2 * Math.PI * arm)
                            / arms;

            for(int i = 0;
                i < particlesPerArm;
                i++) {

                double spread =
                        (random.nextDouble() - 0.5)
                                * 0.3;

                double angle =
                        armAngle + spread;

                double vx =
                        Math.cos(angle)
                                * speed;

                double vy =
                        Math.sin(angle)
                                * speed;

                particles.add(

                        new Particle(

                                new Vector2D(
                                        centerX,
                                        centerY
                                ),

                                new Vector2D(
                                        vx,
                                        vy
                                ),

                                selectedColor
                        )
                );
            }
        }

        return particles;
    }
}