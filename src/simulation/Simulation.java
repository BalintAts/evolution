package simulation;

import app.config;
import biology.Colony;
import biology.ColonyManipulate;
import biology.Environment;
import biology.Species;
import graphicsLogic.Display;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
    private int elapsedTime = 0;
    private Text elapsedTimeText = new Text();


    public void initAndStart() {
        colony.create(config.NUMBER_OF_INITIAL_CREATURES, display);
        numberOFSpecies.setX(50);
        numberOFSpecies.setY(50);
        numberOFSpecies.setFill(textColor);
        numberOFSpecies.setFont(Font.font(null, FontWeight.BOLD, 30));
        display.add(numberOFSpecies);

        numberOFReds.setX(50);
        numberOFReds.setY(100);
        numberOFReds.setFill(textColor);
        numberOFReds.setFont(Font.font(null, FontWeight.BOLD, 30));
        display.add(numberOFReds);

        elapsedTimeText.setX(50);
        elapsedTimeText.setY(150);
        elapsedTimeText.setFill(textColor);
        elapsedTimeText.setFont(Font.font(null, FontWeight.BOLD, 30));
        display.add(elapsedTimeText);



        gameTimer.setup(this::step);
        gameTimer.play();
    }


    public void step() {
        Iterator<Species> iter = colony.getSpeciesSet().iterator();

        while (iter.hasNext()) {
            Species member = iter.next();
            member.replicate();
            if (member.die()) {
                iter.remove();
            }
        }
        for (Species creatureToBorn : colony.getiWillBorn()) {
            colony.getSpeciesSet().add(creatureToBorn);
        }
        colony.getiWillBorn().clear();
        elapsedTime++;
        log();
    }


    public void log() {
        int numberOfHasWings = 0;
        for (Species creature : colony.getSpeciesSet()) {
            if (creature.isHasWings()) {
                numberOfHasWings++;
            }
        }

        numberOFSpecies.toFront();
        numberOFReds.toFront();
        elapsedTimeText.toFront();
        numberOFSpecies.setText("Creatures:  " + String.valueOf(Species.getNumberOfSpecies1()));
        numberOFReds.setText("Reds:      " + String.valueOf(numberOfHasWings));
        elapsedTimeText.setText("Elapsed time:  " + String.valueOf(elapsedTime));

//        System.out.println("-------------------------------------------");
//        System.out.println("number of species1: " + Species.getNumberOfSpecies1());
//        System.out.println("has wings: " + numberOfHasWings);
    }
}
