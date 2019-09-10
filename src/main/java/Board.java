public class Board {
    private int[][] board = null;

    Board() {
        board = new int[][]{{0, 3, 0, 3, 0, 3, 0, 3},//0 nothing, 1 white man, 2 white king, 3 black man, 4 black king
                {3, 0, 3, 0, 3, 0, 3, 0},
                {0, 3, 0, 3, 0, 3, 0, 3},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0},};
    }

    public int[][] getBoard() {
        return board;
    }
}
