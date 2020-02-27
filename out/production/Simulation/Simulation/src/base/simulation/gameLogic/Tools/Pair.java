package base.simulation.gameLogic.Tools;

import items.simulation.creatures.Blob;

public class Pair<Blob> {

    // Pair Type Variables

    Blob first;
    Blob second;
    protected float value;

    // Pair Type constructors

    Pair(){
        value = 0;
        first = null;
        second = null;
    }

    Pair(int value , Blob first , Blob second){
        this.value = value;
        this.first = first;
        this.second = second;
    }

    // Setters + Getters

    public boolean hasPair(){
        return this.first != null && this.second != null;
    }

    public Blob getFirst() {
        return first;
    }

    public void setFirst(Blob first) {
        this.first = first;
    }

    public void setSecond(Blob second) {
        this.second = second;
    }

    public Blob getSecond() {
        return second;
    }

    public void setValue(float value){
        this.value = value;
    }

    public float getValue(){
        return value;
    }
}
