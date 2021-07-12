package com.vmware.model;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * A model representing the Connect Four board.
 *
 * @author Srinath Tridandapani
 */
public class ConnectFourModel {
    private static final char[] players = new char[]{'X', 'O'};

    private int width;
    private int height;
    private char[][] grid;
    private int lastCol = -1;
    private int lastTop = -1;

    public ConnectFourModel(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new char[height][];
        for (int h = 0; h < height; h++) {
            Arrays.fill(this.grid[h] = new char[width], '.');
        }
    }

    public static char[] getPlayers() {
        return players;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public char[][] getGrid() {
        return grid;
    }

    public void setGrid(char[][] grid) {
        this.grid = grid;
    }

    public int getLastCol() {
        return lastCol;
    }

    public void setLastCol(int lastCol) {
        this.lastCol = lastCol;
    }

    public int getLastTop() {
        return lastTop;
    }

    public void setLastTop(int lastTop) {
        this.lastTop = lastTop;
    }

    public String toString() {
        return IntStream.range(0, this.width)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining()) + "\n" +
                Arrays.stream(this.grid)
                        .map(String::new)
                        .collect(Collectors.joining("\n"));
    }

}
