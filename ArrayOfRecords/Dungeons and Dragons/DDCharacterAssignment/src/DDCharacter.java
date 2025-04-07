/*
 * @Author : Yunseo Jeon
 * @Last Modified: Mar 3 2025
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
    private final long recLen = 112; // Length of each record

    /*
     * Method Name: DDCharacter
     * Author: Yunseo Jeon
     * Creation Date: Mar 3 2025
     * Description: Peeks at the size of the array
     * @Parameters: A integer array
     * @Return Value: Returns the number of lines in a file
     * Data Type: integer ARRAY
     * Dependencies: n/a
     * Throws/Exceptions: File IO errors
     */

     
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

    public DDCharacter() {
        characterName = "";
        race = "";
        playerClass = "";
        level = 0;
        hitPoints = 0;
        strength = 0;
        constitution = 0;
        intelligence = 0;
        wisdom = 0;
        dexterity = 0;
        charisma = 0;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setClass(String playerClass) {
        this.playerClass = playerClass;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setHitPoints(int newHitPoints) {
        this.hitPoints = newHitPoints;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setRizz(int charisma) {
        this.charisma = charisma;
    }

    public String getCharacterName() {
        return this.characterName;
    }

    public String getRace() {
        return this.race;
    }

    public String getPlayerClass() {
        return this.playerClass;
    }

    public int getLevel() {
        return this.level;
    }

    public int getHitPoints() {
        return this.hitPoints;
    }

    public int getStrength() {
        return this.strength;
    }

    public int getConstitution() {
        return this.constitution;
    }

    public int getIntelligence() {
        return this.intelligence;
    }

    public int getWisdom() {
        return this.wisdom;
    }

    public int getDexterity() {
        return this.dexterity;
    }

    public int getCharisma() {
        return this.charisma;
    }

    public int getDiceRoll(int max) {
        Random rand = new Random(); // Create a Random object
        int result = rand.nextInt(max) + 1; // Generate a random number between 1 and max (inclusive)
        return result;
    }

    public void updateOrCreateRAF(RandomAccessFile raf, int recNum) throws IOException {
        raf.seek(recNum * recLen); // move pointer to position in file
        int nameLength = characterName.length(); // determine if there are more than 20 characters
        int raceLength = race.length();
        int classLength = playerClass.length();
        int paddingLength = 0; // calculate the number of blanks that need to be

        //NAME PADDING
        if (nameLength > 20) {
            nameLength = 20; // maintain a length of 20
        } 
        else {
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
        } 
        else {
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
        } 
        else {
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
        //write everything else to RAF
        raf.writeInt (level);
        raf.writeInt (hitPoints);
        raf.writeInt (strength);
        raf.writeInt (constitution);
        raf.writeInt (intelligence);
        raf.writeInt (wisdom);
        raf.writeInt (dexterity);
        raf.writeInt (charisma);
    }

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

 
}
