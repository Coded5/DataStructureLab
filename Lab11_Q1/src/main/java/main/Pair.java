package main;

public class Pair {
    public int value;
    public int freq;

    public Pair(int v, int f) {
        value = v;
        freq = f;
    }

    // Additional method(s) can be written below.
    public boolean isMoreThan(Pair other) {
        if (this.freq > other.freq)
            return true;
        else if (this.freq == other.freq) {
            return this.value < other.value;
        }

        return false;
    }
}
