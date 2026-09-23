package lab3;

public class TestQueue {

    public static void main(String[] args) {

        try {
            QueueOfDistinctStrings q = new QueueOfDistinctStrings();

            // Test enqueue
            q.enqueue("ab");
            q.enqueue("cd");
            q.enqueue("ae");
            q.enqueue("bd");

            System.out.println("After enqueues:");
            System.out.println(q);
            System.out.println("repOK: " + q.repOK());
            System.out.println();

            // Test duplicate (should do nothing)
            q.enqueue("cd");
            System.out.println("After attempting duplicate enqueue:");
            System.out.println(q);
            System.out.println("repOK: " + q.repOK());
            System.out.println();

            // Test dequeue
            String removed = q.dequeue();
            System.out.println("Dequeued element: " + removed);
            System.out.println("After dequeue:");
            System.out.println(q);
            System.out.println("repOK: " + q.repOK());
            System.out.println();

            // Remove everything
            q.dequeue();
            q.dequeue();
            q.dequeue();

            System.out.println("After removing all elements:");
            System.out.println(q);
            System.out.println("repOK: " + q.repOK());

        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }
}
