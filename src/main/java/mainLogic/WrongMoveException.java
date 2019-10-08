package mainLogic;

public class WrongMoveException extends Exception {
    public WrongMoveException() {
        super();
    }

    public WrongMoveException(String message) {
        super(message);
    }

    public WrongMoveException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongMoveException(Throwable cause) {
        super(cause);
    }
}
