package main;

public class PointListNode {
    public Point data;
    public PointListNode nextNode, previousNode;

    public PointListNode(Point data) {
        this(data, null, null);
    }

    public PointListNode(Point theElement, PointListNode n, PointListNode p) {
        data = theElement;
        nextNode = n;
        previousNode = p;
    }

}
