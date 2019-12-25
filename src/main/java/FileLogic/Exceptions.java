package FileLogic;

public class Exceptions {
    public static class WrongFileException extends Exception {
        public WrongFileException(String message) {
            super(message);
        }
    }
}
