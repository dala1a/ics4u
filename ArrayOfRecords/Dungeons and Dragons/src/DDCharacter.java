public class DDCharacter {
    private String Name;
    private String Race;
    private String Class;
    private int Level;
    private int hitPoints;
    private int Strength;
    private int Constitution;
    private int Intelligence;
    private int Wisdom;
    private int Dexterity;
    private int Charisma;
   
    public void setName (String newName) {
        this.Name = newName;
    }

    public void setRace (String newRace) {
        this.Race = newRace;
    }

    public void setClass (String newClass) {
        this.Class = newClass;
    }

    public void setLevel (int newLevel) {
        this.Level = newLevel;
    }

    public void setHitPoints (int newHitPoints) {
        this.hitPoints = newHitPoints;
    }

    public void setStrength (int newStrength) {
        this.Strength = newStrength;
    }
    public void setConstitution (int newConstitution) {
        this.Constitution = newConstitution;
    }

    public void setIntelligence (int newIntelligence) {
        this.Intelligence = newIntelligence;
    }

    public void setWisdom (int newWisdom) {
        this.Wisdom = newWisdom;
    }

    public void setDexterity (int newDexterity) {
        this.Dexterity = newDexterity;
    }

    public void setCharisma (int newCharisma) {
        this.Charisma = newCharisma;
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
