/* @author  shenxianovo
 * @github  https://github.com/shenxianovo
 * @email   shenxianovo@gmail.com
 * 
 * This is part of course CS61B
 * 
 * @brief   Deque implemented by array (circular)
 *          Spent me a lot of time Orz
 *          But so happy when implemented it OvO
 * 
 */

 public class ArrayDeque<T> {

    T[] arr;
    int capacity;
    int size;
    int indexFirst;
    int indexLast;

    /* Default constructor */
    public ArrayDeque() {
        arr = (T[]) new Object[8];
        capacity = 8;
        size = 0;
        indexFirst = 0;
        indexLast = 0;
    }
    /* Add in range 0 to capacity-1  */
    private int add(int left, int right) {
        return (left + right) % capacity;
    }
    /* Subtract in range 0 to capacity-1 */
    private int subtract(int left, int right) {
        int result = (left - right) % capacity;
        return result > 0 ? result : result + capacity;
    }
    /* Double the size of the deque  */
    public void grow() {
        T[] newArr = (T[]) new Object[2 * size];
        System.arraycopy(arr, indexFirst, newArr, 0, size - indexFirst);
        System.arraycopy(arr, 0, newArr, size - indexFirst, indexLast + 1);
        arr = newArr;
        newArr = null;
        indexFirst = 0;
        indexLast = size - 1;
        capacity *= 2;
    }
    /* Half the size of the deque */
    public void shrink() {
        if (capacity > 8) {
            T[] newArr = (T[])new Object[capacity / 2];
            int i = 0;
            for (int index = indexFirst; index != indexLast; index = add(index, 1) ) {
                newArr[i] = arr[index];
                i++;
            }
            newArr[i] = arr[indexLast];

            arr = newArr;
            newArr = null;
            capacity /= 2;
            indexFirst = 0;
            indexLast = size - 1;
        }
    }
    /* Gets the usage capacity of the deque */
    public double getUsageFactor() {
        return (double)size / (double)capacity;
    }
    
    /* Adds an item to the front from the deque */
    public void addFirst(T item) {
        if (size == capacity) {
            grow();
        }
        if (isEmpty()) {
            arr[indexFirst] = item;
        } else {
            arr[subtract(indexFirst, 1)] = item;
            indexFirst = subtract(indexFirst, 1);
        }
        
        size += 1;
    }
    /* Adds an item to the back of the deque */  
    public void addLast(T item) {
        if (size == capacity) {
            grow();
        }
        if (isEmpty()) {
            arr[indexLast] = item;
        } else {
            arr[indexLast + 1] = item;
            indexLast += 1;
        }
        size += 1;
    }
    /* Removes the first item in the deque */
    public void removeFirst() {
        size -= 1;
        arr[indexFirst] = null;
        indexFirst = add(indexFirst, 1);
        if (getUsageFactor() < 0.25) {
            shrink();
        }
    }
    /* Removes the first item in the deque */
    public void removeLast() {
        size -= 1;
        arr[indexLast] = null;
        indexLast = subtract(indexLast, 1);
        if (getUsageFactor() < 0.25) {
            shrink();
        }
    }
    
    /* Returns true if the deque is empty, false otherwise */
    public boolean isEmpty() {
        return (size == 0);
    }
    /* Returns the size of the deque */
    public int size() {
        return size;
    }
    /* Prints the deque from first to last */
    public void printDeque() {
        int first = indexFirst;
        int last = indexLast;
        while (first != last) {
            System.out.print(arr[first] + " ");
            first = add(first, 1);
        }
        System.out.print(arr[first]);
    }

    public T get(int index) {
        return arr[add(indexFirst, index)];
    }



    public static void main(String[] args) {
        ArrayDeque<String> strArr = new ArrayDeque();
        strArr.addFirst("17");
        strArr.addLast("16");
        strArr.addFirst("15");
        strArr.addFirst("14");
        strArr.addLast("13");
        strArr.addFirst("12");
        strArr.addFirst("11");
        strArr.addFirst("10");
        strArr.addFirst("9");
        strArr.addFirst("8");

        strArr.removeFirst();
        strArr.removeFirst();
        strArr.removeLast();
        strArr.removeFirst();
        strArr.removeLast();
        strArr.removeLast();
        strArr.removeLast();
        strArr.removeLast();
        
        strArr.printDeque();

        System.out.println(strArr.get(2));

    }


}
