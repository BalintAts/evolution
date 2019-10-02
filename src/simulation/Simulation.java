package simulation;

import biology.Colony;
import biology.ColonyManipulate;
import biology.Environment;
import biology.Species1;
import graphicsLogic.Display;
import javafx.scene.layout.Pane;

import java.util.Iterator;

public class Simulation extends Pane {

    private Environment environment = new Environment();
    private ColonyManipulate colony = new Colony(environment);
    private int simTime = 1000;
    private Display display = new Display(this);
    private GameTimer gameTimer = new GameTimer();

    public void initAndStart(){
        colony.create(10,display);
        simulationLoop();
        gameTimer.setup(this::step);
        gameTimer.play();

    }

    public void step(){
         Iterator<Species1> iter = colony.getSpecies1Set().iterator();

         while (iter.hasNext()) {
             Species1 member = iter.next();
             member.replicate();
//             if (member.replicate()){
//                 colony.getSpecies1Set().add(new Species1(colony, environment, member.isHasColor(),member.isHasWings()));
//             }
             if (member.die()) {
                 iter.remove();
             }
         }
        for (Species1 creatureToBorn : colony.getiWillBorn() ) {
            colony.getSpecies1Set().add(creatureToBorn);
        }
        colony.getiWillBorn().clear();
//        render();
        log();
    }

    public void render(){
        display.clear();
        for(Species1 member: colony.getSpecies1Set()){
            display.add(member.getCircle());
        }
    }

    public void simulationLoop(){
        for(int i = 0; i<simTime; i++){
            step();
        }

    }

    public void log(){
        int numberOfHasWings = 0;
        for(Species1 creature: colony.getSpecies1Set()){
            if (creature.isHasWings()){
                numberOfHasWings++;
            }
        }
        System.out.println("-------------------------------------------");
        System.out.println("number of species1: " + Species1.getNumberOfSpecies1());
        System.out.println("has wings: " + numberOfHasWings);
    }
}
