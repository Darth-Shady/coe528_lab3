# COE528 — Lab 3: QueueOfDistinctStrings

A mutable, bounded FIFO queue of distinct (non-null, non-duplicate) strings, built as a data-abstraction exercise with an explicit abstraction function and rep invariant.

## Package

```
lab3
```

## Files

| File | Role |
|---|---|
| `QueueOfDistinctStrings.java` | The queue abstraction: `enqueue`, `dequeue`, `repOK`, `toString` |
| `TestQueue.java` | Manual driver that exercises enqueue, duplicate-enqueue, dequeue, and full-drain behavior, checking `repOK()` after each step |

## Abstraction Function & Rep Invariant

**Abstraction function:**
`AF(this) = a queue q of distinct strings where q contains the elements of items in order, with the front of the queue at items.get(0) and the end at items.get(items.size() - 1)`.

**Rep invariant:**
1. `items != null`
2. `items` contains no `null` elements
3. `items` contains no duplicate strings

## Class: `QueueOfDistinctStrings`

**Rep:** `private ArrayList<String> items`

**Constructor**
- `QueueOfDistinctStrings()` — creates an empty queue.

**Methods**
- `enqueue(String element)` — appends `element` to the end of the queue if it isn't already present (no-op on duplicates). Throws `Exception` if `element` is `null`.
- `dequeue()` — removes and returns the string at the front of the queue. Throws `Exception` if the queue is empty.
- `repOK()` — checks the rep invariant directly: `items` is non-null, contains no nulls, and contains no duplicates (checked pairwise, O(n²)). Returns `true`/`false`.
- `toString()` — prints the full queue, plus the front and end elements (`"null"` for both when the queue is empty).

## Testing

`TestQueue.java` is a `main`-method driver (not JUnit) that:
1. Enqueues four distinct strings (`"ab"`, `"cd"`, `"ae"`, `"bd"`) and prints the queue + `repOK()`.
2. Attempts to enqueue a duplicate (`"cd"`) and confirms the queue is unchanged.
3. Dequeues one element and prints the result.
4. Dequeues the remaining three elements to drain the queue, printing state and `repOK()` throughout.

Any thrown `Exception` (e.g. dequeuing an empty queue, enqueuing `null`) is caught in `main` and printed.

**Run with:**
```
javac lab3/*.java
java lab3.TestQueue
```

## Known Quirks

- `enqueue` and `dequeue` are declared to throw the generic `Exception` rather than a more specific unchecked exception (e.g. `IllegalArgumentException`, `NoSuchElementException`), so callers can't distinguish failure causes without inspecting the message (which is empty here, since `new Exception()` is thrown with no message).
- `repOK()`'s duplicate check is O(n²); fine at this queue's expected scale, but worth noting if it's ever reused for larger inputs.
