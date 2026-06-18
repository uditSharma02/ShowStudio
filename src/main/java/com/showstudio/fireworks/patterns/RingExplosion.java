package com.showstudio.fireworks.patterns;

import com.showstudio.fireworks.Particle;
import com.showstudio.physics.Vector2D;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RingExplosion
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
                Color.YELLOW,
                Color.WHITE
        };

        Color selectedColor =
                colors[
                        random.nextInt(
                                colors.length
                        )
                        ];

        int count = 120;

        for (int i = 0; i < count; i++) {

            double angle =
                    (2 * Math.PI * i) / count;

            double speed = 150;

            double vx =
                    Math.cos(angle) * speed;

            double vy =
                    Math.sin(angle) * speed;

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