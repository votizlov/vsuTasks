package interfaceControllers;

import javafx.scene.Scene;
import javafx.stage.Stage;
import mainLogic.Move;
import mainLogic.Square;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;

public class CheckersInterface extends MoveEmitter {
    private static JPanel myPanel;
    private static JFrame frame;
    private final HashSet<Square> board;
    private JButton[][] jButtons;
    private Square firstSquare;
    private Move move;
    private int x, y;

    public CheckersInterface(HashSet<Square> board, int x, int y) {
        this.board = board;
        this.x = x;
        this.y = y;
    }

    @Override
    public void drawBoard() {
        if (frame == null) {
            myPanel = new JPanel();
            frame = new JFrame();
            myPanel.setSize(800, 600);
            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(myPanel);
            frame.setVisible(true);
            frame.setTitle("Checkers");
            myPanel.setVisible(true);
            myPanel.setLayout(new GridLayout(x, y));
            jButtons = new JButton[y][x];
            CheckerActionListener actionListener = new CheckerActionListener();
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    jButtons[i][j] = new JButton();
                    jButtons[i][j].addActionListener(actionListener);
                    myPanel.add(jButtons[i][j]);
                    jButtons[i][j].setBackground(getSquareByCoord(i, j).getColor());
                }
            }
            JPanel myPanel1 = new JPanel();
            JFrame frame1 = new JFrame();
            myPanel1.setSize(200, 400);
            frame1.setSize(200, 400);
            frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame1.setContentPane(myPanel1);
            frame1.setVisible(true);
            frame1.setTitle("Options");
            myPanel1.setVisible(true);
            myPanel1.setLayout(new GridLayout(1, 2));
            JButton b1 = new JButton();
            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFileChooser fileChooser = new JFileChooser();
                    JFrame d = new JFrame();
                    if (fileChooser.showOpenDialog(d) ==JFileChooser.APPROVE_OPTION){
                        File file = fileChooser.getSelectedFile();
                        onLoad(file.getAbsolutePath());
                    }
                }
            });
            b1.setText("Load");
            myPanel1.add(b1);
            b1 = new JButton();
                    b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFileChooser fileChooser = new JFileChooser();
                    JFrame d = new JFrame();
                    if (fileChooser.showSaveDialog(d) == JFileChooser.APPROVE_OPTION) {
                        File file = fileChooser.getSelectedFile();
                        onSave(file.getAbsolutePath());
                    }
                }
            });
            b1.setText("Save");
            myPanel1.add(b1);
        } else {
            updateBoard();
        }
    }

    public void updateBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                jButtons[i][j].setBackground(getSquareByCoord(i, j).getColor());
            }
        }
    }

    public Move parseMove() throws InterruptedException {
        return move;
    }

    class CheckerActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            for (int i1 = 0; i1 < jButtons.length; i1++) {
                for (int j1 = 0; j1 < jButtons[0].length; j1++) {
                    if (jButtons[i1][j1] == actionEvent.getSource())
                        if (firstSquare == null) {
                            firstSquare = getSquareByCoord(i1, j1);
                        } else {
                            move = new Move(firstSquare, getSquareByCoord(i1, j1));
                            onMove(move);
                            firstSquare = null;
                        }
                }
            }
        }
    }

    private Square getSquareByCoord(int i, int j) {
        Iterator<Square> it = board.iterator();
        Square t;
        while (it.hasNext()) {
            t = it.next();
            if (t.getX() == i && t.getY() == j)
                return t;
        }
        return null;
    }
}
