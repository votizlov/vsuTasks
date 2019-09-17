public class Move {
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private Checker checker1;
    private Checker checker2;

 //   Move(int x1, int y1, int x2, int y2) {
 //      this.x1 = x1;
 //       this.x2 = x2;
 //       this.y1 = y1;
 //      this.y2 = y2;
 //   }

    Move(Checker checker1,Checker checker2){
        this.checker1 = checker1;
        this.checker2 = checker2;
    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }


    public Checker getChecker1() {
        return checker1;
    }

    public Checker getChecker2() {
        return checker2;
    }
}
