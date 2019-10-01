import java.util.LinkedList;

public class Man implements Figure {
    private int x;
    private int y;
    private boolean color;

    Man() {
    }

    Man(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public LinkedList<Move> getAvailableMoves(Figure[][] field) {
        LinkedList<Move> linkedList = new LinkedList<>();
        if (x-1>0&&y-1>0&&field[x][y]==null){
            linkedList.add(new Move(x,y,x-1,y-1));
        }
        if (x-1>0&&y+1<field[0].length&&field[x][y]==null){
            linkedList.add(new Move(x,y,x-1,y+1));
        }
        if (x+1<field.length&&y-1>0&&field[x][y]==null){
            linkedList.add(new Move(x,y,x+1,y-1));
        }
        if (x+1<field.length&&y+1<field[0].length&&field[x][y]==null){
            linkedList.add(new Move(x,y,x+1,y+1));
        }

        return linkedList;
    }

    @Override
    public boolean getColor() {
        return color;
    }
}
