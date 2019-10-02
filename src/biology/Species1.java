package biology;

import app.config;
import com.sun.javafx.geom.Vec2d;
import javafx.scene.image.Image;
import javafx.scene.shape.Circle;
import utils.RandomUtil;

import javax.swing.text.Element;
import javafx.scene.image.ImageView;

import java.io.ObjectInputFilter;

public class Species1 extends Entity {

    private float deathByChance;
    private float baseDeathByChance;
//    private int baseReplicationRate = 20;
    private float mutatedDeathByChanceFactor = 0;
    private int mutatedReplicationrateFactor = 4;
    private int mutationRate = 10;
    private int remainingLifeTime = 100;
    private boolean hasColor;
    private boolean hasWings;
    private int replicationRate = 20;
    private ColonyManipulate colony;
    private static int numberOfSpecies1 = 0;
    private static int numberOfHasColor = 0;
    private static int numberOfHasWings = 0;
    private Environment environment;
    private boolean iWillDie = false;
    private Circle circle;

    public ColonyManipulate getColony() {
        return colony;
    }

    public boolean isiWillDie() {
        return iWillDie;
    }



    public Species1(ColonyManipulate colony, Environment environment, boolean hasColor, boolean hasWings) {
        numberOfSpecies1++;
        this.colony = colony;
        this.environment = environment;
        this.hasColor = hasColor;
        this.hasWings = hasWings;
        this.deathByChance = environment.getPredators();
        this.baseDeathByChance = deathByChance;
        mutate();
        setImage(new Image("face-without-mouth.jpg"));

//        Vec2d positionInit = new Vec2d(300,300);
//        setPosition(positionInit);
        int x = (RandomUtil.getRandomNumberInRange(0, config.window_width));
        int y = (RandomUtil.getRandomNumberInRange(0, config.window_height));
        this.circle = new Circle(x,y,20);


    }


    public Circle getCircle() {
        return circle;
    }

    public boolean die() {
        remainingLifeTime--;
        if (remainingLifeTime < 0 || RandomUtil.getRandomNumberInRange(0, 100) < deathByChance) {
            //colony.getSpecies1Set().remove(this);

//            System.out.println("die");
            numberOfSpecies1--;
            return true;
        }
        return false;
//        System.out.println("remaining life: " + remainingLifeTime);

    }

    public boolean replicate() {
        //if random
        if (RandomUtil.getRandomNumberInRange(0, 100) < replicationRate && numberOfSpecies1 < environment.getPopulationLimit()) {
//            System.out.println("replicate");
            colony.getiWillBorn().add(new Species1(colony, environment, hasColor, hasWings));
                return true;

        }else{
            return false;
        }

    }

    public static int getNumberOfHasColor() {
        return numberOfHasColor;
    }

    public static int getNumberOfHasWings() {
        return numberOfHasWings;
    }

    public static int getNumberOfSpecies1() {
        return numberOfSpecies1;
    }

    public void mutate() {
        if (RandomUtil.getRandomNumberInRange(0, 100) < mutationRate) {
//            System.out.println("mutation hasWings");
            if (!hasWings) {
                hasWings = true;
                this.deathByChance = baseDeathByChance * mutatedDeathByChanceFactor;
//                this.deathByChance = 0;
            } else {
                hasWings = false;
                deathByChance = baseDeathByChance;
            }
        }
//        if (RandomUtil.getRandomNumberInRange(0, 100) < mutationRate) {
//            if(!hasColor) {
//                System.out.println("mutation hasColor");
//                hasColor = true;
//                this.replicationRate = baseReplicationRate * mutatedReplicationrateFactor;
//                this.deathByChance = deathByChance * mutatedReplicationrateFactor;   // as if they have color, predators recognize them easier
//            } else {
//                hasColor = false;
//                this.replicationRate = baseReplicationRate;
//            }
//        }
        //---------------------------------------------------------------------------
//        if (hasWings){
//            deathByChance = mutatedDeathByChance;
//        }
//        if (hasColor){
//            replicationRate = mutationRate;
//        }

    }

    public boolean isHasWings() {
        return hasWings;
    }

    public boolean isHasColor() {
        return hasColor;
    }


}
