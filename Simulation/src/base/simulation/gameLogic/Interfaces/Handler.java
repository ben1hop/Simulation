package base.simulation.gameLogic.Interfaces;

import base.simulation.gameLogic.Tools.Pair;
import items.simulation.creatures.Blob;

public interface Handler {
    void handle(Pair<Blob> type);
}
