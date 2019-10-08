package mainLogic;

import figures.Figure;

public class Square {
    private Square upperLeft;
    private Square upperRight;
    private Square lowerLeft;
    private Square lowerRight;
    private Figure figure;

    Square(Figure figure) {
        this.figure = figure;
    }

    Square() {
        this.figure = null;
    }

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
        if (figure == null) {
            return '-';
        } else {
            return figure.getSymbol();
        }
    }

    public void setUpperLeft(Square upperLeft) {
        this.upperLeft = upperLeft;
    }

    public void setUpperRight(Square upperRight) {
        this.upperRight = upperRight;
    }

    public void setLowerLeft(Square lowerLeft) {
        this.lowerLeft = lowerLeft;
    }

    public void setLowerRight(Square lowerRight) {
        this.lowerRight = lowerRight;
    }
}
