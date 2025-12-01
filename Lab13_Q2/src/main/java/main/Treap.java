package main;

public class Treap {

    public TreapNode root;
    public int size;

    private TreapNode lastNode;

    public Treap() {
        this.root = null;
        this.size = 0;
    }

    // public Treap(TreapNode root, int size) {
    // this.root = root;
    // this.size = size;
    // }

    private TreapNode insertBST(int v, int h) {
        TreapNode parent = null;
        TreapNode temp = root;

        // This first part is almost the same as find,
        // but it has an extra pointer called parent.
        while (temp != null && temp.bstValue != v) {
            if (v < temp.bstValue) {
                parent = temp;
                temp = temp.left;

            } else {
                parent = temp;
                temp = temp.right;
            }
        }

        if (temp == null) {
            TreapNode n = new TreapNode(v, h, null, null, parent);
            if (parent == null) {
                root = n;
            } else if (v < parent.bstValue) {
                parent.left = n;
            } else {
                parent.right = n;
            }
            size++;
            return n;
        }

        return null;
    }

    private TreapNode rotateLeftChild(TreapNode node) {
        TreapNode l = node.left;
        TreapNode lr = node.left.right;
        TreapNode parent = node.parent;

        node.left = lr;

        if (lr != null)
            lr.parent = node;

        l.right = node;
        l.parent = node.parent;
        node.parent = l;

        if (parent == null)
            root = l;
        else if (parent.left == node)
            parent.left = l;
        else
            parent.right = l;

        return l;
    }

    private TreapNode rotateRightChild(TreapNode node) {
        TreapNode r = node.right;
        TreapNode rl = node.right.left;
        TreapNode parent = node.parent;

        node.right = rl;

        if (rl != null)
            rl.parent = node;

        r.left = node;
        r.parent = node.parent;
        node.parent = r;

        if (parent == null)
            root = r;
        else if (parent.left == node)
            parent.left = r;
        else
            parent.right = r;
        return r;
    }

    public TreapNode insert(int v, int h) {
        TreapNode node = insertBST(v, h);

        if (node == null)
            return null;

        while (node.parent != null && node.heapValue < node.parent.heapValue) {
            TreapNode parent = node.parent;
            if (parent.left == node)
                node = rotateLeftChild(parent);
            else
                node = rotateRightChild(parent);
        }

        return node;
    }

}
