import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        GameSession currentSession = new GameSession(0);
        while (currentSession.getWinFlag() == 0) {
            if (scanner.hasNextInt()) {
                int x1 = scanner.nextInt();
                int y1 = scanner.nextInt();
                int x2 = scanner.nextInt();
                int y2 = scanner.nextInt();
                currentSession.makeMove(new Move(x1, y1, x2, y2));
            } else {
                currentSession.makeMove();
            }
        }
        if (currentSession.getWinFlag() == 1) {
            System.out.println("White wins");
        } else {
            System.out.println("Black wins");
        }
    }

    public void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
