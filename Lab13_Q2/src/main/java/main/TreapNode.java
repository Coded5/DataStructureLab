package main;

public class TreapNode {
    public int bstValue; // value stored in the node.
    public int heapValue; // priority value as in a min heap
    public TreapNode left; // pointer to lower left node.
    public TreapNode right; // pointer to lower right node.
    public TreapNode parent; // pointer to the node above.

    public TreapNode(int data, int heapValue) {
        this(data, heapValue, null, null, null);
    }

    public TreapNode(int data, int hv, TreapNode left, TreapNode right, TreapNode parent) {
        bstValue = data;
        heapValue = hv;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public static void main(String[] args) {
        TreapNode b = new TreapNode(9, 50);
    }
}
