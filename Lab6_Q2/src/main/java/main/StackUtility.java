package main;

public class StackUtility {

    public static MyStack removeRange(MyStack s, int i, int j) throws Exception {
        MyStack temp = new StackLinkedList();

        for (int ii = 0; ii < i; ii++) {
            temp.push(s.top());
            s.pop();
        }

        int removeSize = j - i + 1;
        for (int jj = 0; jj < removeSize; jj++) {
            s.pop();
        }

        while (!temp.isEmpty()) {
            s.push(temp.top());
            temp.pop();
        }

        return s;
    }

}
