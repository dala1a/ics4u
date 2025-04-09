package DDCharacterAssignment;
/*
 * @Author : Yunseo Jeon
 * @Last Modified: Mar 7 2025
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
     * Reads through a text file containing the info of all the characters line by
     * line and stores all that data in an array of characters.
     * 
     * @author Yunseo Jeon
     * @since Mar 3 2025
     * @param characters The array of characters.
     * @param fileName   The name of the file being read
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
     * Prints out all the information for all the characters stored in the array in
     * a neat format.
     * 
     * @author Yunseo Jeon
     * @since Mar 3 2025
     * @param characters The array of characters.
     * @param numRecs    The total numbers for characters
     */
    public static void printReport(DDCharacter[] characters, int numRecs) {
        for (int i = 0; i < numRecs; i++) {
            if (characters[i].getLevel() != 0) {
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
    }

    /**
     * Writes the whole array to a binary file.
     * 
     * @author Yunseo Jeon
     * @since Mar 3 2025
     * @param characters     The array of characters.
     * @param binaryFileName The name of the new binary file
     * @param numRecs        The total numbers of characters
     * @throws IOException Throws File IO Exceptions if the file could not be
     *                     created
     */
    public static void writeNewBinaryFile(DDCharacter characters[], String binaryFileName, int numRecs)
            throws IOException {
        RandomAccessFile raf = new RandomAccessFile(binaryFileName, "rw");
        for (int i = 0; i < numRecs; i++) {
            characters[i].updateOrCreateRAF(raf, i);
        }
        raf.close();
    }

    /**
     * Reads the whole binary file and stores the information in an array and prints
     * it out.
     * 
     * @author Yunseo Jeon
     * @since Mar 7 2025
     * @param characters     The array of characters.
     * @param binaryFileName The name of the binary file being read.
     * @return The number of records found in the binary file.
     * @throws IOException Throws File IO Exceptions if the file could not be found
     *                     or read.
     */
    public static int readBinaryFile(DDCharacter characters[], String binaryFileName) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(binaryFileName, "r");
        int numRecs = (int) raf.length() / 112;
        for (int i = 0; i < numRecs; i++) {
            characters[i] = new DDCharacter();
            characters[i].readRec(raf, i);
        }
        printReport(characters, numRecs);
        raf.close();
        return numRecs;
    }

    /**
     * Updates the level for a character by a specified amount.
     * 
     * @author Yunseo Jeon
     * @since Mar 23 2025
     * @param name           The name of the character whose level is being updated
     * @param increaseLevels The amount of levels the character is getting
     * @param filename       The name of the binary file being updated
     * @param character      The array of characters
     * @param numrecs        The total number of records saved
     * @throws IOException Throws File IO Exceptions if the file could not be found
     *                     or read.
     */
    public static void updateLevel(String name, int increasedLevels, String filename, DDCharacter[] character,
            int numrecs) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(filename, "rw");

        for (int i = 0; i < numrecs; i++) {
            if (character[i].getCharacterName().equalsIgnoreCase(name)) {
                for (int j = 0; j < increasedLevels; j++) {
                    character[i].levelUp();
                }
                character[i].setLevel(character[i].getLevel() + increasedLevels);
                character[i].updateOrCreateRAF(raf, i);
                break;
            }
        }
        printReport(character, numrecs);
        raf.close();
    }

    /**
     * Updates the stats for a specific character
     * 
     * @author Yunseo Jeon
     * @since Mar 20 2025
     * @param character     The array of characters
     * @param filename      The name of the binary file being updated
     * @param str           The Strength of the new character
     * @param constitution  The constitution of the new character
     * @param intellingence The intelligence of the new character
     * @param wisdom        The wisdom of the new character
     * @param dex           The dexterity of the new character
     * @param rizz          The rizzzzz of the new character
     * @param numrecs       The total number of records saved
     * @throws IOException Throws File IO Exceptions if the file could not be found
     *                     or read.
     */
    public static void updateStats(DDCharacter[] character, String filename, String name, int str, int constitution,
            int intelligence, int wisdom, int dex, int rizz, int numrecs) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(filename, "rw");
        for (int i = 0; i < numrecs; i++) {
            System.out.println(character[i].getCharacterName());
            if (character[i].getCharacterName().equalsIgnoreCase(name)) {
                character[i].setStrength(str);
                character[i].setConstitution(constitution);
                character[i].setIntelligence(intelligence);
                character[i].setWisdom(wisdom);
                character[i].setDexterity(dex);
                character[i].setRizz(rizz);
                character[i].updateOrCreateRAF(raf, i);
                break;
            }
        }
        printReport(character, numrecs);
        raf.close();
    }

    /**
     * Changes class of a character and updates the binary file.
     * 
     * @author Yunseo Jeon
     * @since Mar 20 2025
     * @param playerClass The new class of the character.
     * @param name        The name of the character being update
     * @param filename    The name of the binary file being updated.
     * @param character   The array of characters.
     * @param numrecs     The total number of records stored.
     * @throws IOException Throws File IO Exceptions if the file could not be found
     *                     or read.
     */
    public static void changeClass(String playerClass, String name, String filename, DDCharacter[] character,
            int numrecs) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(filename, "rw");
        for (int i = 0; i < numrecs; i++) {
            if (character[i].getCharacterName().equalsIgnoreCase(name)) {
                character[i].changeClass(playerClass);
                character[i].updateOrCreateRAF(raf, i);
                break;
            }
        }
        printReport(character, numrecs);
        raf.close();
    }

    /**
     * Changes race of a character and updates the binary file.
     * 
     * @author Yunseo Jeon
     * @since Mar 21 2025
     * @param race      The new race of the character.
     * @param name      The name of the character being update
     * @param filename  The name of the binary file being updated.
     * @param character The array of characters.
     * @param numrecs   The total number of records stored.
     * @throws IOException Throws File IO Exceptions if the file could not be found
     *                     or read.
     */
    public static void changeRace(String race, String name, String filename, DDCharacter[] character, int numrecs)
            throws IOException {
        RandomAccessFile raf = new RandomAccessFile(filename, "rw");
        for (int i = 0; i < numrecs; i++) {
            if (character[i].getCharacterName().equalsIgnoreCase(name)) {
                character[i].raceSelected(race);
                character[i].updateOrCreateRAF(raf, i);
                break;
            }
        }
        printReport(character, numrecs);
        raf.close();
    }

    /**
     * Adds a completely new character to the game and updates the binary file.
     * 
     * @author Yunseo Jeon
     * @since Mar 26 2025
     * @param race        The race of the new character
     * @param playerClass The class of the new character
     * @param name        The name of the new character.
     * @param filename    The name of the binary file being updated.
     * @param character   The array of characters.
     * @param recNum      The total number of records stored.
     * @throws IOException Throws File IO Exceptions if the file could not be found
     *                     or read.
     */
    public static void addNewCharacter(String race, String playerClass, String name, String filename,
            DDCharacter characters[], int recNum) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(filename, "rw");

        characters[recNum] = new DDCharacter();
        characters[recNum].createCharacter(raf, name, race, playerClass, recNum);
        characters[recNum].updateOrCreateRAF(raf, recNum);
        raf.close();
    }

    /**
     * Deletes a character by settings their values to nothing and updates the
     * binary file.
     * file.
     * 
     * @author Yunseo Jeon
     * @since Mar 26 2025
     * @param characters The array of characters
     * @param filename   The name of the binary file being updated.
     * @param charName   The name of the character being deleted.
     * @return The number of records found in the binary file.
     * @throws IOException Throws File IO Exceptions if the file could not be found
     *                     or read.
     */
    public static int deleteCharacter(DDCharacter characters[], String filename, String charName) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(filename, "rw");
        int numrecs = (int) raf.length() / 112;

        for (int i = 0; i < numrecs; i++) {
            if (characters[i].getCharacterName().equalsIgnoreCase(charName)) {
                characters[i].deleteCharacter(charName);
                characters[i].updateOrCreateRAF(raf, i);
                System.out.println();
                System.out.println("=====================================");
                System.out.println("CHARACTER HAS BEEN REMOVED!");
                System.out.println("=====================================");
                System.out.println();
                raf.close();
            }
        }
        System.out.println("=====================================");
        System.out.println("CHARACTER NOT FOUND!");
        System.out.println("=====================================");
        raf.close();
        return -1;
    }

    /**
     * Searches for a character in the character array and prints it out.
     * 
     * @author Yunseo Jeon
     * @since Mar 26 2025
     * @param characters The array of the characters
     * @param name       The name of the character being searched
     * @param numrecs    The total number of records stored.
     * @throws IOException Throws File IO Exceptions if the file could not be found
     *                     or read.
     */
    public static void searchCharacter(DDCharacter characters[], String name, int numrecs)
            throws IOException {

        for (int i = 0; i < numrecs; i++) {
            if (characters[i].getCharacterName().equalsIgnoreCase(name)) {
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
                break;
            }
        }
        System.out.println();

    }

    public static void main(String[] args) throws IOException {

        // Initialize Variables
        Scanner scanner = new Scanner(System.in);
        DDCharacter[] characters = new DDCharacter[100];
        String fileName = ""; // The ASCII filename
        String binaryFileName = ""; // Binary File name
        int numRec = 0; // Total numbers of records.
        int choice = 0; // Choice for the switch case.
        boolean isRead = false; // Variable to check if the user has read in a file
        String nameEdit = "";
        String raceEdit = "";
        String classEdit = "";
        int levelEdit = 0;
        boolean raceDone = false;
        boolean classDone = false;
        int key = 0;

        System.out.println("============= D&D MENU 2 =============");
        System.out.println("1  - Read an ASCII File");
        System.out.println("2  - Read a random‐access file");
        System.out.println("====================================");
        key = Integer.parseInt(scanner.nextLine().trim());

        do {
            switch (key) {
                case 1:
                    System.out.println("Enter ASCII file name: ");
                    fileName = scanner.nextLine().trim();
                    numRec = readASCII(characters, fileName);
                    System.out.println("There are " + numRec + " characters in this file.");
                    isRead = true;
                    break;
                case 2:
                    System.out.println("Enter Binary File name: ");
                    binaryFileName = scanner.nextLine();
                    numRec = readBinaryFile(characters, binaryFileName);
                    System.out.println("There are " + numRec + " characters in this file.");
                    isRead = true;
                    break;
                default:
                    System.out.println("Please read in an ASCII file first!");
            }

        } while (isRead == false);
        // Do while loop for the menu
        do {
            System.out.println("============================================");
            System.out.println("Menu \n(Type in Number)");
            System.out.println(
                    "1. Read in ASCII file \n2. Print out Report\n3. Create New Binary File\n4. Read Binary File\n5. Add a new Character\n6. Delete a Character\n7. Change Race\n8. Change Class\n9. Update Level of Character\n10. Update Character Stat\n11. Search by Character Name\n12. Exit");
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
                    printReport(characters, numRec);
                    break;
                case 3: // Save all the data in a binary file by creating or updating an existing one.
                    System.out.println("Enter Binary File name:");
                    binaryFileName = scanner.nextLine().trim();
                    writeNewBinaryFile(characters, binaryFileName, numRec);
                    System.out.println("");

                    break;
                case 4: // Read in data from an existing binary file.
                    System.out.println("Enter Binary File name:");
                    binaryFileName = scanner.nextLine().trim();
                    readBinaryFile(characters, binaryFileName);
                    isRead = true;
                    break;
                case 5: // add new charcater
                    classDone = false;
                    raceDone = false;
                    System.out.println("Enter name of new character: ");
                    nameEdit = scanner.nextLine().trim();

                    while (raceDone == false) {
                        System.out.println("Human\nHalfling\nElf\nDwarf\nOrc\nGnome");
                        System.out.println("Enter race of new character: ");
                        raceEdit = scanner.nextLine().trim();
                        if (raceEdit.equalsIgnoreCase("human") || raceEdit.equalsIgnoreCase("halfling")
                                || raceEdit.equalsIgnoreCase("elf") || raceEdit.equalsIgnoreCase("dwarf")
                                || raceEdit.equalsIgnoreCase("orc") || raceEdit.equalsIgnoreCase("gnome")) {
                            raceDone = true;
                        } else {
                            System.out.println("Pick pick a valid race");
                        }
                    }

                    while (classDone == false) {
                        System.out.println("Warrior\nCleric\nBard\nRanger\nRogue\nMage");
                        System.out.println("Enter class of new character: ");
                        classEdit = scanner.nextLine().trim();
                        if (classEdit.equalsIgnoreCase("warrior") || classEdit.equalsIgnoreCase("cleric")
                                || classEdit.equalsIgnoreCase("bard") || classEdit.equalsIgnoreCase("ranger")
                                || classEdit.equalsIgnoreCase("rogue") || classEdit.equalsIgnoreCase("mage")) {
                            classDone = true;
                        } else {
                            System.out.println("Pick pick a valid class.");
                        }
                    }
                    System.out.println(binaryFileName);
                    addNewCharacter(raceEdit, classEdit, nameEdit, binaryFileName, characters, numRec);
                    numRec++;
                    printReport(characters, numRec);
                    System.out.println(nameEdit + " has been added!");
                    break;
                case 6: // delete character
                    System.out.println("Enter name of character you want to delete: ");
                    for (int i = 0; i < numRec; i++) {
                        if(characters[i].getLevel() != 0) { 
                            System.out.println(characters[i].getCharacterName());
                        }
                    }
                    nameEdit = scanner.nextLine().trim();
                    int deleteCheck = deleteCharacter(characters, binaryFileName, nameEdit);
                    if (deleteCheck == 0) {
                        numRec--;
                        System.out.println(nameEdit + " has been deleted!");
                    }
                    printReport(characters, numRec);
                    break;
                case 7: // Change race
                    raceDone = false;
                    System.out.println("Enter name of character you want to change races of: ");
                    for (int i = 0; i < numRec; i++) {
                        if(characters[i].getLevel() != 0) { 
                            System.out.println(characters[i].getCharacterName());
                        }
                    }
                    nameEdit = scanner.nextLine().trim();
                    while (raceDone == false) {
                        System.out.println("Enter race of character you want to change races of: ");
                        System.out.println("Human\nHalfling\nElf\nDwarf\nOrc\nGnome");
                        raceEdit = scanner.nextLine().trim();
                        if (raceEdit.equalsIgnoreCase("human") || raceEdit.equalsIgnoreCase("halfling")
                                || raceEdit.equalsIgnoreCase("elf") || raceEdit.equalsIgnoreCase("dwarf")
                                || raceEdit.equalsIgnoreCase("orc") || raceEdit.equalsIgnoreCase("gnome")) {
                            raceDone = true;
                        } else {
                            System.out.println("Pick pick a valid race");
                        }
                    }
                    changeRace(raceEdit, nameEdit, binaryFileName, characters, numRec);
                    System.out.println(nameEdit + "'s race has been changed to " + raceEdit);
                    break;
                case 8: // Change Class
                    classDone = false;
                    System.out.println("Enter name of character you want to change class of: ");
                    for (int i = 0; i < numRec; i++) {
                        if(characters[i].getLevel() != 0) { 
                            System.out.println(characters[i].getCharacterName());
                        }
                    }
                    nameEdit = scanner.nextLine().trim();

                    while (classDone == false) {
                        System.out.println("Warrior\nCleric\nBard\nRanger\nRogue\nMage");
                        System.out.println("Enter class you want to change it to: ");
                        classEdit = scanner.nextLine().trim();
                        if (classEdit.equalsIgnoreCase("warrior") || classEdit.equalsIgnoreCase("cleric")
                                || classEdit.equalsIgnoreCase("bard") || classEdit.equalsIgnoreCase("ranger")
                                || classEdit.equalsIgnoreCase("rogue") || classEdit.equalsIgnoreCase("mage")) {
                            classDone = true;
                        } else {
                            System.out.println("Pick pick a valid class.");
                        }

                    }
                    changeClass(classEdit, nameEdit, binaryFileName, characters, numRec);
                    System.out.println(nameEdit + "'s class has been changed to " + classEdit);
                    break;
                case 9: // Update level of character
                    System.out.println("Enter name of character you want to update level for: ");
                    for (int i = 0; i < numRec; i++) {
                        if(characters[i].getLevel() != 0) { 
                            System.out.println(characters[i].getCharacterName());
                        }
                    }
                    nameEdit = scanner.nextLine().trim();
                    System.out.println("Enter number of level(s) to increase by:");
                    levelEdit = Integer.parseInt(scanner.nextLine().trim());
                    updateLevel(nameEdit, levelEdit, binaryFileName, characters, numRec);
                    System.out.println("Updated level for " + nameEdit);
                    break;
                case 10: // Update Character Stat
                    System.out.println("Enter name of character you want to update level for: ");
                    for (int i = 0; i < numRec; i++) {
                        if(characters[i].getLevel() != 0) { 
                            System.out.println(characters[i].getCharacterName());
                        }
                    }
                    nameEdit = scanner.nextLine().trim();
                    System.out.println("What Would You Like " + nameEdit + "'s Strength to be: ");
                    int newStrength = Integer.parseInt(scanner.nextLine().trim());
                    System.out.println("What Would You Like " + nameEdit + "'s Constitution to be: ");
                    int newConst = Integer.parseInt(scanner.nextLine().trim());

                    System.out.println("What Would You Like " + nameEdit + "'s Intelligence to be: ");
                    int newInt = Integer.parseInt(scanner.nextLine().trim());

                    System.out.println("What Would You Like " + nameEdit + "'s Wisdom to be: ");
                    int newWisdom = Integer.parseInt(scanner.nextLine().trim());

                    System.out.println("What Would You Like " + nameEdit + "'s Dexterity to be: ");
                    int newDex = Integer.parseInt(scanner.nextLine().trim());

                    System.out.println("What Would You Like " + nameEdit + "'s Charisma to be: ");
                    int newCharisma = Integer.parseInt(scanner.nextLine().trim());
                    updateStats(characters, binaryFileName, nameEdit, newStrength, newConst, newInt, newWisdom, newDex,
                            newCharisma, numRec);
                    System.out.println("Updated stats for " + nameEdit);
                    break;
                case 11: // Search by Character Name
                    System.out.println("Enter name of character you want to search:");
                    for (int i = 0; i < numRec; i++) {
                        if(characters[i].getLevel() != 0) { 
                            System.out.println(characters[i].getCharacterName());
                        }
                    }
                    nameEdit = scanner.nextLine().trim();
                    searchCharacter(characters, nameEdit, numRec);
                    break;
                default:
                    if (choice != 12) {
                        System.out.println("Please choose a valid input!");
                    }
            }
        } while (choice != 12); // end
        System.out.println("Ended Program!");
        scanner.close();
        System.exit(0);
    }
}
