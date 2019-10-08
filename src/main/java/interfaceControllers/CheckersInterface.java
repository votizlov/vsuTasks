package interfaceControllers;
import mainLogic.Move;
import mainLogic.Square;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckersInterface implements ControllerInterface {
    private static JPanel myPanel;
    private static JFrame frame;
    private final Square[][] board;
    private JButton[][] jButtons;

    public CheckersInterface(Square[][] board) {
        this.board = board;
    }

    @Override
    public void drawBoard(boolean side) {
        myPanel = new JPanel();
        frame = new JFrame();

        myPanel.setSize(800, 600);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(myPanel);
        frame.setVisible(true);
        frame.setTitle("Checkers");
        myPanel.setVisible(true);
        myPanel.setLayout(new GridLayout(board.length, board[0].length));
        jButtons = new JButton[board.length][board[0].length];
        CheckerActionListener actionListener = new CheckerActionListener();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                jButtons[i][j] = new JButton(i+" "+j);
                jButtons[i][j].addActionListener(actionListener);
                myPanel.add(jButtons[i][j]);
                jButtons[i][j].setBackground(board[i][j].getColor());
            }
        }
    }

    private void buttonPressed(JButton source) {
    }

    @Override
    public void updateBoard(boolean side) {

    }

    @Override
    public Move parseMove() {
        return null;
    }
    class CheckerActionListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            for(int i1 = 0; i1<jButtons.length;i1++){
                for (int j1 = 0; j1<jButtons[0].length;j1++){
                    if(jButtons[i1][j1]==actionEvent.getSource());
                }
            }
        }
    }
}
