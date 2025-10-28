package main;

import java.util.ArrayList;

public class BSTList {
    public BSTNodeList root;
    public int size;

    public BSTList() {
        root = null;
        size = 0;
    }

    public BSTList(BSTNodeList root, int size) {
        this.root = root;
        this.size = size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void makeEmpty() {
        root = null;
        size = 0;
    }

    public BSTNodeList find(Pairdata v) {
        int firstValue = v.first;

        BSTNodeList currentNode = root;

        while (currentNode != null) {
            int value = currentNode.dataList.get(0).first;

            if (firstValue == value) {
                if (currentNode.dataList.contains(v))
                    return currentNode;

                return null;
            } else if (firstValue > value) {
                currentNode = currentNode.right;
            } else if (firstValue < value) {
                currentNode = currentNode.left;
            }
        }

        return null;
    }

    public BSTNodeList insert(Pairdata v) {
        ArrayList<Pairdata> pdArray = new ArrayList<Pairdata>();
        pdArray.add(v);
        size++;
        if (root == null) {
            root = new BSTNodeList(pdArray, null, null, null);
            return root;
        }

        BSTNodeList parent = null;
        BSTNodeList currentNode = root;
        int pdValue = v.first;
        while (currentNode != null) {
            int firstValue = currentNode.dataList.get(0).first;

            if (pdValue == firstValue) {
                if (currentNode.dataList.contains(v)) {
                    size--;
                    return root;
                }

                currentNode.dataList.add(v);
                return root;
            } else if (pdValue > firstValue) {
                parent = currentNode;
                currentNode = currentNode.right;
            } else if (pdValue < firstValue) {
                parent = currentNode;
                currentNode = currentNode.left;
            }
        }

        int parentValue = parent.dataList.get(0).first;
        if (pdValue > parentValue) {
            parent.right = new BSTNodeList(pdArray, null, null, parent);
            return root;
        } else {
            parent.left = new BSTNodeList(pdArray, null, null, parent);
            return root;
        }
    }

}
