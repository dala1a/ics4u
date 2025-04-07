/*
 * @Author : Yunseo Jeon
 * @Last Modified: Mar 3 2025
 * @Description: Interface for D&D Assigment. 
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.Scanner;


public class Interface {

    /**
     * Reads through a text file containing the info of all the characters line by line and stores all that data in an array of characters. 
     * @author Yunseo Jeon
     * @since Mar 3 2025
     * @param characters The array of characters. 
     * @param fileName The name of the file being read
     * @return Integer: The numbers of characters that have been read. 
     * @throws IOException Throws File IO Exceptions if the file could not be found. 
     */
    public static int readASCII(DDCharacter[] characters, String fileName) throws IOException {
        int i = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        while (br.ready() == true) {
            characters[i] = new DDCharacter();
            characters[i].setCharacterName(br.readLine());
            characters[i].setRace(br.readLine());
            characters[i].setClass(br.readLine());
            characters[i].setLevel(Integer.parseInt(br.readLine()));
            characters[i].setHitPoints(Integer.parseInt(br.readLine()));
            characters[i].setStrength(Integer.parseInt(br.readLine()));
            characters[i].setConstitution(Integer.parseInt(br.readLine()));
            characters[i].setIntelligence(Integer.parseInt(br.readLine()));
            characters[i].setWisdom(Integer.parseInt(br.readLine()));
            characters[i].setDexterity(Integer.parseInt(br.readLine()));
            characters[i].setRizz(Integer.parseInt(br.readLine()));
            i++;
        }
        br.close();
        return i;
    }

    /**
     * Prints out all the information for all the characters stored in the array in a neat format. 
     * @author Yunseo Jeon
     * @since Mar 3 2025
     * @param characters The array of characters. 
     * @param numRecs The total numbers for characters
     */
    public static void printReport(DDCharacter[] characters, int numRecs) {
        for (int i = 0; i < numRecs; i++) {
            System.out.println("============================================");
            System.out.println("Character No.:\t" + (i + 1));
            System.out.println("Name:\t\t" + characters[i].getCharacterName());
            System.out.println("Race:\t\t" + characters[i].getRace());
            System.out.println("Class:\t\t" + characters[i].getPlayerClass());
            System.out.println("Level:\t\t" + characters[i].getLevel());
            System.out.println("Hit Points:\t" + characters[i].getHitPoints());
            System.out.println("Strength:\t" + characters[i].getStrength());
            System.out.println("Constitution:\t" + characters[i].getConstitution());
            System.out.println("Intelligence:\t" + characters[i].getIntelligence());
            System.out.println("Wisdom:\t\t" + characters[i].getWisdom());
            System.out.println("Dexterity:\t" + characters[i].getDexterity());
            System.out.println("Charisma:\t" + characters[i].getCharisma());
            System.out.println("============================================");
        }
    }

    /**
     * Writes the whole array to a binary file. 
     * @author Yunseo Jeon
     * @since Mar 3 2025
     * @param characters The array of characters. 
     * @param binaryFileName The name of the new binary file
     * @param numRecs The total numbers of characters 
     * @throws IOException Throws File IO Exceptions if the file could not be created
     */
    public static void writeNewBinaryFile(DDCharacter characters[], String binaryFileName, int numRecs) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(binaryFileName, "rw");
        for (int i = 0; i < numRecs; i++) {
            characters[i].updateOrCreateRAF(raf, i);
        }
        raf.close();
    }

    /**
     * Reads the whole binary file and stores the information in an array and prints it out. 
     * @author Yunseo Jeon
     * @since Mar 3 2025
     * @param characters The array of characters. 
     * @param binaryFileName The name of the binary file being read. 
     * @throws IOException Throws File IO Exceptions if the file could not be found or read. 
     */
    public static void readBinaryFile(DDCharacter characters[], String binaryFileName) throws IOException{
        RandomAccessFile raf = new RandomAccessFile(binaryFileName, "r");
        int numRecs = (int) raf.length()/112;
        for (int i = 0; i < numRecs; i++) {
            characters[i] = new DDCharacter();
            characters[i].readRec(raf, i);
        }
        printReport(characters, numRecs);
        raf.close();
    }
    
    public static void main(String[] args) throws IOException {
        
        // Initialize Variables
        Scanner scanner = new Scanner(System.in);
        DDCharacter[] characters = new DDCharacter[100];
        String fileName = "";   // The ASCII filename
        String binaryFileName = ""; // Binary File name
        int numRec = 0; // Total numbers of records. 
        int choice = 0; // Choice for the switch case. 
        boolean isRead = false; // Variable to check if the user has read in a file

        // Do while loop for the menu
        do {
            System.out.println("============================================");
            System.out.println("Menu \n(Type in Number)");
            System.out.println(
                    "1. Read in ASCII file \n2. Print out Report\n3. Create New Binary File\n4. Read Binary File\n5. Exit");
            choice = Integer.parseInt(scanner.nextLine().trim()); // Choice to be used for switch case. 
            switch (choice) {
                case 1: // Read in an ASCII File 
                    System.out.println("Enter file name: ");
                    fileName = scanner.nextLine().trim();
                    numRec = readASCII(characters, fileName);
                    System.out.println("There are " + numRec + " characters in this file.");
                    isRead = true;
                    break;
                case 2: // Print out all the character informations stored
                    if (isRead == true) {
                        printReport(characters, numRec);
                    } else {
                        System.out.println("Please read an ASCII file first.");
                    }
                    break;
                case 3: // Save all the data in a binary file by creating or updating an existing one. 
                    if (isRead == true) {
                        System.out.println("Enter Binary File name:");
                        binaryFileName = scanner.nextLine().trim();
                        writeNewBinaryFile(characters, binaryFileName, numRec);
                        System.out.println("");
                    } else {
                        System.out.println("Please read an ASCII file first.");
                    }
                    break;
                case 4: // Read in data from an existing binary file. 
                    System.out.println("Enter Binary File name:");
                    binaryFileName = scanner.nextLine().trim();
                    readBinaryFile(characters, binaryFileName);
                    isRead = true; 
                break; 
                default:
                    if (choice != 5) {
                        System.out.println("Please choose a valid input!");
                    }
            }
        } while (choice != 5); // end 
        System.out.println("Ended Program!");
        scanner.close();
    }
}
