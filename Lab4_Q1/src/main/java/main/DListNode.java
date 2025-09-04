package main;

public class DListNode {

    public char data;
    public DListNode nextNode, previousNode;

    public DListNode(char data) {
        this(data, null, null);
    }

    public DListNode(char theElement, DListNode n, DListNode p) {
        data = theElement;
        nextNode = n;
        previousNode = p;
    }

}
