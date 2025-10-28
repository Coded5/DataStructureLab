package main;

public class TTree {
    public Node[][] theArray;
    public int level; // what is the max level of the Tree
    public Node winner; // The node that stores the champion.

    public TTree(int level) {
        this.level = level;
        theArray = new Node[level + 1][];

        for (int i = 0; i <= level; i++) { // create all arrays
            theArray[i] = new Node[(int) Math.pow(2, level - i)];
        }

        for (int i = 0; i <= level; i++) { // create all default nodes inside arrays
            for (int j = 0; j < theArray[i].length; j++) {
                theArray[i][j] = new Node();
            }
        }

        for (int i = 0; i < level; i++) { // linked all nodes into a tree
            for (int j = 0, k = 0; j < theArray[i].length;) {
                theArray[i][j].down = theArray[i + 1][k];
                theArray[i][j + 1].down = theArray[i + 1][k];
                theArray[i + 1][k].upLeft = theArray[i][j];
                theArray[i + 1][k].upRight = theArray[i][j + 1];
                j = j + 2;
                k++;
            }
        }

        winner = theArray[level][0];

    }

    public void predictResult() {
        for (int i = 1; i < level + 1; i++) {
            for (Node node : theArray[i]) {
                Node winner = (node.upLeft.ranking < node.upRight.ranking) ? node.upLeft : node.upRight;

                node.name = winner.name;
                node.ranking = winner.ranking;
            }
        }
    }

}
