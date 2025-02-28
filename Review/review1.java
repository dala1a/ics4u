package Review;
/*
 * @Author : Yunseo Jeon
 * @Last Modified: Feb 9 2025
 * @Description: Read in a dataset with ID numbers, Student last names, and first names.
 *               Manipulate and sort alphabetically, print, and write out to new file.
 */
import java.io.*;
import java.util.Scanner;

public class review1 {
     /*
     * Method Name: CheckSize
     * Author: Kyle McKay
     * Creation Date: Nov 15 2023
     * Date: Nov 15 2023
     * Description: Peeks at the size of the array
     * 
     * @Parameters: A integer array
     * 
     * @Return Value: Returns the number of lines in a file
     * Data Type: integer ARRAY
     * Dependencies: n/a
     * Throws/Exceptions: File IO errors
     */
    public static int CheckSize(String filename) {
        int NumberOfItems = 0;
        try {
            BufferedReader FileInputPointer = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
            while (FileInputPointer.ready() == true) {
                FileInputPointer.readLine(); // Advances the pointer
                NumberOfItems++;
            }
            FileInputPointer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error - this file does not exist");
        } catch (IOException e) {
            System.out.println("Error" + e.toString());
        }

        return NumberOfItems;
    }

    /*
     * Method Name: writeOut
     * Author: Kyle McKay
     * Creation Date; Nov 15 2023
     * Modified Date: Nov 15 2023
     * Description: Creates a new file and outputs the doubles and string array to
     * it.
     * 
     * @Parameters: file name as a string, String Array and a double array
     * 
     * @Return Value: None its a procedure
     * Data Type: integer ARRAY
     * Dependencies: n/a
     * Throws/Exceptions: File IO exceptions
     */
    public static void writeOut(String filename, String[][] data) {
        try {
            PrintWriter outputfile = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
            for (int r = 0; r < data.length; r++) {
                for (int c = 0; c < data[r].length; c++) {
                    outputfile.println(data[r][c]);
                }
            }
            outputfile.close();
        } catch (Exception e) {
            System.out.println("My Application Error: " + e.toString());
        }

    }

    /*
     * Method Name: readIn
     * Author: Kyle McKay
     * Creation Date; Nov 15 2023
     * Modified Date: Nov 15 2023
     * Description: Reads line by line the integers in a file and places in an array
     * 
     * @Parameters: A integer array, and file name as a string
     * 
     * @Return Value: Returns the filled in array
     * Data Type: integer ARRAY
     * Dependencies: n/a
     * Throws/Exceptions: File IO exceptions
     */
    public static String[][] readIn(String filename, String[][] data) {
        String dataItem;
        try {
            BufferedReader FileInputPointer = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
            while (FileInputPointer.ready() == true) {
                for (int r = 0; r < data.length; r++) {
                    for (int c = 0; c < data[r].length; c++) {
                        dataItem = FileInputPointer.readLine();
                        data[r][c] = dataItem;
                    }
                }
            }
            FileInputPointer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error - this file does not exist");
        } catch (IOException e) {
            System.out.println("Error" + e.toString());
        }
        return data;
    }

    /*
     * Method Name: printOut
     * Author: Kyle McKay
     * Creation Date; Nov 15 2023
     * Modified Date: May 23, 2024 by Yunseo Jeon
     * Description: To output the String 2D array
     * 
     * @Parameters: String 2D array
     * 
     * @Return Value: None its a procedure
     * Data Type: n/a
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */
    public static void printOut(String[][] data) {
        String[] header = {"ID Number", "  Last", " First"};
        
            for (int i = 0; i < header.length; i++) {
                System.out.print(header[i] + "\t\t");
            }
        System.out.println();

        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[r].length; c++) {
                System.out.print(data[r][c] + "\t\t");
            }
            System.out.println();
        }
    }
   
    /*
     * Method Name: CheckArray
     * Author: Yunseo Jeon
     * Creation Date: Feb 9 2025
     * Description: Checks if 2D array is "empty".
     *
     * @Parameters: String 2D array (student data)
     *
     * @Return Value: boolean (true if array is considered empty, false otherwise)
     * Data Type: boolean
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */
    public static boolean CheckArray(String [][] data) {
        if (data[0][0] == ""){
            return true;
        }
        return false;
    }
    
    /*
     * Method Name: CheckChoice
     * Author: Yunseo Jeon
     * Creation Date: Feb 9 2025
     * Description: Checks if data is read and prompts to read data if not.
     *
     * @Parameters: String 2D array (student data)
     *
     * @Return Value: void (prints output to console)
     * Data Type: void
     * Dependencies: CheckArray method
     * Throws/Exceptions: n/a
     */
    public static void CheckChoice(String [][] data) {
        if (CheckArray(data) == false){
            System.out.println("Please Read In your data first!");
        }
    }

    /*
     * Method Name: selectionSort
     * Author: Yunseo Jeon
     * Creation Date: Feb 9 2025
     * Description: Sorts 2D string array alphabetically of second index.
     *
     * @Parameters: String 2D array - data: The 2D array containing student data to be sorted.
     *              int - n: The number of rows in the `sortedData` array 
     *
     * @Return Value: void
     * Data Type: void
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */
    public static void selectionSort(String [][] data, int n) {
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; // alphabetically earliest last name's index

            for (int j = i + 1; j < n; j++) { // find the index of alphabetically earilest last name
                if (data[j][1].compareTo(data[minIndex][1]) < 0) { // compare last names alphabetically to the rest of the last names
                    minIndex = j; // new alphabetically earliest last name index 
                } 
                else if (data[j][1].compareTo(data[minIndex][1]) == 0) {
                    if (data[j][2].compareTo(data[minIndex][2]) < 0) { // if last names are the same, compare first names alphabetically
                        minIndex = j; // new alphabetically earliest based on first name 
                    }
                }
            }
            if (minIndex != i) { // Swap the found minimum row with the current row if they are not the same
                String[] tempRow = data[i]; // Store current row in temp
                data[i] = data[minIndex]; // Place the minimum row at current position
                data[minIndex] = tempRow; // Place the current row at the minimum position
            }
        }
    }
   
    /*
     * Method Name: sortByLastName
     * Author: Yunseo Jeon
     * Creation Date: Feb 9 2025
     * Description: Sorts 2D array by last then first name, returns new sorted array.
     *
     * @Parameters: String 2D array (original student data to be sorted)
     *
     * @Return Value: String 2D array (a new sorted 2D array)
     * Data Type: String 2D array
     * Dependencies: selectionSort() method
     * Throws/Exceptions: n/a
     */
    public static String[][] sortByLastName(String[][] originalData) {
        String[][] sortedData = new String[originalData.length][originalData[0].length]; //initialize sorted array
        int n = sortedData.length; // number of rows in the array

        for (int i = 0; i < originalData.length; i++) {
            for (int j = 0; j < originalData[i].length; j++) {
                sortedData[i][j] = originalData[i][j]; // copy array to new array
            }
        }

        selectionSort(sortedData, n);
        
        return sortedData;
    }
    
     /*
     * Method Name: findByNumber
     * Author: Yunseo Jeon
     * Creation Date: May 23 2024
     * Description: Finds student by ID, returns formatted name or "Student not found".
     *
     * @Parameters: String 2D array (student data), int (student ID number to search for)
     *
     * @Return Value: String (formatted student information or "Student not found" message)
     * Data Type: String
     * Dependencies: n/a
     * Throws/Exceptions: n/a
     */
    public static String findByNumber(String[][] data, int num) {
        String number = String.valueOf(num); // ID number as a string
        String first = null; //first name of student
        String last = null; //last name of student

        while (number.length() != data[0][0].length()){ 
            number = "0" + number; //add zero padding if length of id is less than required
        }

        for (int r = 0; r < data.length; r++) { 
            if (data[r][0].equals(number)){ // find if the ID number matches a student
                first = data[r][2]; // set first as first name of student
                last = data[r][1]; // set last as last name of student
            }
        }

        if (first != null && last != null){ // if student is found, return student info
            return "The student with ID " + number + " is " + first + " " + last + ". ";
        }
        else { // if not found, return not found message
            return "Student not found. Try another ID number!";
        }
    }
   
    public static void main(String[] args) {
    Scanner userinput = new Scanner(System.in);
        String fileName = ""; // File name
        int SizeOfArray = 0; // Find file size
        String[][] studentInfo = null; //initialize studentInfo outside of switch
        String[][] sortedInfo = null; //initialize sortedInfo outside of switch
        boolean isRead = false; //If the file was read or not
        boolean isSorted = false; //If the list was sorted or not
        int choice = 0; // choice for the main menu
        int idNumber = 0; //ID number for finding student in menu 5

        do {
            System.out.println(
                "\n \t\tMenu \n\t   Enter a number!" 
                + "\n 1. Read in Data" 
                + "\n 2. Sort list by student last name" 
                + "\n 3. Print out a table"
                + "\n 4. Write file with new sorted data file"
                + "\n 5. Search for a Student Number"
                + "\n 6. Exit\n"
            );
            choice = Integer.parseInt(userinput.nextLine().trim());

            switch(choice){
                case 1: //Read in
                System.out.println("Please enter a filename to read?");
                fileName = userinput.nextLine().trim(); // File name
                SizeOfArray = CheckSize(fileName); // Find file size
                studentInfo = new String[SizeOfArray / 3][3]; 
                readIn(fileName,studentInfo);
                System.out.println("\nRead In Data from: " + fileName);
                System.out.println("# of students in the file: " + SizeOfArray/3);
                isRead = true;
                break;

                case 2: //Sort by last name
                if (isRead == true) {
                    sortedInfo = sortByLastName(studentInfo);
                    isSorted = true;
                    System.out.println("\nSorted alphabetically (last name)!");
                }
                else{
                    System.out.println("Please read in a file first!");
                }
                break;

                case 3: //Print table
                if (isRead == true && isSorted == true) {
                    System.out.println("\n\tOrignal Student Information Table");
                    printOut(studentInfo);
                    System.out.println("\n\tSorted Student Information Table");
                    printOut(sortedInfo);
                }
                else if (isRead == false){
                    System.out.println("Please read In a file first!");
                }
                else{
                    System.out.println("Please sort the file first!");
                }
                break;

                case 4: //Write file
                if (isRead == true && isSorted == true) {
                    writeOut("stsort.dat", sortedInfo);
                }
                else if (isRead == false){
                    System.out.println("Please read in a file first!");
                }
                else{
                    System.out.println("Please sort the file first!");
                }
                break;

                case 5: //search with student number
                if (isRead == true) {
                System.out.println("Please input a Student ID number:");
                idNumber = Integer.parseInt(userinput.nextLine().trim());
                System.out.println(findByNumber(studentInfo,idNumber));
                }
                else{
                    System.out.println("Please read in a file first!");
                }
                break;

                default:
                if (choice!=6){
                    System.out.println("Please choose a valid input!");
                }
            }
            
        }
        while (choice != 6);
        System.out.println("Ended Program!");
        userinput.close();
    }
}
