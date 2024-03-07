public class Homework {
    public static int max(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] >= max) {
                max = arr[i];
            } else {
                ;
            }
        }

        return max;
    }

    public static void windowPosSum(int[] a, int n) {
        for (int i = 0; i < a.length; ++i) {
            if  (a[i] < 0) {
                continue;
            } else {
                for (int j = 1; j <= n; ++j) {
                    if ((i+j) > a.length-1) {
                        break;    
                    } else {
                        a[i] += a[i+j];
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int[] a = {1, -1, -1, 10, 5, -1};
        int n = 2;
        windowPosSum(a, n);
     
        System.out.println(java.util.Arrays.toString(a));
    }    
}
