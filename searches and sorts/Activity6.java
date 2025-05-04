import java.util.Scanner;

public class Activity6 {
    /*
     * Method Name: randomNumber
     * Author: K. McKay
     * Creation Date; April 10, 2024
     * Description: generate random number between two values
     * 
     * @Parameters: high number and low number
     * 
     * @Return Value: integer
     * Data Type: integer
     * Throws/Exceptions: n/a
     */

    public static int randomNumber(int lower, int upper) {
        int answer = (int) ((Math.random() * (upper - lower)) + lower);
        return answer;
    }

    /*
     * Method Name: randomFillArray
     * Author: Yunseo Jeon
     * Creation Date: April 23, 2025
     * Description: Recursively fills an array with random values.
     * 
     * @Parameters: list - The array to be filled, upper - The upper bound for
     * random values, index - The current index being filled
     * 
     * @Return Value: int array
     * Data Type: int[]
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */
    public static int[] randomFillArray(int[] list, int upper, int index) {
        if (index >= list.length) {
            return list; // Base case: If index exceeds array length, return the array
        }
        list[index] = randomNumber(1, upper); // Fill the current index with a random number
        return randomFillArray(list, upper, index + 1); // Recursive call for the next index
    }

    /*
     * Method Name: getTIme
     * Author: Yunseo Jeon
     * Creation Date: April 23, 2024
     * Description: returns the time in nanoseconds
     * 
     * @Parameters: n/a
     * 
     * @Return Value: long
     * Data Type: long
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */
    public static long getTime() {
        long tick = System.nanoTime();
        return tick;
    }

    /*
     * Method Name: printArray
     * Author: Yunseo Jeon
     * Creation Date: April 23, 2025
     * Description: Recursively prints values of an array in a tabular format.
     * 
     * @Parameters: list - The array to be printed, columns - Number of columns per
     * row, index - Current index being printed
     * 
     * @Return Value: n/a
     * Data Type: void
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */
    public static void printArray(int[] list, int columns, int index) {
        if (index >= 1000) {
            return; // Base case: If index exceeds 1000, stop recursion
        }
        System.out.print(list[index] + "\t"); // Print the current element
        if ((index + 1) % columns == 0) {
            System.out.print("\n"); // Print a newline after every 'columns' elements
        }
        printArray(list, columns, index + 1); // Recursive call for the next index
    }

    /*
     * Method Name: copyArray
     * Author: Yunseo Jeon
     * Creation Date: May 25, 2024
     * Description: copies the elements in one array into another.
     * 
     * @Parameters: A - The Array being copied, B - The array being rewritten
     * 
     * @Return Value: int array
     * Data Type: int[]
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */
    public static int[] copyArray(int[] A, int[] B) {
        for (int i = 0; i < A.length; i++) {
            B[i] = A[i];
        }
        return B;
    }

    /*
     * Method Name: bubbleSortTimeASC
     * Author: Yunseo Jeon
     * Creation Date: April 10, 2024
     * Description: Times an array being sorted in ascneding order using bubble sort
     * before and after and then returns the final time in nanoseconds.
     * 
     * @Parameters: data - The int array getting sorted
     * 
     * @Return Value: long - The final time after the array has been sorted
     * Data Type: long
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */
    public static long bubbleSortTimeASC(int[] data) {
        long beforeSort, afterSort, time = 0;
        beforeSort = getTime();
        SortSearchLibrary.bubbleSortASC(data);
        afterSort = getTime();
        time += (afterSort - beforeSort);
        return time;
    }

    /*
     * Method Name: bubbleSortTimeDES
     * Author: Yunseo Jeon
     * Creation Date: April 10, 2024
     * Description: Times an array being sorted in descending order using bubble
     * sort before and after and then returns the final time in nanoseconds.
     * 
     * @Parameters: data - The int array getting sorted
     * 
     * @Return Value: long - The final time after the array has been sorted
     * Data Type: long
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */
    public static long bubbleSortTimeDES(int[] data) {
        long beforeSort, afterSort, time = 0;
        beforeSort = getTime();
        SortSearchLibrary.bubbleSortDES(data);
        afterSort = getTime();
        time += (afterSort - beforeSort);
        return time;
    }

    /*
     * Method Name: quickSortTimeASC
     * Author: Yunseo Jeon
     * Creation Date: April 10, 2024
     * Description: Times an array being sorted in ascending order using quick
     * sort before and after and then returns the final time in nanoseconds.
     * 
     * @Parameters: data - The int array getting sorted
     * 
     * @Return Value: long - The final time after the array has been sorted
     * Data Type: long
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */
    public static long quickSortTimeASC(int[] data) {
        long beforeSort, afterSort, time = 0;
        beforeSort = getTime();
        SortSearchLibrary.quickSortASC(data, 0 , data.length - 1);
        afterSort = getTime();
        time += (afterSort - beforeSort);
        return time;
    }

    /*
     * Method Name: quickSortTimeDES
     * Author: Yunseo Jeon
     * Creation Date: April 10, 2024
     * Description: Times an array being sorted in descending order using quick
     * sort before and after and then returns the final time in nanoseconds.
     * 
     * @Parameters: data - The int array getting sorted
     * 
     * @Return Value: long - The final time after the array has been sorted
     * Data Type: long
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */
    public static long quickSortTimeDES(int[] data) {
        long beforeSort, afterSort, time = 0;
        beforeSort = getTime();
        SortSearchLibrary.quickSortDES(data, 0 , data.length - 1);
        afterSort = getTime();
        time += (afterSort - beforeSort);
        return time;
    }

    /*
     * Method Name: mergeSortTimeASC
     * Author: Yunseo Jeon
     * Creation Date: April 10, 2024
     * Description: Times an array being sorted in ascending order using merge
     * sort before and after and then returns the final time in nanoseconds.
     * 
     * @Parameters: data - The int array getting sorted
     * 
     * @Return Value: long - The final time after the array has been sorted
     * Data Type: long
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */
    public static long mergeSortTimeASC(int[] data) {
        long beforeSort, afterSort, time = 0;
        beforeSort = getTime();
        SortSearchLibrary.mergeSortASC(data, 0 , data.length - 1);
        afterSort = getTime();
        time += (afterSort - beforeSort);
        return time;
    }

    /*
     * Method Name: mergeSortTimeDES
     * Author: Yunseo Jeon
     * Creation Date: April 10, 2024
     * Description: Times an array being sorted in descending order using merge
     * sort before and after and then returns the final time in nanoseconds.
     * 
     * @Parameters: data - The int array getting sorted
     * 
     * @Return Value: long - The final time after the array has been sorted
     * Data Type: long
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */
    public static long mergeSortTimeDES(int[] data) {
        long beforeSort, afterSort, time = 0;
        beforeSort = getTime();
        SortSearchLibrary.mergeSortDES(data, 0 , data.length - 1);
        afterSort = getTime();
        time += (afterSort - beforeSort);
        return time;
    }

    /*
     * Method Name: sequentialSearchTime
     * Author: Yunseo Jeon
     * Creation Date: May 10, 2024
     * Description: Times an array being searched for an int using sequential search
     * before and after and then returns the final time in nanoseconds.
     * 
     * @Parameters: data - The int array getting sorted, num - The int thats being
     * searched for
     * 
     * @Return Value: long - The final time after the array has been searched
     * Data Type: long
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */
    public static long sequentialSearchTime(int[] data, int num) {
        long beforeSearch, afterSearch, time = 0;
        beforeSearch = getTime();
        SortSearchLibrary.sequentialSearch(data, num);
        afterSearch = getTime();
        time += (afterSearch - beforeSearch);
        return time;
    }

    /*
     * Method Name: binarySearchTime
     * Author: Yunseo Jeon
     * Creation Date: May 10, 2024
     * Description: Times an array being searched for an int using Binary search
     * before and after and then returns the final time in nanoseconds.
     * 
     * @Parameters: data - The int array getting sorted, num - The int thats being
     * searched for
     * 
     * @Return Value: long - The final time after the array has been searched
     * Data Type: long
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */
    public static long binarySearchTime(int[] data, int num) {
        long beforeSearch, afterSearch, time = 0;
        beforeSearch = getTime();
        SortSearchLibrary.binarySearch(data, num);
        afterSearch = getTime();
        time += (afterSearch - beforeSearch);
        return time;
    }

    public static void randomFillAndCopy(int[] A1, int[] A2, int[] A3, int[] B1, int[] B2, int[] B3, int[] C1, int[] C2, int[] C3, int maxValue) {
        //Array for selection sort
        randomFillArray(A1, maxValue, 0);
        randomFillArray(A2, maxValue, 0);
        randomFillArray(A3, maxValue, 0);

        // Copy the array for quick
        copyArray(A1, B1);
        copyArray(A2, B2);
        copyArray(A3, B3);

        // Copy the array for merge
        copyArray(A1, C1);
        copyArray(A2, C2);
        copyArray(A3, C3);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0; // The choice of the users
        // The following code is used to test the sorting and searching algorithms
        int maxValue = 100000; 
        int SizeOfArray = 1000; // CHANGE To 100000
        int[] A1 = new int[SizeOfArray]; // bubble sort 1
        int[] A2 = new int[SizeOfArray]; // bubble sort 2
        int[] A3 = new int[SizeOfArray]; // bubble sort 3

        int[] B1 = new int[SizeOfArray]; // quick sort 1
        int[] B2 = new int[SizeOfArray]; // quick sort 2
        int[] B3 = new int[SizeOfArray]; // quick sort 3

        int[] C1 = new int[SizeOfArray]; // merge sort 1
        int[] C2 = new int[SizeOfArray]; // merge sort 2
        int[] C3 = new int[SizeOfArray]; // merge sort 3

        int[] searchArray = new int[SizeOfArray]; // Making an array for searches
        int key = 0; // The Element being searched for in the array

        do {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Fill arrays with randomly ordered values");
            System.out.println("2. Fill arrays with values in reversed order");
            System.out.println("3. Fill arrays in Few Unique fashion (1-1000)");
            System.out.println("4. Sort the array in ascending order");
            System.out.println("5. Sort the array in descending order");
            System.out.println("6. Search for a value in the array");
            System.out.println("7. Exit");
            choice = Integer.parseInt(scanner.nextLine().trim());

            switch (choice) {
                case 1: // Fill all the arrays with random values
                randomFillAndCopy(A1, A2, A3, B1, B2, B3, C1, C2, C3, maxValue);

                System.out.println("\nArray A with randomized values, (first 1000 values)");
                printArray(A1, 17, key);
                System.out.println("\n\nArray B with randomized values, (first 1000 values)");
                printArray(A2, 17, key);
                System.out.println("\n\nArray C with randomized values, (first 1000 values)");
                printArray(A3, 17, key);
                    break;
                case 2: // Generate data to represent case the following cases & criteria.
                    
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        // Sorting random
        System.out.println("********************RANDOM********************");
        long bubbleTime = bubbleSortTimeASC(A1) + bubbleSortTimeASC(A2) +
                bubbleSortTimeASC(A3);
        System.out.println("Average (Bubble): " + bubbleTime / 3 + " nanoseconds");
        long quickTime = quickSortTimeASC(B1) + quickSortTimeASC(B2) +
                quickSortTimeASC(B3);
        System.out.println("Average (quick): " + quickTime / 3 + " nanoseconds");
        long mergeTime = mergeSortTimeASC(C1) + mergeSortTimeASC(C2) +
                mergeSortTimeASC(C3);
        System.out.println("Average (merge): " + mergeTime / 3 + " nanoseconds");

        // Sorting one out of place
        A1[randomNumber(1, maxValue)] = maxValue + 69;
        A2[randomNumber(1, maxValue)] = maxValue + 69;
        A3[randomNumber(1, maxValue)] = maxValue + 69;

        // Copy the array for quick
        copyArray(A1, B1);
        copyArray(A2, B2);
        copyArray(A3, B3);

        // Copy the array for merge
        copyArray(A1, C1);
        copyArray(A2, C2);
        copyArray(A3, C3);

        System.out.println("\n********************ONE OUT OF PLACE********************");
        bubbleTime = bubbleSortTimeASC(A1) + bubbleSortTimeASC(A2) +
                bubbleSortTimeASC(A3);
        System.out.println("Average (Bubble): " + bubbleTime / 3 + " nanoseconds");
        quickTime = quickSortTimeASC(B1) + quickSortTimeASC(B2) +
                quickSortTimeASC(B3);
        System.out.println("Average (quick): " + quickTime
                / 3 + " nanoseconds");
        mergeTime = mergeSortTimeASC(C1) + mergeSortTimeASC(C2) +
                mergeSortTimeASC(C3);
        System.out.println("Average (merge): " + mergeTime
                / 3 + " nanoseconds");

        // Reverse
        System.out.println("\n********************REVERSE********************");
        bubbleTime = bubbleSortTimeDES(A1) + bubbleSortTimeDES(A2) +
                bubbleSortTimeDES(A3);
        System.out.println("Average (Bubble): " + bubbleTime / 3 + " nanoseconds");
        quickTime = quickSortTimeDES(B1) + quickSortTimeDES(B2) +
                quickSortTimeDES(B3);
        System.out.println("Average (quick): " + quickTime / 3 + " nanoseconds");
        mergeTime = mergeSortTimeDES(C1) + mergeSortTimeDES(C2) +
                mergeSortTimeDES(C3);
        System.out.println("Average (merge): " + mergeTime / 3 + " nanoseconds");
} // end main
}
