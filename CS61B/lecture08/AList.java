public class AList<T> implements List61B<T> {

    private T[] items;
    private int size;

    /* Creates an empty list */
    public AList() {
        items = (T[]) new Object[32]; // Java's annoying feature
        size = 0;
    }

    /* Resizes the array to the target capacity */
    public void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    /* Inserts X To the back of the list */
    @Override
    public void addLast(T x) {
        if (size == items.length) {
            resize(2*size);
        }
        items[size] = x;
        size += 1;
    }

    /* Returns the item from the back of the list */
    @Override
    public T getLast() {
        return items[size - 1];
    }

    /* Gets the ith item in the list (0 is the front) */
    @Override
    public T get(int i) {
        return items[i];
    }

    /* Returns the number of items in the list */
    @Override
    public int size() {
        return size;
    }

    /*
     * Deletes the item from back of the list and returns
     * the deleted item
     */
    @Override
    public T removeLast() {
        T returnItem = getLast();
        items[size - 1] = null;
        size -= 1;
        return returnItem;
    }


}