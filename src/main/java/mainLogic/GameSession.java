package mainLogic;

import FileLogic.*;
import interfaceControllers.CheckersInterface;
import interfaceControllers.ConsoleInterface;
import interfaceControllers.InputListener;
import interfaceControllers.MoveEmitter;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;

public class GameSession implements InputListener, FileListener {
    private SessionType sessionType;
    private Board mainBoard;
    private LinkedList<Player> whomMove = new LinkedList<Player>();
    private boolean isInterfaceEnabled = true;
    private MoveEmitter controllerInterface;
    private Bot bot;

    public GameSession(SessionType sessionType) {
        this.sessionType = sessionType;
        mainBoard = new Board(8, 8);
        switch (sessionType){
            case EVE:Bot bot = new Bot();
            break;
            case PVE:;
            break;
            case PVP:;
            break;
            case ONLINE_PVP:;
            break;
        }
        whomMove.add(new Player(Colors.WHITE_TEAM,playerType.HUMAN));
        whomMove.add(new Player(Colors.BLACK_TEAM,playerType.HUMAN));

        MoveEmitter checkersInterface = new CheckersInterface(mainBoard.getField(),mainBoard.getX(),mainBoard.getY());
        checkersInterface.addMoveListener(this);
        checkersInterface.drawBoard();
        controllerInterface = checkersInterface;
    }

    private GameSession(GameState state){
        this.sessionType = state.getSessionType();
        mainBoard = new Board(8, 8);
        switch (sessionType){
            case EVE:Bot bot = new Bot();
                break;
            case PVE:;
                break;
            case PVP:;
                break;
            case ONLINE_PVP:;
                break;
        }
        whomMove = state.getWhomMove();
        mainBoard.setField(state.getSquares());
        MoveEmitter checkersInterface = new CheckersInterface(mainBoard.getField(),mainBoard.getX(),mainBoard.getY());
        checkersInterface.addMoveListener(this);
        checkersInterface.drawBoard();
        controllerInterface = checkersInterface;
    }

    @Override
    public void move(Move move){
        System.out.println("j");
        if (whomMove.peek().getType()==playerType.BOT){
            mainBoard.makeAIMove(bot.move(mainBoard,whomMove.peek()));
            whomMove.addLast(whomMove.poll());
        } else {
            try {
                mainBoard.makeHumanMove(move);
                controllerInterface.drawBoard();
                whomMove.addLast(whomMove.poll());
            } catch (WrongMoveException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void save(String path) {
        if(path!=null){
            try {
                new JSONWriter().saveGame(path,new GameState(mainBoard.getField(),whomMove,sessionType));
            } catch (Exceptions.WrongFileException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void load(String path) {
        if(path!=null){
            JSONReader reader = new JSONReader();
            reader.setPath(path);
            reader.run();
        }
    }

    @Override
    public void onFileLoaded(GameState gameState) {
        new GameSession(gameState);
    }
}
