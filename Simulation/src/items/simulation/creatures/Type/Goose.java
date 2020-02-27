package items.simulation.creatures.Type;

import base.simulation.gameLogic.Tools.MathRound;
import items.simulation.creatures.Blob;
import items.simulation.creatures.action.BehaviorTypes;

public class Goose extends Blob {

    // type of behaviors
    BehaviorTypes type;

    // Goose count
    private static int gooseCount=0;

    // Goose constructor

    public Goose(){

    }

    public Goose(int energy){
        // set up Goose default stats and increments the creature count
        setEnergy(energy);
        setStash(0);
        setPlace(0);
        setPop();
        setBehavior();
        gooseCount++;
    }

    @Override
    public void interact(Blob type){
        switch(type.getBehavior()){
            case AGGRESSIVE:
                if(MathRound.decide(50)){
                    this.setStash(0*5);
                }else{
                    this.setStash(0*25);
                }
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
    public BehaviorTypes getBehavior() {
        return type;
    }

    @Override
    public void setBehavior() {
        this.type = BehaviorTypes.DEFENSIVE;
    }

    @Override
    public final void die() {
        gooseCount--;
    }

    public static int population_of_type() {
        return gooseCount;
    }

    @Override
    public Blob getNew() {
        return new Goose(3);
    }
}
