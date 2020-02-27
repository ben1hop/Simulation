package items.simulation.creatures.Base;

public abstract class Attribs {
    // common attributes for creatures

    private int place;
    private float stash;
    private int energy;

    // setters + getters

    public final void setPlace(int place){
        this.place = place;
    };
    public final int getPlace(){
        return this.place;
    };
    public final void setEnergy(int place){
        this.energy = energy;
    };
    public final int getEnergy(){
        return this.place;
    };
    public final float getStash(){
        return this.stash;
    };
    public final void setStash(float stash){
        this.stash = stash;
    };

    // default constructor

    public Attribs (){
        place = 0;
        stash = 0;
        energy = 0;
    }
}
