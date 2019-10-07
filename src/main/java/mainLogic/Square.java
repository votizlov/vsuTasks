package mainLogic;

import figures.Figure;

public class Square {
    private Square upperLeft;
    private Square upperRight;
    private Square lowerLeft;
    private Square lowerRight;
    private Figure figure;

    Square(Figure figure){
        this.figure = figure;
    }
    Square(){}

    public Square getUpperLeft() {
        return upperLeft;
    }

    public Square getUpperRight() {
        return upperRight;
    }

    public Square getLowerLeft() {
        return lowerLeft;
    }

    public Square getLowerRight() {
        return lowerRight;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    public char getSymbol() {
        if(figure==null){
            return 0;
        } else {
            return figure.getSymbol();
        }
    }
}
