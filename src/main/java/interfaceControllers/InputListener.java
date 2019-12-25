package interfaceControllers;

import mainLogic.Move;

public interface InputListener {
    void move(Move m);
    void save(String path);
    void load(String path);
}
