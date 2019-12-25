package FileLogic;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JSONWriter {
    ObjectMapper mapper = new ObjectMapper();

    public void saveGame(String path, GameState state) throws Exceptions.WrongFileException {

        try {
            mapper.writeValue(new File(path), state);
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exceptions.WrongFileException("Неправильный путь");
        }
    }

}
