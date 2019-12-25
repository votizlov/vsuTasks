package FileLogic;


import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.IOException;

public class JSONReader extends FileEmitter implements Runnable {
    ObjectMapper objectMapper = new ObjectMapper();
    private GameState gameState;

    public void setPath(String path) {
        this.path = path;
    }

    private String path;

    private GameState loadGame(String path) throws Exceptions.WrongFileException {
        GameState state = null;

        try {
            FileInputStream fis = new FileInputStream(path);
            JsonFactory jf = new JsonFactory();
            JsonParser jp = jf.createParser(fis);
            jp.setCodec(new ObjectMapper());
            jp.nextToken();
            if (!jp.hasCurrentToken())
                throw new Exceptions.WrongFileException("Неверный файл сохранения!");
            state = jp.readValueAs(GameState.class);
            this.gameState = state;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return state;
    }

    @Override
    public void run() {
        try {
            loadGame(path);
            onFileLoaded(gameState);
        } catch (Exceptions.WrongFileException e) {
            e.printStackTrace();
        }
    }
}
