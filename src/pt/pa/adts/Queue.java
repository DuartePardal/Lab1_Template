package pt.pa.adts;

/**
 * TODO: Fornecer documentação da interface.
 *
 * @param <T> The queue element type
 */
public interface Queue<T> {
    /**
     * Enqueues a new element in the queue.
     * @param element The element to enqueue.
     * @throws FullQueueException when the is full.
     */
    void enqueue(T element) throws FullQueueException;

    /**
     * Dequeues the oldest element of the queue according to the enqueing order. The element is removed and returned.
     * @return the oldest element in the queue.
     * @throws EmptyQueueException when the queue is empty.
     */
    T dequeue() throws EmptyQueueException;

    /**
     * Returns the oldest element of the queue according to the enqueing order. The element is not removed.
     * @return the oldest element in the queue.
     * @throws EmptyQueueException when the queue is empty.
     */
    T front() throws EmptyQueueException;

    /**
     * Returns the number of elements in the queue.
     * @return The queue size.
     */
    int size();

    /**
     * Returns true if the queue is empty and false if is not.
     * @return if the queue is empty or not
     */
    boolean isEmpty();

    /**
     * Removes all the elements in the queue
     */
    void clear();
    //TODO: definir operações do ADT e documentá-las

}
