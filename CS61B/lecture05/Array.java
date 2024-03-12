public class Array {
    public static void main(String[] args) {
        String[] s = new String[5]; // creat a reference sequence of String
        s[0] = "Miku";

        int[] arr = new int[] {1, 2, 3, 4, 5};
        int[] arr2 = new int[] {66, 77};

        System.arraycopy(arr, 0, arr2, 3, 2);

    }    
}
