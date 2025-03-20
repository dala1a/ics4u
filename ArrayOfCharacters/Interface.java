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

        for (int i = 0; i < numrecs; i++) {
            inCharacter[i] = new DDCharacter();
            inCharacter[i].readRec(raf, i); 
	    } //end for	
        printOutData(filename, inCharacter);
        raf.close();
	    System.out.println();
	    System.out.println("--- End Of File ---");
	    return numrecs;
    } // end writeNewBinFile

    public static void deleteCharacter(DDCharacter characters[], String filename, String charName) throws IOException { 
        RandomAccessFile raf = new RandomAccessFile(filename, "rw");
	    int numrecs = (int) raf.length() / 112;

	    for (int i = 0; i < numrecs; i++) {
		   characters[i].deleteCharacter(raf, charName, i);    
           characters[i].updateOrCreateRaf(raf, i); 
	    }
	    System.out.println();
	    System.out.println("=============================================================================================================================================");
	    System.out.println("CHARACTER HAS BEEN REMOVED!");
	    System.out.println("=============================================================================================================================================");
	    System.out.println();
	    raf.close();
    }

    public static void changeRace(String race, String name, String filename, DDCharacter[] character, int numrecs) throws IOException { 
        RandomAccessFile raf = new RandomAccessFile(filename, "rw");
	    for (int i = 0; i < numrecs; i++) {
            if(character[i].getCharacterName().equalsIgnoreCase(name)) { 
                character[i].changeRace(race, raf, i);
                character[i].updateOrCreateRaf(raf, i);
                break;
            }   
	    }
        printOutData(filename, character);
	    raf.close();
    }

    public static void classChanger(String playerClass, String name, String filename, DDCharacter[] character, int numrecs) throws IOException {
	    RandomAccessFile raf = new RandomAccessFile(filename, "rw");
	    for (int i = 0 ; i < numrecs; i++) {
            if(character[i].getCharacterName().equalsIgnoreCase(name)) { 
                character[i].changeClass(playerClass, raf, i);
                character[i].updateOrCreateRaf(raf, i);
                break;     
            }
	    }
        printOutData(filename, character);
        raf.close();
    }

    public static void updateLevel(String name, int level, String filename, DDCharacter[] character, int numrecs) throws IOException {
	    RandomAccessFile raf = new RandomAccessFile(filename, "rw");

        for (int i = 0; i < level; i++) {
	      System.out.println("You Have Leveled Up!");
	    }

	    for (int i = 0; i < numrecs; i++) {
            if(character[i].getCharacterName().equalsIgnoreCase(name)) { 
                character[i].levelUp(raf, i, level);
                character[i].updateOrCreateRaf(raf, i);   
                break; 
            }
	    }
        printOutData(filename, character);
	    raf.close();
    }

    public static void updateStats(DDCharacter[] character, String filename, String name, int str, int constitution, int intelligence, int wisdom, int dex, int rizz, int numrecs) throws IOException { 
        RandomAccessFile raf = new RandomAccessFile(filename, "rw");
        for (int i = 0 ; i < numrecs; i++) {
            System.out.println(character[i].getCharacterName());
            if(character[i].getCharacterName().equalsIgnoreCase(name)) { 
                character[i].setStrength(str);
                character[i].setConstitution(constitution);
                character[i].setIntelligence(intelligence);
                character[i].setWisdom(wisdom);
                character[i].setDexterity(dex);
                character[i].setCharisma(rizz);
                break; 
            }
          character[i].updateOrCreateRaf(raf, i); 
        }
        printOutData(filename, character);
        raf.close();
    }   

    public static void searchCharacter(DDCharacter characters[], String filename, String name, int numrecs) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(filename, "r");
        System.out.println("=============================================================================================================================================");
	    System.out.format("%-25s %-15s %-15s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s", "Name", "Race", "Class", "Lvl", "HP", "Str", "Const", "Int", "Wisdom", "Dex", "Chr");
	    System.out.println();
	    System.out.println();  
        for (int i = 0; i < numrecs; i++) {
            if(characters[i].getCharacterName().equalsIgnoreCase(name)) { 
                System.out.format("%-25s %-15s %-15s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s", characters[i].getCharacterName(), characters[i].getRace(), characters[i].getPlayerClass(), characters[i].getLevel(), characters[i].getHitPoints(), characters[i].getStrength(), characters[i].getConstitution(), characters[i].getIntelligence(), characters[i].getWisdom(), characters[i].getDexterity(), characters[i].getCharisma() + "\n");
                System.out.println();
                break; 
            }
        }
        System.out.println("=============================================================================================================================================");
	    System.out.println();
          raf.close();
    }

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

                case 5: 
                    String race = "s"; 
                    String playerClass = ""; 

                    System.out.println("Please enter your character name: ");
                    String characterName = sc.nextLine(); 
                    System.out.println();
                    boolean raceDone = false;
                    boolean classDone = false; 

                    while(!raceDone) { 
                        System.out.println("Human:		No Stat Adjustments (Hard Mode)");
                        System.out.println("Halfling:	Dex + 2, Con + 1");
                        System.out.println("Elf:		Dex + 3, Con ‐ 2");
                        System.out.println("Dwarf:		Con + 3");
                        System.out.println("Orc:		Str + 3, Con + 1");
                        System.out.println("Gnome:		Int + 2, Wis +1, Str ‐3");
                        System.out.print("Please Pick a Race: ");
                        race = sc.nextLine(); 
                        System.out.println();
                        if (race.equalsIgnoreCase("human") || race.equalsIgnoreCase("halfling") || race.equalsIgnoreCase("elf") || race.equalsIgnoreCase("dwarf") || race.equalsIgnoreCase("orc") || race.equalsIgnoreCase("gnome")) {
                            raceDone = true;
                          } else {
                            System.out.println("ERROR!!! The Race You Picked Does Not Exist Please Pick Another.");
                          }
                    }

                    while(!classDone) { 
                        System.out.println("Warrior");
                        System.out.println("Cleric");
                        System.out.println("Bard");
                        System.out.println("Ranger");
                        System.out.println("Rogue");
                        System.out.println("Mage");
                        System.out.print("Please Pick a Class: ");
                        playerClass = sc.nextLine(); 
                        System.out.println();
                        if (playerClass.equalsIgnoreCase("warrior") || playerClass.equalsIgnoreCase("cleric") || playerClass.equalsIgnoreCase("bard") || playerClass.equalsIgnoreCase("ranger") || playerClass.equalsIgnoreCase("rogue") || playerClass.equalsIgnoreCase("mage")) {
                            classDone = true;
                          } else {
                            System.out.println("ERROR!!! The Class You Picked Does Not Exist Please Pick Another.");
                          }
                    }

                    addNewCharacter(sc, race, playerClass, characterName, binaryFile, character, recs);
                    recs++; 
                break;

                case 6: 
                    System.out.println("Please enter the character you would like to delete: ");
                    String charName = sc.nextLine(); 

                    deleteCharacter(character, binaryFile, charName);
                break; 

                case 7: 
                    characterName = "";    
                    race = "";  
                    System.out.println("Which Character's Race Would You Like to Change: ");
                    characterName = sc.nextLine(); 

                    raceDone = false; 
                    while (!raceDone) {
                        System.out.println("Human:		No Stat Adjustments (Hard Mode)");
                        System.out.println("Halfling:	    Dex + 2, Con + 1");
                        System.out.println("Elf:		    Dex + 3, Con ‐ 2");
                        System.out.println("Dwarf		    Con + 3");
                        System.out.println("Orc:		    Str + 3, Con + 1");
                        System.out.println("Gnome:		Int + 2, Wis +1, Str ‐3");
                        System.out.print("Please Pick a Race: ");
                        race = sc.nextLine();
                        System.out.println();
                        if (race.equalsIgnoreCase("human") || race.equalsIgnoreCase("halfling") || race.equalsIgnoreCase("elf") || race.equalsIgnoreCase("dwarf") || race.equalsIgnoreCase("orc") || race.equalsIgnoreCase("gnome")) {
                            raceDone = true;
                        } else {
                          System.out.println("ERROR!!! The Race You Picked Does Not Exist Please Pick Another.");
                        }
                    }

                    changeRace(race, characterName, binaryFile, character, recs); 
                break; 

                case 8: 
                    characterName = ""; 
                    playerClass = "";     
                    System.out.println("Which Character's Class Would You Like to Change: ");
                    characterName = sc.nextLine(); 
                    
                    classDone = false; 

                    while (!classDone) {
                        System.out.println("Warrior");
                        System.out.println("Cleric");
                        System.out.println("Bard");
                        System.out.println("Ranger");
                        System.out.println("Rogue");
                        System.out.println("Mage");
                        System.out.print("Please Pick a Class: ");
                        playerClass = sc.nextLine();
                        System.out.println();
                        if (playerClass.equalsIgnoreCase("warrior") || playerClass.equalsIgnoreCase("cleric") || playerClass.equalsIgnoreCase("bard") || playerClass.equalsIgnoreCase("ranger") || playerClass.equalsIgnoreCase("rogue") || playerClass.equalsIgnoreCase("mage")) {
                          classDone = true;
                        } else {
                          System.out.println("ERROR!!! The Class You Picked Does Not Exist Please Pick Another.");
                        }
                      }
                      classChanger(playerClass, characterName, binaryFile, character,recs);
                    break; 

                    case 9: 
                        characterName = ""; 
                        System.out.println("Which Character's Level Would You Like 7 Change: ");
                        characterName = sc.nextLine();
        
                        System.out.println("What Level Would You Like Your Character to be: ");
                        int level = Integer.parseInt(sc.nextLine().trim());

                        updateLevel(characterName, level, binaryFile, character, recs);
                    break; 

                    case 10: 
                        characterName = ""; 
                        System.out.println("Which Character's Stats Would You Like to Update: ");
                        characterName = sc.nextLine();
        
                        System.out.println("What Would You Like " + characterName + "'s Strength to be: ");
                        int newStrength = Integer.parseInt(sc.nextLine().trim());
                        System.out.println("What Would You Like " + characterName + "'s Constitution to be: ");
                        int newConst = Integer.parseInt(sc.nextLine().trim());
        
                        System.out.println("What Would You Like " + characterName + "'s Intelligence to be: ");
                        int newInt = Integer.parseInt(sc.nextLine().trim());
        
                        System.out.println("What Would You Like " + characterName + "'s Wisdom to be: ");
                        int newWisdom = Integer.parseInt(sc.nextLine().trim());
        
                        System.out.println("What Would You Like " + characterName + "'s Dexterity to be: ");
                        int newDex = Integer.parseInt(sc.nextLine().trim());
        
                        System.out.println("What Would You Like " + characterName + "'s Charisma to be: ");
                        int newCharisma = Integer.parseInt(sc.nextLine().trim());

                        updateStats(character, binaryFile, characterName, newStrength, newConst, newInt, newWisdom, newDex, newCharisma, recs);
                    break; 

                    case 11: 
                        characterName = " "; 
                        System.out.println("Which Character Would You Like to Search For: ");
                        characterName = sc.nextLine(); 

                        searchCharacter(character, binaryFile, characterName, recs);
                    break; 

                    case 12: 
                        System.out.println("Ending Program.......");
                        System.exit(0);
                    
                    default: 
                        System.out.println("Please Select a Valid Option!");
                    
                      
            }
        } while (initialInput == true);
        
    }

}
