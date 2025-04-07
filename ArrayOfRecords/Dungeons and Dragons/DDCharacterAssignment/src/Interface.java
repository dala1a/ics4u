/*
 * @Author : Yunseo Jeon
 * @Last Modified: Mar 3 2025
 * @Description: Interface for D&D
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.Scanner;


public class Interface {
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

    public static void printReport(DDCharacter[] characters, int numRecs) throws IOException {
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

    public static void writeNewBinaryFile(DDCharacter characters[], String binaryFileName, int numRecs)
            throws IOException {
        RandomAccessFile raf = new RandomAccessFile(binaryFileName, "rw");
        for (int i = 0; i < numRecs; i++) {
            characters[i].updateOrCreateRAF(raf, i);
        }
        raf.close();
    }

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
        Scanner scanner = new Scanner(System.in);
        DDCharacter[] characters = new DDCharacter[100];
        String fileName = "";
        String binaryFileName = "";
        int numRec = 0;
        int choice = 0;
        boolean isRead = false;

        do {
            System.out.println("============================================");
            System.out.println("Menu \n(Type in Number)");
            System.out.println(
                    "1. Read in ASCII file \n2. Print out Report\n3. Create New Binary File\n4. Read Binary File");
            choice = Integer.parseInt(scanner.nextLine().trim());
            switch (choice) {
                case 1:
                    System.out.println("Enter file name: ");
                    fileName = scanner.nextLine().trim();
                    numRec = readASCII(characters, fileName);
                    System.out.println("There are " + numRec + " characters in this file.");
                    isRead = true;
                    break;
                case 2:
                    if (isRead == true) {
                        printReport(characters, numRec);
                    } else {
                        System.out.println("Please read an ASCII file first.");
                    }
                    break;
                case 3:
                    if (isRead == true) {
                        System.out.println("Enter Binary File name:");
                        binaryFileName = scanner.nextLine().trim();
                        writeNewBinaryFile(characters, binaryFileName, numRec);
                        System.out.println("");
                    } else {
                        System.out.println("Please read an ASCII file first.");
                    }
                    break;
                case 4:
                    System.out.println("Enter Binary File name:");
                    binaryFileName = scanner.nextLine().trim();
                    readBinaryFile(characters, binaryFileName);
                default:
                    if (choice != 5) {
                        System.out.println("Please choose a valid input!");
                    }
            }
        } while (choice != 5);
        System.out.println("Ended Program!");
        scanner.close();
    }
}
