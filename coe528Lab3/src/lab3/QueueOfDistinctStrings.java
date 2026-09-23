package lab3;

import java.util.ArrayList;

public class QueueOfDistinctStrings {

    // Overview: QueueOfDistinctStrings are mutable, bounded
    // collection of distinct strings that operate in
    // FIFO (First-In-First-Out) order.
    //
    // The abstraction function is:
    // AF(this) = a queue q of distinct strings where
    // q contains the elements of items in order,
    // with the front of the queue at items.get(0)
    // and the end of the queue at items.get(items.size() - 1).
    //
    // The rep invariant is:
    // 1. items != null
    // 2. items contains no null elements
    // 3. items contains no duplicate strings


    // the rep
    private ArrayList<String> items;

    // constructor
    public QueueOfDistinctStrings() {
        // EFFECTS: Creates a new QueueOfDistinctStrings object
        items = new ArrayList<String>();
    }

    // MODIFIES: this
    // EFFECTS: Appends the element at the end of the queue
    // if the element is not in the queue, otherwise
    // does nothing.
    public void enqueue(String element) throws Exception {
        if (element == null) throw new Exception();
        if (!items.contains(element)) {
            items.add(element);
        }
    }

    // MODIFIES: this
    // EFFECTS: Removes an element from the front of the queue
    public String dequeue() throws Exception {
        if (items.size() == 0) throw new Exception();
        return items.remove(0);
    }

    public boolean repOK() {

        // items must not be null
        if (items == null) return false;

        // no null elements allowed
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) == null) return false;
        }

        // no duplicate elements allowed
        for (int i = 0; i < items.size(); i++) {
            for (int j = i + 1; j < items.size(); j++) {
                if (items.get(i).equals(items.get(j))) {
                    return false;
                }
            }
        }

        return true;
    }

    public String toString() {

        String result = "Queue: " + items.toString();

        if (items.size() == 0) {
            result += "\nFront: null";
            result += "\nEnd: null";
        } else {
            result += "\nFront: " + items.get(0);
            result += "\nEnd: " + items.get(items.size() - 1);
        }

        return result;
    }
}
