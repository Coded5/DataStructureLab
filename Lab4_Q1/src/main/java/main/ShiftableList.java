package main;

public class ShiftableList extends CDLinkedList {

    public ShiftableList() throws Exception {
        this("");
    }

    public ShiftableList(String s) throws Exception {
        // initialize the list
        // each data comes from each character in s
        int n = s.length();
        DListIterator d = new DListIterator(header);
        for (int i = n - 1; i >= 0; i--) {
            insert(s.charAt(i), d);
        }

    }

    // change the nth data (counting from header) to be a new first
    // data of the list
    public void shift(int n) throws Exception {
        if (n < 0 || n > size)
            throw new Exception();

        DListNode node = header;

        for (int i = 0; i < n; i++) {
            if (node.nextNode == header)
                throw new Exception();

            node = node.nextNode;
        }
        shift(node);
    }

    // shift the list such that the data at position newStart becomes the first data
    // for list a,b,c,d,e,f
    // if newStart is pointing at c,
    // the new list will be c,d,e,f,a,b
    public void shift(DListNode newStart) {
        DListNode first = header.nextNode;
        DListNode last = header.previousNode;

        DListNode newLast = newStart.previousNode;

        header.nextNode = newStart;
        newStart.previousNode = header;

        header.previousNode = newLast;
        newLast.nextNode = header;

        first.previousNode = last;
        last.nextNode = first;
    }

}
