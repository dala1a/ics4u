import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.Scanner;

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

    public DDCharacter (String characterName, String race, String playerClass, int level, int hitPOints, int strength, int constitution, int intelligence, int wisdom, int dexterity, int charisma) {
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

    public DDCharacter () {
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

    public void setName(String characterName) {
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

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }
    
    public int getDiceRoll(int max) {
        Random rand = new Random(); // Create a Random object
        int result = rand.nextInt(max) + 1; // Generate a random number between 1 and max (inclusive)
        return result;
    }

    public int randomStatGen() {

        return 0;
    }

    public void levelUp() {

    }

    public void ChangeClass() {

    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
