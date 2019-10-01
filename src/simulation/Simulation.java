package simulation;

import biology.Colony;
import biology.ColonyManipulate;
import biology.Environment;
import biology.Species1;
import graphicsLogic.Display;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class Simulation extends Pane {

    private Environment environment = new Environment();
    private ColonyManipulate colony = new Colony(environment);
    private int simTime = 1000;
    private Display display = new Display(this);
    private GameTimer gameTimer = new GameTimer();

    public void initAndStart(){
        colony.create(10);
        simulationLoop();
        gameTimer.setup(this::step);
        gameTimer.play();

    }

    public void step(){
        List<Species1> deathNote = new ArrayList<>();
        for(Species1 member: colony.getSpecies1Set()){
            member.replicate();
            member.die();
            if (member.isiWillDie())
                deathNote.add(member);
        }
        for (Species1 dyinCreature : deathNote) {
            colony.getSpecies1Set().remove(dyinCreature);
        }
        for (Species1 creatureToBorn : colony.getiWillBorn() ) {
            colony.getSpecies1Set().add(creatureToBorn);
        }
        colony.getiWillBorn().clear();
        render();
        log();
    }

    public void render(){
        for(Species1 member: colony.getSpecies1Set()){
            display.add(member);
        }
    }

    public void simulationLoop(){
        for(int i = 0; i<simTime; i++){
            step();
        }

    }

    public void log(){
        int numberOfHasWings = 0;
        int numberOfHasColor = 0;
        for(Species1 creature: colony.getSpecies1Set()){
            if (creature.isHasWings()){
                numberOfHasWings++;
            }
            if (creature.isHasColor()){
                numberOfHasColor++;
            }
        }
        System.out.println("-------------------------------------------");
//        System.out.println("population limit: " + environment.getPopulationLimit());
//        System.out.println("predators: " + environment.getPredators());
//        System.out.println("                              ");
        System.out.println("number of species1: " + Species1.getNumberOfSpecies1());
        System.out.println("has wings: " + numberOfHasWings);
        System.out.println("has color: " + numberOfHasColor);
    }
}
