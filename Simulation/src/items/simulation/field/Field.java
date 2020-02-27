package items.simulation.field;

import base.simulation.gameLogic.Tools.Pair;
import base.simulation.gameLogic.Tools.PairList;
import items.simulation.creatures.Blob;

public class Field {

    // Attributes
    private static PairList field;
    private final int populationCap;
    private final float food;

    // Constructor
    public Field(int fieldSize,float foodCount){

        field = new PairList(fieldSize);
        food = foodCount;
        populationCap = fieldSize*2;
        fillField();
    }

    // Class methods
    public static int fieldSize(){
        return field.size();
    }

    public final int getPopulationCap(){
        return populationCap;
    }

    public static float foodCount(int index){ return field.get(index).getValue(); };

    public static Pair<Blob> get_Blobs_on_field(int index){
        return field.get(index);
    }


    // Filling the field with food
    public final void fillField(){
        //
        int i = 0;
        for(Pair current : field.getList()){
            current.setValue(food);
            i++;
            System.out.println(i);
        }

    };

    public static final boolean step(Blob currentBlob){
        return field.addIndex(currentBlob.getPlace(), currentBlob);
    }
}
