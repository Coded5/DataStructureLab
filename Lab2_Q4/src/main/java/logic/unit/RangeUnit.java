package logic.unit;

import java.util.ArrayList;

public class RangeUnit extends BaseUnit {

    public RangeUnit(int startColumn, int startRow, boolean isWhite, String name) {
        super(startColumn, startRow, isWhite, name);
        this.hp = 2;
    }

    @Override
    public void attack(ArrayList<BaseUnit> targetPieces) {
        int attackingRow = isWhite() ? getRow() + 1 : getRow() - 1;

        for (BaseUnit unit : targetPieces) {
            // boolean isOpponent = unit.isWhite() != this.isWhite();
            boolean isOnAttackingSquare = (unit.getColumn() == this.getColumn()) && (unit.getRow() == attackingRow);
            if (isOnAttackingSquare) {
                System.out.println(this.getName() + " attacks " + unit.getName());
                unit.hp -= this.power;
            }
        }
    }

}
