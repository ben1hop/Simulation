package items.simulation.creatures;

import items.simulation.creatures.action.Actions;
import items.simulation.creatures.action.Behavior;
import items.simulation.creatures.action.CreatureActions;

// Basic creature type , it can be extended to any other type of creature , it has the basic creature attribs and methods
public abstract class Blob extends Actions implements Behavior , CreatureActions {

    private static int population=0;

    public final void setPop(){
        this.population++;
    };
    public final static int getPop(){
        return population;
    }

    // virtual methods overridden by instances of the children
}
