package com.showstudio.fireworks.patterns;

import com.showstudio.fireworks.Particle;
import com.showstudio.physics.Vector2D;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HeartExplosion
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
                Color.PINK,
                Color.HOTPINK,
                Color.DEEPPINK
        };

        Color selectedColor =
                colors[
                        random.nextInt(
                                colors.length
                        )
                        ];

        for(double t = 0;
            t < 2 * Math.PI;
            t += 0.1) {

            double x = 16 * Math.pow(
                    Math.sin(t),
                    3
            );

            double y =
                    13 * Math.cos(t)
                            - 5 * Math.cos(2 * t)
                            - 2 * Math.cos(3 * t)
                            - Math.cos(4 * t);

            double scale = 12;

            double vx = x * scale;

            double vy = -y * scale;

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

        return particles;
    }
}