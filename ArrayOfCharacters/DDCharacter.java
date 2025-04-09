package ArrayOfCharacters;



/*
 * @Author : Yunseo Jeon
 * @Last Modified: Mar 7 2025
 * @Description: All methods regarding characters and their characteristics in D&D
 */

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class DDCharacter {
    private String characterName; // 40 Bytes (20 Characters)
    private String race; // 20 Bytes (10 Characters)
    private String playerClass; // 20 Bytes (10 Characters)
    private int level; // 4 Bytes
    private int hitPoints; // 4 Bytes
    private int strength; // 4 Bytes
    private int constitution; // 4 Bytes
    private int intelligence; // 4 Bytes
    private int wisdom; // 4 Bytes
    private int dexterity; // 4 Bytes
    private int charisma; // 4 Bytes
    private final long recLen = 112; // Length of all records

    // Constructor
    public DDCharacter(String characterName, String race, String playerClass, int level, int hitPOints, int strength,
            int constitution, int intelligence, int wisdom, int dexterity, int charisma) {
        this.characterName = characterName;
        this.race = race;
        this.playerClass = playerClass;
        this.level = level;
        this.hitPoints = hitPOints;
        this.strength = strength;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.dexterity = dexterity;
        this.charisma = charisma;
    }

    // Default Constructor
    public DDCharacter() {
        characterName = "";
        race = "";
        playerClass = "";
        level = 1;
        hitPoints = 0;
        strength = 0;
        constitution = 0;
        intelligence = 0;
        wisdom = 0;
        dexterity = 0;
        charisma = 0;
    }

    /**
     * A setter for the character's characterName
     * 
     * @author Yunseo Jeon
     * @since Mar 3 2025
     * @param characterName A setter for the character name.
     */
    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    /**
     * A setter for the character's race
     * 
     * @author Yunseo Jeon
     * @since Mar 3 2025
     * @param race A setter for the character race.
     */
    public void setRace(String race) {
        this.race = race;
    }

    /**
     * A setter for the character's class
     * 
     * @author Yunseo Jeon
     * @since Mar 3 2025
     * @param playerClass A setter for the character class.
     */
    public void setClass(String playerClass) {
        this.playerClass = playerClass;
    }

    /**
     * A setter for the character's level
     * 
     * @author Yunseo Jeon
     * @since Mar 3 2025
     * @param level A setter for the character's level.
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * A setter for the character's hitPoints stat
     * 
     * @author Yunseo Jeon
     * @since Mar 3 2025
     * @param newHitPoints A setter for the character's hitpoints.
     */
    public void setHitPoints(int newHitPoints) {
        this.hitPoints = newHitPoints;
    }

    /**
     * A setter for the character's strength stat
     * 
     * @author Yunseo Jeon
     * @since Mar 3 2025
     * @param strength A setter for the character's strength.
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }

    /**
     * A setter for the character's constitution stat
     * 
     * @author Yunseo Jeon
     * @since Mar 3 2025
     * @param constitution A setter for the character's constitution.
     */
    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    /**
     * A setter for the character's intelligence stat
     * 
     * @author Yunseo Jeon
     * @since Mar 3 2025
     * @param intelligence A setter for the character's intelligence.
     */
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    /**
     * A setter for the character's wisdom stat
     * 
     * @author Yunseo Jeon
     * @since Mar 3 2025
     * @param wisdom A setter for the character's wisdom.
     */
    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    /**
     * A setter for the character's dexterity stat
     * 
     * @author Yunseo Jeon
     * @since Mar 3 2025
     * @param dexterity A setter for the character's dex.
     */
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    /**
     * A setter for the character's charisma stat
     * 
     * @author Yunseo Jeon
     * @since Mar 3 2025
     * @param charisma A setter for the character's charisma.
     */
    public void setRizz(int charisma) {
        this.charisma = charisma;
    }

    /**
     * A getter for the character's name
     * 
     * @author Yunseo Jeon
     * @since Mar 3 2025
     * @return The Character name
     */
    public String getCharacterName() {
        return this.characterName;
    }

    /**
     * A getter for the character's race
     * 
     * @author Yunseo Jeon
     * @since Mar 3 2025
     * @return The Character race
     */
    public String getRace() {
        return this.race;
    }

    /**
     * A getter for the character's class
     * 
     * @author Yunseo Jeon
     * @since Mar 3 2025
     * @return The Character Class
     */
    public String getPlayerClass() {
        return this.playerClass;
    }

    /**
     * A getter for the character's level
     * 
     * @author Yunseo Jeon
     * @since Mar 3 2025
     * @return The Character's level
     */
    public int getLevel() {
        return this.level;
    }

    /**
     * A getter for the character's hitPoints stat
     * 
     * @author Yunseo Jeon
     * @since Mar 3 2025
     * @return The Character's hitpoints
     */
    public int getHitPoints() {
        return this.hitPoints;
    }

    /**
     * A getter for the character's strength stat
     * 
     * @author Yunseo Jeon
     * @since Mar 3 2025
     * @return The Character's strength
     */
    public int getStrength() {
        return this.strength;
    }

    /**
     * A getter for the character's constitution stat
     * 
     * @author Yunseo Jeon
     * @since Mar 3 2025
     * @return The Character's constitution
     */
    public int getConstitution() {
        return this.constitution;
    }

    /**
     * A getter for the character's intelligence stat
     * 
     * @author Yunseo Jeon
     * @since Mar 3 2025
     * @return The Character's intelligence
     */
    public int getIntelligence() {
        return this.intelligence;
    }

    /**
     * A getter for the character's wisdom stat
     * 
     * @author Yunseo Jeon
     * @since Mar 3 2025
     * @return The Character's wisdom
     */
    public int getWisdom() {
        return this.wisdom;
    }

    /**
     * A getter for the character's dexterity stat
     * 
     * @author Yunseo Jeon
     * @since Mar 3 2025
     * @return The Character's dexterity
     */
    public int getDexterity() {
        return this.dexterity;
    }

    /**
     * A getter for the character's charisma stat
     * 
     * @author Yunseo Jeon
     * @since Mar 3 2025
     * @return The Character's charisma
     */
    public int getCharisma() {
        return this.charisma;
    }

    /**
     * Generates a random numbers between 1 and the max provided by the user.
     * 
     * @author Yunseo Jeon
     * @since Mar 3 2025
     * @param max The number of sides the dice has.
     * @return A random number between 1 and the max number of sides inputted.
     */
    public int getDiceRoll(int max) {
        Random rand = new Random(); // Create a Random object
        int result = rand.nextInt(max) + 1; // Generate a random number between 1 and max (inclusive)
        return result;
    }

    /**
     * Create or updates an existing binary file record. Adds padding to string
     * variables and writes it all out to a binary file.
     * 
     * @author Yunseo Jeon
     * @since Mar 3 2025
     * @param raf    The binary file being read in.
     * @param recNum The record Number to which the pointer should jump to.
     * @throws IOException Throws an Exception if the file could not be read or
     *                     found.
     */
    public void updateOrCreateRAF(RandomAccessFile raf, int recNum) throws IOException {
        raf.seek(recNum * recLen); // move pointer to position in file
        int nameLength = characterName.length(); // determine if there are more than 20 characters
        int raceLength = race.length();
        int classLength = playerClass.length();
        int paddingLength = 0; // calculate the number of blanks that need to be

        // NAME PADDING
        if (nameLength > 20) {
            nameLength = 20; // maintain a length of 20
        } else {
            paddingLength = 20 - nameLength;
        }

        for (int i = 0; i < characterName.length(); i++) { // write the name
            raf.writeChar(characterName.charAt(i));
        }

        if (paddingLength > 0) { // write the extra blanks
            for (int i = 0; i < paddingLength; i++) {
                raf.writeChar(' ');
            }
        }

        // RACE PADDING
        paddingLength = 0;
        if (raceLength > 10) {
            raceLength = 10; // maintain a length of 20
        } else {
            paddingLength = 10 - raceLength;
        }

        for (int i = 0; i < race.length(); i++) { // write the race
            raf.writeChar(race.charAt(i));
        }

        if (paddingLength > 0) { // write the extra blanks
            for (int i = 0; i < paddingLength; i++) {
                raf.writeChar(' ');
            }
        }

        // CLASS PADDING
        paddingLength = 0;
        if (classLength > 10) {
            classLength = 10; // maintain a length of 20
        } else {
            paddingLength = 10 - classLength;
        }

        for (int i = 0; i < playerClass.length(); i++) { // write the race
            raf.writeChar(playerClass.charAt(i));
        }

        if (paddingLength > 0) { // write the extra blanks
            for (int i = 0; i < paddingLength; i++) {
                raf.writeChar(' ');
            }
        }
        // write everything else to RAF
        raf.writeInt(level);
        raf.writeInt(hitPoints);
        raf.writeInt(strength);
        raf.writeInt(constitution);
        raf.writeInt(intelligence);
        raf.writeInt(wisdom);
        raf.writeInt(dexterity);
        raf.writeInt(charisma);
    }

    /**
     * Reads a record from a binary file and stores all that data.
     * 
     * @author Yunseo Jeon
     * @since Mar 3 2025
     * @param raf    The binary file being read in.
     * @param recNum The record Number to which the pointer should jump to.
     * @throws IOException Throws an Exception if the file could not be read or
     *                     found.
     */
    public void readRec(RandomAccessFile raf, int recNum) throws IOException {
        raf.seek(recNum * recLen);
        String temp = "";
        for (int i = 0; i < 20; i++) {
            temp = temp + raf.readChar();
        }
        characterName = temp.trim();
        temp = "";
        for (int i = 0; i < 10; i++) {
            temp = temp + raf.readChar();
        }

        race = temp.trim();
        temp = "";
        for (int i = 0; i < 10; i++) {
            temp = temp + raf.readChar();
        }
        playerClass = temp.trim();

        // read the long and doubles from the file
        setLevel(raf.readInt());
        setHitPoints(raf.readInt());
        setStrength(raf.readInt());
        setConstitution(raf.readInt());
        setIntelligence(raf.readInt());
        setWisdom(raf.readInt());
        setDexterity(raf.readInt());
        setRizz(raf.readInt());
    }


    /**
     * Generates random stats for a character using a six sided dice. 
     * @author Yunseo Jeon
     * @since Mar 15 2025
     * @return The randomly generated stats of an attribute by rolling 4 6 sided dices.  
     */
    public int randomStatGen() {
        int rolls[] = new int[4];
        int total = 0;
        int smallest = 0;
        for (int i = 0; i < rolls.length; i++) {
            rolls[i] = getDiceRoll(6);
            total += rolls[i];
        }

        smallest = rolls[0];
        for (int i = 0; i < rolls.length; i++) {
            if (rolls[i] < smallest) {
                smallest = rolls[i];
            }
        }
        return total - smallest;
    }

    /**
     * Levels up a character and rolls the new hitpoints for it based on their class. (Updates the binary file at the end)
     * @author Yunseo Jeon
     * @since Mar 21 2025
     * @param raf    The binary file being read in.
     * @param recordNum The record Number to which the pointer should jump to.
     * @throws IOException Throws an Exception if the file could not be read or
     *                     found.
     */
    public void levelUp() throws IOException {
        System.out.println("sigma");
        switch (playerClass) {
            case "Warrior":
                hitPoints += getDiceRoll(10);
                break;
            case "Cleric":
                hitPoints += getDiceRoll(8);
                break;
            case "Bard", "Ranger", "Rogue":
                hitPoints += getDiceRoll(6);
                break;
            case "Mage":
                hitPoints += getDiceRoll(4);
                break;
            default:
                System.out.println("No Hitpoints Added");
                break;
        }
        // updateOrCreateRAF(raf, recordNum);
    }


    /**
     * Changes the class of a character and also rerolls their hitpoints based on what class they picked (Updates the binary file at the end)
     * @author Yunseo Jeon
     * @since Mar 21 2025
     * @param raf    The binary file being read in.
     * @param newClass The new class of the character
     * @param recordNum The record Number to which the pointer should jump to.
     * @throws IOException Throws an Exception if the file could not be read or
     *                     found.
     */
    public void changeClass(String newClass) throws IOException {
        setClass(newClass);
        System.out.println(level);
        for (int i = 0; i < level; i++) {
            levelUp();
        }
    }

    /**
     * A helper method used to remove any race modifiers a character has to then change their race. 
     * @author Yunseo Jeon
     * @since Mar 21 2025
     */
    public void removeRaceModifiers() {
        switch (race) {
            case "Halfling":
                dexterity -= 2;
                constitution -= 1;
                break;

            case "Elf":
                dexterity -= 3;
                constitution += 2;
                break;

            case "Dwarf":
                constitution -= 3;
                break;

            case "Orc":
                strength -= 3;
                constitution -= 1;
                break;

            case "Gnome":
                intelligence -= 2;
                wisdom -= 1;
                strength += 3;
                break;

            default:
                System.out.println("Could not remove Stat Adjustments");
                break;
        }
    }

    /**
     * Changes the race of a character and updates their race modifiers. 
     * @author Yunseo Jeon
     * @since Mar 21 2025
     * @param newRace The new race of the character
     * @param recordNum The record Number to which the pointer should jump to.
     * @throws IOException Throws an Exception if the file could not be read or
     *                     found.
     */
    public void raceSelected(String newRace) throws IOException {
        removeRaceModifiers();
        setRace(newRace);

        switch (race) {
            case "Halfling":
                dexterity += 2;
                constitution += 1;
                break;

            case "Elf":
                dexterity += 3;
                constitution -= 2;
                break;

            case "Dwarf":
                constitution += 3;
                break;

            case "Orc":
                strength += 3;
                constitution += 1;
                break;

            case "Gnome":
                intelligence += 2;
                wisdom += 1;
                strength -= 3;
                break;

            default:
                System.out.println("Could not remove Stat Adjustments");
                break;
        }
    }

    /**
     * Creates a new character and updates the binary file. 
     * @author Yunseo Jeon
     * @since Mar 21 2025
     * @param raf    The binary file being read in.
     * @param name The name of the character
     * @param race The race of the new character. 
     * @param playerClass The class of the new Character. 
     * @param recordNum The record Number to which the pointer should jump to.
     * @throws IOException Throws an Exception if the file could not be read or
     *                     found.
     */
    public void createCharacter(RandomAccessFile raf, String name, String race, String playerClass, int recordNum)
            throws IOException {
        setCharacterName(name);
        changeClass(capitalize(playerClass));
        raceSelected(capitalize(race));

        raf.seek(recordNum * recLen); // move pointer to position in file
        int nameLen = characterName.length(); // determine if there are more than 20 characters
        int padLen = 0; // calculate the number of blanks that need to be
        if (nameLen > 20) // added to maintain a length of 20
            nameLen = 20;
        else
            padLen = 20 - nameLen;
        for (int i = 0; i < characterName.length(); i++) // write the name
            raf.writeChar(characterName.charAt(i));
        if (padLen > 0) { // write the extra blanks
            for (int i = 0; i < padLen; i++)
                raf.writeChar(' ');
        }

        // repeat for Race
        // ---------------------------------------------------
        nameLen = race.length();
        padLen = 0;
        if (nameLen > 10)
            nameLen = 10;
        else
            padLen = 10 - nameLen;
        for (int i = 0; i < race.length(); i++)
            raf.writeChar(race.charAt(i));
        if (padLen > 0) {
            for (int i = 0; i < padLen; i++)
                raf.writeChar(' ');
        }

        // repeat for Class
        // ---------------------------------------------------
        nameLen = playerClass.length();
        padLen = 0;
        if (nameLen > 10)
            nameLen = 10;
        else
            padLen = 10 - nameLen;
        for (int i = 0; i < playerClass.length(); i++)
            raf.writeChar(playerClass.charAt(i));
        if (padLen > 0) {
            for (int i = 0; i < padLen; i++)
                raf.writeChar(' ');
        }

        // Set their stats
        setStrength(randomStatGen());
        setConstitution(randomStatGen());
        setIntelligence(randomStatGen());
        setWisdom(randomStatGen());
        setDexterity(randomStatGen());
        setRizz(randomStatGen());

        // Update the raf file. 
        raf.writeInt(level);
        raf.writeInt(hitPoints);
        raf.writeInt(strength);
        raf.writeInt(constitution);
        raf.writeInt(intelligence);
        raf.writeInt(wisdom);
        raf.writeInt(dexterity);
        raf.writeInt(charisma);
    }

    /**
     * Sets all the character attributes to nothing to delete a character
     * @author Yunseo Jeon
     * @since Mar 21 2025
     * @throws IOException Throws an Exception if the file could not be read or
     *                     found.
     */
    public void deleteCharacter(String name) throws IOException {
        characterName = "";
        playerClass = "";
        race = "";
        level = 0;
        hitPoints = 0;
        strength = 0;
        constitution = 0;
        intelligence = 0;
        wisdom = 0;
        dexterity = 0;
        charisma = 0;
    }

    /**
     * Method used to update all the stats of a character. 
     * @author Yunseo Jeon
     * @since Mar 21 2025
     * @throws IOException Throws an Exception if the file could not be read or
     *                     found.
     */
    public void updateCharacterStat(RandomAccessFile raf, int recNum, String name, int Strength, int Constitution, int Intelligence,
            int Wisdom, int Dexterity, int rizz) throws IOException {
        strength = Strength;
        constitution = Constitution;
        intelligence = Intelligence;
        wisdom = Wisdom;
        dexterity = Dexterity;
        charisma = rizz;
    }

    private static final String capitalize(String str) {  
        if (str == null || str.length() == 0) return str;  
        return str.substring(0, 1).toUpperCase() + str.substring(1);  
    } 
}
