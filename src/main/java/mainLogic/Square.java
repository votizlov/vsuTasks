package mainLogic;

import figures.Figure;

import java.awt.*;
import java.util.LinkedList;

import static mainLogic.ConnectionDirections.UP;

public class Square {
    private int x;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private int y;
    private Figure figure;
    private Square[] connections = new Square[8];

    public void addConnection(Square s, ConnectionDirections dir) {
        connections[getSquareIndexByDir(dir)] = s;
    }

    public Square getConnection(ConnectionDirections dir) {
        return connections[getSquareIndexByDir(dir)];
    }

    private int getSquareIndexByDir(ConnectionDirections dir) {
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

    public Square(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Square(Figure figure) {
        this.figure = figure;
    }

    Square() {
        this.figure = null;
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

    public Color getColor() {
        if (figure == null) {
            return Color.GRAY;
        } else {
            return figure.getDrawable();
        }
    }

    public Square[] getConnections() {
        return  connections;
    }

    public void setUpperLeft(Square squareByCoord) {
    }

    public void setUpperRight(Square squareByCoord) {
    }

    public void setLowerLeft(Square squareByCoord) {
    }

    public void setLowerRight(Square squareByCoord) {
    }

    public Square getUpperRight() {
        return null;
    }

    public Square getUpperLeft() {
        return null;
    }

    public Square getLowerRight() {
        return null;
    }

    public Square getLowerLeft() {
        return null;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setConnections(Square[] connections) {
        this.connections = connections;
    }
}
