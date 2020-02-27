package base.simulation.gameLogic;
import items.simulation.creatures.Type.Goose;
import items.simulation.field.Field;
import items.simulation.creatures.Blob;
import items.simulation.creatures.Type.Dove;
import items.simulation.creatures.Type.Hawk;

import java.util.ArrayList;
import java.util.Arrays;

enum BLOB_TYPES { HAWK , DOVE , GOOSE };

public class GameSetup {

    public static final ArrayList<Blob> setupBlob(int hawkCount, int doveCount, int gooseCount, int startEnergy){

        // starting population
        int starting_population = hawkCount + doveCount + gooseCount;

        // Store the blobs while initialize
        int counter = 0;

        ArrayList<Blob> blobContainerTemp = new ArrayList<>();

        // Generating blobs until we reach the starting blob population
        while(starting_population > counter){

            // Picking a random type
            BLOB_TYPES random_Type = BLOB_TYPES.values()[(int)Math.random() * (BLOB_TYPES.values().length)];
            switch (random_Type){
                // Create Hawk
                case HAWK:
                    if(Hawk.population_of_type() < hawkCount){
                        blobContainerTemp.add(new Hawk(3));
                    }
                    break;
                // Create Dove
                case DOVE:
                    if(Dove.population_of_type() < doveCount){
                        blobContainerTemp.add(new Dove(3));
                    }
                    break;
                // Create Goose
                case GOOSE:
                    if(Goose.population_of_type() < gooseCount){
                        blobContainerTemp.add(new Goose(3));
                    }
                    break;
                default:
            }
            counter++;
        }
        return blobContainerTemp;
    }

    public static final Field setupField(int fieldSize, int foodCount){
        return new Field(fieldSize,foodCount);
    }
}
