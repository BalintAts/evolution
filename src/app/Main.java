package app;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import simulation.Simulation;
import utils.RandomUtil;


public class Main extends Application {
    public static void main(String[] args) {
        System.out.println("evo started");
        launch(args);

    }

    @Override
    public void start(Stage primaryStage){
        Simulation simulation = new Simulation();

        Scene mainScene = new Scene(simulation, config.window_width, config.window_height);

        primaryStage.setTitle("Evolution");
        primaryStage.setScene(mainScene);
        primaryStage.show();


        simulation.initAndStart();
    }


//    public void start(Stage stage) {
//        // set title for the stage
//        stage.setTitle("creating circle");
//
//        // create a circle
//
//        // create a Group
//
//        Label label = new Label("myLabel");
//        Group group = new Group(label);
//        VBox vBox = new VBox(group, label);
//        MyCircle myCircle = new MyCircle(5.0f, vBox);
//        vBox.getChildren().add(myCircle);
//
//        // create a scene
//        Scene scene = new Scene(vBox, 500, 300);
//
//
//        // set the scene
//        stage.setScene(scene);
//
//        new AnimationTimer(){
//
//            @Override
//            public void  handle(long currentNanoTime){
//                if (RandomUtil.getRandomNumberInRange(0, 100) == 1)   {
//                    vBox.getChildren().add(new Label("new random label"));
//                    myCircle.destroy();
//
//                }
//            }
//        }.start();
//
//
//        stage.show();
//    }


    @Override
    public void stop() throws Exception {
        System.out.println("Exiting..");
    }

}
