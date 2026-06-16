package com.showstudio.rendering;

import com.showstudio.core.engine.SimulationEngine;
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

        drawHud(gc, engine, fps);
        drawFirework(gc, engine);
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
    private void drawFirework(
            GraphicsContext gc,
            SimulationEngine engine
    ) {

        double x =
                engine.getFirework()
                        .getPosition()
                        .getX();

        double y =
                engine.getFirework()
                        .getPosition()
                        .getY();

        gc.setFill(Color.ORANGE);

        gc.fillOval(
                x,
                y,
                8,
                8
        );
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
    }
}