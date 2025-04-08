public class Ya {
    /*Write a recursive method digitSum that has a single int parameter.
The method should return the sum of the digits of the parameter. */
    public static int digitSumIterative(int a) {
        String s = Integer.toString(a);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        return sum;
    }
    public static int digitSumRecursive(int a) {
        String s = Integer.toString(a);
        if (a < 10 && a > 0) {
            return a;
        }
        else {
            return digitSumRecursive(a);
    }
}



    public static void main(String[] args) {
        System.out.println(digitSumRecursive(1234)); // Output: 10


    }
}
