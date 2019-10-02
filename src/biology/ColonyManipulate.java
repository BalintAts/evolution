package biology;

import graphicsLogic.Display;

import java.util.List;
import java.util.Set;

public interface ColonyManipulate {

    public Set<Species1> getSpecies1Set();

    public void create(int initNumberOfSpecies1, Display display);

    public void destroy(Species1 creature);

    public List<Species1> getiWillBorn();


    }
