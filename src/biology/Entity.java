package biology;

import graphicsLogic.Display;
import javafx.scene.image.ImageView;

public abstract class Entity extends ImageView {

    protected ColonyManipulate colony;
    protected Environment environment;
    protected int remainingLifeTime = 50;
    protected float deathByChance;
    protected float baseDeathByChance;
    protected Display display;




    public Entity(ColonyManipulate colony, Environment environment, Display display){
        this.colony = colony;
        this.environment = environment;
        this.display = display;
    }

    public Environment getEnvironment() {
        return environment;
    }
}
