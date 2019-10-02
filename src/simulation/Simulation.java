package simulation;

import biology.Colony;
import biology.ColonyManipulate;
import biology.Environment;
import biology.Species1;
import graphicsLogic.Display;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.Iterator;

public class Simulation extends Pane {

    private Environment environment = new Environment();
    private ColonyManipulate colony = new Colony(environment);
    private Display display = new Display(this);
    private GameTimer gameTimer = new GameTimer();
    private Text numberOFSpecies = new Text();
    private Text numberOFReds = new Text();
    private Color textColor = new Color(0, 0, 1, 1);

    public void initAndStart(){
        colony.create(10,display);
        numberOFSpecies.setX(50);
        numberOFSpecies.setY(50);
        numberOFSpecies.setFill(textColor);
        numberOFSpecies.setStyle("-fx-font: 24 arial;");
        display.add(numberOFSpecies);

        numberOFReds.setX(50);
        numberOFReds.setY(100);
        numberOFReds.setFill(textColor);
        numberOFReds.setStyle("-fx-font: 24 arial;");
        display.add(numberOFReds);

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
        log();
    }



    public void log(){
        int numberOfHasWings = 0;
        for(Species1 creature: colony.getSpecies1Set()){
            if (creature.isHasWings()){
                numberOfHasWings++;
            }
        }

        numberOFSpecies.toFront();
        numberOFReds.toFront();
        numberOFSpecies.setText("Creatures:  " + String.valueOf(Species1.getNumberOfSpecies1()));
        numberOFReds.setText("Reds:      " + String.valueOf(numberOfHasWings));

        System.out.println("-------------------------------------------");
        System.out.println("number of species1: " + Species1.getNumberOfSpecies1());
        System.out.println("has wings: " + numberOfHasWings);
    }
}
