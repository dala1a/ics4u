import java.io.*;
import java.util.Scanner;
import java.util.function.Function;

public class review1 {

    public static boolean CheckArray(String [][] data) {
        if (data[0][0] == ""){
            return true;
        }
        return false;
    }
    public static void CheckChoice(String [][] data) {
        if (CheckArray(data) == false){
            System.out.println("Please Read In your data first!");
        }
    }
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

    public static void printOut(String[][] data) {
        System.out.println("\n\t  Student Information Table");
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
    public static void main(String[] args) {
    Scanner userinput = new Scanner(System.in);
        String fileName = ""; // File name
        int SizeOfArray = 0; // Find file size
        String[][] studentInfo = null; //initialize studentInfo outside of switch
        boolean isRead = false; //If the file was read or not
        int choice = 0; // choice for the main menu
        String stringChoice = ""; // choice for sorting menu

        do {
            System.out.println(
                "\n \t\tMenu \n\t   Enter a number!" 
                + "\n 1. Read in Data" 
                + "\n 2. Sort list by student lastname" 
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
                System.out.println("Read In Data from: " + fileName);
                System.out.println("# of items in the file: " + SizeOfArray);
                isRead = true;
                break;
                case 2: //Sort by last name
                if (isRead == true) {
                    
                }
                else{
                    System.out.println("Please Read In a file first!");
                }
                break;
                case 3: //Print table
                if (isRead == true) {
                    printOut(studentInfo);
                }
                else{
                    System.out.println("Please Read In a file first!");
                }
               
                break;
                case 4: //Write file
                break;
                case 5: //search with student number
                break;
                default:
                if (choice!=6){
                    System.out.println("Please choose a valid input!");
                }
            }
            
        }
        while (choice!=6);
        System.out.println("Ended Program!");
        userinput.close();
    }
}
