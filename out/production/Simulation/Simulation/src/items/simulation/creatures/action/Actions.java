package items.simulation.creatures.action;

import base.simulation.gameLogic.Tools.MathRound;
import items.simulation.creatures.Base.Attribs;
import items.simulation.creatures.Base.BaseActions;

import java.util.Random;

public class Actions extends Attribs implements BaseActions {

    // Decide reproducing

    @Override
    public boolean reproduce() {
        if(getStash() >= 2){
            return true;
        }
        // If he has food between 1-2 , that fractal between them becomes the survival chance
        else if(getStash() > 1){
            return MathRound.decideReproduce(getStash());
        }
        return false;
    }

    // Decide survival

    @Override
    public boolean survive() {
        if(getStash() >= 1){

            return true;
        }
        // If he has food between 0-1 , that number becomes his survival chance
        else if(getStash() > 0){

            return MathRound.decideSurvive(getStash());
        }
        else{

            return false;
        }
    }

    // ezt meg felulkene irni
    @Override
    public boolean gainEnergy() {
        return MathRound.decide(0);
    }

    // Moving

    @Override
    public void move(int fieldSize) {
        Random rand = new Random();
        setPlace(rand.nextInt(fieldSize));
    }

    // SetBack to default

    @Override
    public void setBack() {
        setPlace(-1);
    }

    //

    @Override
    public void die() {
        return;
    }
}
