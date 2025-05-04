public class Questions {
    // Question 1
    public static int stringLengthIterative(String input) {
        int count = 0;
        while (!(input.isEmpty())) {
            System.out.println(input);
            input = input.substring(1);
            System.out.println(count);
            count++;
        }
        return count;
    }

    public static int stringLengthRecursive(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        else {
            return 1 + stringLengthRecursive(input.substring(1));
        }
    }

    // Question 2
    public static int sumIterative(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            System.out.println(sum);
            sum += i;
        }
        return sum;
    }
    
    public static int sumRecursive(int n) {
        if (n == 0){
            return 0;
        }
        else {
            return n + sumRecursive(n - 1);
        }
    }

    // Question 3
    public static int findMaxIterative(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }

    public static int findMaxRecursive(int[] a){
        int max = a[0];
        if (a.length == 1) {
            return max;
        }
        else {
            return Math.max(a[a.length], a[a.length - 1]);
        }
    }

    // Question 4
    public static int sumOddIterative(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            if (num % 2 != 0) {
                sum += num;
            }
        }
        return sum;
    }

    // Question 5
    public static int countElementIterative(int[] arr, int target) {
        int count = 0;
        for (int num : arr) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }

    // Question 6
    public static int gcdIterative(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
       int[] a = {1,2,3};
       System.out.println(findMaxIterative(a));


    
}}