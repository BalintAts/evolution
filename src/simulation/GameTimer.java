package simulation;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class GameTimer {
    private static final double FPS = 0.1;
    private double frameTime = 0.1;
    private Timeline timeline = new Timeline();

    GameTimer() {
        System.out.println(FPS);
    }


    public void setup(Runnable loopMethod) {
        timeline.setCycleCount( Timeline.INDEFINITE );

        KeyFrame kf = new KeyFrame(
                Duration.seconds(frameTime),
                ae -> loopMethod.run());

        timeline.getKeyFrames().add( kf );
    }

    public void play() {
        timeline.play();
        System.out.println("GameTimer playing.");
    }

    public  void  stop(){
        timeline.stop();
    }
}
