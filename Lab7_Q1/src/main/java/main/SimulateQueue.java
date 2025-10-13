package main;

public class SimulateQueue {

    public CustomerInfo[][] allEvents; // events in each and every queue

    public MyQueue[] allQueues; // queues of people, corresponding to the events

    public SimulateQueue(CustomerInfo[][] allEvents, MyQueue[] allQueues) {
        super();
        this.allEvents = allEvents;
        this.allQueues = allQueues;
    }

    public void stateBeforeTimeT(int t) throws Exception {
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < allQueues.length; j++) {
                for (int k = 0; k < allEvents[j].length; k++) {
                    if (allEvents[j][k].time == i) {

                        if (allEvents[j][k].event == 1)
                            allQueues[j].insertLast(1);
                        else if (allEvents[j][k].event == -1)
                            allQueues[j].removeFirst();
                        else
                            throw new Exception("Invalid event");
                    }
                }
            }
        }
    }

}
