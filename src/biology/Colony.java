package biology;

import graphicsLogic.Display;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Colony implements ColonyManipulate {

    private Environment environment;
    private List<Species1> iWillBorn = new ArrayList<>();
    private Set<Species1> species1Set = new HashSet<>();


    public Colony(Environment environment) {
        this.environment = environment;
    }

    public void create(int initNumberOfSpecies1, Display display){
        for (int i = 0; i < initNumberOfSpecies1; i++) {
             species1Set.add(new Species1(this, environment, false, false, display));
        }
    }

    public void destroy(Species1 creature){
        species1Set.remove(creature);

    }

    public List<Species1> getiWillBorn() {
        return iWillBorn;
    }

    public Set<Species1> getSpecies1Set() {
        return species1Set;
    }


}
