import java.util.Scanner;


/**
 * This class contains code for activity 6 searching and sorting analysis
 * @author Yunseo Jeon
 */
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
     * Description: fills an array with random values.
     * 
     * @Parameters: list - The array to be filled, upper - The upper bound for
     * random values, index - The current index being filled
     * 
     * @Return Value: int array
     * Data Type: int[]
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */
	public static int[] randomFillArray(int size) {
		int[] randomArray = new int[size]; // random array
		for (int i = 0; i < size; i++) {
			randomArray[i] = randomNumber(1, size);
		} // end for
		return randomArray;
	} // end randomFillArray
    
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
        SortSearchLibrary.mergeSortASC(data, 0 , data.length / 2);
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
     * @Parameters: data - The int array getting sorted
     * @Return Value: long - The final time after the array has been sorted
     * Data Type: long
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */
    public static long mergeSortTimeDES(int[] data) {
        long beforeSort, afterSort, time = 0;
        beforeSort = getTime();
        SortSearchLibrary.mergeSortDES(data, 0 , data.length / 2);
        afterSort = getTime();
        time += (afterSort - beforeSort);
        return time;
    }

    /*
     * Method Name: selectionSortTimeASC
     * Author: Yunseo Jeon
     * Creation Date: April 10, 2024
     * Description: Times an array being sorted in ascending order using selection
     * sort before and after and then returns the final time in nanoseconds.
     * @Parameters: data - The int array getting sorted
     * @Return Value: long - The final time after the array has been sorted
     * Data Type: long
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */
    public static long selectionSortTimeASC(int[] data) {
        long beforeSort, afterSort, time = 0;
        beforeSort = getTime();
        SortSearchLibrary.selectionSortASC(data);
        afterSort = getTime();
        time += (afterSort - beforeSort);
        return time;
    }

    /*
     * Method Name: selectionSortTimeDES
     * Author: Yunseo Jeon
     * Creation Date: April 10, 2024
     * Description: Times an array being sorted in ascending order using selection
     * sort before and after and then returns the final time in nanoseconds.
     * @Parameters: data - The int array getting sorted
     * @Return Value: long - The final time after the array has been sorted
     * Data Type: long
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */
    public static long selectionSortTimeDES(int[] data) {
        long beforeSort, afterSort, time = 0;
        beforeSort = getTime();
        SortSearchLibrary.selectionSortDES(data);
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
        int[] X1 = randomFillArray(maxValue); // bubble sort 1
        int[] X2 = randomFillArray(maxValue); // bubble sort 2
        int[] X3 = randomFillArray(maxValue); // bubble sort 3

        // Copy the array for quick
        copyArray(X1, A1);
        copyArray(X2, A2);
        copyArray(X3, A3);

        // Copy the array for quick
        copyArray(X1, B1);
        copyArray(X2, B2);
        copyArray(X3, B3);

        // Copy the array for merge
        copyArray(X1, C1);
        copyArray(X2, C2);
        copyArray(X3, C3);
    }

    public static double percentDifferent(long x, long y) { 
        double absVal = (double) (Math.abs(x) - Math.abs(y)); 
        double avgval = (double) ((x + y) / 2); 
        return (absVal / avgval) * 100; 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int choice = 0; // The choice of the users
        // The following code is used to test the sorting and searching algorithms
        int maxValue = 100000; 
        int SizeOfArray = maxValue; // CHANGE To 100000
        int[] A1 = randomFillArray(SizeOfArray); // bubble sort 1
        int[] A2 = randomFillArray(SizeOfArray); // bubble sort 2
        int[] A3 = randomFillArray(SizeOfArray); // bubble sort 3

        int[] B1 = randomFillArray(SizeOfArray); // quick sort 1
        int[] B2 = randomFillArray(SizeOfArray); // quick sort 2
        int[] B3 = randomFillArray(SizeOfArray); // quick sort 3

        int[] C1 = randomFillArray(SizeOfArray); // merge sort 1
        int[] C2 = randomFillArray(SizeOfArray); // merge sort 2
        int[] C3 = randomFillArray(SizeOfArray); // merge sort 3

        int[] searchArray = randomFillArray(SizeOfArray); // Making an array for searches

        int key = 0; // The Element being searched for in the array 

        SortSearchLibrary.mergeSortASC(searchArray, 0, searchArray.length-1);

        while(true) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Fill arrays with randomly ordered values");
            System.out.println("2. Fill arrays with values in reversed order");
            System.out.println("3. Fill arrays in Few Unique fashion (1-1000)");
            System.out.println("4. Sort the array in ascending order");
            System.out.println("5. Sort the array in descending order");
            System.out.println("6. Search for a value in the array");
            System.out.println("7. Print out first 1000 values");
            System.out.println("8. Print Search Array");
            System.out.println("9. Print Report");
            System.out.println("10. Exit");

            choice = Integer.parseInt(scanner.nextLine().trim());

            switch (choice) {
                case 1: // Fill all the arrays with random values
                    randomFillAndCopy(A1, A2, A3, B1, B2, B3, C1, C2, C3, maxValue);

                    // Copy the array for quick
                    copyArray(A1, B1);
                    copyArray(A2, B2);
                    copyArray(A3, B3);

                    // Copy the array for merge
                    copyArray(A1, C1);
                    copyArray(A2, C2);
                     copyArray(A3, C3);
                    System.out.println("\nArray A with randomized values, (first 1000 values)");
                    printArray(A1, 17, key);
                    System.out.println("\n\nArray B with randomized values, (first 1000 values)");
                    printArray(A2, 17, key);
                    System.out.println("\n\nArray C with randomized values, (first 1000 values)");
                    printArray(A3, 17, key);
                break;

                case 2: // Fill arays with values in reversed order
                    SortSearchLibrary.mergeSortDES(A1, 0, A1.length-1); 
                    SortSearchLibrary.mergeSortDES(A2, 0, A1.length-1); 
                    SortSearchLibrary.mergeSortDES(A3, 0, A1.length-1); 

                     // Copy the array for quick
                    copyArray(A1, B1);
                    copyArray(A2, B2);
                    copyArray(A3, B3);

                    // Copy the array for merge
                    copyArray(A1, C1);
                    copyArray(A2, C2);
                    copyArray(A3, C3);
                    break;

                case 3: // Fill arrays in a Few Unique Fashion (1-1000)
                    randomFillAndCopy(A1, A2, A3, B1, B2, B3, C1, C2, C3, 1000);
                break; 

                case 4: // Sort the Array in Ascending order
                    int subMenuChoice1; 

                    do { 
                        System.out.println("\nWhich sort would you like to use");
                        System.out.println("1) Selection Sort") ;
                        System.out.println("2) Quick Sort");
                        System.out.println("3) Merge Sort");
                        System.out.println("4) Go Back");
                        subMenuChoice1 = Integer.parseInt(scanner.nextLine().trim()); 
    
                        switch (subMenuChoice1) { 
                            case 1: // Selection Sort
                                long selectionTime = (selectionSortTimeASC(A1) + selectionSortTimeASC(A2) + selectionSortTimeASC(A3)) / 3; 
                                System.out.println("It took selection sort " + selectionTime + " nanoseconds to sort on average");
                            break; 

                            case 2: // Quick Sort
                                long quickTime = (quickSortTimeASC(B1) + quickSortTimeASC(B2) + quickSortTimeASC(B3)) / 3; 
                                System.out.println("It took quick sort " + quickTime + " nanoseconds to sort on average");
                            break; 

                            case 3: // Merge Sort
                                long mergeTime = (mergeSortTimeASC(C1) + mergeSortTimeASC(C2) + mergeSortTimeASC(C3)) / 3; 
                                System.out.println("It took merge sort " + mergeTime + " nanoseconds to sort on average");
                            break; 

                            default:
                                System.out.println("Select a valid input");
                        }
                    } while(subMenuChoice1 != 4); 

                break; 

                case 5: // Sort the Array in descending order
                    int subMenuChoice2; 

                    do { 
                        System.out.println("\nWhich sort would you like to use");
                        System.out.println("1) Selection Sort") ;
                        System.out.println("2) Quick Sort");
                        System.out.println("3) Merge Sort");
                        System.out.println("4) Go Back");
                        subMenuChoice2 = Integer.parseInt(scanner.nextLine().trim()); 

                        switch (subMenuChoice2) { 
                            case 1: // Selection Sort
                                long selectionTime = (selectionSortTimeDES(A1) + selectionSortTimeDES(A2) + selectionSortTimeDES(A3)) / 3; 
                                System.out.println("It took selection sort " + selectionTime + " nanoseconds to sort on average");
                            break; 

                            case 2: // Quick Sort
                                long quickTime = (quickSortTimeDES(B1) + quickSortTimeDES(B2) + quickSortTimeDES(B3)) / 3; 
                                System.out.println("It took quick sort " + quickTime + " nanoseconds to sort on average");
                            break; 

                            case 3: // Merge Sort
                                long mergeTime = (mergeSortTimeDES(C1) + mergeSortTimeDES(C2) + mergeSortTimeDES(C3)) / 3; 
                                System.out.println("It took merge sort " + mergeTime + " nanoseconds to sort on average");
                            break; 

                            default:
                                System.out.println("Select a valid input");
                        }
                    } while(subMenuChoice2 != 4); 

                break; 

                case 6: // Search for a value in the Array
                    int subMenuChoice3; 
                    do {
                        System.out.println("\nWhich search would you like to use");
                        System.out.println("1) Sequeuntial search");
                        System.out.println("2) Binary Search");
                        System.out.println("3) Go back");
                        subMenuChoice3 = Integer.parseInt(scanner.nextLine().trim()); 

                        int searchNum = 0; 
                        if(subMenuChoice3 != 3) { 
                            System.out.println("\nInput the number you would like to search for: ");
                            searchNum = Integer.parseInt(scanner.nextLine().trim());     
                        }

                        switch(subMenuChoice3) { 
                            case 1: // Sequential Search
                                if(SortSearchLibrary.sequentialSearch(searchArray, searchNum) == -1) { 
                                    System.out.println("The number you are looking for was not found");
                                } else { 
                                    System.out.println("The number " + searchNum + " was found!");
                                    System.out.println("It took sequential search " + sequentialSearchTime(searchArray, searchNum) + " nanoseconds to find the number");
                                }
                            break; 
                            
                            case 2: // Binary Search
                                if(SortSearchLibrary.binarySearch(searchArray, searchNum) == -1) {
                                    System.out.println("The number you are looking for was not found");
                                } else { 
                                    System.out.println("The number " + searchNum + " was found!");
                                    System.out.println("It took binary search " + binarySearchTime(searchArray, searchNum) + " nanoseconds to find the number");
                                }
                            break; 

                            default: 
                                System.out.println("Please enter a valid input");
                        }
                    } while(subMenuChoice3 != 3); 

                break;

                case 7: // Print first 1000 values
                    System.out.println("\nArray A");
                    printArray(A1, 17, key);
                    System.out.println("\n\nArray B");
                    printArray(A2, 17, key);
                    System.out.println("\n\nArray C");
                    printArray(A3, 17, key);
                break; 
                
                case 8: // Print first 1000 values of search array
                    System.out.println("Search Array 1000 values");
                    printArray(searchArray, 17, key);
                break; 

                case 9: // Print Report
                    double quickToSelection = 0; 
                    double mergeToSelection = 0; 

                    System.out.println("********************RANDOM********************");
                    long selectionTime = selectionSortTimeASC(A1) + selectionSortTimeASC(A2) + selectionSortTimeASC(A3);
                    System.out.println("Average (Selection): " + selectionTime / 3 + " nanoseconds");
                    long quickTime = quickSortTimeASC(B1) + quickSortTimeASC(B2) + quickSortTimeASC(B3);
                    System.out.println("Average (quick): " + quickTime / 3 + " nanoseconds");
                    long mergeTime = mergeSortTimeASC(C1) + mergeSortTimeASC(C2) + mergeSortTimeASC(C3);
                    System.out.println("Average (merge): " + mergeTime / 3 + " nanoseconds");

                    quickToSelection = percentDifferent(selectionTime, quickTime); 
                    mergeToSelection = percentDifferent(selectionTime, mergeTime);

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

                    // One of place
                    System.out.println("\n********************ONE OUT OF PLACE********************");
                    selectionTime = selectionSortTimeASC(A1) + selectionSortTimeASC(A2) + selectionSortTimeASC(A3);
                    System.out.println("Average (Selection): " + selectionTime / 3 + " nanoseconds");
                    quickTime = quickSortTimeASC(B1) + quickSortTimeASC(B2) + quickSortTimeASC(B3);
                    System.out.println("Average (quick): " + quickTime / 3 + " nanoseconds");
                    mergeTime = mergeSortTimeASC(C1) + mergeSortTimeASC(C2) + mergeSortTimeASC(C3);
                    System.out.println("Average (merge): " + mergeTime / 3 + " nanoseconds");

                    // Reverse
                    System.out.println("\n********************REVERSE********************");
                    selectionTime = selectionSortTimeDES(A1) + selectionSortTimeDES(A2) + selectionSortTimeDES(A3);
                    System.out.println("Average (Selection): " + selectionTime / 3 + " nanoseconds");
                    quickTime = quickSortTimeDES(B1) + quickSortTimeDES(B2) + quickSortTimeDES(B3);
                    System.out.println("Average (quick): " + quickTime / 3 + " nanoseconds");
                    mergeTime = mergeSortTimeDES(C1) + mergeSortTimeDES(C2) + mergeSortTimeDES(C3);
                    System.out.println("Average (merge): " + mergeTime / 3 + " nanoseconds");

                    // Few Unique
                    System.out.println("\n********************FEW UNIQUE********************");
                    randomFillAndCopy(A1, A2, A3, B1, B2, B3, C1, C2, C3, 1000);
                    selectionTime = selectionSortTimeASC(A1) + selectionSortTimeASC(A2) + selectionSortTimeASC(A3);
                    System.out.println("Average (Selection): " + selectionTime / 3 + " nanoseconds");
                    quickTime = quickSortTimeASC(B1) + quickSortTimeASC(B2) + quickSortTimeASC(B3);
                    System.out.println("Average (quick): " + quickTime / 3 + " nanoseconds");
                    mergeTime = mergeSortTimeASC(C1) + mergeSortTimeASC(C2) + mergeSortTimeASC(C3);
                    System.out.println("Average (merge): " + mergeTime / 3 + " nanoseconds");

                    // REPORT
                    System.out.println("\n********************REPORT********************");
                    System.out.println("The average execution times in nanoseconds reveal that Selection Sort was significantly slower across all scenarios,");  
                    System.out.println("with Quick Sort being approximately " + quickToSelection + " faster. Merge Sort also outperformed Selection Sort, demonstrating"); 
                    System.out.println("speeds roughly " + mergeToSelection + " faster. Comparing Quick Sort and Merge Sort has been inconsistent because quick sort isn't a stable sort, ");
                    System.out.println("it is sometimes faster than merge sort but other times slower, the problem could be bad pivot points for quick sort which causes it to sort slower."); 
                    System.out.println("In Conclusion while Quick Sort is generally faster than Selection Sort, Merge Sort offers consistent and often superior"); 
                    System.out.println("performance, particularly in cases like reverse sorted and data with few unique elements");

                    System.out.println("\n********************SEARCHES********************");
                    boolean searchFlag = false; 
                    int searchKey; 

                    do { 
                        System.out.println("Input a number you would like to search for");
                        searchKey = Integer.parseInt(scanner.nextLine().trim()); 
    
                        if(SortSearchLibrary.binarySearch(searchArray, searchKey) != -1) { 
                            searchFlag = true; 
                        } else { 
                            System.out.println("The number was not found please try again ");
                        }
                    } while (searchFlag != true); 

                    long sequentialTime = (sequentialSearchTime(searchArray, searchKey) + sequentialSearchTime(searchArray, searchKey) + sequentialSearchTime(searchArray, searchKey)); 
                    System.out.println("Average time for sequential search: " + sequentialTime/3 + " nanoseconds");

                    long binaryTime = (binarySearchTime(searchArray, searchKey) + binarySearchTime(searchArray, searchKey) + binarySearchTime(searchArray, searchKey)); 
                    System.out.println("Average time for binary search: " + binaryTime/3 + " nanoseconds");

                    System.out.println("\n********************REPORT********************");
                    System.out.println("A binary search is often more efficient than a sequential search. In a best case scenario, a binary");
                    System.out.println("search and a sequential search will take about the same amount of time, as the key is found in the first");
                    System.out.println("index searched. In a worst case scenario, where the key is not found within the array, a sequential search will take longer because it ");
                    System.out.println("must check every element in the array. On average, a binary search\nwill be faster than a sequential search, as it grows more efficient in comparison as the ");
                    System.out.println("size of the data set increases. The only time a sequential search will be faster than binary search is when you do not have time to sort data before");
                    System.out.println("searching for something.");
                break;

                case 10: // Exit
                    System.exit(0);

                break; 
                

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } 
    } // end main
}
