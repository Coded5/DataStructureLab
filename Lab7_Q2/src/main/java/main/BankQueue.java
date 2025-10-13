package main;

public class BankQueue { // must work for any implementation of DeQ
    public DeQ[] counters;
    public DeQ special;

    public BankQueue(DeQ[] counters, DeQ special) {
        super();
        this.counters = counters;
        this.special = special;
    }

    // Write this method
    public void distribute() throws Exception {
        int count = 0;
        for (DeQ counter : counters)
            count += counter.size();

        float rawQueueLength = ((float) count) / (counters.length + 1);
        int queueLength = Math.round(rawQueueLength);

        for (int i = 0; i < counters.length; i++) {
            if (counters[i].size() == queueLength)
                continue;

            int remainder = counters[i].size() - queueLength;

            if (remainder <= 0)
                continue;

            if (special.size() == queueLength)
                break;

            DeQLinkedList temp = new DeQLinkedList();
            for (int j = 0; j < remainder; j++) {
                temp.insertFirst(counters[i].removeLast());
            }

            for (int j = 0; j < remainder; j++) {
                special.insertLast(temp.removeFirst());

                if (special.size() == queueLength)
                    break;
            }

            while (!temp.isEmpty())
                counters[i].insertLast(temp.removeFirst());

        }

        if (special.isEmpty())
            special.insertLast(counters[counters.length - 1].removeLast());
    }

}
