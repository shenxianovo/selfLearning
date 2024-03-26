public class Sort {

    public static void sort(String[] x) {
        // find the smallest item
        // move it to the front
        // selection sort to thr rest
        sort(x, 0);
    }

    /* Sorts x at position start */
    private static void sort(String[] x, int start) {
        if (start == x.length) {
            return;
        }
        int smallest = findSmallest(x, start);
        swap(x, start, smallest);
        sort(x, start + 1);
    }

    /* swap item a with b */
    public static void swap(String[] x, int a, int b) {
        String tmp = x[a];
        x[a] = x[b];
        x[b] = tmp;    
    }

    public static int findSmallest(String[] x, int start) {
        int smallestIndex = start;
        for(int i = start; i < x.length; ++i) {
            int cmp = x[i].compareTo(x[smallestIndex]);
            if (cmp < 0) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

}