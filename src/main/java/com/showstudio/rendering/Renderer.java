package com.showstudio.rendering;
import com.showstudio.fireworks.Firework;
import com.showstudio.core.engine.SimulationEngine;
import com.showstudio.fireworks.Particle;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Renderer {

    public void render(
            GraphicsContext gc,
            SimulationEngine engine,
            double fps
    ) {

        double width =
                gc.getCanvas().getWidth();

        double height =
                gc.getCanvas().getHeight();

        drawSky(gc, width, height);

        drawGround(gc, width, height);

        drawParticles(gc, engine);

        drawFireworks(gc, engine);

        drawHud(gc, engine, fps);
    }

    private void drawSky(
            GraphicsContext gc,
            double width,
            double height
    ) {

        gc.setFill(Color.BLACK);

        gc.fillRect(
                0,
                0,
                width,
                height
        );
    }

    private void drawGround(
            GraphicsContext gc,
            double width,
            double height
    ) {

        gc.setFill(Color.DARKGREEN);

        gc.fillRect(
                0,
                height - 80,
                width,
                80
        );
    }

    private void drawFireworks(
            GraphicsContext gc,
            SimulationEngine engine
    ) {

        gc.setFill(Color.ORANGE);

        for(Firework firework :
                engine.getFireworkManager()
                        .getFireworks()) {

            if(!firework.isActive()) {
                continue;
            }

            gc.fillOval(
                    firework.getPosition().getX(),
                    firework.getPosition().getY(),
                    8,
                    8
            );
        }
    }


    private void drawParticles(
            GraphicsContext gc,
            SimulationEngine engine
    ) {



        for (Particle particle :
                engine.getParticles()) {
            gc.setGlobalAlpha(
                    particle.getOpacity()
            );

            gc.setFill(
                    particle.getColor()
            );
            gc.fillOval(
                    particle.getPosition().getX(),
                    particle.getPosition().getY(),
                    4,
                    4
            );
        }
        gc.setGlobalAlpha(1.0);
    }

    private void drawHud(
            GraphicsContext gc,
            SimulationEngine engine,
            double fps
    ) {

        gc.setFill(Color.WHITE);

        gc.fillText(
                String.format(
                        "FPS: %.0f",
                        fps
                ),
                20,
                30
        );

        gc.fillText(
                String.format(
                        "Time: %.2f",
                        engine.getCurrentTime()
                ),
                20,
                55
        );

        gc.fillText(
                "Particles: " +
                        engine.getParticles().size(),
                20,
                80
        );
    }
}