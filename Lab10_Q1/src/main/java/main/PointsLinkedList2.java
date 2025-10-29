package main;

public class PointsLinkedList2 extends PointsLinkedList {
    // Write this method
    // Find if there is a point in a linked list with the same value as p,
    // but with different nextValue or different preValue

    public boolean pointValueExist(Point p) throws Exception {
        PointListIterator itr = new PointListIterator(this.header);

        while (true) {
            itr.next();

            Point point = itr.currentNode.data;

            if (itr.currentNode == this.header)
                break;

            if (point == null)
                continue;

            boolean sameValue = p.value == point.value;
            boolean samePrev = p.preValue == point.preValue;
            boolean sameNext = p.nextValue == point.nextValue;

            if (sameValue && (!samePrev || !sameNext))
                return true;
        }

        return false;
    }

}
