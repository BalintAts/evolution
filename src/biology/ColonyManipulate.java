package biology;

import graphicsLogic.Display;

import java.util.List;
import java.util.Set;

public interface ColonyManipulate {

    public Set<Species> getSpeciesSet();

    public void create(int initNumberOfSpecies1, Display display);

    public void destroy(Species creature);

    public List<Species> getiWillBorn();


    }
