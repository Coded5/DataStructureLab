package main;

public class StackArray implements MyStack {
    private int[] theArray;
    private int currentSize;
    private static final int DEFAULT_SIZE = 10;

    public StackArray() { // create an empty stack
        this(DEFAULT_SIZE);
    }

    public StackArray(int intendedCapacity) {
        theArray = new int[intendedCapacity];
        currentSize = 0;
    }

    public StackArray(int[] theArray, int currentSize) {
        super();
        this.theArray = theArray;
        this.currentSize = currentSize;
    }

    public int[] getTheArray() {
        return theArray;
    }

    public void setTheArray(int[] theArray) {
        this.theArray = theArray;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == theArray.length;
    }

    public void makeEmpty() {
        theArray = new int[DEFAULT_SIZE];
        currentSize = 0;
    }

    public int top() throws MyStackException {
        if (isEmpty())
            throw new MyStackException();
        return theArray[currentSize - 1];
    }

    public void pop() throws MyStackException {
        if (isEmpty())
            throw new MyStackException();
        currentSize--;
    }

    public void doubleCapacity() { // resize array to twice the original size
        int[] temp = new int[theArray.length * 2];
        System.arraycopy(theArray, 0, temp, 0, theArray.length);
        theArray = temp;
    }

    public void push(int data) throws Exception {
        if (isFull())
            doubleCapacity();
        theArray[currentSize] = data;
        currentSize++;
    }

    public void removeRange(int i, int j) {
        int removeSize = j - i + 1;
        int newSize = this.currentSize - removeSize;

        int rmStart = this.currentSize - j - 1;

        for (int pos = rmStart; pos < newSize; pos++) {
            int copy_pos = pos + removeSize;

            if (copy_pos >= this.currentSize)
                break;

            this.theArray[pos] = this.theArray[copy_pos];
        }

        this.currentSize = newSize;
    }

}
