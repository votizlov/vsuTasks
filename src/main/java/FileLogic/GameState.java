package FileLogic;

import mainLogic.Player;
import mainLogic.SessionType;
import mainLogic.Square;

import java.util.HashSet;
import java.util.LinkedList;

public class GameState {
    private LinkedList<Player> whomMove;
    private HashSet<Square> squares;
    private SessionType sessionType;

    public GameState(HashSet<Square> squares, LinkedList<Player> whomMove, SessionType sessionType) {
        this.squares = squares;
        this.whomMove = whomMove;
        this.sessionType = sessionType;
    }

    public HashSet<Square> getSquares() {
        return squares;
    }

    public void setSquares(HashSet<Square> squares) {
        this.squares = squares;
    }

    public LinkedList<Player> getWhomMove() {
        return whomMove;
    }

    public void setWhomMove(LinkedList<Player> whomMove) {
        this.whomMove = whomMove;
    }

    public SessionType getSessionType() {
        return sessionType;
    }

    public void setSessionType(SessionType sessionType) {
        this.sessionType = sessionType;
    }
}
