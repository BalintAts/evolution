## evolution

This is a simulation of natural selection.
There are black entities, they can born, die. They can die in two ways: by reaching their end of life, or by an environmental cause.
When a new entity borns, it can mutate to a red entity (and vice-versa), which can resist more against environmental hazards. We expect, that after time, there will be more red creatures, than black creatures.

You can set the rules in the /src/app/config.java config file.
- POPULATION_LIMIT: The number of entities the environment can hold.
- DEATH_CHANCE_OF_BLACK: How often the black creature dies because of the environment.
- MUTATED_DEATH_BY_CHANCE_FACTOR: This influences the death rate of the red creatures.
- MUTATION_RATE: How often will be a new born creature a mutated one. 
- NUMBER_OF_INITIAL_CREATURES: How many creature the simulation starts with.
- BASIC_LIFE_TIME: How long creatures can live at max.
