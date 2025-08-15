package logic.unit;

public class FlyingUnit extends BaseUnit {

    public FlyingUnit(int startColumn, int startRow, boolean isWhite, String name) {
        super(startColumn, startRow, isWhite, name);
        this.hp = 2;
        this.isFlying = true;
    }

    @Override
    public boolean move(int direction) {
        final int width = 5;
        final int height = 5;

        int newRow = getRow();
        int newCol = getColumn();

        switch (direction) {
            case 0:
                newRow += 2;
                break;
            case 1:
                newCol += 2;
                break;
            case 2:
                newRow -= 2;
                break;
            case 3:
                newCol -= 2;
                break;
            default:
                return false;
        }

        boolean legal = (newCol >= 0 && newCol < width) && (newRow >= 0 && newRow < height);

        if (legal) {
            setRow(newRow);
            setColumn(newCol);
        }

        return legal;
    }

}
