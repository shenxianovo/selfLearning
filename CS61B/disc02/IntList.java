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
            totalSize += 1;
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
        IntList p = this.rest;
        int retVal = this.first;
        for (int j = 0; j < i; ++j) {
            retVal = p.first;
            p = p.rest;
        }
        return retVal;
    }
    // 递归到最深处 在出来时进行运算 新结点接旧头
    public static IntList square(IntList L) {
        if (L == null) {
            return L;
        } else {
            IntList rest = square(L.rest);
            IntList M = new IntList(L.first*L.first, rest);
            return M;
        }
    }
    // 递推 新结点挂旧尾
    public static IntList iterativeSquare(IntList L) {
        if (L == null) {
            return L;
        }
        IntList B = L.rest;
        IntList LSquared = new IntList(L.first * L.first, null);
        IntList C = LSquared;
        while (B != null) {
            C.rest = new IntList(B.first * B.first, null);
            B = B.rest;
            C = C.rest;
        }
        return LSquared;
    }

    public static IntList squareMutative(IntList L) {
        if (L == null) {
            return L;
        } else {
            L.first *= L.first;
            squareMutative(L.rest);
        }
        return L;
    }

    public static IntList iterativeSquareMutative(IntList L) {
        IntList p = L;
        while (p != null) {
            p.first = p.first * p.first;
            p = p.rest;
        }
        return L;
    }

    public static void main(String[] args) {

        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);

        IntList L2 = iterativeSquare(L);

        System.out.println(L.get(0));
        System.out.println(L.get(1));
        System.out.println(L.get(2));

        System.out.println(L2.get(0));
        System.out.println(L2.get(1));
        System.out.println(L2.get(2));
    }
}
