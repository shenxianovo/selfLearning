public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }
    public int iterativeSize() {
        IntList p = this;
        int totalSize = 0;
        while (p != null) {
            totalSize +=1;
            p = p.rest;
        }
        return totalSize;
    }

    public int get(int i) {
        if (i == 0) {
            return first;
        }
        return rest.get(i - 1);
    }
    public int iterativeGet(int i) {
        IntList p = this;
        int retVal = 0;
        for(int j = 0; j < i; ++j) {
            retVal = p.first;
            p = p.rest;
        }
        return retVal;
    }


    public static void main(String[] args) {
        /* AWKWARD CODE
        IntList L = new IntList();
        L.first = 5;
        L.rest = null;

        L.rest = new IntList();
        L.rest.first = 10;

        L.rest.rest = new IntList();
        L.rest.rest.first = 15;
        */

        /* Still awkward code
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);
        */
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);
        System.out.println(L.iterativeSize());
        System.out.println(L.iterativeGet(4));
    }
}
