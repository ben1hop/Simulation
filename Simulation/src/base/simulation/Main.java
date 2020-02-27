package base.simulation;


import base.simulation.gameLogic.Application;

public class Main {

    public static void main(String[] args) {
        // instance of the simulation
        Application simulation = new Application(100,3,2,40,60, 30);
        simulation.run(10);
    }
}
