package com.showstudio.app;

import com.showstudio.core.engine.SimulationEngine;
import com.showstudio.core.engine.SimulationLoop;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {

        SimulationEngine engine =
                new SimulationEngine();

        SimulationLoop loop =
                new SimulationLoop(engine);

        Label fpsLabel = new Label();

        Label timeLabel = new Label();

        VBox root =
                new VBox(10);

        root.getChildren().addAll(
                fpsLabel,
                timeLabel
        );

        Scene scene =
                new Scene(root, 1400, 800);

        stage.setTitle("ShowStudio");

        stage.setScene(scene);

        stage.show();

        loop.start();

        new AnimationTimer() {

            @Override
            public void handle(long now) {

                fpsLabel.setText(
                        String.format(
                                "FPS: %.0f",
                                loop.getFps()
                        )
                );

                timeLabel.setText(
                        String.format(
                                "Simulation Time: %.2f",
                                engine.getCurrentTime()
                        )
                );
            }

        }.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}