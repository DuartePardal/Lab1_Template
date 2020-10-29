package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.pa.adts.EmptyQueueException;
import pt.pa.adts.FullQueueException;
import pt.pa.adts.Queue;
import pt.pa.adts.QueueLinkedList;

import static org.junit.jupiter.api.Assertions.*;

class QueueLinkedListTest {
    private Queue<String> queue;

    @BeforeEach
    public void setup() {
        queue = new QueueLinkedList<>(10);
    }

    @Test
    void enqueue() throws FullQueueException, EmptyQueueException {
        queue = new QueueLinkedList<>(10);
        queue.enqueue("PA");
        assertEquals("PA", queue.front());
        assertEquals(1, queue.size());
    }

    @Test
    void dequeueWhenEmpty(){
        assertThrows(EmptyQueueException.class, () -> queue.dequeue());
    }

    @Test
    void enqueueOverCapacity() throws FullQueueException {
        for (int i = 0; i < 10; i++) {
            queue.enqueue("Element"+1);

        }
        assertThrows(FullQueueException.class, () -> queue.enqueue("reject"));
}
    @Test
    void dequeueOneElement()throws FullQueueException, EmptyQueueException{
        queue= new QueueLinkedList<>(10);
        queue.enqueue("PA");
        assertEquals("PA", queue.dequeue());


    }
    @Test
    void dequeueTwoElement()throws FullQueueException, EmptyQueueException {
        queue.enqueue("PA");
        queue.enqueue("IPS");
        assertEquals("PA", queue.dequeue());
        assertEquals("IPS", queue.dequeue());
        assertThrows(EmptyQueueException.class,() -> queue.dequeue());
    }
    @Test
    void front() throws FullQueueException, EmptyQueueException {
        assertThrows(EmptyQueueException.class, () -> queue.front());
        queue.enqueue("PA");
        assertEquals("PA", queue.front());
        queue.enqueue("IPS");
        assertEquals("PA", queue.front());
    }

    @Test
    void size() throws EmptyQueueException, FullQueueException {
        assertEquals(0, queue.size());
        queue.enqueue("PA");
        assertEquals(1, queue.size());
        queue.enqueue("IPS");
        assertEquals(2, queue.size());
        queue.dequeue();
        assertEquals(1, queue.size());
        queue.dequeue();
        assertEquals(0, queue.size());
    }

    @Test
    void isEmpty() throws FullQueueException {
        assertTrue(queue.isEmpty());
        queue.enqueue("PA");
        assertFalse(queue.isEmpty());
    }

    @Test
    void clear() throws FullQueueException {
        queue.enqueue("PA");
        queue.enqueue("IPS");
        queue.clear();
        assertEquals(0,queue.size());
        assertTrue(queue.isEmpty());
    }
}