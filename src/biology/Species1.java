package biology;

import app.config;
import graphicsLogic.Display;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import utils.RandomUtil;



public class Species1 extends Entity {


    private int baseReplicationRate = 20;
    private float mutatedDeathByChanceFactor = 0;
    private int mutatedReplicationrateFactor = 4;
    private int mutationRate = 10;
    private boolean hasColor;
    private boolean hasWings;
    private int replicationRate = 20;
    private static int numberOfSpecies1 = 0;
    private Circle circle;



    public Species1(ColonyManipulate colony, Environment environment, boolean hasColor, boolean hasWings, Display display) {
        super(colony,environment, display);
        this.hasColor = hasColor;
        this.hasWings = hasWings;
        this.deathByChance = environment.getPredators();
        this.baseDeathByChance = deathByChance;
        setImage(new Image("face-without-mouth.jpg"));
        int x = (RandomUtil.getRandomNumberInRange(0, config.window_width));
        int y = (RandomUtil.getRandomNumberInRange(0, config.window_height));
        this.circle = new Circle(x,y,20);
        if(hasWings){
            circle.setFill(Color.RED);
        }
        numberOfSpecies1++;
        mutate();
        display.add(circle);



    }


    public Circle getCircle() {
        return circle;
    }

    public boolean die(boolean mustDie) {
        remainingLifeTime--;
        if (remainingLifeTime < 0 || RandomUtil.getRandomNumberInRange(0, 100) < deathByChance || mustDie || numberOfSpecies1 >= environment.getPopulationLimit()) {
            numberOfSpecies1--;
            System.out.println("die");
            display.remove(circle);
            return true;
        }
        return false;
    }


    public boolean replicate() {
        if (RandomUtil.getRandomNumberInRange(0, 100) < replicationRate ) {
            colony.getiWillBorn().add(new Species1(colony, environment, hasColor, hasWings, display));
            if (numberOfSpecies1 > environment.getPopulationLimit()-1) {
                return true;
            }
        }
        return false;
    }




    public static int getNumberOfSpecies1() {
        return numberOfSpecies1;
    }

    public void mutate() {
        if (RandomUtil.getRandomNumberInRange(0, 100) < mutationRate) {
            if (!hasWings) {
                hasWings = true;
                deathByChance = baseDeathByChance * mutatedDeathByChanceFactor;
                circle.setFill(Color.RED);
            } else {
                hasWings = false;
                deathByChance = baseDeathByChance;
                circle.setFill(Color.BLACK);
            }
        }
    }

    public boolean isHasWings() {
        return hasWings;
    }

    public boolean isHasColor() {
        return hasColor;
    }
}
