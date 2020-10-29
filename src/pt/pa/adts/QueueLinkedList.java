package pt.pa.adts;

/**
 * Doubly linked list implementation of the queue data structure.
 *
 * @param <T> The queue element type.
 */
public class QueueLinkedList<T> implements Queue<T> {

    private Node header, trailer;
    private int size;
    private int capacity;

    /**
     * Creates a new doubly linked list based queue.
     */
    public QueueLinkedList(int capacity) {
        //TODO: construtor deve inicializar uma fila vazia
        this.capacity=capacity;
        clear();

    }

    /**
     * Enqueues a new element in the queue.
     *
     * @param element The element to enqueue.
     * @throws FullQueueException when the is full.
     */
    public void enqueue(T element) throws FullQueueException {
        if(size() == capacity)
                throw new FullQueueException();
        Node newElement = new Node(element, header, header.next);
        header.next.prev= newElement;
        header.next= newElement;
        size++;
    }

    /**
     * Dequeues the oldest element of the queue according to the enqueing order. The element is removed and returned.
     *
     * @return the oldest element in the queue.
     * @throws EmptyQueueException when the queue is empty.
     */
    public T dequeue() throws EmptyQueueException {
       if(isEmpty())
           throw new EmptyQueueException();
        Node node= trailer.prev;
        trailer.prev=node.prev;
        node.prev.next=trailer;
        size--;
        return node.element;
    }

    /**
     * Returns the oldest element of the queue according to the enqueing order. The element is not removed.
     *
     * @return the oldest element in the queue.
     * @throws EmptyQueueException when the queue is empty.
     */
    public T front() throws EmptyQueueException {
        if(size()==0)
            throw new EmptyQueueException();

        return trailer.prev.element;
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return The queue size.
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if the queue is empty and false if is not.
     *
     * @return if the queue is empty or not
     */
    public boolean isEmpty() {

        return size()==0;
    }

    /**
     * Removes all the elements in the queue
     */
    public void clear() {
        header = new Node(null,null, null);
        trailer = new Node(null,header, null);
        header.next=trailer;
        size=0;

    }
//TODO: implementar métodos da interface à custa da estrutura de dados fornecida

    private class Node {
        private T element;
        private Node next;
        private Node prev;

        public Node(T element, Node prev, Node next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
