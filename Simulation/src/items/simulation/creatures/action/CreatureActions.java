package items.simulation.creatures.action;

import items.simulation.creatures.Blob;

public interface CreatureActions {

    public Blob getNew();
    public void interact(Blob type);
}
