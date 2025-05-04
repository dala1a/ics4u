public class Ya {
    /*
     * Write a recursive method digitSum that has a single int parameter.
     * The method should return the sum of the digits of the parameter.
     */
    public static int digitSumIterative(int a) {
        String s = Integer.toString(a);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        return sum;
    }

    public static int digitSumRecursive(int a) {
        if (a == 0) {
            return 0;
        } 
        else {
            return (a % 10) + digitSumRecursive(a / 10);
        }
    }
    /*
         * Write a method printSub with an int parameter sum and an int
         * array parameter list. The method should look for a sublist of list
         * whose elements add up to sum. If it finds such a sublist, it should
         * print it. For example, if list = {3,7,5,3,8} and sum = 12, then
         * the method should print 7 and 5. You may assume that there will be
         * no more than one sublist satisfying the condition.
         */
        public static void printSub(int sum, int[] list) {
            int start = 0; // Start index for the sublist
            if (start >= list.length) { // Base case: if we reach the end of the array
                System.out.println("No sublist found that adds up to " + sum);
                return;
            }
            int currentSum = 0;
            for (int i = start; i < list.length; i++) { // Check sublists starting from the current index
                currentSum += list[i];
                if (currentSum == sum) { // If the sublist adds up to the target sum
                    for (int j = start; j <= i; j++) {
                        System.out.print(list[j] + " ");
                    }
                    System.out.println("add up to " + sum);
                    return;
                }
            }
            start++; // Move to the next starting index
        }

    public static void main(String[] args) {
        System.out.println(digitSumRecursive(1234)); // Output: 10

    }
}
