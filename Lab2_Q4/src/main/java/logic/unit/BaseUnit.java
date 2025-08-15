package logic.unit;

import java.util.ArrayList;

public class BaseUnit {

    private int row;
    private int column;
    private boolean isWhite;
    private String name;
    protected int hp;
    protected int power;
    protected boolean isFlying;

    public BaseUnit(int startColumn, int startRow, boolean isWhite, String name) {
        this.power = 1;
        this.isFlying = false;
        this.hp = 2;

        setColumn(startColumn);
        setRow(startRow);
        this.isWhite = isWhite;
        this.name = name;
    }

    public boolean move(int direction) {
        final int width = 5;
        final int height = 5;

        int newRow = row;
        int newCol = column;

        switch (direction) {
            case 0:
                newRow++;
                break;
            case 1:
                newCol++;
                break;
            case 2:
                newRow--;
                break;
            case 3:
                newCol--;
                break;
            default:
                return false;
        }

        boolean legal = (newCol >= 0 && newCol < width) && (newRow >= 0 && newRow < height);

        if (legal) {
            this.row = newRow;
            this.column = newCol;
        }

        return legal;
    }

    public void attack(ArrayList<BaseUnit> targetPieces) {
        for (BaseUnit unit : targetPieces) {
            boolean sameTile = unit.getColumn() == column && unit.getRow() == row;
            if (!unit.isFlying() && sameTile) {
                System.out.println(this.getName() + " attacks " + unit.getName());
                unit.hp -= this.power;
            }
        }
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = Math.clamp(row, 0, 4);
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = Math.clamp(column, 0, 4);
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setWhite(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public boolean isFlying() {
        return isFlying;
    }

}
