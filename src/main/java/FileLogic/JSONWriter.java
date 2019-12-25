package FileLogic;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JSONWriter implements Runnable {
    ObjectMapper mapper = new ObjectMapper();
    private String path;
    private GameState gameState;

    public void saveGame(String path, GameState state) throws Exceptions.WrongFileException {
        try {
            mapper.writeValue(new File(path), state);
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exceptions.WrongFileException("Неправильный путь");
        }
    }

    @Override
    public void run() {
        try {
            saveGame(path, gameState);
        } catch (Exceptions.WrongFileException e) {
            e.printStackTrace();
        }
    }
}
