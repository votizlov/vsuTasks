package FileLogic;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class JSONReader {
    ObjectMapper objectMapper = new ObjectMapper();

    public static GameState loadGame(String path) throws Exceptions.WrongFileException {
        GameState state = null;

        try {
            FileInputStream fis = new FileInputStream(path);
            JsonFactory jf = new JsonFactory();
            JsonParser jp = jf.createParser(fis);
            jp.setCodec(new ObjectMapper());
            jp.nextToken();
            if (!jp.hasCurrentToken())
                throw new Exceptions.WrongFileException("Поезда тут нет!");

            state = jp.readValueAs(GameState.class);
            jp.nextToken();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return state;
    }
}
