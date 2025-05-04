public class SortSearchLibrary {
/*
	 * Method Name: bubbleSortASC 
	 * Author: K. McKay
	 * Creation Date: April 10, 2024
	 * Description: Sorts an int array in ascending order using bubble sort.  
	 * @Parameters: data - The int array getting sorted
	 * @Return Value: n/a 
	 * Data Type: void
	 * Dependencies: n/a 
	 * Throws/Exceptions: n/a
	*/
	public static void bubbleSortASC(int data[]) {
		int tmp;
		int j = 0;
		boolean sorted = false;
		while ((!sorted) && (j < data.length)) {
			sorted = true;
			for (int i = 0; i < data.length - 1; i++)
				if (data[i] > data[i + 1]) {
					sorted = false;
					tmp = data[i];
					data[i] = data[i + 1];
					data[i + 1] = tmp;
				} // end if
		} // end while
	}// end bubbleSort

	/*
	 * Method Name: bubbleSortASC 
	 * Author: K. McKay
	 * Creation Date: April 10, 2024
	 * Description: Sorts an int array in descending order using bubble sort.  
	 * @Parameters: data - The int array getting sorted
	 * @Return Value: n/a 
	 * Data Type: void
	 * Dependencies: n/a 
	 * Throws/Exceptions: n/a
	*/
	public static void bubbleSortDES(int data[]) {
		int tmp;
		int j = 0;
		boolean sorted = false;
		while ((!sorted) && (j < data.length)) {
			sorted = true;
			for (int i = 0; i < data.length - 1; i++)
				if (data[i] < data[i + 1]) {
					sorted = false;
					tmp = data[i];
					data[i] = data[i + 1];
					data[i + 1] = tmp;
				} // end if
		} // end while
	}// end bubbleSort

	/*
	 * Method Name: insertionSortASC 
	 * Author: K. McKay
	 * Creation Date: April 10, 2024
	 * Description: Sorts an int array in ascending order using insertion sort.  
	 * @Parameters: data - The int array getting sorted
	 * @Return Value: n/a 
	 * Data Type: void
	 * Dependencies: n/a 
	 * Throws/Exceptions: n/a
	*/
	public static void insertionSortASC(int data[]) {
		int tmp;
		int i, j;
		for (j = 0; j < data.length; j++) {
			i = j - 1;
			tmp = data[j];
			while ((i >= 0) && (tmp < data[i])) {
				data[i + 1] = data[i];
				i--;
			}
			data[i + 1] = tmp;
		}
	}

	/*
	 * Method Name: insertionSortDES 
	 * Author: K. McKay
	 * Creation Date: April 10, 2024
	 * Description: Sorts an int array in descending order using insertion sort.  
	 * @Parameters: data - The int array getting sorted
	 * @Return Value: n/a 
	 * Data Type: void
	 * Dependencies: n/a 
	 * Throws/Exceptions: n/a
	*/
	public static void insertionSortDES(int data[]) {
		int tmp;
		int i, j;
		for (j = 0; j < data.length; j++) {
			i = j - 1;
			tmp = data[j];
			while ((i >= 0) && (tmp > data[i])) {
				data[i + 1] = data[i];
				i--;
			}
			data[i + 1] = tmp;
		}
	}

	/*
	 * Method Name: selectionSortASC 
	 * Author: K. McKay
	 * Creation Date: April 10, 2024
	 * Description: Sorts an int array in ascending order using selection sort.  
	 * @Parameters: data - The int array getting sorted
	 * @Return Value: n/a 
	 * Data Type: void
	 * Dependencies: n/a 
	 * Throws/Exceptions: n/a
	*/
	public static void selectionSortASC(int[] intArray) {
		for (int i = intArray.length - 1; i > 0; i--) {
			int maxLoc = 0; // Location of largest item seen so far.
			for (int j = 1; j <= i; j++) {
				if (intArray[j] > intArray[maxLoc]) {
					maxLoc = j;
				}
			}
			int temp = intArray[maxLoc]; // Swap largest item with intArray[i].
			intArray[maxLoc] = intArray[i];
			intArray[i] = temp;
		} // end of for loop
	} // end selectSort

	/*
	 * Method Name: selectionSortDES 
	 * Author: K. McKay
	 * Creation Date: April 10, 2024
	 * Description: Sorts an int array in descending order using selection sort.  
	 * @Parameters: data - The int array getting sorted
	 * @Return Value: n/a 
	 * Data Type: void
	 * Dependencies: n/a 
	 * Throws/Exceptions: n/a
	*/
	public static void selectionSortDES(int[] intArray) {
		for (int i = intArray.length - 1; i > 0; i--) {
			int maxLoc = 0; // Location of largest item seen so far.
			for (int j = 1; j <= i; j++) {
				if (intArray[j] < intArray[maxLoc]) {
					maxLoc = j;
				}
			}
			int temp = intArray[maxLoc]; // Swap largest item with intArray[i].
			intArray[maxLoc] = intArray[i];
			intArray[i] = temp;
		} // end of for loop
	} // end selectSort

    /*
 * Method Name: quickSortASC
 * Author: Yunseo Jeon
 * Creation Date: April 23, 2025
 * Description: Sorts an int array in ascending order using quicksort.
 * @Parameters: array - The int array to be sorted, low - starting index, high - ending index
 * @Return Value: n/a
 * Data Type: void
 * Dependencies: n/a
 * Throws/Exceptions: n/a
 */
public static void quickSortASC(int[] array, int low, int high) {
    if (low < high) {
        int pi = partitionASC(array, low, high);
        quickSortASC(array, low, pi - 1);
        quickSortASC(array, pi + 1, high);
    }
}

private static int partitionASC(int[] array, int low, int high) {
    int pivot = array[high];
    int i = low - 1;
    for (int j = low; j < high; j++) {
        if (array[j] < pivot) {
            i++;
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
    int temp = array[i + 1];
    array[i + 1] = array[high];
    array[high] = temp;
    return i + 1;
}

/*
 * Method Name: quickSortDES
 * Author: Yunseo Jeon
 * Creation Date: April 23, 2025
 * Description: Sorts an int array in descending order using quicksort.
 * @Parameters: array - The int array to be sorted, low - starting index, high - ending index
 * @Return Value: n/a
 * Data Type: void
 * Dependencies: n/a
 * Throws/Exceptions: n/a
 */
public static void quickSortDES(int[] array, int low, int high) {
    if (low < high) {
        int pi = partitionDES(array, low, high);
        quickSortDES(array, low, pi - 1);
        quickSortDES(array, pi + 1, high);
    }
}

private static int partitionDES(int[] array, int low, int high) {
    int pivot = array[high];
    int i = low - 1;
    for (int j = low; j < high; j++) {
        if (array[j] > pivot) {
            i++;
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
    int temp = array[i + 1];
    array[i + 1] = array[high];
    array[high] = temp;
    return i + 1;
}

/*
 * Method Name: mergeSortASC
 * Author: Yunseo Jeon
 * Creation Date: April 23, 2025
 * Description: Sorts an int array in ascending order using merge sort.
 * @Parameters: array - The int array to be sorted
 * @Return Value: n/a
 * Data Type: void
 * Dependencies: n/a
 * Throws/Exceptions: n/a
 */
public static void mergeSortASC(int[] array, int left, int right) {
    if (left < right) {
        int mid = left + (right - left) / 2;
        mergeSortASC(array, left, mid);
        mergeSortASC(array, mid + 1, right);
        mergeASC(array, left, mid, right);
    }
}

private static void mergeASC(int[] array, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;

    int[] L = new int[n1];
    int[] R = new int[n2];

    for (int i = 0; i < n1; i++) L[i] = array[left + i];
    for (int j = 0; j < n2; j++) R[j] = array[mid + 1 + j];

    int i = 0, j = 0, k = left;
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            array[k] = L[i];
            i++;
        } else {
            array[k] = R[j];
            j++;
        }
        k++;
    }

    while (i < n1) {
        array[k] = L[i];
        i++;
        k++;
    }

    while (j < n2) {
        array[k] = R[j];
        j++;
        k++;
    }
}

/*
 * Method Name: mergeSortDES
 * Author: Yunseo Jeon
 * Creation Date: April 23, 2025
 * Description: Sorts an int array in descending order using merge sort.
 * @Parameters: array - The int array to be sorted
 * @Return Value: n/a
 * Data Type: void
 * Dependencies: n/a
 * Throws/Exceptions: n/a
 */
public static void mergeSortDES(int[] array, int left, int right) {
    if (left < right) {
        int mid = left + (right - left) / 2;
        mergeSortDES(array, left, mid);
        mergeSortDES(array, mid + 1, right);
        mergeDES(array, left, mid, right);
    }
}

private static void mergeDES(int[] array, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;

    int[] L = new int[n1];
    int[] R = new int[n2];

    for (int i = 0; i < n1; i++) L[i] = array[left + i];
    for (int j = 0; j < n2; j++) R[j] = array[mid + 1 + j];

    int i = 0, j = 0, k = left;
    while (i < n1 && j < n2) {
        if (L[i] >= R[j]) {
            array[k] = L[i];
            i++;
        } else {
            array[k] = R[j];
            j++;
        }
        k++;
    }

    while (i < n1) {
        array[k] = L[i];
        i++;
        k++;
    }

    while (j < n2) {
        array[k] = R[j];
        j++;
        k++;
    }
}


    /*
	 * Method Name: sequentialSearch 
	 * Author: Yunseo Jeon
	 * Creation Date: May 25, 2024
	 * Description: Searches through an array using sequention search method.  
	 * @Parameters: data - The int array getting sorted, key - The int thats being searched for
	 * @Return Value: int - returns the index of the number if found otherwise returns -1
	 * Data Type: int
	 * Dependencies: n/a 
	 * Throws/Exceptions: n/a
	*/
	public static int sequentialSearch(int[] array, int key) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == key) {
				return i; /* the position where the element was found */
			}
		}
		return -1; /* return -1 if key not found in the array */
	}

    public static int binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (array[mid] == key) {
                return mid; // Key found
            } else if (array[mid] < key) {
                low = mid + 1; // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }
        return -1; // Key not found
    }

    public static int recursiveBinarySearch(int[] array, int key, int low, int high) {
        if (low > high) {
            return -1; // Key not found
        }

        int mid = low + (high - low) / 2;

        if (array[mid] == key) {
            return mid; // Key found
        } else if (array[mid] < key) {
            return recursiveBinarySearch(array, key, mid + 1, high); // Search in the right half
        } else {
            return recursiveBinarySearch(array, key, low, mid - 1); // Search in the left half
        }
    }

}
