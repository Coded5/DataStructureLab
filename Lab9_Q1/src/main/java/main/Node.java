package main;

import java.util.Objects;

public class Node {
    public String name;
    public int ranking;
    public Node upLeft, upRight, down;

    public Node() {
        this("Null", 0, null, null, null);
    }

    public Node(String name, int ranking, Node upLeft, Node upRight, Node down) {
        super();
        this.name = name;
        this.ranking = ranking;
        this.upLeft = upLeft;
        this.upRight = upRight;
        this.down = down;
    }

    @Override
    public int hashCode() {
        return Objects.hash(down, name, ranking, upLeft, upRight);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Node other = (Node) obj;
        return Objects.equals(name, other.name) && ranking == other.ranking;

    }

}
