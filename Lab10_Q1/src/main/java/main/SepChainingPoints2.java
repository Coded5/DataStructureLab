package main;

public class SepChainingPoints2 extends SepChainingPoints {
    // Implement this method.
    public boolean isCrossRoad(Point p) throws Exception {

        boolean exists = pointValueExist(p);

        add(p);
        return exists;
    }
}
