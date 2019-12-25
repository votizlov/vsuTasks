package FileLogic;

import java.util.HashSet;
import java.util.Set;

public abstract class FileEmitter {
    private Set<FileListener> listeners = new HashSet<>();

    public void addMoveListener(FileListener listener) {
        listeners.add(listener);
    }

    public void removeMoveListener(FileListener listener) {
        listeners.remove(listener);
    }

    public void onFileLoaded(GameState g) {
        for (FileListener cl : listeners)
            cl.onFileLoaded(g);
    }
}
