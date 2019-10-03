package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import simulation.Simulation;


public class Main extends Application {
    public static void main(String[] args) {
        System.out.println("evo started");
        launch(args);

    }

    @Override
    public void start(Stage primaryStage){
        Simulation simulation = new Simulation();

        Scene mainScene = new Scene(simulation, config.WINDOW_WIDTH, config.WINDOW_HEIGHT);

        primaryStage.setTitle("Evolution");
        primaryStage.setScene(mainScene);
        primaryStage.show();

        simulation.initAndStart();
    }



    @Override
    public void stop() throws Exception {
        System.out.println("Exiting..");
    }

}
