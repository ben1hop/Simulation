package items.simulation.creatures.Base;

public interface BaseActions {

    // A blob needs these types of functions to function

    boolean reproduce();
    boolean survive();
    boolean gainEnergy();
    void move(int fieldSize);
    void setBack();
    void die();
}
