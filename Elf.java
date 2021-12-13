/**
 * The Elf class implements a wrapper for the base Creature class with the following additions
 * Implements a maximum/minimum strength for the creature type [18/5]
 * Implements a maximum/minimum hitpoint total for the creature type [25/8]
 * Implements a 10% chance to override attack and cause doubled damage
 * 
 * @author Spencer Gunning
 * @version 2021.12.12
 */
public class Elf extends Creature
{
    private static final int MAX_ELF_HP = 25;
    private static final int MIN_ELF_HP = 8;
    private static final int MAX_ELF_STR = 18;
    private static final int MIN_ELF_STR = 5;

    /**
     * Constructor for objects of class Elf -
     * The instantiating class asks for a Elf and the human class is responsible for
     * returing an Elf object with values in the appropriate range
     */
    public Elf()
    {
        // Generated values via Randomizer class
        super(
            Randomizer.nextInt(MAX_ELF_HP-MIN_ELF_HP)+MIN_ELF_HP,    
            Randomizer.nextInt(MAX_ELF_STR-MIN_ELF_STR)+MIN_ELF_STR
        );
          
    }

    /**
     * Allows an elf to determine how much damage it is causing in this round of battle.
     * Has a 10% to do magical damage and double the damage returned another creature
     * @return a value to be used to cause damage to another creature
     */
    public int attack() {
        if (Randomizer.nextInt(10) == 1) {
            return super.attack() * 2;
        }
        return super.attack();
    }
}