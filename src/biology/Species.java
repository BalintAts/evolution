package biology;

import app.config;
import graphicsLogic.Display;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import utils.RandomUtil;

import java.util.Iterator;


public class Species extends Entity {


    private int baseReplicationRate = 20;
    private int mutationRate = config.MUTATION_RATE;
    private boolean hasColor;
    private boolean hasWings;
    private int replicationRate = 20;
    private static int numberOfSpecies1 = 0;
    private Circle circle;
    protected float deathByChance;


    public Species(ColonyManipulate colony, Environment environment, boolean hasColor, boolean hasWings, Display display) {
        super(colony, environment, display);
        this.hasColor = hasColor;
        this.hasWings = hasWings;
        deathByChance = config.DEATH_CHANCE_OF_BLACK;
        setImage(new Image("face-without-mouth.jpg"));
        int x = (RandomUtil.getRandomNumberInRange(0, config.WINDOW_WIDTH));
        int y = (RandomUtil.getRandomNumberInRange(0, config.WINDOW_HEIGHT));
        this.circle = new Circle(x, y, 20);
        circle.setFill(Color.BLACK);
        if (hasWings) {
            circle.setFill(Color.RED);
            setDeathByChanceToMutated();
        }
        numberOfSpecies1++;
        display.add(circle);

    }

    private void setDeathByChanceToMutated() {
        deathByChance = environment.getPredators() * config.MUTATED_DEATH_BY_CHANCE_FACTOR;
    }

    public static int getNumberOfSpecies1() {
        return numberOfSpecies1;
    }


    public Circle getCircle() {
        return circle;
    }


    public boolean die(Boolean mustDie) {
        if (numberOfSpecies1 >= environment.getPopulationLimit() || remainingLifeTime < 0 || (RandomUtil.getRandomNumberInRange(0, 100) < deathByChance || mustDie)) {
            numberOfSpecies1--;
            display.remove(circle);
            return true;
        }
        return false;
    }


    public boolean replicate() {
        if (RandomUtil.getRandomNumberInRange(0, 100) < replicationRate ) {
            colony.getiWillBorn().add(new Species(colony, environment, hasColor, mutate(), display));
            if (numberOfSpecies1 >= environment.getPopulationLimit() - 1) {
//                colony.getSpeciesSet().remove(this);
                return true;
            }
        }
        return false;
    }


        public boolean mutate () {
            if (RandomUtil.getRandomNumberInRange(0, 100) < mutationRate) {
                if (!hasWings) {
                    return true;
//                deathByChance = (float) (environment.getPredators() * 0); //baseDeathByChance * MUTATED_DEATH_BY_CHANCE_FACTOR;
                } else {
                    return false;
                }
            }
            return hasWings;
        }

        public boolean isHasWings () {
            return hasWings;
        }

        public boolean isHasColor () {
            return hasColor;
        }
    }
