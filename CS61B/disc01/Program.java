public class Program {
    public static int mystery(int[] inputArray, int k) {
        int x = inputArray[k];
        int answer = k;
        int index = k + 1;
        while (index < inputArray.length) {
            if (inputArray[index] < x) {
                x = inputArray[index];
                answer = index;
            }
            index = index + 1;
        }
        return answer;
    }

    public static void mystery2(int[] inputArray) {
        int index = 0;
        while (index < inputArray.length) {
            int targetIndex = mystery(inputArray, index);
            int temp = inputArray[targetIndex];
            inputArray[targetIndex] = inputArray[index];
            inputArray[index] = temp;
            index = index + 1;
        }
    }

    public static int fib(int n) {
        int[] arr = new int[n+2];
        arr[0] = 0;
        arr[1] = 0;
        arr[2] = 1;
        for (int i = 3; i <= n; ++i) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; ++i){
            System.out.println(fib(i));
        }
    }

}