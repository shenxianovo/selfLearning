/* Deque: pronunce deck */

public class LinkedListDeque<T> {

    private class Node {
        private T item;
        private Node next;
        private Node prev;

        public Node() {
            item = null;
            prev = null;
            next = null;
        }

        public Node(T i) {
            item = i;
            prev = null;
            next = null;
        }
    }

    private Node sentinal;
    private int size;

    public LinkedListDeque() {
        sentinal = new Node();
        size = 0;
    }

    public LinkedListDeque(T item) {
        sentinal = new Node();
        Node newNode = new Node(item);
        size = 1;
        sentinal.next = newNode;
        sentinal.prev = newNode;
        newNode.next = sentinal;
        newNode.prev = sentinal;
    }

    /* Adds an item T to the front of the deque */
    public void addFirst(T item) {
        Node newNode = new Node(item);
        size += 1;

        if (sentinal.next == null) {
            sentinal.next = newNode;
            sentinal.prev = newNode;
            newNode.prev = sentinal;
            newNode.next = sentinal;
        } else {   
            newNode.next = sentinal.next;
            sentinal.next.prev = newNode;
            sentinal.next = newNode;
            newNode.prev = sentinal;
        }
    }

    /* Adds an item T to the back of the deque */
    public void addLast(T item) {
        Node newNode = new Node(item);
        size += 1;
        sentinal.prev.next = newNode;
        newNode.prev = sentinal.prev;
        newNode.next = sentinal;
        sentinal.prev = newNode;
    }

    /* Returns true if the deque is empty, false otherwise */
    public boolean isEmpty() {
        return (size == 0);
    }

    /* Return the number of items in the deque */
    public int size() {
        return size;
    }

    /* Prints the items in the deque from first to last, seperated by a space */
    public void printDeque() {
        Node p = sentinal.next;
        while (p.item != null) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

    /*
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null
     */
    public T removeFirst() {
        size -= 1;
        Node save = sentinal.next;

        sentinal.next = save.next;
        save.next.prev = sentinal;
        save.prev = null;
        save.next = null;

        return save.item;
    }

    /*
     * Removes and returns the item at the back of the deque
     * if no such item exists, return null
     */
    public T removeLast() {
        size -= 1;
        Node save = sentinal.prev;

        save.prev.next = sentinal;
        sentinal.prev = save.prev;
        save.prev = null;
        save.next = null;

        return save.item;
    }

    /*
     * Gets the items at the given index, where 0 is the front, 1, 2... and so forth
     * If no such item exists, return null.
     */
    public T get(int index) {
        Node p = sentinal.next;
        int i = 0;
        while (i < index) {
            p = p.next;
            i += 1;
        }
        return p.item;
    }

    public static void main(String args[]) {
        LinkedListDeque<Integer> a = new LinkedListDeque<>();
        a.addFirst(12);
        a.addFirst(66);
        a.addLast(123);

        a.printDeque();

        System.out.println(a.get(2));
        System.out.println(a.removeLast());

        a.printDeque();

        a.addFirst(1234);
        a.printDeque();
        a.removeFirst();
        a.printDeque();
    }

}
