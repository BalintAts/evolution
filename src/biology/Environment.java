package biology;

import app.config;

public class Environment {
    private int populationLimit = config.POPULATION_LIMIT;
    private int predators = 24;

    public int getPopulationLimit() {
        return populationLimit;
    }

    public int getPredators() {
        return predators;
    }
}
