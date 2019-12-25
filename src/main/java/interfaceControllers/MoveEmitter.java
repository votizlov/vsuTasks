package interfaceControllers;

import mainLogic.Move;

import java.util.HashSet;
import java.util.Set;

public abstract class MoveEmitter {
    private Set<InputListener> listeners = new HashSet<>();


    public void addMoveListener(InputListener listener) {
        listeners.add(listener);
    }


    public void removeMoveListener(InputListener listener) {
        listeners.remove(listener);
    }

    public abstract void drawBoard();

    public void onMove(Move m) {
        for (InputListener cl : listeners)
            cl.move(m);
    }

    public void onSave(String path){
        for (InputListener cl : listeners)
            cl.save(path);
    }

    public void onLoad(String path){
        for (InputListener cl : listeners)
            cl.load(path);
    }
}
