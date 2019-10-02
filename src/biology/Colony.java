package biology;

import graphicsLogic.Display;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Colony implements ColonyManipulate {

    private Environment environment;
    private List<Species> iWillBorn = new ArrayList<>();
    private Set<Species> speciesSet = new HashSet<>();


    public Colony(Environment environment) {
        this.environment = environment;
    }

    public void create(int initNumberOfSpecies1, Display display){
        for (int i = 0; i < initNumberOfSpecies1; i++) {
             speciesSet.add(new Species(this, environment, false, false, display));
        }
    }

    public void destroy(Species creature){
        speciesSet.remove(creature);

    }

    public List<Species> getiWillBorn() {
        return iWillBorn;
    }

    public Set<Species> getSpeciesSet() {
        return speciesSet;
    }


}
