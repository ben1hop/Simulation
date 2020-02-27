package base.simulation.gameLogic;
import java.util.ArrayList;

import base.simulation.gameLogic.GameSetup;
import base.simulation.gameLogic.GameLogic;
import items.simulation.creatures.Blob;
import items.simulation.field.Field;


public class Application {
    private static Field field;
    private static ArrayList<Blob> blobContainer;
    /*
    private int runTime;
    private Timer timer;
    */

    public Application( int fieldSize, int startEnergy, int foodCount, int hawkCount , int doveCount , int gooseCount ) {
        // Setting up field
        field = GameSetup.setupField( fieldSize , foodCount );

        // Setting up blobs
        blobContainer = GameSetup.setupBlob( hawkCount , doveCount , gooseCount , startEnergy );

    }

    public void run(int stepCounter) {
        //GAME LOOP
        int currentStep = 0;
        boolean can_run = true;

        while (currentStep < stepCounter && can_run) {
            System.out.println(currentStep + ": step from " + stepCounter);

            // SET PLACES AND FOOD AND INTERACTING

            GameLogic.moveAndGather_v2(blobContainer);

            // INTERACTING
            //GameLogic.hasMetAnyone(blobContainer, places);

            // GIVING ACTION BASED ON FOOD THEN RETURN TO DEFAULT
            // Energy losing
            GameLogic.whoIsntSurvive(blobContainer);

            // Reproduce
            can_run = GameLogic.whoIsReproducing(blobContainer, blobContainer.size(), field.getPopulationCap());

            // Energy gain


            // Giving next step and setting up field and setting back the blobs
            GameLogic.setBack(blobContainer);
            currentStep++;
        }

        // Calling results after a round

        GameLogic.results(this.blobContainer);
    }
}
