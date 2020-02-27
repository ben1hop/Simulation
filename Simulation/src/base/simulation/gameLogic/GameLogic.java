package base.simulation.gameLogic;

import base.simulation.gameLogic.Tools.FileStream;
import base.simulation.gameLogic.Tools.FileStreamDirection;
import base.simulation.gameLogic.Interfaces.Handler;
import base.simulation.gameLogic.Tools.PairList;
import items.simulation.creatures.Blob;
import items.simulation.creatures.Type.Dove;
import items.simulation.creatures.Type.Hawk;
import items.simulation.creatures.Type.Goose;
import items.simulation.field.Field;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GameLogic {

    public static void results(ArrayList<Blob> blobContainer) {

        File results = new File("results.txt");

        FileStream output = new FileStream(FileStreamDirection.Write, results);

        try
        {
            output.writer.write("Number of total blobs: "+Blob.getPop());
            output.writer.newLine();
            output.writer.write("Hawk population: "+Hawk.getPop());
            output.writer.newLine();
            output.writer.write("Dove population: "+Dove.getPop());
            output.writer.newLine();
            output.writer.write("Dove population: "+Goose.getPop());
            output.writer.flush();
            output.writer.close();

        }catch(IOException err){
            System.err.format("Output file error: "+err);
        } finally {

            System.out.println("Results has been stored.");
        }

    }


    public static void setBack(ArrayList<Blob> blobContainer){
        // Set place to default
        blobContainer.forEach((blob) -> blob.setBack());
    }

    public static void whoIsntSurvive(ArrayList<Blob> blobContainer) {
        // iterate through in our array
        for (int blobStep = 0; blobStep < blobContainer.size(); blobStep++) {
            // checking the current elements criteria for survive
                if(!blobContainer.get(blobStep).survive()){
                    // decrements the types counter then deletes from the list
                    blobContainer.get(blobStep).die();
                    blobContainer.remove(blobStep);
                    // And step one back to not skip the next element
                    blobStep--;
                }
        }
    }

    public static boolean whoIsReproducing(ArrayList<Blob> blobContainer, int listSize, int populationCap) {

        // iterate through the in our array
        for (int blobStep = 0; blobStep < listSize; blobStep++) {
            // if the fields population cap gets full , stops
            if(populationCap > Blob.getPop() ){
                // checking the current elements criteria for reproducing
                if (blobContainer.get(blobStep).reproduce()) {
                    // calls the the current types constructor
                    blobContainer.add(blobContainer.get(blobStep).getNew());
                    System.out.println("Rep Success " + blobContainer.size());
                }else{
                    System.out.println("Didnt rep itself "+ blobContainer.size());
                }
            }else{
                System.out.println("There is no room.");
                return false;
            }
        }
        return true;
    }

    public static ArrayList<Blob> moveAndGather_v2 (ArrayList<Blob> blobContainer){

        // Iterate through the blobcontainer and placing all of them onto the field
        for(int i = 0 ; i < blobContainer.size();i++){
            Blob current_blob = blobContainer.get(i);

            // Getting a place value
            current_blob.move(Field.fieldSize());
            // Trying to place this blob into this field index
            if(Field.step(current_blob)){
                // success - placed on that field and got its food count
                // if second -> interact
                if(Field.get_Blobs_on_field(i).hasPair()){
                    handler.handle(Field.get_Blobs_on_field(i));
                }
            }
        }

        // refilling an arraylist type for blobcontainer
        ArrayList<Blob> newArray = new ArrayList<>(blobContainer.size());
        for(int i = 0; i < Field.fieldSize() ; i++){
            newArray.add(Field.get_Blobs_on_field(i).getFirst());
            newArray.add(Field.get_Blobs_on_field(i).getSecond());
        }
        return newArray;
    }

    public static void hasMetAnyone(ArrayList<Blob> blobContainer, PairList pairList){
        // Checking if a blob met another one

        // Iterate through each pair element , interacting the first Blob with the second one
        // But not every list element has 2 blobs
        for(int i = 0; i < pairList.size(); i++){
            if(pairList.get(i).hasPair()){
                pairList.get(i).getFirst().interact(pairList.get(i).getSecond());
                pairList.get(i).getSecond().interact(pairList.get(i).getFirst());
            }
        }

        for(int pairCounter = 0; pairCounter < pairList.size();pairCounter++){
            int temp = 0;
            int blobCounter = 0;
            while(blobCounter < blobContainer.size() && temp < 2){
                blobCounter++;
                if(blobContainer.get(blobCounter).getPlace() == pairList.get(pairCounter).getValue()){

                    if(blobContainer.get(blobCounter).getClass() == pairList.get(pairCounter).getFirst().getClass()){

                        blobContainer.get(blobCounter).setStash(  pairList.get(pairCounter).getFirst().getStash()  );
                    }else{

                        blobContainer.get(blobCounter).setStash(  pairList.get(pairCounter).getSecond().getStash()  );
                    }
                    temp++;
                }
            }
        }
    }


    static Handler handler = type -> {
        type.getFirst().interact(type.getSecond());
        type.getSecond().interact(type.getFirst());
    };

}
