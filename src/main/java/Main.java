import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        GameSession currentSession = new GameSession(SessionType.PVE);

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
