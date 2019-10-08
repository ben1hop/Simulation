package base.simulation;

import items.simulation.*;
import java.util.ArrayList;
import base.simulation.gameLogic.GameLogic;

public class Application {
    private Field field;
    private ArrayList<Blobs> blobContainer;

    public Application(int fieldSize, int startEnergy, int stepCounter, int foodCount, int hawkCount , int doveCount) {
        // Setting up field
        this.field = new Field(fieldSize, foodCount);

        // Setting up blobs
        int blobCount = hawkCount +doveCount;
        blobContainer = new ArrayList<>();
        for (int i = 0; i < blobCount; i++) {
            if(doveCount > i){
                blobContainer.add(i, new Blobs(startEnergy, "Dove"));
            }
            else{
                blobContainer.add(i, new Blobs(startEnergy, "Hawk"));
            }

        }

        // Running the simulation
        run(this.field, this.blobContainer, fieldSize, stepCounter);
    }

    private void run(Field field, ArrayList<Blobs> blobContainer, int sizeField, int stepCounter) {
        //GAME LOOP
        int currentStep = 0;

        while (currentStep < stepCounter) {
            System.out.println(currentStep + ": step from " + stepCounter);

            // SET PLACES AND FOOD
            GameLogic.moveAndGather(this.field, this.blobContainer, sizeField);


            // GIVING ACTION BASED ON FOOD THEN RETURN TO DEFAULT

            // Health losing logic
            GameLogic.whoIsntSurvive(this.blobContainer);

            // Reproduce logic
            GameLogic.whoIsReproducing(this.blobContainer, this.blobContainer.size());

            // Giving next step and setting up field and setting back the blobs
            GameLogic.setBack(this.blobContainer);
            field.fillField();
            currentStep++;
        }

        GameLogic.results(this.blobContainer);
    }


}
