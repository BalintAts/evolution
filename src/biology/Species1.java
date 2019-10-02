package biology;

import app.config;
import graphicsLogic.Display;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import utils.RandomUtil;



public class Species1 extends Entity {


    private int baseReplicationRate = 20;
    private float mutatedDeathByChanceFactor = (float) 0.9;
    private int mutatedReplicationrateFactor = 4;
    private int mutationRate = 50;
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
        deathByChance = environment.getPredators();
        setImage(new Image("face-without-mouth.jpg"));
        int x = (RandomUtil.getRandomNumberInRange(0, config.window_width));
        int y = (RandomUtil.getRandomNumberInRange(0, config.window_height));
        this.circle = new Circle(x,y,20);
        circle.setFill(Color.BLACK);
        if(hasWings){
            circle.setFill(Color.RED);
            setDeathByChanceToMutated();
        }
        numberOfSpecies1++;
        display.add(circle);

    }

    private void setDeathByChanceToMutated() {
        deathByChance = (float) (environment.getPredators() * 0.6);
    }

    public static int getNumberOfSpecies1() {
        return numberOfSpecies1;
    }


    public Circle getCircle() {
        return circle;
    }



    public boolean die(){
        if (numberOfSpecies1 >= environment.getPopulationLimit() || remainingLifeTime < 0 || (RandomUtil.getRandomNumberInRange(0, 100) < deathByChance)){
            numberOfSpecies1--;
            display.remove(circle);
            return true;
        }
        return false;
    }


    public boolean replicate() {
        if (RandomUtil.getRandomNumberInRange(0, 100) < replicationRate ) {
            colony.getiWillBorn().add(new Species1(colony, environment, hasColor, mutate(), display));
            if (numberOfSpecies1 > environment.getPopulationLimit()-1) {
                return true;
            }
        }
        return false;
    }




    public boolean mutate() {
        if (RandomUtil.getRandomNumberInRange(0, 100) < mutationRate) {
            if (!hasWings) {
                return true;
//                deathByChance = (float) (environment.getPredators() * 0); //baseDeathByChance * mutatedDeathByChanceFactor;
            }
            else {
                return false;
            }
        }
        return hasWings;
    }

    public boolean isHasWings() {
        return hasWings;
    }

    public boolean isHasColor() {
        return hasColor;
    }
}
