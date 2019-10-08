package base.simulation.gameLogic;

import items.simulation.Blobs;
import items.simulation.Field;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class GameLogic {

    public static void results(ArrayList<Blobs> blobContainer){

        int hawks = 0,doves = 0;
        for(int i = 0; i < blobContainer.size();i++){
            if(blobContainer.get(i).thisType()== "Hawk"){
                hawks++;
            }else{
                doves++;
            }
        }

        System.out.println("Number of total blobs: "+blobContainer.size());
        System.out.println("Hawk population: "+hawks);
        System.out.println("Dove population: "+doves);
    }


    public static void setBack(ArrayList<Blobs> blobContainer){
        for (int blobStep = 0; blobStep < blobContainer.size(); blobStep++) {
            // Set place to default
            blobContainer.get(blobStep).setBack();
        }
    }

    public static void whoIsntSurvive(ArrayList<Blobs> blobContainer) {
        for (int blobStep = 0; blobStep < blobContainer.size(); blobStep++) {
                if(!blobContainer.get(blobStep).survive()){
                    blobContainer.remove(blobStep);
                    blobStep--;
                }
        }
    }

    public static void whoIsReproducing(ArrayList<Blobs> blobContainer, int listSize) {

        for (int blobStep = 0; blobStep < listSize; blobStep++) {
            if(Field.populationCap > Blobs.population ){
                if (blobContainer.get(blobStep).reproduce()) {

                    blobContainer.add(new Blobs(1,blobContainer.get(blobStep).thisType()));
                    System.out.println("Rep Success " + blobContainer.size());
                }else{
                    System.out.println("Didnt rep itself "+ blobContainer.size());
                }
            }else{
                System.out.println("There is no room.");
            }

        }
    }


    public static void moveAndGather(Field field, ArrayList<Blobs> blobContainer, int sizeField) {
        ArrayList<Integer> tempArray = new ArrayList<>();

        for (int blobStep = 0; blobStep < blobContainer.size(); blobStep++) {

            // Move
            blobContainer.get(blobStep).move(sizeField);
            System.out.println("The "+blobStep+"blobs place: "+blobContainer.get(blobStep).place);

            boolean unique = isUnique(tempArray,blobContainer.get(blobStep).place);
            while(!unique){
                blobContainer.get(blobStep).move(sizeField);
                System.out.println("The "+blobStep+"blobs new place: "+blobContainer.get(blobStep).place);
                unique = isUnique(tempArray,blobContainer.get(blobStep).place);
            }
            tempArray.add(blobContainer.get(blobStep).place);
            System.out.println("Added to temp: "+blobContainer.get(blobStep).place + " and it was a "+blobContainer.get(blobStep).thisType());

            // Gather
            blobContainer.get(blobStep).stash = field.isThereFood(blobContainer.get(blobStep).place);

        }
        // Pairs
        hasMetAnyone(blobContainer);
    }

    private static void hasMetAnyone(ArrayList <Blobs> blobContainer){
        // Checking if a blob met another one
        for (int i = 0; i < blobContainer.size(); i++) {
            for(int j = i+1; j < blobContainer.size(); j++){
                if(blobContainer.get(i).place == blobContainer.get(j).place){
                    // if hawk - dove , hawk - hawk , dove - dove
                    if(blobContainer.get(i).thisType() == "Hawk" && blobContainer.get(j).thisType() == "Hawk"){
                        blobContainer.get(i).stash = 0;
                        blobContainer.get(j).stash = 0;

                    }else if(blobContainer.get(i).thisType() == "Dove" && blobContainer.get(j).thisType() == "Hawk"){
                        blobContainer.get(i).stash *= 0.25f;
                        blobContainer.get(j).stash *= 0.75f;

                    }else if(blobContainer.get(i).thisType() == "Hawk" && blobContainer.get(j).thisType() == "Dove"){
                        blobContainer.get(i).stash *= 0.75f;
                        blobContainer.get(j).stash *= 0.25f;

                    }else if(blobContainer.get(i).thisType() == "Dove" && blobContainer.get(j).thisType() == "Dove"){
                        blobContainer.get(i).stash *= 0.5f;
                        blobContainer.get(j).stash *= 0.5f;

                    }
                }
            }
        }
    }


    public static boolean isUnique(ArrayList<Integer> tempArray, int currentValue) {
        int isSomeoneThere = 0;

        for(int i = 0; i < tempArray.size();i++){
            if(tempArray.get(i) == currentValue){
                isSomeoneThere++;
                if(isSomeoneThere == 2){
                    return false;
                }
            }
        }
        return true;

    }

}
