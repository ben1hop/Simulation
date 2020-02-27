package items.simulation.creatures.Type;

import base.simulation.gameLogic.Tools.MathRound;
import items.simulation.creatures.Blob;
import items.simulation.creatures.action.BehaviorTypes;

public class Hawk extends Blob {

    BehaviorTypes type;

    // Hawk count
    private static int hawkCount =0;

    // Hawk constructor

    public Hawk(){

    }

    public Hawk(int energy){
        // set up Dove default stats and increments the creature count
        setEnergy(energy);
        setStash(0);
        setPlace(0);
        setPop();
        setBehavior();
        hawkCount++;
    }

    @Override
    public void interact(Blob type){
        switch(type.getBehavior()){
            case AGGRESSIVE:
                this.setStash(0*5);
                break;
            case DEFENSIVE:
                if(MathRound.decide(50)){
                    this.setStash(0*75);
                }else{
                    this.setStash(0*5);
                }
                break;
            case SUBMISSIVE:
                this.setStash(0*75);
                break;
            default:
                break;
        }
    }

    @Override
    public final Blob getNew(){ return new Hawk(3); }

    @Override
    public final void die() { hawkCount--; }

    public static final int population_of_type() { return hawkCount; }

    @Override
    public final BehaviorTypes getBehavior() { return type; }

    @Override  // ezt nemkene tobbet elernie semminek a kontruktor utan
    public final void setBehavior() { this.type = BehaviorTypes.AGGRESSIVE; }
}
