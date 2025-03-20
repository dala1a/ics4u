package ArrayOfCharacters;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.Scanner;

public class DDCharacter {

    private String characterName;   // 40 Bytes (20 Characters)
    private String race;    // 20 Bytes (10 Characters)
    private String playerClass; // 20 Bytes (10 Characters)
    private int level; // 4 Bytes
    private int hitPoints; // 4 Bytes
    private int strength;   // 4 Bytes
    private int constitution;   // 4 Bytes 
    private int intelligence;   // 4 Bytes 
    private int wisdom; // 4 Bytes 
    private int dexterity; // 4 Bytes 
    private int charisma; // 4 Bytes 
    private final long recLen = 112; //Length of each record	

    public DDCharacter(String characterName, String race, String playerClass, int level, int hitPoints, int strength, int constitution, int intelligence, int wisdom, int dexterity, int charisma) {
        this.characterName = characterName; 
        this.race = race; 
        this.playerClass = playerClass; 
        this.level = level; 
        this.hitPoints = hitPoints; 
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
		level = 1;
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

    public void setPlayerClass(String playerClass) { 
        this.playerClass = playerClass; 
    }

    public void setLevel(int level) { 
        this.level = level; 
    }

    public void setHitPoints(int hitPoints) { 
        this.hitPoints = hitPoints; 
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

    public int getDice(int Sides) {
		int max;
		int randomNum;
		
		do {
            Random rand = new Random();
            max = Sides;
            randomNum = rand.nextInt(max+1); 
		} while(randomNum == 0);

		return randomNum;
	} 

    public int randomStatGen() { 
        int total = 0; 
        int rolls[] = new int[4];

        for(int i = 0; i < rolls.length; i++) { 
            rolls[i] = getDice(6);
            total += rolls[i]; 
        }

        int smallestRoll = rolls[0]; 

        for(int i = 0; i < rolls.length; i++) { 
            if(rolls[i] < smallestRoll) { 
                smallestRoll = rolls[i]; 
            }
        }

        return total - smallestRoll; 
    }

    public void levelUp(RandomAccessFile raf, int recordNum, int newLevel) throws IOException { 
        setLevel(newLevel);
        hitPoints = 0;
        for(int i = 0; i < newLevel; i++) { 
            switch (playerClass) {
                case "Warrior":
                    hitPoints += getDice(10);
                    break;
                case "Cleric": 
                    hitPoints += getDice(8);
                    break; 
                case "Bard", "Ranger", "Rogue": 
                    hitPoints += getDice(6); 
                    break; 
                case "Mage": 
                    hitPoints += getDice(4); 
                    break; 
                default:
                    System.out.println("No Hitpoints Added");
                    break;
            }
        }
       
        updateOrCreateRaf(raf, recordNum);
    }

    public void changeClass(String newPlayerClass, RandomAccessFile raf, int recordNum) throws IOException { 
        setPlayerClass(newPlayerClass); 
        levelUp(raf, recordNum, level);

        updateOrCreateRaf(raf, recordNum);
    }

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
                constitution -=3; 
                break; 

            case "Orc": 
                strength -= 3; 
                constitution -=1; 
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

    public void changeRace(String newRace, RandomAccessFile raf, int recordNum) throws IOException { 
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
                constitution +=3; 
                break; 

            case "Orc": 
                strength += 3; 
                constitution +=1; 
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

    public void updateOrCreateRaf(RandomAccessFile raf, int recordNum) throws IOException { 
        raf.seek (recordNum * recLen); // move pointer to position in file
        int nameLen = characterName.length();	  // determine if there are more than 20 characters
		int padLen = 0;					  // calculate the number of blanks that need to be 
        if (nameLen > 20)		          //  added to maintain a length of 20
            nameLen = 20;
        else
            padLen = 20 - nameLen;
        for (int i = 0 ; i < characterName.length () ; i++)	// write the name
            raf.writeChar (characterName.charAt (i));
        if (padLen > 0)	{					// write the extra blanks
            for (int i = 0 ; i < padLen ; i++)
                raf.writeChar (' ');
        }
        
        
        // repeat for Race
        // ---------------------------------------------------
        nameLen = race.length ();
		padLen = 0;						
        if (nameLen > 10)					
            nameLen = 10;
        else
            padLen = 10 - nameLen;
        for (int i = 0 ; i < race.length () ; i++)	
            raf.writeChar(race.charAt (i));
        if (padLen > 0)	{				
            for (int i = 0 ; i < padLen ; i++)
                raf.writeChar(' ');
        }
        
        // repeat for Class
        // ---------------------------------------------------
        nameLen = playerClass.length ();
		padLen = 0;						
        if (nameLen > 10)					
            nameLen = 10;
        else
            padLen = 10 - nameLen;
        for (int i = 0 ; i < playerClass.length() ; i++)	
            raf.writeChar(playerClass.charAt(i));
        if (padLen > 0)	{				
            for (int i = 0 ; i < padLen ; i++)
                raf.writeChar(' ');
        }
        // write the int and double to the file
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
        for (int i = 0 ; i < 20 ; i++)
            temp = temp + raf.readChar();
        characterName = temp.trim();
        temp = "";
        for (int i = 0 ; i < 10 ; i++)
            temp = temp + raf.readChar();
        race = temp.trim();
        temp = "";
        for (int i = 0 ; i < 10 ; i++)
            temp = temp + raf.readChar();
        playerClass = temp.trim();
        
        // read the long and doubles from the file
        setLevel(raf.readInt());
        setHitPoints(raf.readInt());
        setStrength(raf.readInt());
        setConstitution(raf.readInt());
        setIntelligence(raf.readInt());
        setWisdom(raf.readInt());
        setDexterity(raf.readInt()); 
        setCharisma(raf.readInt()); 
    }

    public void createCharacter(Scanner sc, String race, String playerClass, String name, RandomAccessFile raf, int recordNum) throws IOException { 
        setCharacterName(capitalize(name));
        changeClass(playerClass, raf, recordNum);
        changeRace(race, raf, recordNum);

        raf.seek (recordNum * recLen); // move pointer to position in file
        int nameLen = characterName.length();	  // determine if there are more than 20 characters
		int padLen = 0;					  // calculate the number of blanks that need to be 
        if (nameLen > 20)		          //  added to maintain a length of 20
            nameLen = 20;
        else
            padLen = 20 - nameLen;
        for (int i = 0 ; i < characterName.length () ; i++)	// write the name
            raf.writeChar (characterName.charAt (i));
        if (padLen > 0)	{					// write the extra blanks
            for (int i = 0 ; i < padLen ; i++)
                raf.writeChar (' ');
        }
        
        
        // repeat for Race
        // ---------------------------------------------------
        nameLen = race.length ();
		padLen = 0;						
        if (nameLen > 10)					
            nameLen = 10;
        else
            padLen = 10 - nameLen;
        for (int i = 0 ; i < race.length () ; i++)	
            raf.writeChar(race.charAt (i));
        if (padLen > 0)	{				
            for (int i = 0 ; i < padLen ; i++)
                raf.writeChar(' ');
        }
        
        // repeat for Class
        // ---------------------------------------------------
        nameLen = playerClass.length ();
		padLen = 0;						
        if (nameLen > 10)					
            nameLen = 10;
        else
            padLen = 10 - nameLen;
        for (int i = 0 ; i < playerClass.length() ; i++)	
            raf.writeChar(playerClass.charAt(i));
        if (padLen > 0)	{				
            for (int i = 0 ; i < padLen ; i++)
                raf.writeChar(' ');
        }

        setStrength(randomStatGen());
        setConstitution(randomStatGen());
        setIntelligence(randomStatGen());
        setWisdom(randomStatGen());
        setDexterity(randomStatGen());
        setCharisma(randomStatGen());

        raf.writeInt(level);
        raf.writeInt(hitPoints);
        raf.writeInt(strength);
        raf.writeInt(constitution);
        raf.writeInt(intelligence);
        raf.writeInt(wisdom);
        raf.writeInt(dexterity);
        raf.writeInt(charisma);
        raf.close();

    }

    public void deleteCharacter(RandomAccessFile raf, String name, int recNum) throws IOException{

        raf.seek (recNum * recLen);	 
        String fake = ""; 	  

        for (int i = 0 ; i < 20 ; i++) { 
            fake = fake + raf.readChar();
        }

        characterName = fake.trim();

        if(characterName.equalsIgnoreCase(name)) {
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
    }

    public void updateCharacterStat(RandomAccessFile raf, int recNum, String name, int Str, int Constitution, int Int, int Wis, int Dex, int Charis) throws IOException { 
        raf.seek (recNum * recLen);	 
        String fake = ""; 
       
       for (int i = 0 ; i < 20 ; i++)
           fake = fake + raf.readChar();
       characterName = fake.trim();
       fake = "";
       for (int i = 0 ; i < 10 ; i++)
           fake = fake + raf.readChar();
       race = fake.trim();
       fake = "";
       for (int i = 0 ; i < 10 ; i++)
           fake = fake + raf.readChar();
       playerClass = fake.trim();
       fake = "";

      //  read the long and doubles from the file
       level = raf.readInt();
       hitPoints = raf.readInt();
       strength = raf.readInt();
       constitution = raf.readInt();
       intelligence = raf.readInt();
       wisdom = raf.readInt();
       dexterity = raf.readInt();
       charisma = raf.readInt();
           
        if(characterName.equalsIgnoreCase(name)) {
            strength = Str;
            constitution = Constitution;
            intelligence = Int;
            wisdom = Wis;
            dexterity = Dex;
            charisma = Charis;
        }  
    } 	

    private static final String capitalize(String str) {  
        if (str == null || str.length() == 0) return str;  
        return str.substring(0, 1).toUpperCase() + str.substring(1);  
    } 

}
