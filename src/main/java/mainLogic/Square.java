package mainLogic;

import figures.Figure;

import java.awt.*;
import java.util.LinkedList;

import static mainLogic.ConnectionDirections.UP;

public class Square {
    private Square upperLeft;
    private Square upperRight;
    private Square lowerLeft;
    private Square lowerRight;
    private int x;
    private Square upper;
    private Square lower;
    private Square right;
    private Square left;
    private Figure figure;
    private Square[] connections = new Square[8];

    public void addConnection(Square s, ConnectionDirections dir) {
        connections[getSquareIndexByDir(dir)] = s;
    }

    public Square getConnection(ConnectionDirections dir){
        return connections[getSquareIndexByDir(dir)];
    }

    private int getSquareIndexByDir(ConnectionDirections dir){
        switch (dir) {
            case UP:
                return 0;
            case UP_RIGHT:
                return 1;
            case RIGHT:
                return 2;
            case DOWN_RIGHT:
                return 3;
            case DOWN:
                return 4;
            case DOWN_LEFT:
                return 5;
            case LEFT:
                return 6;
            case UP_LEFT:
                return 7;
            default:
                return -1;
        }
    }

    public Square(int x, int y, Figure figure) {
        this.x = x;
        this.y = y;
        this.figure = figure;
    }

    private int y;

    public Square getUpper() {
        return upper;
    }

    public void setUpper(Square upper) {
        this.upper = upper;
    }

    public Square getLower() {
        return lower;
    }

    public void setLower(Square lower) {
        this.lower = lower;
    }

    public Square getRight() {
        return right;
    }

    public void setRight(Square right) {
        this.right = right;
    }

    public Square getLeft() {
        return left;
    }

    public void setLeft(Square left) {
        this.left = left;
    }

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

    public Color getColor() {
        if (figure == null) {
            return Color.GRAY;
        } else {
            return figure.getDrawable();
        }
    }
}
