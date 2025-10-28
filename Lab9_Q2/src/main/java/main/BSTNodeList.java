package main;

import java.util.ArrayList;

public class BSTNodeList {
    public ArrayList<Pairdata> dataList; // value stored in the node.
    public BSTNodeList left; // pointer to lower left BSTNode.
    public BSTNodeList right; // pointer to lower right BSTNode.
    public BSTNodeList parent; // pointer to the BSTNode above.

    public BSTNodeList() {
        this(new ArrayList<Pairdata>(), null, null, null);
    }

    public BSTNodeList(ArrayList<Pairdata> data, BSTNodeList left, BSTNodeList right, BSTNodeList parent) {
        this.dataList = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

}
