package items.simulation.creatures.Type;

import items.simulation.creatures.Blob;
import items.simulation.creatures.action.BehaviorTypes;
import items.simulation.creatures.action.CreatureActions;
import items.simulation.field.Field;

public class Dove extends Blob {

    BehaviorTypes type;

    // Dove count
    private static int doveCount=0;

    public Dove(){

    }

    // dove constructor
    public Dove(int energy){
        // set up Dove default stats and increments the creature count
        setEnergy(energy);
        setStash(0);
        setPlace(0);
        setPop();
        setBehavior();
        doveCount++;
    }

    @Override
    public void interact(Blob type){
        switch(type.getBehavior()){
            case AGGRESSIVE:
                this.setStash(0*25);
                break;
            case DEFENSIVE:
                this.setStash(0*5);
                break;
            case SUBMISSIVE:
                this.setStash(0*5);
                break;
            default:
                break;
        }
    }

    @Override
    public final void die() {
        doveCount--;
    }

    public static final int population_of_type() {
        return doveCount;
    }

    @Override
    public final Blob getNew() {
        return new Dove(3);
    }

    public static final int getDoveCount(){
        return doveCount;
    }

    @Override
    public final BehaviorTypes getBehavior() {
        return type;
    }

    @Override
    public final void setBehavior() {
        this.type = BehaviorTypes.SUBMISSIVE;
    }
}
