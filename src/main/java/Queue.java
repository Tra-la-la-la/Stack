import java.util.Arrays;

// Simulating the FIFO queue using generics and arrays
public class Queue<Q> {

    private Q[] queueArray; // my array as a Q named queueArray
    //    private int front; // the front of the Q
//    private int rear; // the rear of the Q
    private static final int DEFAULT_CAPACITY = 10;
    private int size;

    //    @SuppressWarnings("unchecked")
//    public Queue(int capacity) { // Checking the capacity of our Q
//        queueArray = (Q[]) new Object[capacity]; // where the queueArray is the array of Q as an object capacity of type int which is represented by the
//        front = 0; // front which starts from 0
//        rear = -1; // and the rear which ends in -1, so as from the front the Q can be incremented  (if the Q is -1 means is empty, and so we can check if is empty)
//    }
    @SuppressWarnings("unchecked")
    public Queue() {
        queueArray = (Q[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(Q element) { // adding a Q element
//        queueArray[++rear] = element; // in the queueArray by incrementation of the element
        ensureCapacity(size + 1); // Ensure capacity for new element
        queueArray[size++] = element;
    }

    public Q remove() { // remove Q element
        if (isEmpty()) { // with an exception if
            throw new IllegalStateException("Queue is empty"); // the queue is empty
        }
//        Q element = queueArray[front++]; // Sorting the Q element
//        if (front > rear) { // as long as the front is higher as the rear
//            front = 0; // where the front starts from 0
//            rear = -1; // and the rear is -1, as the last parameter
//        }
//        return element; // and returning the values if the element/s in the Q
//    }
//        if (isEmpty()) {
//            throw new IllegalStateException("Queue is empty");
//        }
        Q element = queueArray[0];
        System.arraycopy(queueArray, 1, queueArray, 0, size - 1);
        queueArray[--size] = null; // Clear the last element
        return element;
    }

    public Q get() { // get Q element
        if (isEmpty()) { // with an exception if
            throw new IllegalStateException("Queue is empty"); // the queue is empty
        }
        return queueArray[0];
//        return queueArray[front]; // return the Q from front
    }

    public void list() { // this list will return is value
//        for (int i = front; i <= rear; i++) { // starting from the front by incrementation of the elements until reach the rear
        for (int i = 0; i < size; i++) {
            System.out.println(queueArray[i]); // by iterating all the elements in the queueArray represented here by i
        }
    }

    public boolean isEmpty() { // check if the Q is empty
        return size == 0;
//        return rear < front; // if the rear is smaller by front (as the original values) than the Q is empty.
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > queueArray.length) {
            int newCapacity = Math.max(queueArray.length * 2, minCapacity);
            queueArray = Arrays.copyOf(queueArray, newCapacity);
        }
    }
}