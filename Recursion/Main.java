import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Class that contains all the code for the recursive assignment which includes Game of Thrones, Fractal Patterns, Count Shapes and Max Profit. 
 * @author:  Yunseo Jeon
 * @since: 2 May 2025
 */
public class Main { 

	private static char[][] charArr; 		// Initializing Char array for blobCounter. 
    private static int rows;    	 		// Number of rows for the rectangle
    private static int columns; 	 		// Number of columns for the rectangle.  
    private static boolean[][] visited; 	// Initial boolean array for Visited. 
    private static int lineSkip = 0; 		// Variable for skipping lines. 
    private static int recs = 0; 			// Total number of recs. 

    // ======================== GAME OF THRONES =================================

    /**
     * This method removes duplicate characters in the character array before passing it off to {@link #printPossiblePal(char[], int, int)}. 
     * @author Yunseo Jeon
     * @since 2 May 2025
     * @param givenStr The character array provided by the user
     * @param i variable used to iterate through the char array should be set to 0 when calling
     * @param j variable used to iterate through the char array should be set to 0 when calling
     * @return Whether the provided String is a palindrome or not. 
     */
    public static boolean possiblePal(char[] givenStr, int i, int j) { 
        int temp = 1; 

        // checks if the String length is less than 1 which makes it a palindrome automatically 
        if(j == 0) { 
            if(givenStr.length <= 1)
                return true; 

            j += temp; 
        }

        // If 2 of the characters are the same delete them
        if(givenStr[i] == givenStr[j]) { 
            givenStr[i] = ' ';
            givenStr[j] = ' ';  
        }

        // Base statement for when it reaches the end of the array 
        if(i == j-1 && j == givenStr.length - 1) { 
            return printPossiblePal(givenStr, 0, 0);    
        }

        j++; 

        if(j == givenStr.length) { 
            i++;
            j = i+1; 
        }

        return possiblePal(givenStr, i, j);
    }

    /** A Helper method that takes in the array with no duplicate character from {@link #possiblePal(char[], int, int)} and checks to see if it's a palindrome or not. 
     * @author Yunseo Jeon
     * @since 2 May 2025
     * @param Str The character array with no duplicates. 
     * @param i Variable used to iterate through the char array should be set to 0 when calling
     * @param num A counter to see how many characters are left in the array should be set to 0 when calling. 
     * @dependencies {@link #possiblePal(char[], int, int)}
     * @return Whether the provided string is a palindrome or not. 
     */
    public static boolean printPossiblePal(char[] Str, int i, int num) {
		
		// If it finds a letter in the array of char num increases by 1
		if (i < Str.length) {
            if (Str[i] != ' ') {
                num = num + 1;
            }
           return printPossiblePal(Str, i+1, num); // Recursive call to process the next character
        } 
		// Base statement to print out if it is a Palindrome or not. 
		else {
			if(num == 0 || num == 1) {
                return true; 
			}
			else {
                return false; 
			}
        }
	}

    /**
     * Recursively rearranges a char array in alphabetical order to help with palindrome checker
     * @author Yunseo Jeon
     * @since 2 May 2025
     * @param Str The char array provided by the user. 
     * @param i Variable used to iterate through the char array should be set to 0 when calling
     * @param j Variable used to iterate through the char array should be set to 0 when calling
     * @return The sorted char array
     */
    public static char[] alphaOrder(char Str[], int i, int j) {

        // If both i and j reach the end of the array, the sorting is complete.
        if (i == Str.length - 1 && j == Str.length - 1) {
            return Str;
        }
        
        // Sort the array using bubble sort. 
        if (Str[i] < Str[j] || Str[i] == Str[j]) {
            char temp = Str[i];
            Str[i] = Str[j];
            Str[j] = temp;
        }
        j++;
        
        // To make it not go above the array limit set j = 0
        if (j == Str.length) {
            i++;
            j = 0;
        }
        
        return alphaOrder(Str, i, j);
    }

    // ======================== Fractal Patterns =================================

    /**
     * This sets up everything needed to draw the pattern in the console
     * @author Yunseo Jeon
     * @since 2 May 2025
     * @param n Max Length of the pattern 
     * @param i Horizontal offset of the pattern
     * @param k A counter for stars and spaces.
     */
    public static void pattern(int n, int i, int k) {
        // Base case when n = 1, print * at a specified spot.
        if (n == 1) {
        	printSpaces(n, i, k);
        	System.out.println("*");
        }
        else { 
        	// generate the top part of the patters for n and i.
        	pattern(n / 2, i, k);
        	
        	// Print spaces based on i value.
        	printSpaces(n, i, k);
        	
        	// print n amount of stars on a line.
        	printStars(n, i, k);
        	
        	
        	System.out.println();
        	
        	// To generate the bottom part of the pattern.
        	pattern(n / 2, i + n / 2, k);
        }
    }
  
    /**
     * This prints out the spaces needed to draw the pattern. 
     * @author Yunseon Jeon
     * @since 2 May 2025
     * @param n Max Length of the pattern 
     * @param i Horizontal offset of the pattern
     * @param k A counter for stars and spaces.
     * @dependencies: {@link #pattern(int, int, int)}
     */
    public static void printSpaces(int n, int i, int k) {
            // basically a for loop but with if statement to add spaces.
    		if(k < i) {
    			System.out.print(" ");
    			k++;
    			printSpaces(n, i, k);
    		}
    }
    
    /**
     * This prints out the stars needed to draw the pattern. 
     * @author Yunseon Jeon
     * @since 2 May 2025
     * @param n Max Length of the pattern 
     * @param i Horizontal offset of the pattern
     * @param k A counter for stars and spaces.
     * @dependencies: {@link #pattern(int, int, int)}
     */
    public static void printStars(int n, int i, int k) {
		    // basically a for loop but with if statement but to add n amount of stars in a line.
    		if(k < n) {
    			System.out.print("*");
    			k++;
    			printStars(n, i, k);
    		}
    }


    // ======================== Count Shapes =================================

    /**
     * Counts the blobs from a given file recursively. 
     * @author Yunseo Jeon
     * @since 2 May 2025
     * @param arr The array containing X and .
     * @param row The current row being checked (should be set to 0)
     * @param col The current col being checked (should be set to 0)
     * @param blobCount Total blob count (should be set to 0)
     * @return The total number of blobs in that pattern
     */
    public static int countBlobs(char[][] arr, int row, int col, int blobCount) {
    
        // Base condition: If we've gone out of bounds, return
        if (row >= rows) {
            return blobCount;
        }

        // Check the current cell for a blob
        if (arr[row][col] == 'X' && !visited[row][col]) {
            // Found a new blob; increment the count and explore it
            blobCount++;
            getBlobSize(row, col);
        }

        // Move to the next cell
        if (col+1 < columns) {
            return countBlobs(arr, row, col + 1, blobCount); // Go to the next column
        } else {
            return countBlobs(arr, row + 1, 0, blobCount); // Go to the next row
        }
    }
        
    
    
	/**
	 * Purpose is to check the size in all directions. 
	 * @author Mr.McKay
     * @param row The current row being checked (should be set to 0)
     * @param col The current col being checked (should be set to 0)
	 * @dependencies: {@link #countBlobs(char[][], int, int, int)}
	 */
    private static void getBlobSize(int row, int col) {
        // Check if the current square is out of bounds or has already been visited.
        if (row < 0 || row >= rows || col < 0 || col >= columns || visited[row][col] || charArr[row][col] == '.') {
            return;
        }

        // Mark the square as visited.
        visited[row][col] = true;

        // Recursively explore all adjacent squares.
        getBlobSize(row - 1, col);
        getBlobSize(row + 1, col);
        getBlobSize(row, col - 1);
        getBlobSize(row, col + 1);
    }

    /**
     * Purpose is to read in the text file with all the information neeeded to count the blobs
     * @author Yunseo Jeon
     * @since 2 May 2025
     * @param filename The name of the file being read. 
     * @return A 2D char array containing the patters
     */
    public static char[][] readIn(String filename) {
        try {
            // Create a BufferedReader to read the file
            BufferedReader reader = new BufferedReader(new FileReader(filename));

            // Initialize variables
            int numRows = 0;
            int numCols = 0;
                     
            
            // Loop to skip lines when reading the rows and columns after the first rectangle. 
            for (int i = 0; i < lineSkip; i++) {
                String line = reader.readLine();
                if (line == null) {
                    break; // End of file reached before skipping all lines
                }
            } // end for
             
            
            // Determine the number of rows and columns in the file
            String line;
            while ((line = reader.readLine()) != null) {
            	try { 
                	if(numRows == 0 || numCols == 0) {
                        while(line != "."|| line != "X"){
                            numCols = Integer.parseInt(line);
                            line = reader.readLine();
                            numRows = Integer.parseInt(line);
                            line = reader.readLine();
                        }
                	}
            	}
                catch(NumberFormatException e) {}
        	}
            
            rows = numRows;
            columns = numCols;
            
            // Reset the reader to the beginning of the file
            reader.close();
            // Start a new reader to read in the rectangle
            reader = new BufferedReader(new FileReader(filename));
            
           
            // Skip lines when reading rectangles if necessary. 
            for (int i = 0; i < lineSkip; i++) {
                line = reader.readLine();
                if (line == null) {
                    break; // End of file reached before skipping all lines
                }                                                                    
            } // End for. 
           
            
            charArr = new char[numRows][numCols]; // Create a 2D char array to store the rectangle. 
            
            visited = new boolean[numRows][numCols]; // 2D Boolean array to see if the position has been checked when counting blobs. 
            
            int count = 0; // Count to break the loop when it reaches the end of the rectangle. 
            int row = 0; // Initializing Variable for loop. 
            
            
            while ((line = reader.readLine()) != null) {
            	
            	// To skip the first 2 lines on initial run. 
            	if(line.matches("\\d+")) {
            		// When line has 1 or more numeric digits it does count +1. 
            		count++;
            	}
            	
            	// Exits the loop if it finds a number after the initial 2 at the start of the file. 
            	if(count > 2) {
            		break; 	
            	}
            	
            	// If the current line does not 1 or more numeric digits continue. 
                if (!line.matches("\\d+")) {
                	// Write the rectangle to a char array. 
                    for (int col = 0; col < line.length(); col++) {
                        charArr[row][col] = line.charAt(col);
                	}
                    row++;
                }
                
                // For skipping lines on the next runs. 
            	lineSkip += 1;
            }

            // Close the reader when done
            reader.close();               
            return charArr; // Return the array. 
            
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        
    } // End method. 

     /**
      * Purpose is to get the amount of records in the file
      * @author Yunseo Jeon
      * @since 2 May 2025
      * @param filename The name of the file being read
      * @return The amount of records in the file.
      */
	public static int recs(String filename) {
		
		try {
			
		 // Start BufferedReader
		 BufferedReader reader = new BufferedReader(new FileReader(filename));
      

		 String line;
		 
		 // Continues reading the file till it reaches the end. 
		 while ((line = reader.readLine()) != null) {
			 
			// If the current line has a number do +1 recs. 
         	try { 
         		if(Integer.parseInt(line) > 0) {
         		recs++;
         		}
         	}
             catch(NumberFormatException e) {}
     	}
         reader.close(); // close BufferedReader.
		}
		catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
		return recs/2; // return amount of recs
		
	} // end

    // ======================== Max Profit =================================
    
    /**
     * Calculates the maximum profit by finding the best time to buy and sell stocks within the day limit. 
     * @author Yunseo Jeon
     * @since 2 May 2025
     * @param prices The prices of all the stocks
     * @param n The max amount of days to sell it
     * @param counter A counter to help iterate to the int array (should be set to 0)
     * @param profit Keeps track of the total profit (should be set to 0)
     * @param counter2 A counter to help iterate to the int array (should be set to 0)
     * @return The max profit you can get. 
     */
    public static int maxProfit(int prices[], int n, int counter, int profit, int counter2) { 
        int len = prices.length - (counter+1); 

        // Base case when n is 0 it returns the profit
        if(n == 0) { 
            return profit; 
        }
        
        // if there are more days than max days 
        if(len >= n) { 
            if (counter2 < n+counter) {     // basically a for loop for going through all the days before moving onto the next investment
                counter2++; 
                // calculate profit
                int tempProfit = prices[counter2] - prices[counter]; 
                if(profit > tempProfit) { 
                    tempProfit = profit; 
                }
                return maxProfit(prices, n, counter, tempProfit, counter2); 
            } else { // moving onto next investment
                counter++; 
                return maxProfit(prices, n, counter, profit, counter); 
            }
        } else { // decreasing as it gets closer to the end. 
            return maxProfit(prices, len, counter, profit, counter2);
        }

    }
    
    /**
     * Recursively convert a String array to an int array 
     * @author Yunseo Jeon
     * @since 2 May 2025
     * @param numArr The String array being converted
     * @param arr The new array with the converted values
     * @param k A counter to help iterate through the array
     * @return The int array after being converted 
     */
	public static int[] convertArr(String[] numArr, int[] arr, int k) {
		// Method to convert the String array of integers to an int array to be used for the calculations. 
		if(k < numArr.length) {
			arr[k] = Integer.parseInt(numArr[k].trim());
			convertArr(numArr, arr, k+1);
		}
		return arr;
	}


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 

        while(true) { 
            System.out.println("========== Menu ==========");
            System.out.println("1) Game Of Thrones ");
            System.out.println("2) Fractal Pattern");
            System.out.println("3) Count Shapes");
            System.out.println("4) Buy and Sell Stocks");
            System.out.println("5) Quit\n");
            int input = Integer.parseInt(scanner.nextLine().trim()); 
    
            switch (input) {
                
                case 1: // Game of Thrones
                    System.out.println("Enter the palindrome: ");
                    char[] givenStr = scanner.nextLine().trim().toLowerCase().toCharArray();
                    if(possiblePal(alphaOrder(givenStr, 0, 0), 0, 0) == true) { 
                        System.out.println("\nYes, This is a palindrome\n");
                    }  else { 
                        System.out.println("\nNo this is not a palindrome\n");
                    }
                break; 

                case 2: // Fractal Pattern
                    System.out.println("Enter the max length of your pattern: ");
                    int n = Integer.parseInt(scanner.nextLine().trim()); 

                    System.out.println("Input your pattern offset: ");
                    int i = Integer.parseInt(scanner.nextLine().trim()); 

                    pattern(n, i, 0);
                break; 

                case 3: // Count Your Shapes
                    System.out.println("Enter your filename: ");
                    String filename = scanner.nextLine(); 
                    int recs = recs(filename);

                    for(int x = 0; x < recs; x++) { 
                        char[][] grid = readIn(filename); // Read a new grid array from the file

                        if (grid == null) {
                            break; // Exit the loop when the end of the file is reached
                        }
                        
                        // Get blobCount for a specific Rectangle. 
                        int blobCount = countBlobs(grid, 0, 0, 0);
                        System.out.println("In Rectangle #" + (x+1) + " are " + blobCount + " Shapes. ");
                    }
                break; 

                case 4: // Buy and Sell Stocks
                    String[] num = null; 

                    System.out.println("Please enter stock prices (ex: 1, 2, 3, 4, 5): ");
                    String price = scanner.nextLine(); 

                    System.out.println("Please enter the max days to sell the stocks: ");
                    int days = Integer.parseInt(scanner.nextLine().trim()); 
                    
                    num = price.split(", "); 
                    int[] priceArr = new int[num.length]; 
                    
                    System.out.println("MAX PROFIT: " + maxProfit(convertArr(num, priceArr, 0), days, 0, 0, 0) + "\n");
                break; 

                case 5: 
                    scanner.close();
                    System.out.println("Good Bye!");
                    System.exit(0);
                break; 

                default: 
                    System.out.println("Please enter a valid input");
                break; 
            } // end switch
        } // end While
    } // end main
} // end class