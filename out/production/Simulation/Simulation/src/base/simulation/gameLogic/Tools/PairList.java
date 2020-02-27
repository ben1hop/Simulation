package base.simulation.gameLogic.Tools;

import items.simulation.creatures.Blob;
import items.simulation.field.Field;

import java.util.ArrayList;

public class PairList {
    // Pair list variables

    private final ArrayList<Pair<Blob>> array;
    private int size;

    // Constructors

    public PairList(){
        size = 0;
        array = new ArrayList<>();
    }

    public PairList(int size){
        this.size = size;
        array = new ArrayList<>();

        int counter = 0;
        while(size> counter){
            array.add(new Pair<>());
            counter++;
        }
    }

    // Methods

    public final Pair<Blob> get(int index){
        try {
            array.get(index);
        }catch(ArrayIndexOutOfBoundsException ref) {
            System.out.println("sheeet");
            System.out.println(ref);
        }
        return array.get(index);
    }

    public final boolean addIndex(int index , Blob blob){

        // Checking is there place -- index on pairlist , current blob
        // If the first is empty
        if(array.get(index).getFirst() == null){
            // place blob there and add the food on that field pairlist index to it
            array.get(index).setFirst(blob);
            array.get(index).getFirst().setStash(Field.foodCount(index));
            return true;

        }
        // If the second is empty
        else if(array.get(index).getSecond() == null){
            array.get(index).setSecond(blob);
            array.get(index).getFirst().setStash(Field.foodCount(index));
            return true;
        }else{
            // mar foglalt ez a slot
            return false;
        }
    }

    /*public final boolean isFull(int index){
        return array.get(index).getFirst() != null && array.get(index).getSecond() != null;
    }*/

    public final void addNext(int place , Blob blob){

        int i = 0;
        // itterate through the array while we reach the end or find a same value
        while(i < array.size() && array.get(i).getValue()!= place){
            i++;
        }
        // if we reach the end we add a new object at the end of the array
        if(i == array.size()){
            array.add(new Pair<Blob>(place, blob , null));
            size++;
        }
        // if we stop before that we found an object with the same place value
        else{
            array.get(i).setSecond(blob);
        }
    }

    public final int size(){
        return size;
    }

    public final ArrayList<Pair<Blob>> getList(){
        return array;
    }
}
