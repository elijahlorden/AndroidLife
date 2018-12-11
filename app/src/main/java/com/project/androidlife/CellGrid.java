package com.project.androidlife;

import android.graphics.Canvas;

public class CellGrid {

    private boolean[][] grid;
    private int xSize, ySize;

    public CellGrid(int xSize, int ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.grid = new boolean[xSize][ySize];
    }

    public void setCell(boolean[][] grid, int x, int y, boolean state) {
        if (x > xSize-1 || x < 0) return;
        if (y > ySize-1 || y < 0) return;
        grid[x][y] = state;
    }

    public boolean getCell(boolean[][] grid, int x, int y) {
        if (x > xSize-1 || x < 0) return false;
        if (y > ySize-1 || y < 0) return false;
        return grid[x][y];
    }

    public void tick() {
        boolean[][] newGrid = new boolean[xSize][ySize];
        for (int x = 0; x < xSize-1; x++) {
            for (int y = 0; y < ySize-1; y++) {
                int neighbors = getLiveNeighbors(grid, x, y);
                if (grid[x][y]) {
                    if (neighbors == 2 || neighbors == 3) newGrid[x][y] = true;
                } else {
                    if (neighbors == 3) newGrid[x][y] = true;
                }
            }
        }
        grid = newGrid;
    }

    public boolean[][] getGrid() {
        return this.grid;
    }

    public void setGrid(boolean[][] grid) {
        this.xSize = grid.length;
        this.ySize = grid[0].length;
        this.grid = grid;
    }

    public int getxSize() {
        return this.xSize;
    }

    public int getySize() {
        return this.ySize;
    }

    private int getLiveNeighbors(boolean[][] grid, int cX, int cY) {
        int count = 0;
        for (int x=cX-1; x<=cX+1; x++) {
            for (int y=cY-1; y<=cY+1; y++) {
                if (!(x == cX && y == cY) && getCell(grid, x, y)) count++;
            }
        }
        return count;
    }








}
