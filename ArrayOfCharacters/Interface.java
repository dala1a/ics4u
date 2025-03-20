package ArrayOfCharacters;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Interface {

    public static int readASCII(String filename, DDCharacter characters[]) { 
        int i = 0; 
        try { 
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
            while (in.ready() == true) {
                    characters[i] = new DDCharacter();
                    characters[i].setCharacterName(in.readLine());
                    characters[i].setRace(in.readLine());
                    characters[i].setPlayerClass(in.readLine());
                    characters[i].setLevel(Integer.parseInt(in.readLine()));
                    characters[i].setHitPoints(Integer.parseInt(in.readLine()));
                    characters[i].setStrength(Integer.parseInt(in.readLine()));
                    characters[i].setConstitution(Integer.parseInt(in.readLine()));
                    characters[i].setIntelligence(Integer.parseInt(in.readLine()));
                    characters[i].setWisdom(Integer.parseInt(in.readLine()));
                    characters[i].setDexterity(Integer.parseInt(in.readLine()));
                    characters[i].setCharisma(Integer.parseInt(in.readLine()));
                    i++;
            } // End loop

            in.close();
        } catch (IOException e) {}
        return i; 
    }

    public static void printOutData(String filename, DDCharacter printCharacters[]) throws IOException {
	    RandomAccessFile raf = new RandomAccessFile(filename, "r");
	    int numrecs = (int) raf.length() / 112;
	    System.out.println("=============================================================================================================================================");
	    System.out.format("%-25s %-15s %-15s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s", "Name", "Race", "Class", "Lvl", "HP", "Str", "Const", "Int", "Wisdom", "Dex", "Chr");
	    System.out.println();
	    System.out.println();
	    for (int i = 0; i < numrecs; i++) {
	      if(printCharacters[i].getLevel() == 0)
	      printCharacters[i].readRec(raf, i);
	      if(printCharacters[i].getLevel() != 0) {
	      System.out.format("%-25s %-15s %-15s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s", printCharacters[i].getCharacterName(), printCharacters[i].getRace(), printCharacters[i].getPlayerClass(), printCharacters[i].getLevel(), printCharacters[i].getHitPoints(), printCharacters[i].getStrength(), printCharacters[i].getConstitution(), printCharacters[i].getIntelligence(), printCharacters[i].getWisdom(), printCharacters[i].getDexterity(), printCharacters[i].getCharisma() + "\n");
	      System.out.println();
	      }    
	    }
	    System.out.println("=============================================================================================================================================");
	    System.out.println();
    } 

    public static void writeNewBinFile(String filename, DDCharacter outCharacter[], int numrecs) throws IOException { 
        RandomAccessFile raf = new RandomAccessFile(filename, "rw");
        for(int i = 0; i < numrecs; i++) { 
            outCharacter[i].updateOrCreateRaf(raf, i); 
        }
        raf.close();
    }   

    public static void addNewCharacter(Scanner sc, String race, String playerClass, String name, String filename, DDCharacter outCharacter[], int numrecs) throws IOException { 
        RandomAccessFile raf = new RandomAccessFile(filename, "rw");
 
	    for (int i = 0; i < numrecs; i++) {
		      if(outCharacter[i].getLevel() == 0) { 
                outCharacter[i].updateOrCreateRaf(raf, i);
              }
	    }
	    outCharacter[numrecs] = new DDCharacter();
	    outCharacter[numrecs].createCharacter(sc, race, playerClass, name, raf, numrecs);
    }

    public static int readNewBinFile(String filename, DDCharacter inCharacter[]) throws IOException {
	    RandomAccessFile raf = new RandomAccessFile(filename, "r");
	    int numrecs = (int) raf.length() / 112;

        System.out.println(numrecs);

	    System.out.println();
	    System.out.println("=============================================================================================================================================");
	    System.out.format("%-25s %-15s %-15s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s", "Name", "Race", "Class", "Lvl", "HP", "Str", "Const", "Int", "Wisdom", "Dex", "Chr");
	    System.out.println();
	    System.out.println();
	    for (int i = 0; i < numrecs; i++) {
            inCharacter[i] = new DDCharacter();
            inCharacter[i].readRec(raf, i);
            if(inCharacter[i].getLevel() != 0) {
                System.out.format("%-25s %-15s %-15s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s", inCharacter[i].getCharacterName(), inCharacter[i].getRace(), inCharacter[i].getPlayerClass(), inCharacter[i].getLevel(), inCharacter[i].getHitPoints(), inCharacter[i].getStrength(), inCharacter[i].getConstitution(), inCharacter[i].getIntelligence(), inCharacter[i].getWisdom(), inCharacter[i].getDexterity(), inCharacter[i].getCharisma() + "\n");
                System.out.println();
            }    
	    } //end for	
	    System.out.println("=============================================================================================================================================");
	    raf.close();
	    System.out.println();
	    System.out.println("--- End Of File ---");
	    return numrecs;
	  } // end writeNewBinFile

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
	    DDCharacter[] character = new DDCharacter[100];
        int key = 0;
        String textFileName = ""; 
        String binFileName = ""; 
        String binaryFile = ""; 
        int recs = 0; 

        boolean initialInput = false; 

        System.out.println("============= D&D MENU 2 =============");
	    System.out.println("1  - Read an ASCII File");
	    System.out.println("2  - Read a random‐access file");
	    System.out.println("====================================");
	    key = Integer.parseInt(sc.nextLine().trim());

        do { 
            switch (key) {
                case 1:
                    System.out.println("Please input ASCII File Name: ");
                    textFileName = sc.nextLine(); 
                    recs = readASCII(textFileName, character); 
                    System.out.println("Your File Has Been Read!");  
                    initialInput = true;           
                    break;
                case 2: 
                    System.out.println("Please enter a Binary file name to read");
                    binFileName = sc.nextLine();
                    recs = readNewBinFile(binFileName, character);
                    binaryFile = binFileName; 
                    System.out.println("Your File Has Been Read");
                    initialInput = true; 
                break;
                
                default: 
                    System.out.println("Please enter a valid Input");
            }
        } while (initialInput == false);

        do { 
            System.out.println("============= D&D MENU 2 =============");
	        System.out.println("1  - Read a new ASCII File");
	        System.out.println("2  - Read a random‐access file");
	        System.out.println("3  - Convert to Binary File");
	        System.out.println("4  - Print All Characters");
	        System.out.println("5  - Add a new Character");
	        System.out.println("6  - Delete by Character name");
	        System.out.println("7  - Change Race");
	        System.out.println("8  - Change Class");
	        System.out.println("9  - Update Level of Character");
	        System.out.println("10 - Update Character Stat");
	        System.out.println("11 - Search by Character Name");
	        System.out.println("12 - Quit");
	        System.out.println("====================================");
	        key = Integer.parseInt(sc.nextLine().trim());
	        System.out.println();

            switch (key) {
                case 1: 
                    System.out.println("Please enter a file name to read");
                    textFileName = sc.nextLine();
                    recs = readASCII(textFileName, character);
                    readASCII(textFileName, character);
                    System.out.println("Your File Has Been Read!");
                    System.out.println();
                break;
                
                case 2: 
                    System.out.println("Please enter a Binary file name to read");
                    binFileName = sc.nextLine();
                    recs = readNewBinFile(binFileName, character);
                    System.out.println("Your File Has Been Read");
                    System.out.println();
                break; 

                case 3: 
                    System.out.println("Please enter a Binary file name to write to");
                    binFileName = sc.nextLine();
                    writeNewBinFile(binFileName, character, recs);
                    binaryFile = binFileName; 
                    System.out.println("Your File Has Been Written to: " + binFileName);
                    System.out.println();
                break; 

                case 4: 
                    printOutData(binaryFile, character);
                break; 

                // case 5: 1

            }
        } while (initialInput == true);
        
    }

}
