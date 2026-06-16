package com.showstudio.app;

import com.showstudio.core.engine.SimulationEngine;
import com.showstudio.core.engine.SimulationLoop;
import com.showstudio.rendering.Renderer;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {

        SimulationEngine engine =
                new SimulationEngine();

        SimulationLoop loop =
                new SimulationLoop(engine);

        Canvas canvas =
                new Canvas(1400, 800);

        GraphicsContext gc =
                canvas.getGraphicsContext2D();

        Renderer renderer =
                new Renderer();

        StackPane root =
                new StackPane(canvas);

        Scene scene =
                new Scene(root);

        stage.setTitle("ShowStudio");

        stage.setScene(scene);

        stage.show();

        loop.start();

        new AnimationTimer() {

            @Override
            public void handle(long now) {

                renderer.render(
                        gc,
                        engine,
                        loop.getFps()
                );
            }

        }.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}