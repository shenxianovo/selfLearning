public class HelloFuncs {

    public static int larger(int x, int y) {
        if (x >+ y) {
            return x;
        }
        else {
            return y;
        }
    }

    public static void main(String[] args) {
        System.out.println(larger(10, 11));
    
    }
}

// Func must be declared in the class
// all functions are methods
// public static