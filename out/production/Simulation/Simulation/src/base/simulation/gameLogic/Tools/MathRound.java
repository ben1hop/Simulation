package base.simulation.gameLogic.Tools;

import java.util.Random;

public class MathRound {

    // Math rounding for survival

    public static final boolean decideSurvive(float stash){

        // chance equals the fraction between 0-1
        int chance = Math.round((stash)*100);
        Random rand = new Random();

        // getting a random number between 0-99
        int success = rand.nextInt(100) + 1;
        if(chance >= success){
            return true;
        }
        else{
            return false;
        }
    };

    // Math rounding for reproducing

    public static final boolean decideReproduce(float stash){

        // chance equals the fraction between 1-2
        int chance = Math.round((stash-1)*100);
        Random rand = new Random();

        // getting a random number between 0-99
        int success = rand.nextInt(100) + 1;
        if(chance >= success){
            return true;
        }
        else{
            return false;
        }
    };

    // Default chance calculator

    public static final boolean decide(int chance){

        // chance equals the fraction between 1-2
        Random rand = new Random();

        // getting a random number between 0-99
        int success = rand.nextInt(100) + 1;
        if(chance >= success){
            return true;
        }
        else{
            return false;
        }
    };
}
