package main;

import java.util.Objects;

public class Pairdata {
    public int first;
    public int second;

    public Pairdata(int first, int second) {
        super();
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pairdata other = (Pairdata) obj;
        return first == other.first && second == other.second;
    }

}
